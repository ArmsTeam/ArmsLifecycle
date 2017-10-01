package org.arms.lifecycle;

import android.app.Application;
import android.content.Context;

import org.arms.lifecycle.delegate.ActivityLifecycle;
import org.arms.lifecycle.delegate.AppLifecycles;
import org.arms.lifecycle.delegate.ILifecycle;
import org.arms.lifecycle.di.component.DaggerLifecycleComponent;
import org.arms.lifecycle.di.component.LifecycleComponent;
import org.arms.lifecycle.di.module.LifecycleModule;
import org.arms.lifecycle.utils.ManifestLifecycleParser;
import org.arms.lifecycle.utils.Preconditions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ArmsTeam on 2017/10/1.
 * Lifecycle 注入器
 */

public class LifecycleInjector implements ILifecycle, AppLifecycles {
    private Application mApplication;
    private LifecycleComponent mLifecycleComponent;
    private LifecycleModule mLifecycleModule;
    @Inject
    protected ActivityLifecycle mActivityLifecycle;
    private List<ConfigLifecycle> mConfigLifecycles;
    private List<AppLifecycles> mAppLifecycles = new ArrayList<>();
    private List<Application.ActivityLifecycleCallbacks> mActivityLifecycles = new ArrayList<>();


    public LifecycleInjector(Context context) {
        mConfigLifecycles = new ManifestLifecycleParser(context).parse();
        for (ConfigLifecycle lifecycle : mConfigLifecycles) {
            lifecycle.injectAppLifecycle(context, mAppLifecycles);
            lifecycle.injectActivityLifecycle(context, mActivityLifecycles);
        }
    }

    @Override
    public void attachBaseContext(Context context) {
        for (AppLifecycles lifecycle : mAppLifecycles)
            lifecycle.attachBaseContext(context);
    }

    @Override
    public void onCreate(Application application) {
        this.mApplication = application;

        if (mLifecycleModule == null)
            mLifecycleModule = new LifecycleModule(mApplication);
        mLifecycleComponent = DaggerLifecycleComponent.builder()
                .lifecycleModule(mLifecycleModule)
                .build();
        mLifecycleComponent.inject(this);

        mLifecycleComponent.extras().put(ConfigLifecycle.class.getName(), mConfigLifecycles);

        mApplication.registerActivityLifecycleCallbacks(mActivityLifecycle);

        this.mConfigLifecycles = null;

        for (Application.ActivityLifecycleCallbacks lifecycle : mActivityLifecycles)
            mApplication.registerActivityLifecycleCallbacks(lifecycle);

        for (AppLifecycles lifecycle : mAppLifecycles)
            lifecycle.onCreate(mApplication);
    }

    @Override
    public void onTerminate(Application application) {
        if (mActivityLifecycle != null)
            mApplication.unregisterActivityLifecycleCallbacks(mActivityLifecycle);

        if (mActivityLifecycles != null && mActivityLifecycles.size() > 0)
            for (Application.ActivityLifecycleCallbacks lifecycle : mActivityLifecycles)
                mApplication.unregisterActivityLifecycleCallbacks(lifecycle);

        if (mAppLifecycles != null && mAppLifecycles.size() > 0)
            for (AppLifecycles lifecycle : mAppLifecycles)
                lifecycle.onTerminate(mApplication);

        this.mLifecycleModule = null;
        this.mLifecycleComponent = null;
        this.mActivityLifecycle = null;
        this.mActivityLifecycles = null;
        this.mAppLifecycles = null;
        this.mApplication = null;
    }


    @Override
    public LifecycleComponent getLifecycleComponent() {
        Preconditions.checkNotNull(mLifecycleComponent,
                "%s cannot be null,first call %s#onCreate(Application) in %s#onCreate()",
                LifecycleComponent.class.getName(), getClass().getName(), mApplication.getClass().getName());
        return this.mLifecycleComponent;
    }

    @Override
    public LifecycleModule getLifecycleModule() {
        Preconditions.checkNotNull(mLifecycleModule,
                "%s cannot be null,first call %s#onCreate(Application) in %s#onCreate()",
                LifecycleModule.class.getName(), getClass().getName(), mApplication.getClass().getName());
        return this.mLifecycleModule;
    }

}


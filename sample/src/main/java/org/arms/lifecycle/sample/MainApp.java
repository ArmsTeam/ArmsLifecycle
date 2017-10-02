package org.arms.lifecycle.sample;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;

import org.arms.lifecycle.LifecycleInjector;
import org.arms.lifecycle.delegate.ILifecycle;
import org.arms.lifecycle.di.component.LifecycleComponent;
import org.arms.lifecycle.di.module.LifecycleModule;
import org.arms.lifecycle.sample.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by ArmsTeam on 2017/10/2.
 */

public class MainApp extends Application
        implements ILifecycle, HasActivityInjector, HasSupportFragmentInjector {
    //Dagger.Android Activity 注入
    @Inject
    DispatchingAndroidInjector<Activity> mActivityInjector;
    //Dagger.Android Fragment 注入
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    private LifecycleInjector mLifecycleInjector;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (mLifecycleInjector == null)
            mLifecycleInjector = new LifecycleInjector(base);
        mLifecycleInjector.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .build()
                .inject(this);
        mLifecycleInjector.onCreate(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return this.mActivityInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return this.mFragmentInjector;
    }

    @Override
    public LifecycleComponent getLifecycleComponent() {
        return mLifecycleInjector.getLifecycleComponent();
    }

    @Override
    public LifecycleModule getLifecycleModule() {
        return mLifecycleInjector.getLifecycleModule();
    }
}

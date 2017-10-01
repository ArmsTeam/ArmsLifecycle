package org.arms.lifecycle.di.module;

import android.app.Application;
import android.support.v4.util.ArrayMap;

import org.arms.lifecycle.delegate.ActivityLifecycle;
import org.arms.lifecycle.delegate.AppManager;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ArmsTeam on 2017/10/1.
 * Dagger LifecycleModule
 */

@Module
public class LifecycleModule {
    private Application mApplication;

    public LifecycleModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    AppManager provideAppManager() {
        return new AppManager(mApplication);
    }

    @Singleton
    @Provides
    ActivityLifecycle provideActivityLifecycle(AppManager appManager, Map<String, Object> extras) {
        return new ActivityLifecycle(appManager, mApplication, extras);
    }

    @Singleton
    @Provides
    Map<String, Object> provideExtras() {
        return new ArrayMap<>();
    }
}

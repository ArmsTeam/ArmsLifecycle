package org.arms.lifecycle.sample.di.module;

import org.arms.lifecycle.di.scope.ActivityScope;
import org.arms.lifecycle.sample.LifecycleActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ArmsTeam on 2017/10/02.
 * Dagger LifecycleActivityModule
 * 用于 Dagger.Android 依赖注入
 */

@Module
public abstract class LifecycleActivityModule {
    /**
     * @see <a href="https://github.com/xiaobailong24/DaggerAndroid">DaggerAndroid</a>
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = KobeModule.class)
    abstract LifecycleActivity contributeLifecycleActivity();
}

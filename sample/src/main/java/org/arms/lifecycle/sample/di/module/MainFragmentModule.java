package org.arms.lifecycle.sample.di.module;

import org.arms.lifecycle.di.scope.FragmentScope;
import org.arms.lifecycle.sample.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ArmsTeam on 2017/10/02.
 * Dagger MainFragmentModule
 * 用于 Dagger.Android 依赖注入
 */

@Module
public abstract class MainFragmentModule {
    /**
     * @see <a href="https://github.com/xiaobailong24/DaggerAndroid">DaggerAndroid</a>
     */
    @FragmentScope
    @ContributesAndroidInjector(modules = JordonModule.class)
    abstract MainFragment contributeMainFragment();
}

package org.arms.lifecycle.sample.di.module;

import dagger.Module;

/**
 * Created by ArmsTeam on 2017/10/2.
 * Dagger Module
 */
@Module(includes = {LifecycleActivityModule.class, MainFragmentModule.class})
public class AppModule {
}

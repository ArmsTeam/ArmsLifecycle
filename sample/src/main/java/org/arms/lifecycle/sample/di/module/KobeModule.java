package org.arms.lifecycle.sample.di.module;

import org.arms.lifecycle.di.scope.ActivityScope;
import org.arms.lifecycle.sample.entry.Person;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ArmsTeam on 2017/10/2.
 * Dagger KobeModule
 */

@Module
public class KobeModule {
    @ActivityScope
    @Provides
    Person provideKobe() {
        return new Person("Kobe", 36);
    }
}

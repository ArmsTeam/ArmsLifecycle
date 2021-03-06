package org.arms.lifecycle.sample.di.module;

import org.arms.lifecycle.di.scope.FragmentScope;
import org.arms.lifecycle.sample.entry.Person;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ArmsTeam on 2017/10/2.
 * Dagger KobeModule
 */

@Module
public class JordonModule {
    @FragmentScope
    @Provides
    Person provideJordon() {
        return new Person("Jordon", 45);
    }
}

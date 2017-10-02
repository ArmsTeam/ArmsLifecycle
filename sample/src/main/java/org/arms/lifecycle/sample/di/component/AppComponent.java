package org.arms.lifecycle.sample.di.component;

import org.arms.lifecycle.di.module.LifecycleModule;
import org.arms.lifecycle.sample.MainApp;
import org.arms.lifecycle.sample.di.module.AppModule;

import dagger.Component;

/**
 * Created by ArmsTeam on 2017/10/2.
 * Dagger Component
 */
@Component(modules = {AppModule.class, LifecycleModule.class})
public interface AppComponent {
    void inject(MainApp mainApp);
}

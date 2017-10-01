package org.arms.lifecycle.di.component;

import org.arms.lifecycle.LifecycleInjector;
import org.arms.lifecycle.delegate.AppManager;
import org.arms.lifecycle.di.module.LifecycleModule;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ArmsTeam on 2017/10/1.
 * Dagger LifecycleComponent
 */

@Singleton
@Component(modules = LifecycleModule.class)
public interface LifecycleComponent {

    //用来存取一些整个App公用的数据,切勿大量存放大容量数据
    Map<String, Object> extras();

    //用于管理所有activity
    AppManager appManager();

    void inject(LifecycleInjector lifecycleInjector);
}

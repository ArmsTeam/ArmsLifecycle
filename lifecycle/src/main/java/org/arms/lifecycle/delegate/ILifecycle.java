package org.arms.lifecycle.delegate;

import org.arms.lifecycle.di.component.LifecycleComponent;
import org.arms.lifecycle.di.module.LifecycleModule;

/**
 * Created by ArmsTeam on 2017/10/1.
 * Application 继承该接口，就可以具有 LifecycleComponent 提供的方法。
 */

public interface ILifecycle {
    /**
     * Description: 获得全局 LifecycleComponent
     *
     * @return LifecycleComponent
     */
    LifecycleComponent getLifecycleComponent();


    /**
     * Description: 获得全局 LifecycleModule 重用
     *
     * @return LifecycleModule
     */
    LifecycleModule getLifecycleModule();
}

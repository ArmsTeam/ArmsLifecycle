package org.arms.lifecycle.utils;

import android.app.Application;
import android.content.Context;

import org.arms.lifecycle.delegate.ILifecycle;
import org.arms.lifecycle.di.component.LifecycleComponent;


/**
 * Created by ArmsTeam on 2017/10/1.
 * LifecycleComponent 工具类
 */

public enum LifecycleUtils {
    INSTANCE;

    public LifecycleComponent obtainLifecycleComponent(Context context) {
        return obtainLifecycleComponent((Application) context.getApplicationContext());
    }

    public LifecycleComponent obtainLifecycleComponent(Application application) {
        Preconditions.checkState(application instanceof ILifecycle,
                "%s does not implements ILifecycle", application.getClass().getName());
        return ((ILifecycle) application).getLifecycleComponent();
    }

}

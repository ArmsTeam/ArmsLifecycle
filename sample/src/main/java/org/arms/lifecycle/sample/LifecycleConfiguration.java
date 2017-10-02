package org.arms.lifecycle.sample;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import org.arms.lifecycle.ConfigLifecycle;
import org.arms.lifecycle.delegate.AppLifecycles;

import java.util.List;

import timber.log.Timber;

/**
 * Created by ArmsTeam on 2017/10/2.
 * 配置 Lifecycle
 */

public class LifecycleConfiguration implements ConfigLifecycle {
    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        lifecycles.add(new AppLifecycles() {
            @Override
            public void attachBaseContext(Context context) {

            }

            @Override
            public void onCreate(Application application) {
                Timber.plant(new Timber.DebugTree());
            }

            @Override
            public void onTerminate(Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }
}

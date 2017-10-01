package org.arms.lifecycle.delegate;

import android.app.Application;
import android.content.Context;

/**
 * Created by ArmsTeam on 2017/10/1.
 * Application 生命周期
 */

public interface AppLifecycles {
    void attachBaseContext(Context context);

    void onCreate(Application application);

    void onTerminate(Application application);
}

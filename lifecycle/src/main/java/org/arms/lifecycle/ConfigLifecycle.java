package org.arms.lifecycle;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import org.arms.lifecycle.delegate.AppLifecycles;

import java.util.List;

/**
 * Created by ArmsTeam on 2017/10/1.
 * 用于自定义配置 Lifecycle，需要在 AndroidManifest.xml 中声明
 */

public interface ConfigLifecycle {

    /**
     * 使用{@link AppLifecycles}在Application的生命周期中注入一些操作
     *
     * @param context:    Context
     * @param lifecycles: List<AppLifecycles>
     */
    void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles);

    /**
     * 使用{@link Application.ActivityLifecycleCallbacks}在Activity的生命周期中注入一些操作
     *
     * @param context:    Context
     * @param lifecycles: List<Application.ActivityLifecycleCallbacks>
     */
    void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles);


    /**
     * 使用{@link FragmentManager.FragmentLifecycleCallbacks}在Fragment的生命周期中注入一些操作
     *
     * @param context:    Context
     * @param lifecycles: List<FragmentManager.FragmentLifecycleCallbacks>
     */
    void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles);
}
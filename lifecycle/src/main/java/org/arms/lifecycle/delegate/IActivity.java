package org.arms.lifecycle.delegate;


import android.os.Bundle;

/**
 * Created by ArmsTeam on 2017/10/1.
 * Activity 公用接口
 */

public interface IActivity {

    /**
     * Description: UI 初始化
     *
     * @param savedInstanceState Bundle
     * @return int
     */
    int initView(Bundle savedInstanceState);

    /**
     * Description: 数据初始化
     *
     * @param savedInstanceState Bundle
     */
    void initData(Bundle savedInstanceState);

    /**
     * Description: 是否使用EventBus
     * 默认使用(true)
     *
     * @return boolean
     */
    boolean useEventBus();

    /**
     * 这个Activity是否会使用Fragment,框架会根据这个属性判断是否注册{@link android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks}
     * 默认使用(true)
     *
     * @return boolean
     */
    boolean useFragment();
}
package org.arms.lifecycle.delegate;

import android.os.Bundle;
import android.os.Parcelable;

/**
 * Created by ArmsTeam on 2017/10/1.
 * Activity 生命周期代理接口
 */

public interface ActivityDelegate extends Parcelable {
    String ACTIVITY_DELEGATE = "activity_delegate";


    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSaveInstanceState(Bundle outState);

    void onDestroy();
}

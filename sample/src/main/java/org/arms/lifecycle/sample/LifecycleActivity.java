package org.arms.lifecycle.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.arms.lifecycle.delegate.IActivity;
import org.arms.lifecycle.sample.entry.Person;
import org.arms.lifecycle.utils.UiUtils;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by ArmsTeam on 2017/10/2.
 * 只是个演示示例。
 *
 * @see <a href="https://github.com/xiaobailong24/MVVMArms/blob/master/arms/src/main/java/me/xiaobailong24/mvvmarms/base/BaseActivity.java">BaseActivity</a>
 */

public class LifecycleActivity extends AppCompatActivity implements IActivity {
    @Inject
    Person mKobe;

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_lifecycle;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Timber.d("Dagger inject for Activity: " + mKobe.toString());
        UiUtils.makeText(this, mKobe.toString());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initView(savedInstanceState));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        initData(savedInstanceState);
    }

    @Override
    public boolean useEventBus() {
        return true;
    }

    @Override
    public boolean useFragment() {
        return true;
    }
}

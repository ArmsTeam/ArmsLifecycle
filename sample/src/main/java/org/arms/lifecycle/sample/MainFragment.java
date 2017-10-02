package org.arms.lifecycle.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.arms.lifecycle.delegate.IFragment;
import org.arms.lifecycle.sample.entry.Person;
import org.arms.lifecycle.utils.UiUtils;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by ArmsTeam on 2017/10/2.
 * 只是个演示示例。
 *
 * @see <a href="https://github.com/xiaobailong24/MVVMArms/blob/master/arms/src/main/java/me/xiaobailong24/mvvmarms/base/BaseFragment.java">BaseFragment</a>
 */

public class MainFragment extends Fragment implements IFragment {

    @Inject
    Person mJordon;

    public MainFragment() {
        setArguments(new Bundle());
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Timber.d("Dagger inject for Fragment: " + mJordon.toString());
        UiUtils.snackbarText(mJordon.toString());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public boolean injectable() {
        return true;
    }

    @Override
    public boolean useEventBus() {
        return true;
    }
}

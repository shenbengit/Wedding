package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.databinding.FragmentWeBinding;
import com.example.wedding.mvvm.viewmodel.WeViewModel;

/**
 * 我们Fragment
 *
 * @author

 */
public class WeFragment extends BaseFragment<FragmentWeBinding, WeViewModel> {

    public static WeFragment newInstance() {
        return new WeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we;
    }

    @Override
    protected Class<WeViewModel> getModelClass() {
        return WeViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        mViewModel.onSupportVisible();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mViewModel.initPickerView(_mActivity);
    }
}

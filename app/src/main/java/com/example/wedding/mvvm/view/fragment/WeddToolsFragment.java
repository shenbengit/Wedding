package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentToolsWeddBinding;

/**
 * 发现页Fragment
 *
 * @author

 */
public class WeddToolsFragment extends BaseFragment<FragmentToolsWeddBinding, BaseViewModel> {

    public static WeddToolsFragment newInstance() {
        return new WeddToolsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tools_wedd;
    }

    @Override
    protected Class<BaseViewModel> getModelClass() {
        return BaseViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}

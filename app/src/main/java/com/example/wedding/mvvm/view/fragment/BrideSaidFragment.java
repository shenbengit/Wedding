package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentBrideSaidBinding;

/**
 * 新娘说Fragment
 *
 * @author
 * @date 2019/4/5 14:46
 * @email 714081644@qq.com
 */
public class BrideSaidFragment extends BaseFragment<FragmentBrideSaidBinding, BaseViewModel> {

    public static BrideSaidFragment newInstance() {
        return new BrideSaidFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bride_said;
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

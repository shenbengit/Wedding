package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentFindHomeBinding;

/**
 * 婚品Fragment
 *
 * @author

 */
public class FindingFragment extends BaseFragment<FragmentFindHomeBinding, BaseViewModel> {

    public static FindingFragment newInstance() {
        return new FindingFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find_home;
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

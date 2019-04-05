package com.example.wedding.mvvm.view.fragment;

import com.android.databinding.library.baseAdapters.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentHomeBinding;
import com.example.wedding.mvvm.viewmodel.HomeViewModel;

/**
 * 首页Fragment
 *
 * @author ShenBen
 * @date 2019/4/5 14:43
 * @email 714081644@qq.com
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected Class<HomeViewModel> getModelClass() {
        return HomeViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData() {

    }
}

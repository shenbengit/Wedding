package com.example.wedding.mvvm.view.fragment;

import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentWeBinding;

/**
 * 我们Fragment
 *
 * @author ShenBen
 * @date 2019/4/5 14:46
 * @email 714081644@qq.com
 */
public class WeFragment extends BaseFragment<FragmentWeBinding, BaseViewModel> {

    public static WeFragment newInstance() {
        return new WeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we;
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
    protected void initData() {

    }
}

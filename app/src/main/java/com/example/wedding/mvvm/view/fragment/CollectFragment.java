package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentCollectionBinding;

/**
 * 收藏Fragment
 *
 * @author ShenBen
 * @date 2019/4/5 14:50
 * @email 714081644@qq.com
 */
public class CollectFragment extends BaseFragment<FragmentCollectionBinding, BaseViewModel> {

    public static CollectFragment newInstance() {
        return new CollectFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collection;
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

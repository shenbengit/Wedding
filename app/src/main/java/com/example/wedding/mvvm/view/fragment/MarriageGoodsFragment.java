package com.example.wedding.mvvm.view.fragment;

import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentMarriageGoodsBinding;

/**
 * 婚品Fragment
 *
 * @author ShenBen
 * @date 2019/4/5 14:49
 * @email 714081644@qq.com
 */
public class MarriageGoodsFragment extends BaseFragment<FragmentMarriageGoodsBinding, BaseViewModel> {

    public static MarriageGoodsFragment newInstance() {
        return new MarriageGoodsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_marriage_goods;
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

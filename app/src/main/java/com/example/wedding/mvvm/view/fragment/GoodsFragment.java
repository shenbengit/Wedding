package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.databinding.FragmentFindHomeBinding;
import com.example.wedding.loader.GlideImageLoader;
import com.example.wedding.mvvm.viewmodel.GoodsViewModel;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

/**
 * 婚品Fragment
 *
 * @author
 */
public class GoodsFragment extends BaseFragment<FragmentFindHomeBinding, GoodsViewModel> {

    public static GoodsFragment newInstance() {
        return new GoodsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find_home;
    }

    @Override
    protected Class<GoodsViewModel> getModelClass() {
        return GoodsViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.bannerGoods.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.bannerGoods.setImageLoader(new GlideImageLoader());
        mBinding.bannerGoods.setBannerAnimation(Transformer.DepthPage);

        mBinding.rvGoods.setLayoutManager(new GridLayoutManager(_mActivity, 5) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvGoods.setAdapter(mViewModel.goodsAdapter);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.sendBannerList.observe(this, list -> {
            if (list!=null&&!list.isEmpty()){
                mBinding.bannerGoods.setImages(list).start();
            }
        });
    }
}

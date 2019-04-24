package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.databinding.FragmentHomeBinding;
import com.example.wedding.loader.GlideImageLoader;
import com.example.wedding.mvvm.viewmodel.HomeViewModel;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

/**
 * 首页Fragment
 *
 * @author
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
    protected void initView() {
        mBinding.banner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.banner.setImageLoader(new GlideImageLoader());
        mBinding.banner.setBannerAnimation(Transformer.DepthPage);

        mBinding.rvWeddingType.setLayoutManager(new GridLayoutManager(_mActivity, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvWeddingType.setAdapter(mViewModel.mWeddingTypeAdapter);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.bannerImageList.observe(this, list -> {
            if (list!=null&&!list.isEmpty()){
                mBinding.banner.setImages(list).start();
            }
        });
    }
}

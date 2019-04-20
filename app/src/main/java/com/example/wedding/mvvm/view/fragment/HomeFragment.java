package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.databinding.FragmentHomeBinding;
import com.example.wedding.http.bean.HomeInfoBean;
import com.example.wedding.loader.GlideImageLoader;
import com.example.wedding.mvvm.view.bean.HomeWeddingBean;
import com.example.wedding.mvvm.viewmodel.HomeViewModel;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页Fragment
 *
 * @author
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private List<String> mBannerList;
    private List<HomeWeddingBean> mWeddingTypeList;
//    private List<HomeWeddingBean> mWeddingToolList;

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
        mBannerList = new ArrayList<>();
        mWeddingTypeList = new ArrayList<>();
//        mWeddingToolList = new ArrayList<>();
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

//        mBinding.rvWeddingTool.setLayoutManager(new GridLayoutManager(_mActivity, 5) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        });
//        mBinding.rvWeddingTool.setAdapter(mViewModel.mWeddingToolAdapter);

    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.firstPageInfo.observe(this, homeInfoBean -> {
            mBannerList.clear();
            mWeddingTypeList.clear();
//            mWeddingToolList.clear();
            if (homeInfoBean != null && homeInfoBean.getStatus().getRetCode() == 0) {
                HomeInfoBean.DataBeanXX.ListBeanXX bannerXX = homeInfoBean.getData().getList().get(0);
                for (HomeInfoBean.DataBeanXX.ListBeanXX.DataBeanX.ListBeanX beanX : bannerXX.getData().getList()) {
                    mBannerList.add(beanX.getImage_path());
                }

                HomeInfoBean.DataBeanXX.ListBeanXX typeXX = homeInfoBean.getData().getList().get(1);
                HomeWeddingBean typeBean;
                for (HomeInfoBean.DataBeanXX.ListBeanXX.DataBeanX.ListBeanX beanX : typeXX.getData().getList()) {
                    typeBean = new HomeWeddingBean();
                    typeBean.setId(beanX.getId());
                    typeBean.setTarget_type(beanX.getTarget_type());
                    typeBean.setTarget_url(beanX.getTarget_url());
                    typeBean.setTarget_id(beanX.getTarget_id());
                    typeBean.setImage_path(beanX.getImage_path());
                    typeBean.setTitle(beanX.getTitle());
                    typeBean.setWatch_count(beanX.getWatch_count());
                    typeBean.setExtention(beanX.getExtention());
                    typeBean.setSub_title(beanX.getSub_title());
                    typeBean.setIs_highlight(beanX.getIs_highlight());
                    typeBean.setIs_valid(beanX.getIs_valid());
                    typeBean.setRoute(beanX.getRoute());
                    mWeddingTypeList.add(typeBean);
                }


            }

            mBinding.banner.setImages(mBannerList);
            mBinding.banner.start();

            mViewModel.mWeddingTypeAdapter.setNewData(mWeddingTypeList);

//            mViewModel.mWeddingToolAdapter.setNewData(mWeddingToolList);
        });
    }
}

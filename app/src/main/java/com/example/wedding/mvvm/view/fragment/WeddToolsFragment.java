package com.example.wedding.mvvm.view.fragment;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.databinding.FragmentToolsWeddBinding;
import com.example.wedding.mvvm.view.bean.HomeWeddingBean;
import com.example.wedding.mvvm.viewmodel.ToolsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现页Fragment
 *
 * @author

 */
public class WeddToolsFragment extends BaseFragment<FragmentToolsWeddBinding, ToolsViewModel> {

    private List<HomeWeddingBean> mWeddingToolList;

    public static WeddToolsFragment newInstance() {
        return new WeddToolsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tools_wedd;
    }

    @Override
    protected Class<ToolsViewModel> getModelClass() {
        return ToolsViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        super.initView();
        mWeddingToolList = new ArrayList<>();

        mBinding.rvWeddingTool.setLayoutManager(new LinearLayoutManager(_mActivity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvWeddingTool.setAdapter(mViewModel.mWeddingToolAdapter);
    }


    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.getBaseLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        mViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        //备婚工具假数据
        HomeWeddingBean toolBean;
        toolBean = new HomeWeddingBean();
        toolBean.setId("0");
        toolBean.setTitle("黄道吉日");
        toolBean.setImage_path("https://qnm.hunliji.com/o_1d58ds37hl8713nm1cd6vbc1raee.png");
        mWeddingToolList.add(toolBean);
        toolBean = new HomeWeddingBean();
        toolBean.setId("1");
        toolBean.setTitle("结婚预算");
        toolBean.setImage_path("https://qnm.hunliji.com/o_1d58nkvhpogiatqb4j17pk1uni9.png");
        mWeddingToolList.add(toolBean);
        toolBean = new HomeWeddingBean();
        toolBean.setId("2");
        toolBean.setTitle("登记处");
        toolBean.setImage_path("https://qnm.hunliji.com/o_1d58o5gtc1ga7i0b1uhqvsn16b59.png");
        mWeddingToolList.add(toolBean);
        toolBean = new HomeWeddingBean();
        toolBean.setId("3");
        toolBean.setTitle("备婚打卡");
        toolBean.setImage_path("https://qnm.hunliji.com/o_1d58p6ada117317sn1eb8amn2d69.png");
        mWeddingToolList.add(toolBean);
        toolBean = new HomeWeddingBean();
        toolBean.setId("4");
        toolBean.setTitle("电子请帖");
        toolBean.setImage_path("https://qnm.hunliji.com/o_1d5m7324jg681nr18gb99r11kt9.png");
        mWeddingToolList.add(toolBean);

        mViewModel.mWeddingToolAdapter.setNewData(mWeddingToolList);
    }
}

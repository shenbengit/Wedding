package com.example.wedding.mvvm.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.constant.Constant;
import com.example.wedding.databinding.ActivityMainBinding;
import com.example.wedding.mvvm.view.fragment.WeddingToolsFragment;
import com.example.wedding.mvvm.view.fragment.HomeFragment;
import com.example.wedding.mvvm.view.fragment.GoodsFragment;
import com.example.wedding.mvvm.view.fragment.WeFragment;
import com.example.wedding.widget.BottomBar;
import com.example.wedding.widget.BottomBarTab;

import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * 主页
 *
 * @author

 */
@Route(path = ARouterPath.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final int FOURTH = 3;
    private static final int FIFTH = 4;
    private ISupportFragment[] mFragments = new ISupportFragment[5];

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
    protected void initView() {
        if (getIntent() != null) {
            //如果需要登录
            if (getIntent().getBooleanExtra(Constant.IS_NEED_LOGIN, true)) {

            }
        }
        mBinding.bottomBar.addItem(new BottomBarTab(this, R.drawable.ic_tab_home, "主页"))
                .addItem(new BottomBarTab(this, R.drawable.ic_tab_social, "婚备工具"))
                .addItem(new BottomBarTab(this, R.drawable.ic_tab_shop, "婚品"))
                .addItem(new BottomBarTab(this, R.drawable.ic_tab_we, "我们"));
        mBinding.bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        ISupportFragment firstFragment = findFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HomeFragment.newInstance();
            mFragments[SECOND] = WeddingToolsFragment.newInstance();
            mFragments[THIRD] = GoodsFragment.newInstance();
            mFragments[FOURTH] = WeFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container,
                    FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = WeddingToolsFragment.newInstance();
            mFragments[THIRD] = GoodsFragment.newInstance();
            mFragments[FOURTH] = WeFragment.newInstance();
        }
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}

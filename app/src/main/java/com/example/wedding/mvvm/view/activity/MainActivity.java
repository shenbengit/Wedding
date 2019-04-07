package com.example.wedding.mvvm.view.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityMainBinding;
import com.example.wedding.mvvm.view.fragment.BrideSaidFragment;
import com.example.wedding.mvvm.view.fragment.CollectFragment;
import com.example.wedding.mvvm.view.fragment.HomeFragment;
import com.example.wedding.mvvm.view.fragment.MarriageGoodsFragment;
import com.example.wedding.mvvm.view.fragment.WeFragment;
import com.example.wedding.widget.BottomBar;
import com.example.wedding.widget.BottomBarTab;

import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

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
        mBinding.bottomBar.addItem(new BottomBarTab(this, R.drawable.ic_tab_home, "主页"))
                .addItem(new BottomBarTab(this, R.drawable.ic_tab_social, "新娘说"))
                .addItem(new BottomBarTab(this, R.drawable.ic_tab_shop, "婚品"))
                .addItem(new BottomBarTab(this, R.drawable.ic_tab_collect, "收藏"))
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
    protected void initData() {
        ISupportFragment firstFragment = findFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HomeFragment.newInstance();
            mFragments[SECOND] = BrideSaidFragment.newInstance();
            mFragments[THIRD] = MarriageGoodsFragment.newInstance();
            mFragments[FOURTH] = CollectFragment.newInstance();
            mFragments[FIFTH] = WeFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container,
                    FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]);
        } else {
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = BrideSaidFragment.newInstance();
            mFragments[THIRD] = MarriageGoodsFragment.newInstance();
            mFragments[FOURTH] = CollectFragment.newInstance();
            mFragments[FIFTH] = WeFragment.newInstance();
        }
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}

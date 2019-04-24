package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.mvvm.model.WeddToolModel;
import com.example.wedding.mvvm.view.adapter.WeddingToolAdapter;
import com.example.wedding.mvvm.view.bean.HomeWeddingBean;
import com.example.wedding.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class WeddingToolsViewModel extends BaseViewModel<WeddToolModel> {

    public WeddingToolAdapter mWeddingToolAdapter;
    public BindingCommand insertDataCommand;

    public ObservableField<Boolean> isVisible;
    private List<HomeWeddingBean> mWeddingToolList;


    public WeddingToolsViewModel(@NonNull Application application) {
        super(application, new WeddToolModel());
        initCommand();
    }

    private void initCommand() {
        mWeddingToolList = new ArrayList<>();
        mWeddingToolAdapter = new WeddingToolAdapter();

        mWeddingToolAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtil.d(position + "点击了");
                switch (position){
                    case 0:
                        ARouter.getInstance()
                                .build(ARouterPath.CALENDAR_ACTIVITY)
                                .navigation();
                        break;
                    case 1:

                        break;
                    case 2:
                        ARouter.getInstance()
                                .build(ARouterPath.WEDD_POSITION_ACTIVITY)
                                .navigation();
                        break;
                }
            }
        });

        insertDataCommand = new BindingCommand(() -> {
            LogUtil.d("insertDataCommand");

            mModel.insertPosition(null, null);
        });

        isVisible = new ObservableField<>();

    }

    @Override
    public void onCreate() {
        super.onCreate();
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

        mWeddingToolAdapter.setNewData(mWeddingToolList);

        mModel.searchWeddPosition(() -> {
            isVisible.set(false);
        }, (e) -> {
            isVisible.set(true);

        });
    }
}

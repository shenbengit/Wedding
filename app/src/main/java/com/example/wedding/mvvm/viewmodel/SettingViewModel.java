package com.example.wedding.mvvm.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.base.BaseModel;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.widget.SureCancelDialog;

import cn.bmob.v3.BmobUser;

/**
 * @author
 */
public class SettingViewModel extends BaseViewModel<BaseModel> {
    /**
     * 账号安全安全点击
     */
    public BindingCommand accountCommand;
    /**
     * 个人资料点击
     */
    public BindingCommand personalCommand;
    /**
     * 用户反馈点击
     */
    public BindingCommand feedbackCommand;
    /**
     * 退出登录点击
     */
    public BindingCommand logoutCommand;

    private SureCancelDialog mDialog;

    public SettingViewModel(@NonNull Application application) {
        super(application, new BaseModel());
        accountCommand = new BindingCommand(() -> ARouter.getInstance()
                .build(ARouterPath.ACCOUNT_SECURITY_ACTIVITY)
                .navigation());

        personalCommand = new BindingCommand(() -> ARouter.getInstance()
                .build(ARouterPath.PERSONAL_INFO_ACTIVITY)
                .navigation());

        feedbackCommand = new BindingCommand(() -> ARouter.getInstance()
                .build(ARouterPath.FEEDBACK_ACTIVITY)
                .navigation());
        logoutCommand = new BindingCommand(() -> {
            if (mDialog != null && !mDialog.isShowing()) {
                mDialog.show();
            }
        });
    }

    public void initDialog(Activity activity) {
        mDialog = new SureCancelDialog(activity);
        mDialog.setContent("是否退出登录？");
        mDialog.setOnOptionClickListener(new SureCancelDialog.OnOptionClickListener() {
            @Override
            public void sure() {
                BmobUser.logOut();
                ARouter.getInstance()
                        .build(ARouterPath.LOGIN_ACTIVITY)
                        .navigation();
            }

            @Override
            public void cancel() {

            }
        });
    }

}

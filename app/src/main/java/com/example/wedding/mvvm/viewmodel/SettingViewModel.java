package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingAction;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;

/**
 * @author ShenBen
 * @date 2019/4/8 22:38
 * @email 714081644@qq.com
 */
public class SettingViewModel extends BaseViewModel {

    public BindingCommand accountCommand;

    public BindingCommand personalCommand;

    public BindingCommand logoutCommand;

    public SettingViewModel(@NonNull Application application) {
        super(application);
        accountCommand = new BindingCommand(new BindingAction() {
            @Override
            public void execute() {

            }
        });

        personalCommand = new BindingCommand(() -> ARouter.getInstance()
                .build(ARouterPath.PERSONAL_INFO_ACTIVITY)
                .navigation());
        logoutCommand = new BindingCommand(new BindingAction() {
            @Override
            public void execute() {

            }
        });
    }

}

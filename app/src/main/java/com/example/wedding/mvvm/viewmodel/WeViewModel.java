package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;

/**
 * @author ShenBen
 * @date 2019/4/8 22:51
 * @email 714081644@qq.com
 */
public class WeViewModel extends BaseViewModel {
    public BindingCommand goToSettingActivity;

    public WeViewModel(@NonNull Application application) {
        super(application);
        goToSettingActivity = new BindingCommand(() -> ARouter.getInstance().build(ARouterPath.SETTING_ACTIVITY).navigation());
    }
}

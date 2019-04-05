package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.util.LogUtil;
import com.orhanobut.logger.Logger;

import io.reactivex.disposables.Disposable;

/**
 * @author ShenBen
 * @date 2018/11/22 14:24
 * @email 714081644@qq.com
 */
public class HomeViewModel extends BaseViewModel {
    /**
     * 用户名
     */
    public ObservableField<String> userName = new ObservableField<>("");
    /**
     * 密码
     */
    public ObservableField<String> password = new ObservableField<>("");

    public ObservableField<String> sex = new ObservableField<>("男");

    public BindingCommand loginCommand;

    public BindingCommand<String> sexCommand;

    public BindingCommand<String> textChangeCommand;

    public BindingCommand<Boolean> isAutoLoginCommand;

    private Disposable mDisposable;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        initCommand();
    }

    private void initCommand() {
        loginCommand = new BindingCommand(() -> {
            if (TextUtils.equals(userName.get(), "111") && TextUtils.equals(password.get(), "111")) {
                Logger.e("用户名、密码正确");
                ARouter.getInstance().build(ARouterPath.TEST_ACTIVITY).navigation();
            }
        });

        sexCommand = new BindingCommand<>(s -> sex.set(s));

        textChangeCommand = new BindingCommand<>(s -> LogUtil.e("字符变化： " + s));

        isAutoLoginCommand = new BindingCommand<>(aBoolean -> LogUtil.e("是否自动登录: " + aBoolean));

    }

}

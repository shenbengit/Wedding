package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingAction;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.http.bean.UserBean;

import cn.bmob.v3.BmobUser;

/**
 * @author
 * @date 2019/4/17 22:27
 * @email 714081644@qq.com
 */
public class AccountSecurityViewModel extends BaseViewModel {

    public ObservableField<String> realName;
    public ObservableField<String> phone;
    public BindingCommand realNameCommand;

    public AccountSecurityViewModel(@NonNull Application application) {
        super(application);
        realName = new ObservableField<>();
        phone = new ObservableField<>();
        realNameCommand = new BindingCommand(new BindingAction() {
            @Override
            public void execute() {

            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UserBean mCurrentUser = BmobUser.getCurrentUser(UserBean.class);
        if (mCurrentUser != null) {
            realName.set(mCurrentUser.getRealName());
            phone.set(mCurrentUser.getMobilePhoneNumber());
        }
    }
}

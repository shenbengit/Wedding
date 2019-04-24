package com.example.wedding.mvvm.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.wedding.base.BaseModel;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.http.bean.UserBean;

import cn.bmob.v3.BmobUser;

/**
 * @author
 */
public class AccountSecurityViewModel extends BaseViewModel<BaseModel> {
    public static final int REAL_NAME_TAG = 1001;
    public static final String REAL_NAME = "REAL_NAME";
    public ObservableField<String> realName;
    public ObservableField<String> phone;
    public BindingCommand realNameCommand;

    public AccountSecurityViewModel(@NonNull Application application) {
        super(application, new BaseModel());
        realName = new ObservableField<>();
        phone = new ObservableField<>();
        realNameCommand = new BindingCommand(() -> getBaseLiveData().postValue("RealName"));
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

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REAL_NAME_TAG && resultCode == Activity.RESULT_OK && data != null) {
            realName.set(data.getStringExtra(REAL_NAME));
        }
    }
}

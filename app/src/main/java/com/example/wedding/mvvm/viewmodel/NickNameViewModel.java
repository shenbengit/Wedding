package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.mvvm.model.PersonalInfoModel;
import com.example.wedding.util.ToastUtil;

import cn.bmob.v3.BmobUser;
import io.reactivex.functions.Action;

/**
 * @author
 * @date 2019/4/16 22:33
 * @email 714081644@qq.com
 */
public class NickNameViewModel extends BaseViewModel<PersonalInfoModel> {
    private UserBean mCurrentUser;
    public ObservableField<String> nickName;
    public BindingCommand submitNickName;

    public NickNameViewModel(@NonNull Application application) {
        super(application, new PersonalInfoModel());
        nickName = new ObservableField<>();
        submitNickName = new BindingCommand(() -> {
            if (TextUtils.isEmpty(nickName.get())) {
                ToastUtil.show(application, "请输入昵称");
                return;
            }
            mCurrentUser.setNickName(nickName.get());
            mModel.updateUserInfo(mCurrentUser, () -> {
                ToastUtil.show(getApplication(), "修改成功");
                getBaseLiveData().postValue(nickName.get());
            }, null);
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mCurrentUser = BmobUser.getCurrentUser(UserBean.class);
        if (mCurrentUser == null) {
            return;
        }
        nickName.set(mCurrentUser.getNickName());
    }
}

package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.rxbus.RxSubscriptions;
import com.example.wedding.util.ToastUtil;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import io.reactivex.disposables.Disposable;


public class RealNameViewModel extends BaseViewModel {

    private UserBean mCurrentUser;
    public ObservableField<String> realNameString;
    public BindingCommand sureCommand;
    private Disposable mCommitRealNameDisposable;


    public RealNameViewModel(@NonNull Application application) {
        super(application);
        realNameString = new ObservableField<>();
        sureCommand = new BindingCommand(this::commitRealName);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mCurrentUser = BmobUser.getCurrentUser(UserBean.class);
        if (mCurrentUser != null) {
            realNameString.set(mCurrentUser.getRealName());
        }
    }

    private void commitRealName() {
        if (TextUtils.isEmpty(realNameString.get())) {
            ToastUtil.show(getApplication(), "请输入姓名");
            return;
        }
        if (mCurrentUser == null) {
            ToastUtil.show(getApplication(), "请先登录");
            return;
        }
        mCurrentUser.setRealName(realNameString.get());
        mCommitRealNameDisposable = mCurrentUser.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    ToastUtil.show(getApplication(), "提交成功");
                    getBaseLiveData().postValue(realNameString.get());
                } else {
                    ToastUtil.show(getApplication(), "提交姓名失败，请重试！ErrorMessage: " + e.getMessage());
                }
            }
        });
        RxSubscriptions.add(mCommitRealNameDisposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        RxSubscriptions.remove(mCommitRealNameDisposable);
    }
}

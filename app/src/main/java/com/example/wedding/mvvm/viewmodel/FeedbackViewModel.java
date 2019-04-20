package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.http.bean.FeedbackBean;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.rxbus.RxSubscriptions;
import com.example.wedding.util.ToastUtil;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import io.reactivex.disposables.Disposable;


public class FeedbackViewModel extends BaseViewModel {
    public ObservableField<String> feedbackString;
    public BindingCommand submitCommand;
    private Disposable mSubmitDisposable;

    public FeedbackViewModel(@NonNull Application application) {
        super(application);
        feedbackString = new ObservableField<>();

        submitCommand = new BindingCommand(this::sumbitFeedback);
    }

    private void sumbitFeedback() {
        if (TextUtils.isEmpty(feedbackString.get())) {
            ToastUtil.show(getApplication(), "请输入要反馈的内容");
            return;
        }
        UserBean userBean = BmobUser.getCurrentUser(UserBean.class);
        if (userBean == null) {
            ToastUtil.show(getApplication(), "请先登录");
            return;
        }
        FeedbackBean bean = new FeedbackBean(userBean.getObjectId(), feedbackString.get());
        mSubmitDisposable = bean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    ToastUtil.show(getApplication(), "反馈成功");
                } else {
                    ToastUtil.show(getApplication(), "提交反馈失败，请重试！ErrorMessage: " + e.getMessage());
                }
            }
        });
        RxSubscriptions.add(mSubmitDisposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        RxSubscriptions.remove(mSubmitDisposable);
    }
}

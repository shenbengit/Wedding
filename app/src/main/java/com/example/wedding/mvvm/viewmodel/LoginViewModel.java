package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.wedding.R;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.Constant;
import com.example.wedding.constant.SharedPreferencesKey;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.rxbus.RxSubscriptions;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.SharedPreferencesUtil;
import com.example.wedding.util.ToastUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;
import io.reactivex.disposables.Disposable;

/**
 * @author ShenBen
 * @date 2019/4/6 19:14
 * @email 714081644@qq.com
 */
public class LoginViewModel extends BaseViewModel {

    private Application mContext;
    /**
     * 使用LiveData，LiveData对生命周期感知，可以避免内存泄漏
     * <p>
     * 轮播图数据
     */
    public MutableLiveData<List<Integer>> images;
    /**
     * 发送验证码，点击事件
     */
    public BindingCommand sendCode;
    /**
     * 发送验证码的图标是否可见
     */
    public MutableLiveData<Boolean> sendCodeIcoVisible;
    /**
     * 倒计时显示
     */
    public ObservableField<String> countDownTime;
    /**
     * 手机号
     */
    public ObservableField<String> phone;
    /**
     * 倒计时
     */
    private CountDownTimer mTimer;
    /**
     * 是否正在倒计时
     */
    private boolean isCountDowning = false;
    /**
     * 验证验证码，点击事件
     */
    public BindingCommand verifyCode;
    /**
     * 短信验证码
     */
    public ObservableField<String> smsCode;

    /**
     * 发送验证码的图标是否可见
     */
    public MutableLiveData<Boolean> singOrLoginSuccess;

    private Disposable mRequestSmsDisposable;

    private Disposable mSignOrLoginDisposable;

    private Disposable mUserUpdateDisposable;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        mContext = application;
        images = new MutableLiveData<>();
        sendCodeIcoVisible = new MutableLiveData<>();
        countDownTime = new ObservableField<>("60秒");
        mTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDownTime.set(millisUntilFinished / 1000 + "秒");
            }

            @Override
            public void onFinish() {
                isCountDowning = false;
                countDownTime.set("重新发送");
            }
        };

        phone = new ObservableField<>("");

        sendCodeIcoVisible.setValue(true);

        List<Integer> list = Arrays.asList(R.drawable.ic_login_bg1,
                R.drawable.ic_login_bg2,
                R.drawable.ic_login_bg3,
                R.drawable.ic_login_bg4);
        images.postValue(list);

        sendCode = new BindingCommand(this::checkPhone);
        verifyCode = new BindingCommand(this::signOrLoginByMobilePhone);
        smsCode = new ObservableField<>("");
        singOrLoginSuccess = new MutableLiveData<>();
        singOrLoginSuccess.setValue(false);
    }

    /**
     * 验证手机号
     */
    private void checkPhone() {
        if (isCountDowning) {
            return;
        }
        if (TextUtils.isEmpty(phone.get())) {
            ToastUtil.show(mContext, "请输入手机号");
            return;
        }

        if (!Objects.requireNonNull(phone.get())
                .matches("0?(13|14|15|18|17)[0-9]{9}")) {//简单正则 匹配
            ToastUtil.show(mContext, "请输入正确的手机号");
            return;
        }
        sendCodeIcoVisible.postValue(false);
        isCountDowning = true;
        requestSMSCode();
        mTimer.start();
    }

    /**
     * 发送短信验证码
     */
    private void requestSMSCode() {
        mRequestSmsDisposable = BmobSMS.requestSMSCode(phone.get(), Constant.SMS_TEMPLATE, new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {
                    LogUtil.i("短息ID: " + integer);
                } else {
                    ToastUtil.show(mContext, "短信发送失败，errorCode: " + e.getErrorCode() + ",message: " + e.getMessage());
                }
            }
        });
        RxSubscriptions.add(mRequestSmsDisposable);
    }

    /**
     * 验证短信验证码,实现手机号一键登录
     */
    private void signOrLoginByMobilePhone() {
        if (TextUtils.isEmpty(phone.get())) {
            ToastUtil.show(mContext, "手机号不能为空");
            return;
        }
        if (TextUtils.isEmpty(smsCode.get())) {
            ToastUtil.show(mContext, "短信验证码不能为空");
            return;
        }
        //手机号一键登录
        mSignOrLoginDisposable = BmobUser.signOrLoginByMobilePhone(phone.get(), smsCode.get(), new LogInListener<UserBean>() {
            @Override
            public void done(UserBean userBean, BmobException e) {
                if (userBean != null) {
                    SharedPreferencesUtil.getInstance().putString(SharedPreferencesKey.USER_PHONE, phone.get());
                    userBean.setPassword(phone.get());
                    mUserUpdateDisposable = userBean.update(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {
                                singOrLoginSuccess.postValue(true);
                            } else {
                                LogUtil.e("设置密码出错: " + e.getMessage());
                            }
                        }
                    });
                } else {
                    ToastUtil.show(mContext, "登录失败，errorCode： " + e.getErrorCode() + "，message： " + e.getMessage());
                }
            }
        });
        RxSubscriptions.add(mSignOrLoginDisposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
        RxSubscriptions.remove(mRequestSmsDisposable);
        RxSubscriptions.remove(mSignOrLoginDisposable);
        RxSubscriptions.remove(mUserUpdateDisposable);
    }
}

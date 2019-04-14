package com.example.wedding.mvvm.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.util.LogUtil;

import cn.bmob.v3.BmobUser;

/**
 * @author ShenBen
 * @date 2019/4/8 22:51
 * @email 714081644@qq.com
 */
public class WeViewModel extends BaseViewModel {
    /**
     * 当前登录用户
     */
    private UserBean mCurrentUser;
    /**
     * 头像url地址
     */
    public ObservableField<String> headPicture;
    /**
     * 婚礼倒计时时间
     */
    public ObservableField<String> weddingDataCountTime;
    /**
     * 昵称
     */
    public ObservableField<String> nickName;
    /**
     * 婚礼倒计时点击事件
     */
    public BindingCommand weddingDataCountTimeCommand;
    /**
     * 设置按钮点击事件
     */
    public BindingCommand settingCommand;


    /**
     * 婚期PickerView
     */
    private TimePickerView mWeddingDatePickerView;

    public WeViewModel(@NonNull Application application) {
        super(application);
        headPicture = new ObservableField<>();
        weddingDataCountTime = new ObservableField<>();
        nickName = new ObservableField<>();
        settingCommand = new BindingCommand(() -> ARouter.getInstance().build(ARouterPath.SETTING_ACTIVITY).navigation());
        weddingDataCountTimeCommand = new BindingCommand(() -> {
            if (mWeddingDatePickerView != null && !mWeddingDatePickerView.isShowing()) {
                mWeddingDatePickerView.show();
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onResume() {
        super.onResume();
        mCurrentUser = BmobUser.getCurrentUser(UserBean.class);
        if (mCurrentUser.getHeadImg() != null) {
            headPicture.set(mCurrentUser.getHeadImg().getFileUrl());
        }
        if (TextUtils.isEmpty(mCurrentUser.getWeddingDate())) {
            weddingDataCountTime.set("设置结婚日期");
        } else {
            weddingDataCountTime.set(mCurrentUser.getWeddingDate());
        }
        nickName.set(TextUtils.isEmpty(mCurrentUser.getNickName()) ?
                mCurrentUser.getUsername() : mCurrentUser.getNickName());
    }

    public void initPickerView(Activity activity) {
        PickerOptions weddingOptions = new PickerOptions(PickerOptions.TYPE_PICKER_TIME);
        weddingOptions.optionsSelectListener = new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                LogUtil.i("options1: " + options1 + ",options2: " + options2 + ",options3: " + options3);
            }
        };
        weddingOptions.context = activity;
        mWeddingDatePickerView = new TimePickerView(weddingOptions);
    }
}

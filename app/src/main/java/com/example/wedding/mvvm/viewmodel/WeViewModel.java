package com.example.wedding.mvvm.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingAction;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.constant.Constant;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.mvvm.model.WeModel;
import com.example.wedding.util.ToolUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.bmob.v3.BmobUser;

/**
 * @author ShenBen
 * @date 2019/4/8 22:51
 * @email 714081644@qq.com
 */
public class WeViewModel extends BaseViewModel<WeModel> {
    /**
     * 当前登录用户
     */
    private UserBean mCurrentUser;
    private SimpleDateFormat mDateFormat;
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
     * 头像点击事件
     */
    public BindingCommand headImageCommand;

    /**
     * 婚期PickerView
     */
    private TimePickerView mWeddingDatePickerView;

    public WeViewModel(@NonNull Application application) {
        super(application, new WeModel());
        mCurrentUser = BmobUser.getCurrentUser(UserBean.class);
        mDateFormat = new SimpleDateFormat(Constant.DATA_FORMAT_PATTERN, Locale.getDefault());
        mDateFormat.setLenient(false);

        headPicture = new ObservableField<>();
        weddingDataCountTime = new ObservableField<>();
        nickName = new ObservableField<>();
        weddingDataCountTimeCommand = new BindingCommand(() -> {
            if (mWeddingDatePickerView != null && !mWeddingDatePickerView.isShowing()) {
                mWeddingDatePickerView.show();
            }
        });
        settingCommand = new BindingCommand(() -> ARouter.getInstance()
                .build(ARouterPath.SETTING_ACTIVITY)
                .navigation());
        headImageCommand = new BindingCommand(() -> ARouter.getInstance()
                .build(ARouterPath.PERSONAL_INFO_ACTIVITY)
                .navigation());
    }

    /**
     * fragment可见时调用
     */
    public void onSupportVisible() {
        mCurrentUser = BmobUser.getCurrentUser(UserBean.class);
        if (mCurrentUser.getHeadImg() != null) {
            headPicture.set(mCurrentUser.getHeadImg().getFileUrl());
        }
        if (TextUtils.isEmpty(mCurrentUser.getWeddingDate())) {
            weddingDataCountTime.set("设置结婚日期");
        } else {
            //计算与结婚日期差
            try {
                int days = ToolUtil.differentDays(new Date(), mDateFormat.parse(mCurrentUser.getWeddingDate()));
                if (days <= 0) {
                    weddingDataCountTime.set("已完婚");
                } else {
                    weddingDataCountTime.set("婚礼倒计时" + days + "天");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        nickName.set(TextUtils.isEmpty(mCurrentUser.getNickName()) ?
                mCurrentUser.getUsername() : mCurrentUser.getNickName());
    }

    public void initPickerView(Activity activity) {
        TimePickerBuilder builder = new TimePickerBuilder(activity, (date, v) -> {
            mCurrentUser.setWeddingDate(mDateFormat.format(date));
            int days = ToolUtil.differentDays(new Date(), date);
            if (days <= 0) {
                weddingDataCountTime.set("已完婚");
            } else {
                weddingDataCountTime.set("婚礼倒计时" + days + "天");
            }
            mModel.updateUserInfo(mCurrentUser, null, null);
        })
                .setRangDate(Calendar.getInstance(), null);
        mWeddingDatePickerView = builder.build();
        if (!TextUtils.isEmpty(mCurrentUser.getWeddingDate())) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(mDateFormat.parse(mCurrentUser.getWeddingDate()));
                mWeddingDatePickerView.setDate(calendar);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}

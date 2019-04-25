package com.example.wedding.mvvm.viewmodel;


import android.app.Application;
import android.support.annotation.NonNull;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.http.bean.BusinessOverviewBean;
import com.example.wedding.mvvm.model.BusinessModel;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.ToastUtil;

import io.reactivex.functions.Action;

public class BusinessViewModel extends BaseViewModel<BusinessModel> {

    public BusinessViewModel(@NonNull Application application) {
        super(application, new BusinessModel());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mModel.getBusinessOverview(mLifecycleProvider, new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                },
                this::parseBusinessOverviewData,
                throwable -> {
                    ToastUtil.show(getApplication(), "出错啦！请稍后重试。ErrorMessage: " + throwable.getMessage());
                    LogUtil.e("商家概览: onError: " + throwable.getMessage());
                });
    }

    /**
     * 解析商家概况数据
     *
     * @param bean 商家概况数据
     */
    private void parseBusinessOverviewData(BusinessOverviewBean bean) {
        if (bean == null || bean.getStatus() == null ) {
            LogUtil.e("商家概览: parseBusinessOverviewData: 数据出错");
            return;
        }
        if (bean.getStatus().getRetCode() != 0){
            LogUtil.e("商家概览: parseBusinessOverviewData: Message: "+bean.getStatus().getMsg());
        }


    }
}

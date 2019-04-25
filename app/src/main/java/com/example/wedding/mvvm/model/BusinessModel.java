package com.example.wedding.mvvm.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.wedding.base.BaseModel;
import com.example.wedding.constant.SharedPreferencesKey;
import com.example.wedding.http.RetrofitClient;
import com.example.wedding.http.bean.BusinessOverviewBean;
import com.example.wedding.util.RxUtil;
import com.example.wedding.util.SharedPreferencesUtil;
import com.trello.rxlifecycle2.LifecycleProvider;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


public class BusinessModel extends BaseModel {

    /**
     * 获取商家概览信息
     *
     * @param lifecycleProvider rxjava取消订阅相关
     * @param onStart           请求开始时回调
     * @param onNext            请求成功时回调
     * @param onError           请求失败回调
     */
    public void getBusinessOverview(@NonNull LifecycleProvider lifecycleProvider, @Nullable Action onStart,
                                    @Nullable Consumer<BusinessOverviewBean> onNext,
                                    @Nullable Consumer<Throwable> onError) {
        String headr = SharedPreferencesUtil.getInstance().getString(SharedPreferencesKey.CITY_HEADER);
        int cityId = SharedPreferencesUtil.getInstance().getInt(SharedPreferencesKey.CITY_ID, 63);
        RetrofitClient.getInstance()
                .getApiService()
                .getBusinessOverview(headr, cityId)
                .compose(RxUtil.io_main())
                .compose(lifecycleProvider.bindToLifecycle())
                .subscribe(new Observer<BusinessOverviewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (onStart != null) {
                            try {
                                onStart.run();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onNext(BusinessOverviewBean businessOverviewBean) {
                        if (onNext != null) {
                            try {
                                onNext.accept(businessOverviewBean);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (onError != null) {
                            try {
                                onError.accept(throwable);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {


    }
}

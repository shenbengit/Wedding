package com.example.wedding.mvvm.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.wedding.base.BaseModel;
import com.example.wedding.constant.SharedPreferencesKey;
import com.example.wedding.http.RetrofitClient;
import com.example.wedding.http.bean.GoodsHttpBen;
import com.example.wedding.util.RxUtil;
import com.example.wedding.util.SharedPreferencesUtil;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class WeddGoodsModel extends BaseModel {
    /**
     * 获取主页信息
     *
     * @param longitude         经度
     * @param latitude          纬度
     * @param province          省份
     * @param city              城市
     * @param district          区
     * @param expo_cid          id
     * @param community_cid     id
     * @param lifecycleProvider 避免内存泄漏，对应界面销毁时自动取消订阅
     * @param onNext            成功回调
     * @param onError           失败回调
     */
    public void getGoods(double longitude, double latitude, String province,
                         String city, String district, int expo_cid, int community_cid,
                         @NonNull LifecycleProvider lifecycleProvider, @Nullable Consumer<GoodsHttpBen> onNext,
                         @Nullable Consumer<Throwable> onError) {
        try {
            String header = SharedPreferencesUtil.getInstance().getString(SharedPreferencesKey.CITY_HEADER);
            if (TextUtils.isEmpty(header)) {
                header = "{\"gps_longitude\":" + longitude + ",\"gps_latitude\":" + latitude + ",\"gps_province\":\"" + URLEncoder.encode(province, "UTF-8") + "\"," +
                        "\"gps_city\":\"" + URLEncoder.encode(city, "UTF-8") + "\",\"gps_district\":\"" + URLEncoder.encode(district, "UTF-8") + "\",\"expo_cid\":" + expo_cid + ",\"community_cid\":" + community_cid + "}";
                SharedPreferencesUtil.getInstance().putString(SharedPreferencesKey.CITY_HEADER, header);
            }

            RetrofitClient.getInstance()
                    .getApiService()
                    .getGoods(header)
                    .compose(RxUtil.io_main())
                    .compose(lifecycleProvider.bindToLifecycle())//避免内存泄漏，对应界面销毁时自动取消订阅
                    .subscribe(new Observer<GoodsHttpBen>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(GoodsHttpBen homeInfoBean) {
                            if (onNext != null) {
                                try {
                                    onNext.accept(homeInfoBean);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (onError != null) {
                                try {
                                    onError.accept(e);
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

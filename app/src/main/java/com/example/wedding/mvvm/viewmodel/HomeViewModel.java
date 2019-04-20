package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.SharedPreferencesKey;
import com.example.wedding.http.RetrofitClient;
import com.example.wedding.http.bean.HomeInfoBean;
import com.example.wedding.mvvm.view.adapter.WeddingTypeAdapter;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.RxUtil;
import com.example.wedding.util.SharedPreferencesUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author

 */
public class HomeViewModel extends BaseViewModel {
    /**
     * 定位位置
     */
    public ObservableField<String> location;
    /**
     * 点击定位按钮
     */
    public BindingCommand locationCommand;
    /**
     * 搜索按钮
     */
    public BindingCommand searchCommand;

    public MutableLiveData<HomeInfoBean> firstPageInfo;

    public WeddingTypeAdapter mWeddingTypeAdapter;
//    public WeddingTypeAdapter mWeddingToolAdapter;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        initCommand();
    }

    private void initCommand() {
        location = new ObservableField<>("");
        locationCommand = new BindingCommand(() -> {
            //
            //
        });

        searchCommand = new BindingCommand(() -> {
            //
            //
        });

        firstPageInfo = new MutableLiveData<>();

        mWeddingTypeAdapter = new WeddingTypeAdapter();
//        mWeddingToolAdapter = new WeddingTypeAdapter();

        mWeddingTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @Override
    public void onCreate() {
        getHomeInfo(118.833373, 31.759363, "江苏省", "南京市", "江宁区", 63, 63);
    }

    @Override
    public void onResume() {
        location.set(SharedPreferencesUtil.getInstance().getString(SharedPreferencesKey.LOCATION, "南京"));
    }

    /**
     * 获取主页信息
     *
     * @param longitude     经度
     * @param latitude      纬度
     * @param province      省份
     * @param city          城市
     * @param district      区
     * @param expo_cid      id
     * @param community_cid id
     */
    private void getHomeInfo(double longitude, double latitude, String province, String city, String district, int expo_cid, int community_cid) {
        try {
            String header = SharedPreferencesUtil.getInstance().getString(SharedPreferencesKey.CITY_HEADER);
            if (TextUtils.isEmpty(header)) {
                header = "{\"gps_longitude\":" + longitude + ",\"gps_latitude\":" + latitude + ",\"gps_province\":\"" + URLEncoder.encode(province, "UTF-8") + "\"," +
                        "\"gps_city\":\"" + URLEncoder.encode(city, "UTF-8") + "\",\"gps_district\":\"" + URLEncoder.encode(district, "UTF-8") + "\",\"expo_cid\":" + expo_cid + ",\"community_cid\":" + community_cid + "}";
                SharedPreferencesUtil.getInstance().putString(SharedPreferencesKey.CITY_HEADER, header);
            }

            RetrofitClient.getInstance()
                    .getApiService()
                    .getHomePage(header)
                    .compose(RxUtil.io_main())
                    .compose(mLifecycleProvider.bindToLifecycle())
                    .subscribe(new Observer<HomeInfoBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(HomeInfoBean homeInfoBean) {
                            firstPageInfo.postValue(homeInfoBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtil.e("获取主页数据失败，message：" + e.getMessage());
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

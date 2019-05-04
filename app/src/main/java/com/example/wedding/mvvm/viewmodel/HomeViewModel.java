package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.constant.SharedPreferencesKey;
import com.example.wedding.http.bean.HomeInfoBean;
import com.example.wedding.mvvm.model.HomeModel;
import com.example.wedding.mvvm.view.adapter.WeddingTypeAdapter;
import com.example.wedding.mvvm.view.bean.HomeWeddingBean;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.SharedPreferencesUtil;
import com.example.wedding.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class HomeViewModel extends BaseViewModel<HomeModel> {
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

    public MutableLiveData<List<String>> bannerImageList;

    public WeddingTypeAdapter mWeddingTypeAdapter;
    private List<String> mBannerList;
    private List<HomeWeddingBean> mWeddingTypeList;

    public HomeViewModel(@NonNull Application application) {
        super(application, new HomeModel());
        init();
    }

    private void init() {
        mBannerList = new ArrayList<>();
        mWeddingTypeList = new ArrayList<>();
        location = new ObservableField<>();
        locationCommand = new BindingCommand(() -> {
            //
            //
        });

        searchCommand = new BindingCommand(() -> {
            //
            //
        });

        bannerImageList = new MutableLiveData<>();

        mWeddingTypeAdapter = new WeddingTypeAdapter();

        mWeddingTypeAdapter.setOnItemClickListener((adapter, view, position) -> {
            HomeWeddingBean bean = mWeddingTypeList.get(position);
            LogUtil.e(bean.getTarget_type() + "");
            switch (bean.getTarget_type()) {
                case "20"://商家
                    ARouter.getInstance().build(ARouterPath.BUSINESS_ACTIVITY).navigation();
                    break;
                case "39":
                    ARouter.getInstance().build(ARouterPath.PHOTO_BUSINESS_ACTIVITY).navigation();
                    break;
                default:
                    ToastUtil.show(getApplication(), "功能暂未开通");
                    break;

            }
        });
    }

    @Override
    public void onCreate() {
        SharedPreferencesUtil.getInstance().putInt(SharedPreferencesKey.CITY_ID, 63);
        mModel.getHomeInfo(118.833373, 31.759363, "江苏省",
                "南京市", "江宁区", 63, 63, mLifecycleProvider,
                this::setHomePageInfo,
                throwable -> {
                    ToastUtil.show(getApplication(), "获取主页数据失败，message：" + throwable.getMessage());
                    LogUtil.e("获取主页数据失败，message：" + throwable.getMessage());
                });
    }

    @Override
    public void onResume() {
        location.set(SharedPreferencesUtil.getInstance().getString(SharedPreferencesKey.LOCATION, "南京"));
    }

    /**
     * 设置主页信息
     *
     * @param homeInfoBean
     */
    private void setHomePageInfo(HomeInfoBean homeInfoBean) {
        mBannerList.clear();
        mWeddingTypeList.clear();
        if (homeInfoBean != null && homeInfoBean.getStatus().getRetCode() == 0) {
            HomeInfoBean.DataBeanXX.ListBeanXX bannerXX = homeInfoBean.getData().getList().get(0);
            for (HomeInfoBean.DataBeanXX.ListBeanXX.DataBeanX.ListBeanX beanX : bannerXX.getData().getList()) {
                mBannerList.add(beanX.getImage_path());
            }

            HomeInfoBean.DataBeanXX.ListBeanXX typeXX = homeInfoBean.getData().getList().get(1);
            HomeWeddingBean typeBean;
            for (HomeInfoBean.DataBeanXX.ListBeanXX.DataBeanX.ListBeanX beanX : typeXX.getData().getList()) {
                typeBean = new HomeWeddingBean();
                typeBean.setId(beanX.getId());
                typeBean.setTarget_type(beanX.getTarget_type());
                typeBean.setTarget_url(beanX.getTarget_url());
                typeBean.setTarget_id(beanX.getTarget_id());
                typeBean.setImage_path(beanX.getImage_path());
                typeBean.setTitle(beanX.getTitle());
                typeBean.setWatch_count(beanX.getWatch_count());
                typeBean.setExtention(beanX.getExtention());
                typeBean.setSub_title(beanX.getSub_title());
                typeBean.setIs_highlight(beanX.getIs_highlight());
                typeBean.setIs_valid(beanX.getIs_valid());
                typeBean.setRoute(beanX.getRoute());
                mWeddingTypeList.add(typeBean);
            }
        }
        bannerImageList.postValue(mBannerList);
        mWeddingTypeAdapter.setNewData(mWeddingTypeList);
    }

}

package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.constant.SharedPreferencesKey;
import com.example.wedding.http.bean.GoodsHttpBen;
import com.example.wedding.mvvm.model.WeddGoodsModel;
import com.example.wedding.mvvm.view.adapter.WeddGoodsAdapter;
import com.example.wedding.mvvm.view.bean.WeddGoodsBean;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.SharedPreferencesUtil;
import com.example.wedding.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class GoodsViewModel extends BaseViewModel<WeddGoodsModel> {

    public MutableLiveData<List<String>> sendBannerList;

    public WeddGoodsAdapter goodsAdapter;
    private List<String> mBannerList;
    private List<WeddGoodsBean> mWeddGoodsList;


    public GoodsViewModel(@NonNull Application application) {
        super(application, new WeddGoodsModel());
        init();
    }

    private void init() {
        sendBannerList = new MutableLiveData<>();
        goodsAdapter = new WeddGoodsAdapter();
        mBannerList = new ArrayList<>();
        mWeddGoodsList = new ArrayList<>();


        goodsAdapter.setOnItemClickListener((adapter, view, position) -> {
            WeddGoodsBean bean = mWeddGoodsList.get(position);
            switch (bean.getTarget_type()) {
                default:
                    ToastUtil.show(getApplication(), "功能暂未开通");
                    break;

            }
        });


    }

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtil.getInstance().putInt(SharedPreferencesKey.CITY_ID, 63);
        mModel.getGoods(118.833373, 31.759363, "江苏省",
                "南京市", "江宁区", 63, 63, mLifecycleProvider,
                this::setGoodsInfo,
                throwable -> {
                    ToastUtil.show(getApplication(), "获取主页数据失败，message：" + throwable.getMessage());
                    LogUtil.e("获取主页数据失败，message：" + throwable.getMessage());
                });
    }

    private void setGoodsInfo(GoodsHttpBen goodsHttpBen) {
        mBannerList.clear();
        mWeddGoodsList.clear();
        if (goodsHttpBen != null && goodsHttpBen.getStatus().getRetCode() == 0) {
            GoodsHttpBen.DataBean.FloorsBean.SiteShopChannelBean bannerBean = goodsHttpBen.getData().getFloors().getSITE_SHOP_CHANNEL_BANNER();

            for (GoodsHttpBen.DataBean.FloorsBean.SiteShopChannelBean.HolesBeanX beanX : bannerBean.getHoles()) {
                if (beanX.getPosters() != null)
                    mBannerList.add(beanX.getPosters().getImage_path());
            }

            GoodsHttpBen.DataBean.FloorsBean.SiteShopCategoryBean categoryBean = goodsHttpBen.getData().getFloors().getSITE_SHOP_CATEGORY();
            WeddGoodsBean goodsBean;
            for (GoodsHttpBen.DataBean.FloorsBean.SiteShopCategoryBean.HolesBeanXXX beanX : categoryBean.getHoles()) {
                goodsBean = new WeddGoodsBean();
                goodsBean.setId(beanX.getPosters().getId());
                goodsBean.setTarget_type(beanX.getPosters().getTarget_type());
                goodsBean.setTarget_url(beanX.getPosters().getTarget_url());
                goodsBean.setTarget_id(beanX.getPosters().getTarget_id());
                goodsBean.setImage_path(beanX.getPosters().getImage_path());
                goodsBean.setTitle(beanX.getPosters().getTitle());
                goodsBean.setWatch_count(beanX.getPosters().getWatch_count());
                goodsBean.setExtention(beanX.getPosters().getExtention());
                goodsBean.setSub_title(beanX.getPosters().getSub_title());
                goodsBean.setIs_highlight(beanX.getPosters().getIs_highlight());
                goodsBean.setIs_valid(beanX.getPosters().getIs_valid());
                goodsBean.setRoute(beanX.getPosters().getRoute());
                mWeddGoodsList.add(goodsBean);
            }
        }
        sendBannerList.postValue(mBannerList);
        goodsAdapter.setNewData(mWeddGoodsList);
    }
}

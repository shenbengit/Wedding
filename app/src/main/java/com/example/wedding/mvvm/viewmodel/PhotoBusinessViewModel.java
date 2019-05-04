package com.example.wedding.mvvm.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.wedding.R;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.http.bean.BusinessListBean;
import com.example.wedding.http.bean.BusinessOverviewBean;
import com.example.wedding.mvvm.model.PhotoBusinessModel;
import com.example.wedding.mvvm.view.adapter.BusinessAdapter;
import com.example.wedding.mvvm.view.bean.BusinessEmceeBean;
import com.example.wedding.mvvm.view.bean.BusinessHotelBean;
import com.example.wedding.mvvm.view.bean.BusinessPhotographyBean;
import com.example.wedding.mvvm.view.bean.RecyclerPopupBean;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.ToastUtil;
import com.example.wedding.widget.RecyclerPopup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.functions.Action;
import razerdp.basepopup.BasePopupWindow;

public class PhotoBusinessViewModel extends BaseViewModel<PhotoBusinessModel> {
    /**
     * 商家-婚纱摄影
     */
    public static final int BUSINESS_PHOTOGRAPHY = 6;
    /**
     * 地区是否选中
     */
    public ObservableField<Boolean> isAreaChecked;
    public ObservableField<String> areaString;
    /**
     * 地区点击事件
     */
    public BindingCommand areaCommand;

    public BusinessAdapter mAdapter;
    /**
     * 当前商家列表信息所有数据
     */
    private List<MultiItemEntity> mBusinessInfoList;
    private List<MultiItemEntity> mBusinessInfoAreaList;

    private List<RecyclerPopupBean> mAreaList;
    public RecyclerPopup mPopup;

    public PhotoBusinessViewModel(@NonNull Application application) {
        super(application, new PhotoBusinessModel());
        init();
    }

    private void init() {
        mBusinessInfoList = new ArrayList<>();
        mAreaList = new ArrayList<>();
        mBusinessInfoAreaList = new ArrayList<>();
        isAreaChecked = new ObservableField<>(false);
        areaString = new ObservableField<>();

        areaCommand = new BindingCommand(() -> {
            if (isAreaChecked.get()) {
                mPopup.dismiss();
            } else {
                isAreaChecked.set(true);
                //显示Popup
                showPopup(mAreaList);
            }
        });
        mAdapter = new BusinessAdapter();

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
                    ToastUtil.show(getApplication(), "获取商家概览出错啦！请稍后重试。ErrorMessage: " + throwable.getMessage());
                    LogUtil.e("商家概览: onError: " + throwable.getMessage());
                });
    }

    public void initPopup(Activity activity) {
        mPopup = new RecyclerPopup(activity);
        mPopup.setOnDismissListener(new BasePopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                isAreaChecked.set(false);
            }
        });

        mPopup.setOnItemClickListener(position -> {
            areaString.set(mAreaList.get(position).getOption());
            screenBusinessAreaList();
        });
    }

    private void showPopup(List<RecyclerPopupBean> list) {
        mPopup.setNewData(BUSINESS_PHOTOGRAPHY, list);
        getBaseLiveData().postValue("1");
    }

    /**
     * 筛选符合地区选择的商家信息
     */
    private void screenBusinessAreaList() {
        mBusinessInfoAreaList.clear();
        if (TextUtils.equals(areaString.get(), mAreaList.get(0).getOption())) {
            mBusinessInfoAreaList.addAll(mBusinessInfoList);
        } else {
            BusinessPhotographyBean photographyBean;
            for (MultiItemEntity entity : mBusinessInfoList) {
                photographyBean = (BusinessPhotographyBean) entity;
                if (TextUtils.equals(areaString.get(), photographyBean.getArea())) {
                    mBusinessInfoAreaList.add(entity);
                }
            }
        }
        mAdapter.setNewData(mBusinessInfoAreaList);
    }

    /**
     * 解析商家概况数据
     *
     * @param bean 商家概况数据
     */
    private void parseBusinessOverviewData(BusinessOverviewBean bean) {
        if (bean == null || bean.getStatus() == null) {
            LogUtil.e("商家概览: parseBusinessOverviewData: 数据出错");
            return;
        }
        if (bean.getStatus().getRetCode() != 0) {
            LogUtil.e("商家概览: parseBusinessOverviewData: Message: " + bean.getStatus().getMsg());
            return;
        }
        RecyclerPopupBean popupBean;

        popupBean = new RecyclerPopupBean(bean.getData().getCity().isEmpty()
                ? "全城" : bean.getData().getCity().get(0).getArea_name(), true, 0, -1);
        mAreaList.add(popupBean);
        for (BusinessOverviewBean.DataBean.AreaBean areaBean : bean.getData().getArea()) {
            popupBean = new RecyclerPopupBean(areaBean.getArea_name(), false, 0, Integer.parseInt(areaBean.getSort()));
            mAreaList.add(popupBean);
        }
        Collections.sort(mAreaList);
        areaString.set(mAreaList.get(0).getOption());

        getBusinessList(1, 30);
    }

    /**
     * 获取商家列表信息
     *
     * @param page    查询页
     * @param perPage 每页数量
     */
    private synchronized void getBusinessList(int page, int perPage) {
        mModel.getBusinessList(mLifecycleProvider, page, perPage, BUSINESS_PHOTOGRAPHY, 0, 0, "default",
                new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                }, this::parseBusinessListData,
                throwable -> {
                    ToastUtil.show(getApplication(), "获取商家列表出错啦！请稍后重试。ErrorMessage: " + throwable.getMessage());
                    LogUtil.e("商家列表: onError: " + throwable.getMessage());
                });
    }

    /**
     * 解析商家列表数据
     *
     * @param bean 数据
     */
    private void parseBusinessListData(BusinessListBean bean) {
        if (bean == null || bean.getStatus() == null) {
            LogUtil.e("商家列表: parseBusinessListData: 数据出错");
            return;
        }
        if (bean.getStatus().getRetCode() != 0 || bean.getData() == null) {
            LogUtil.e("商家列表: parseBusinessListData: Message: " + bean.getStatus().getMsg());
            return;
        }
        mBusinessInfoList.clear();

        parseBusinessPhotographyData(bean.getData());

        screenBusinessAreaList();
    }

    /**
     * 解析婚纱摄影数据
     *
     * @param data
     */
    private void parseBusinessPhotographyData(BusinessListBean.DataBean data) {
        BusinessPhotographyBean bean;
        if (data.getPopular_merchant() != null && data.getPopular_merchant().getList() != null) {
            for (BusinessListBean.DataBean.PopularMerchantBean.ListBean listBean : data.getPopular_merchant().getList()) {
                bean = new BusinessPhotographyBean();
                bean.setItemType(BUSINESS_PHOTOGRAPHY);
                bean.setImagePath(listBean.getLogo_path());
                bean.setName(listBean.getName());
                bean.setGrade(listBean.getGrade());
                bean.setScore(listBean.getMerchant_comment() != null ? listBean.getMerchant_comment().getScore() : null);
                bean.setCommentCount(listBean.getComments_count());
                bean.setPriceStart(listBean.getPrice_start());
                bean.setArea(listBean.getArea());
                bean.setLatitude(listBean.getLatitude());
                bean.setLongitude(listBean.getLongitude());
                if (listBean.getMerchant_tags() != null && !listBean.getMerchant_tags().isEmpty()) {
                    bean.setMerchantTag(listBean.getMerchant_tags().get(0).getName());
                }
                if (listBean.getMerchant_achievement() != null) {
                    bean.setAchievementTitle(listBean.getMerchant_achievement().getTitle());
                    bean.setAchievementImage(listBean.getMerchant_achievement().getLabel_img());
                }
                if (listBean.getPrivilege() != null) {
                    bean.setShopGift(listBean.getPrivilege().getShop_gift());
                }
                bean.setShopGiftImage(R.drawable.ic_gift);
                mBusinessInfoList.add(bean);
            }
        }

        if (data.getNormal_merchant() != null && data.getNormal_merchant().getList() != null) {
            for (BusinessListBean.DataBean.NormalMerchantBean.ListBeanX listBeanX : data.getNormal_merchant().getList()) {
                bean = new BusinessPhotographyBean();
                bean.setItemType(BUSINESS_PHOTOGRAPHY);
                bean.setImagePath(listBeanX.getLogo_path());
                bean.setName(listBeanX.getName());
                bean.setGrade(listBeanX.getGrade());
                bean.setScore(listBeanX.getMerchant_comment() != null ? listBeanX.getMerchant_comment().getScore() : null);
                bean.setCommentCount(listBeanX.getComments_count());
                bean.setPriceStart(listBeanX.getPrice_start());
                bean.setArea(listBeanX.getArea());
                bean.setLatitude(listBeanX.getLatitude());
                bean.setLongitude(listBeanX.getLongitude());
                if (listBeanX.getMerchant_tags() != null && !listBeanX.getMerchant_tags().isEmpty()) {
                    bean.setMerchantTag(listBeanX.getMerchant_tags().get(0).getName());
                }
                if (listBeanX.getPrivilege() != null) {
                    bean.setShopGift(listBeanX.getPrivilege().getShop_gift());
                }
                bean.setShopGiftImage(R.drawable.ic_gift);
                mBusinessInfoList.add(bean);
            }
        }

        LogUtil.i("解析婚纱摄影数据: " + mBusinessInfoList.size());
    }
}

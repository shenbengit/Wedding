package com.example.wedding.mvvm.viewmodel;


import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.wedding.R;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingAction;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.binding.command.BindingConsumer;
import com.example.wedding.http.bean.BusinessListBean;
import com.example.wedding.http.bean.BusinessOverviewBean;
import com.example.wedding.mvvm.model.BusinessModel;
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
import io.reactivex.functions.Consumer;
import razerdp.basepopup.BasePopupWindow;

public class BusinessViewModel extends BaseViewModel<BusinessModel> {
    /**
     * 下拉选项-商家类型
     */
    private static final int POPUP_TYPE_BUSINESS = 1;
    /**
     * 下拉选项-地区选项
     */
    private static final int POPUP_TYPE_AREA = 2;
    /**
     * 商家-婚纱摄影
     */
    public static final int BUSINESS_PHOTOGRAPHY = 6;
    /**
     * 商家-婚礼司仪
     */
    public static final int BUSINESS_EMCEE = 11;
    /**
     * 商家-婚宴酒店
     */
    public static final int BUSINESS_HOTEL = 13;

    public static final String SHOW_RECYCLER_POPUP = "SHOW_RECYCLER_POPUP";
    /**
     * 酒店类型是否点击
     */
    public ObservableField<Boolean> isBusinessChecked;
    public ObservableField<String> businessString;
    /**
     * 酒店类型点击事件
     */
    public BindingCommand businessCommand;
    /**
     * 地区是否选中
     */
    public ObservableField<Boolean> isAreaChecked;
    public ObservableField<String> areaString;
    /**
     * 地区点击事件
     */
    public BindingCommand areaCommand;

    public RecyclerPopup mPopup;

    private List<RecyclerPopupBean> mBusinessList;
    private List<RecyclerPopupBean> mAreaList;
    /**
     * 当前商家类型
     */
    private int mBusinessType;
    public BusinessAdapter mAdapter;
    /**
     * 当前商家列表信息所有数据
     */
    private List<MultiItemEntity> mBusinessInfoList;
    /**
     * 当前商家列表信息符合地区选择的所有数据
     */
    private List<MultiItemEntity> mBusinessInfoAreaList;

    public BusinessViewModel(@NonNull Application application) {
        super(application, new BusinessModel());
        mAdapter = new BusinessAdapter();
        mBusinessInfoList = new ArrayList<>();
        mBusinessInfoAreaList = new ArrayList<>();

        //商家列表点击事件
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            MultiItemEntity entity = mBusinessInfoAreaList.get(position);
            BusinessPhotographyBean photographyBean;
            BusinessEmceeBean emceeBean;
            BusinessHotelBean hotelBean;
            switch (mBusinessType) {
                case BUSINESS_PHOTOGRAPHY:
                    photographyBean = (BusinessPhotographyBean) entity;

                    break;
                case BUSINESS_EMCEE:
                    emceeBean = (BusinessEmceeBean) entity;

                    break;
                case BUSINESS_HOTEL:
                    hotelBean = (BusinessHotelBean) entity;

                    break;
            }
        });
        mBusinessList = new ArrayList<>();
        mAreaList = new ArrayList<>();
        isBusinessChecked = new ObservableField<>(false);
        businessString = new ObservableField<>();
        businessCommand = new BindingCommand(() -> {
            if (isBusinessChecked.get()) {
                mPopup.dismiss();
            } else {
                isBusinessChecked.set(true);
                //显示Popup
                showPopup(POPUP_TYPE_BUSINESS, mBusinessList);
            }
            isAreaChecked.set(false);
        });

        isAreaChecked = new ObservableField<>(false);
        areaString = new ObservableField<>();
        areaCommand = new BindingCommand(() -> {
            if (isAreaChecked.get()) {
                mPopup.dismiss();
            } else {
                isAreaChecked.set(true);
                //显示Popup
                showPopup(POPUP_TYPE_AREA, mAreaList);
            }
            isBusinessChecked.set(false);
        });
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

    /**
     * 初始化Popup
     *
     * @param activity
     */
    public void initPopup(Activity activity) {
        mPopup = new RecyclerPopup(activity);
        mPopup.setOnDismissListener(new BasePopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                isBusinessChecked.set(false);
                isAreaChecked.set(false);
            }
        });

        mPopup.setOnItemClickListener(position -> {
            switch (mPopup.getShowType()) {
                case POPUP_TYPE_BUSINESS:
                    RecyclerPopupBean bean = mBusinessList.get(position);
                    businessString.set(bean.getOption());
                    int index = bean.getIndex();
                    if (mBusinessType != index) {
                        mBusinessType = index;
                        getBusinessList(1, 30);
                    }
                    break;
                case POPUP_TYPE_AREA:
                    areaString.set(mAreaList.get(position).getOption());
                    screenBusinessAreaList();
                    break;
                default:
                    break;
            }
        });
    }

    private void showPopup(int showPopupType, List<RecyclerPopupBean> list) {
        mPopup.setNewData(showPopupType, list);
        getBaseLiveData().postValue(SHOW_RECYCLER_POPUP);
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

        for (BusinessOverviewBean.DataBean.PropertiesBean propertiesBean : bean.getData().getProperties()) {
            switch (Integer.parseInt(propertiesBean.getId())) {
                case BUSINESS_PHOTOGRAPHY://婚纱摄影
                case BUSINESS_EMCEE://婚礼司仪
                case BUSINESS_HOTEL://婚宴酒店
                    popupBean = new RecyclerPopupBean(propertiesBean.getName(), false, Integer.parseInt(propertiesBean.getId()), 0);
                    mBusinessList.add(popupBean);
                    break;
                default:
                    break;
            }
        }
        //设置默认请求的商家类型
        mBusinessType = mBusinessList.get(0).getIndex();
        mBusinessList.get(0).setChecked(true);
        businessString.set(mBusinessList.get(0).getOption());

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
        mModel.getBusinessList(mLifecycleProvider, page, perPage, mBusinessType, 0, 0, "default",
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
        switch (mBusinessType) {
            case BUSINESS_PHOTOGRAPHY://婚纱摄影
                parseBusinessPhotographyData(bean.getData());
                break;
            case BUSINESS_EMCEE://婚礼司仪
                parseBusinessEmceeData(bean.getData());
                break;
            case BUSINESS_HOTEL://婚宴酒店
                parseBusinessHotelData(bean.getData());
                break;
        }
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

    /**
     * 解析婚礼司仪数据
     *
     * @param data
     */
    private void parseBusinessEmceeData(BusinessListBean.DataBean data) {
        BusinessEmceeBean bean;
        if (data.getNormal_merchant() != null && data.getNormal_merchant().getList() != null) {
            for (BusinessListBean.DataBean.NormalMerchantBean.ListBeanX listBeanX : data.getNormal_merchant().getList()) {
                bean = new BusinessEmceeBean();
                bean.setItemType(BUSINESS_EMCEE);
                bean.setImagePath(listBeanX.getLogo_path());
                bean.setName(listBeanX.getName());
                bean.setGrade(listBeanX.getGrade());
                bean.setScore(listBeanX.getMerchant_comment() != null ? listBeanX.getMerchant_comment().getScore() : null);
                bean.setCommentCount(listBeanX.getComments_count());
                bean.setPriceStart(listBeanX.getPrice_start());
                bean.setArea(listBeanX.getArea());
                bean.setLatitude(listBeanX.getLatitude());
                bean.setLongitude(listBeanX.getLongitude());
                mBusinessInfoList.add(bean);
            }
        }
        LogUtil.i("解析婚礼司仪数据: " + mBusinessInfoList.size());
    }

    /**
     * 解析婚宴酒店数据
     *
     * @param data
     */
    private void parseBusinessHotelData(BusinessListBean.DataBean data) {
        BusinessHotelBean bean;
        if (data.getNormal_merchant() != null && data.getNormal_merchant().getList() != null) {
            for (BusinessListBean.DataBean.NormalMerchantBean.ListBeanX listBeanX : data.getNormal_merchant().getList()) {
                bean = new BusinessHotelBean();
                bean.setItemType(BUSINESS_HOTEL);
                bean.setImagePath(listBeanX.getLogo_path());
                bean.setName(listBeanX.getName());
                bean.setGrade(listBeanX.getGrade());
                bean.setScore(listBeanX.getMerchant_comment() != null ? listBeanX.getMerchant_comment().getScore() : null);
                bean.setArea(listBeanX.getArea());
                bean.setLatitude(listBeanX.getLatitude());
                bean.setLongitude(listBeanX.getLongitude());
                if (listBeanX.getHotel() != null) {
                    bean.setKind(listBeanX.getHotel().getKind());
                    bean.setTableMin(listBeanX.getHotel().getTable_min());
                    bean.setTableMax(listBeanX.getHotel().getTable_max());
                    bean.setTablePriceStart(listBeanX.getHotel().getPrice_start());
                }
                bean.setOrderCount(listBeanX.getHotel_order_view_count());
                mBusinessInfoList.add(bean);
            }
        }
        LogUtil.i("解析婚宴酒店数据: " + mBusinessInfoList.size());
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
            BusinessEmceeBean emceeBean;
            BusinessHotelBean hotelBean;
            for (MultiItemEntity entity : mBusinessInfoList) {
                switch (mBusinessType) {
                    case BUSINESS_PHOTOGRAPHY:
                        photographyBean = (BusinessPhotographyBean) entity;
                        if (TextUtils.equals(areaString.get(), photographyBean.getArea())) {
                            mBusinessInfoAreaList.add(entity);
                        }
                        break;
                    case BUSINESS_EMCEE:
                        emceeBean = (BusinessEmceeBean) entity;
                        if (TextUtils.equals(areaString.get(), emceeBean.getArea())) {
                            mBusinessInfoAreaList.add(entity);
                        }
                        break;
                    case BUSINESS_HOTEL:
                        hotelBean = (BusinessHotelBean) entity;
                        if (TextUtils.equals(areaString.get(), hotelBean.getArea())) {
                            mBusinessInfoAreaList.add(entity);
                        }
                        break;
                }
            }
        }
        mAdapter.setNewData(mBusinessInfoAreaList);
    }
}

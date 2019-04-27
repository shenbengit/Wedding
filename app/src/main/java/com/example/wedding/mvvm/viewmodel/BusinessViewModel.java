package com.example.wedding.mvvm.viewmodel;


import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingAction;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.binding.command.BindingConsumer;
import com.example.wedding.http.bean.BusinessListBean;
import com.example.wedding.http.bean.BusinessOverviewBean;
import com.example.wedding.mvvm.model.BusinessModel;
import com.example.wedding.mvvm.view.adapter.BusinessAdapter;
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

    public BusinessViewModel(@NonNull Application application) {
        super(application, new BusinessModel());
        mAdapter = new BusinessAdapter();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

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
                    ToastUtil.show(getApplication(), "出错啦！请稍后重试。ErrorMessage: " + throwable.getMessage());
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
                        getBusinessList(1, 20, index);
                    }
                    break;
                case POPUP_TYPE_AREA:
                    areaString.set(mAreaList.get(position).getOption());
                    LogUtil.i("Popup列表：" + mAreaList.get(position).getOption());
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

        getBusinessList(1, 20, mBusinessType);
    }

    /**
     * 获取商家列表信息
     *
     * @param page     查询页
     * @param perPage  每页数量
     * @param property 商家类型
     */
    private void getBusinessList(int page, int perPage, int property) {
        mModel.getBusinessList(mLifecycleProvider, page, perPage, property, 0, 0, "default",
                new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                }, new Consumer<BusinessListBean>() {
                    @Override
                    public void accept(BusinessListBean businessListBean) throws Exception {
                        LogUtil.i("商家列表信息： " + businessListBean.getStatus().getRetCode());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}

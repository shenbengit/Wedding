package com.example.wedding.mvvm.view.bean;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.wedding.BR;

/**
 * 婚宴酒店
 */
public class BusinessHotelBean implements MultiItemEntity, Observable {
    private int itemType;
    /**
     * 商家图片
     */
    private String imagePath;
    /**
     * 商家名称
     */
    private String name;
    /**
     * 商家等级
     */
    private int grade;
    /**
     * 商家评分
     */
    private String score;
    /**
     * 地区
     */
    private String area;
    /**
     * 经度
     */
    private String latitude;
    /**
     * 纬度
     */
    private String longitude;
    /**
     * 酒店类型
     */
    private String kind;
    /**
     * 起订最小数量
     */
    private String tableMin;
    /**
     * 起订最大数量
     */
    private String tableMax;
    /**
     * 每桌起价
     */
    private String tablePriceStart;
    /**
     * 已下订单数量
     */
    private int orderCount;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();


    @Bindable
    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
        notifyChange(BR.itemType);
    }

    @Bindable
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        notifyChange(BR.imagePath);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange(BR.name);
    }

    @Bindable
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
        notifyChange(BR.grade);
    }

    @Bindable
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
        notifyChange(BR.score);
    }

    @Bindable
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
        notifyChange(BR.area);
    }

    @Bindable
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
        notifyChange(BR.latitude);
    }

    @Bindable
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
        notifyChange(BR.longitude);
    }

    @Bindable
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
        notifyChange(BR.kind);
    }

    @Bindable
    public String getTableMin() {
        return tableMin;
    }

    public void setTableMin(String tableMin) {
        this.tableMin = tableMin;
        notifyChange(BR.tableMin);
    }

    @Bindable
    public String getTableMax() {
        return tableMax;
    }

    public void setTableMax(String tableMax) {
        this.tableMax = tableMax;
        notifyChange(BR.tableMax);
    }

    @Bindable
    public String getTablePriceStart() {
        return tablePriceStart;
    }

    public void setTablePriceStart(String tablePriceStart) {
        this.tablePriceStart = tablePriceStart;
        notifyChange(BR.tablePriceStart);
    }

    @Bindable
    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
        notifyChange(BR.orderCount);
    }

    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }
}

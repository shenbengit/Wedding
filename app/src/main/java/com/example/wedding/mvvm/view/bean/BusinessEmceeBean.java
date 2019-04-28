package com.example.wedding.mvvm.view.bean;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.wedding.BR;

/**
 * 婚礼司仪
 */
public class BusinessEmceeBean implements MultiItemEntity, Observable {
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
    private String grade;
    /**
     * 商家评分
     */
    private String score;
    /**
     * 评价次数
     */
    private String commentCount;
    /**
     * 起价
     */
    private String priceStart;
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
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
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
    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
        notifyChange(BR.commentCount);
    }

    @Bindable
    public String getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(String priceStart) {
        this.priceStart = priceStart;
        notifyChange(BR.priceStart);
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

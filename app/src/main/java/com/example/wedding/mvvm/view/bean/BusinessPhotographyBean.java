package com.example.wedding.mvvm.view.bean;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.text.TextUtils;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.wedding.BR;
import com.example.wedding.R;

/**
 * 婚纱摄影
 */
public class BusinessPhotographyBean implements MultiItemEntity, Observable {
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
    /**
     * 商家标签
     */
    private String merchantTag;
    /**
     * 获得成就标题
     */
    private String achievementTitle;
    /**
     * 成就图片
     */
    private String achievementImage;
    /**
     * 到店礼
     */
    private String shopGift;
    /**
     * 到店礼图标
     */
    private int shopGiftImage;

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
        if (TextUtils.isEmpty(grade)) {
            return R.drawable.ic_merchant_level2;
        }
        switch (grade) {
            case "2":
                return R.drawable.ic_merchant_level2;
            case "3":
                return R.drawable.ic_merchant_level3;
            case "4":
                return R.drawable.ic_merchant_level4;
            default:
                return R.drawable.ic_merchant_level3;
        }
    }

    public void setGrade(String grade) {
        this.grade = grade;
        notifyChange(BR.grade);
    }

    @Bindable
    public String getScore() {
        if (TextUtils.isEmpty(score)) {
            return "0分";
        }
        return score + "分";
    }

    public void setScore(String score) {
        this.score = score;
        notifyChange(BR.score);
    }

    @Bindable
    public String getCommentCount() {
        if (TextUtils.isEmpty(commentCount)) {
            return "0条";
        }
        return commentCount + "条";
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
        notifyChange(BR.commentCount);
    }

    @Bindable
    public String getPriceStart() {
        if (TextUtils.isEmpty(priceStart)) {
            return "￥0起";
        }
        return "￥" + priceStart + "起";
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

    @Bindable
    public String getMerchantTag() {
        return merchantTag;
    }

    public void setMerchantTag(String merchantTag) {
        this.merchantTag = merchantTag;
        notifyChange(BR.merchantTag);
    }

    @Bindable
    public String getAchievementTitle() {
        return achievementTitle;
    }

    public void setAchievementTitle(String achievementTitle) {
        this.achievementTitle = achievementTitle;
        notifyChange(BR.achievementTitle);
    }

    @Bindable
    public String getAchievementImage() {
        return achievementImage;
    }

    public void setAchievementImage(String achievementImage) {
        this.achievementImage = achievementImage;
        notifyChange(BR.achievementImage);
    }

    @Bindable
    public String getShopGift() {
        return shopGift;
    }

    public void setShopGift(String shopGift) {
        this.shopGift = shopGift;
        notifyChange(BR.shopGift);
    }

    @Bindable
    public int getShopGiftImage() {
        return shopGiftImage;
    }

    public void setShopGiftImage(int shopGiftImage) {
        this.shopGiftImage = shopGiftImage;
        notifyChange(BR.shopGiftImage);
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

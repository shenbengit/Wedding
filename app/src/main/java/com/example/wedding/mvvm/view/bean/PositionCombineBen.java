package com.example.wedding.mvvm.view.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wedding.BR;

public class PositionCombineBen extends BaseObservable {

    private String weddName; // 登记处全名
    private String position; //详细地址
    private String area; //区
    private String workTime; //
    private String telephone; //工作联系电话
    private String isHoliday;  //登记处是否节假日工作

    public PositionCombineBen() {
    }

    public PositionCombineBen(String weddName, String position, String area, String workTime, String telephone, String isHoliday) {
        this.weddName = weddName;
        this.position = position;
        this.area = area;
        this.workTime = workTime;
        this.telephone = telephone;
        this.isHoliday = isHoliday;
    }

    @Bindable
    public String getWeddName() {
        return weddName;
    }

    public void setWeddName(String weddName) {
        this.weddName = weddName;
        notifyPropertyChanged(BR.weddName);
    }

    @Bindable
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
        notifyPropertyChanged(BR.position);
    }

    @Bindable
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
        notifyPropertyChanged(BR.area);
    }

    @Bindable
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
        notifyPropertyChanged(BR.workTime);
    }

    @Bindable
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
        notifyPropertyChanged(BR.telephone);
    }

    @Bindable
    public String getHoliday() {
        return isHoliday;
    }

    public void setHoliday(String holiday) {
        isHoliday = holiday;
        notifyPropertyChanged(BR.holiday);
    }
}

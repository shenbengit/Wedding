package com.example.wedding.mvvm.view.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class PositionCombineBen extends BaseObservable {
    @Bindable
    private String weddName; // 登记处全名
    @Bindable
    private String position; //详细地址
    @Bindable
    private String area; //区
    @Bindable
    private String workTime; //
    @Bindable
    private String telephone; //工作联系电话
    @Bindable
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

    public String getWeddName() {
        return weddName;
    }

    public void setWeddName(String weddName) {
        this.weddName = weddName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHoliday() {
        return isHoliday;
    }

    public void setHoliday(String holiday) {
        isHoliday = holiday;
    }
}

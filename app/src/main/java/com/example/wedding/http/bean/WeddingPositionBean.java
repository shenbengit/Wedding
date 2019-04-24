package com.example.wedding.http.bean;


import cn.bmob.v3.BmobObject;

/**
 * 婚姻登记处bean
 */
public class WeddingPositionBean extends BmobObject{
    private String weddingName;     // 登记处全名
    private String position;        //详细地址
    private String area;            //区
    private String weekStart;       //每周工作开始日
    private String weekStop;        //每周工作结束日
    private Integer amBegin;        //工作日上午开始时间
    private Integer amStop;         //工作日上午结束时间
    private Integer pmBegin;        //工作日下午开始时间
    private Integer pmStop;         //工作日下午结束时间
    private String telephone;       //工作联系电话
    private Boolean isHoliday;      //登记处是否节假日工作

    public WeddingPositionBean() {
    }

    public WeddingPositionBean(String weddingName, String position, String area, String weekStart, String weekStop, Integer amBegin, Integer amStop, Integer pmBegin, Integer pmStop, String telephone, Boolean isHoliday) {
        this.weddingName = weddingName;
        this.position = position;
        this.area = area;
        this.weekStart = weekStart;
        this.weekStop = weekStop;
        this.amBegin = amBegin;
        this.amStop = amStop;
        this.pmBegin = pmBegin;
        this.pmStop = pmStop;
        this.telephone = telephone;
        this.isHoliday = isHoliday;
    }

    public String getWeddingName() {
        return weddingName;
    }

    public void setWeddingName(String weddingName) {
        this.weddingName = weddingName;
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

    public String getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(String weekStart) {
        this.weekStart = weekStart;
    }

    public String getWeekStop() {
        return weekStop;
    }

    public void setWeekStop(String weekStop) {
        this.weekStop = weekStop;
    }

    public Integer getAmBegin() {
        return amBegin;
    }

    public void setAmBegin(Integer amBegin) {
        this.amBegin = amBegin;
    }

    public Integer getAmStop() {
        return amStop;
    }

    public void setAmStop(Integer amStop) {
        this.amStop = amStop;
    }

    public Integer getPmBegin() {
        return pmBegin;
    }

    public void setPmBegin(Integer pmBegin) {
        this.pmBegin = pmBegin;
    }

    public Integer getPmStop() {
        return pmStop;
    }

    public void setPmStop(Integer pmStop) {
        this.pmStop = pmStop;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getHoliday() {
        return isHoliday;
    }

    public void setHoliday(Boolean holiday) {
        isHoliday = holiday;
    }

}

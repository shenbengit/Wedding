package com.example.wedding.mvvm.view.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wedding.BR;

public class CalendarInfoBen extends BaseObservable {
    /**
     * avoid : 掘井.动土.破土.安葬.开光.
     * animalsYear : 猪
     * weekday : 星期四
     * suit : 祭祀.进人口.嫁娶.安床.解除.冠笄.出行.裁衣.扫舍.
     * lunarYear : 己亥年
     * lunar : 三月廿一
     * year-month : 2019-4
     * date : 2019-4-25
     */
    private String avoid;
    private String animalsYear;
    private String weekday;
    private String suit;
    private String lunarYear;
    private String lunar;
    private String yearmonth;
    private String date;

    public CalendarInfoBen() {
    }

    public CalendarInfoBen(String avoid, String animalsYear, String weekday, String suit, String lunarYear, String lunar, String yearmonth, String date) {
        this.avoid = avoid;
        this.animalsYear = animalsYear;
        this.weekday = weekday;
        this.suit = suit;
        this.lunarYear = lunarYear;
        this.lunar = lunar;
        this.yearmonth = yearmonth;
        this.date = date;
    }

    public CalendarInfoBen(String avoid, String suit, String lunarYear, String lunar) {
        this.avoid = avoid;
        this.suit = suit;
        this.lunarYear = lunarYear;
        this.lunar = lunar;
    }

    @Bindable
    public String getAvoid() {
        return avoid;
    }

    public void setAvoid(String avoid) {
        this.avoid = avoid;
        notifyPropertyChanged(BR.avoid);
    }

    @Bindable
    public String getAnimalsYear() {
        return animalsYear;
    }

    public void setAnimalsYear(String animalsYear) {
        this.animalsYear = animalsYear;
        notifyPropertyChanged(BR.animalsYear);
    }

    @Bindable
    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
        notifyPropertyChanged(BR.weekday);
    }

    @Bindable
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
        notifyPropertyChanged(BR.suit);
    }

    @Bindable
    public String getLunarYear() {
        return lunarYear;
    }

    public void setLunarYear(String lunarYear) {
        this.lunarYear = lunarYear;
        notifyPropertyChanged(BR.lunarYear);
    }

    @Bindable
    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
        notifyPropertyChanged(BR.lunar);
    }

    @Bindable
    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
        notifyPropertyChanged(BR.yearmonth);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Override
    public String toString() {
        return "CalendarInfoBen{" +
                "avoid='" + avoid + '\'' +
                ", animalsYear='" + animalsYear + '\'' +
                ", weekday='" + weekday + '\'' +
                ", suit='" + suit + '\'' +
                ", lunarYear='" + lunarYear + '\'' +
                ", lunar='" + lunar + '\'' +
                ", yearmonth='" + yearmonth + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

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
    @Bindable
    private String avoid;
    @Bindable
    private String animalsYear;
    @Bindable
    private String weekday;
    @Bindable
    private String suit;
    @Bindable
    private String lunarYear;
    @Bindable
    private String lunar;
    @Bindable
    private String yearmonth;
    @Bindable
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

    public String getAvoid() {
        return avoid;
    }

    public void setAvoid(String avoid) {
        this.avoid = avoid;
        notifyPropertyChanged(BR.avoid);
    }

    public String getAnimalsYear() {
        return animalsYear;
    }

    public void setAnimalsYear(String animalsYear) {
        this.animalsYear = animalsYear;
        notifyPropertyChanged(BR.animalsYear);
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
        notifyPropertyChanged(BR.weekday);
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
        notifyPropertyChanged(BR.suit);
    }

    public String getLunarYear() {
        return lunarYear;
    }

    public void setLunarYear(String lunarYear) {
        this.lunarYear = lunarYear;
        notifyPropertyChanged(BR.lunarYear);
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
        notifyPropertyChanged(BR.lunar);
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
        notifyPropertyChanged(BR.yearmonth);
    }

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

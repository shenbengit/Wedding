package com.example.wedding.mvvm.view.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.example.wedding.BR;

/**
 * 下拉列表popup实体bean
 */
public class RecyclerPopupBean extends BaseObservable implements Comparable<RecyclerPopupBean> {
    /**
     * 选项
     */
    private String option;
    /**
     * 是否以选中
     */
    private boolean isChecked;
    /**
     * 对应标识
     */
    private int index;
    /**
     * 排序
     */
    private int sort;

    public RecyclerPopupBean() {
    }

    public RecyclerPopupBean(String option, boolean isChecked, int index, int sort) {
        this.option = option;
        this.isChecked = isChecked;
        this.index = index;
        this.sort = sort;
    }

    @Bindable
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
        notifyPropertyChanged(BR.option);
    }

    @Bindable
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
        notifyPropertyChanged(BR.checked);
    }

    @Bindable
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        notifyPropertyChanged(BR.index);
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public int compareTo(@NonNull RecyclerPopupBean o) {
        return getSort() - o.getSort();
    }
}

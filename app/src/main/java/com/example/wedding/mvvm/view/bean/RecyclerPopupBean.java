package com.example.wedding.mvvm.view.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wedding.BR;

/**
 *
 */
public class RecyclerPopupBean extends BaseObservable {
    /**
     * 选项
     */
    @Bindable
    private String option;
    /**
     * 是否以选中
     */
    @Bindable
    private boolean isChecked;
    /**
     * 对应标识
     */
    @Bindable
    private int index;

    public RecyclerPopupBean() {
    }

    public RecyclerPopupBean(String option, boolean isChecked, int index) {
        this.option = option;
        this.isChecked = isChecked;
        this.index = index;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
        notifyPropertyChanged(BR.option);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
        notifyPropertyChanged(BR.isChecked);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        notifyPropertyChanged(BR.index);
    }
}

package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.wedding.base.BaseModel;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.util.LogUtil;

public class BudgetViewModel extends BaseViewModel<BaseModel> {

    /**
     * 设置预算（下部）是否可见
     */
    public ObservableField<Boolean> isVisible;

    /**
     * 顶部所有预算
     */
    public ObservableField<String> allBudget;

    /**
     * 修改项目点击事件
     */
    public BindingCommand changeProject;

    /**
     * 重设预算点击事件
     */
    public BindingCommand rechangeBudget;

    public BudgetViewModel(@NonNull Application application) {
        super(application, new BaseModel());
        initCommand();
    }

    private void initCommand() {
        isVisible = new ObservableField<>(false);
        allBudget = new ObservableField<>("50000");

        changeProject = new BindingCommand(() -> {
            LogUtil.d("changeProject");
        });
        rechangeBudget = new BindingCommand(() -> {
            LogUtil.d("rechangeBudget");
        });
    }

}

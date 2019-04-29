package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.wedding.R;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.mvvm.model.BudgetModel;
import com.example.wedding.mvvm.view.adapter.BudgetStyleAdapter;
import com.example.wedding.mvvm.view.bean.BudgetStyleBen;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.SharedPreferencesUtil;
import com.example.wedding.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class BudgetViewModel extends BaseViewModel<BudgetModel> {
    public static final String KEY_BUDGET = "com.example.wedding.mvvm.view.activity.BUDGET_WEDDING";

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


    public ObservableField<String> inBudget;

    public BindingCommand setBudget;

    public MutableLiveData<Integer> pieData;

    public BudgetStyleAdapter beforeAdapter;
    public BudgetStyleAdapter atAdapter;
    public BudgetStyleAdapter afterAdapter;

    private Application application;

    public BudgetViewModel(@NonNull Application application) {
        super(application, new BudgetModel());
        this.application = application;
        initCommand();
    }

    private void initCommand() {
        isVisible = new ObservableField<>(true);
        inBudget = new ObservableField<>();
        allBudget = new ObservableField<>();
        pieData = new MutableLiveData<>();

        beforeAdapter = new BudgetStyleAdapter();
        atAdapter = new BudgetStyleAdapter();
        afterAdapter = new BudgetStyleAdapter();

        setBudget = new BindingCommand(() -> {
            if (inBudget != null) {
                int budgetGet = Integer.parseInt(inBudget.get());
                if (budgetGet != 0) {
                    LogUtil.d(budgetGet + "");
                    SharedPreferencesUtil.getInstance().putInt(KEY_BUDGET, budgetGet);
                    allBudget.set("￥" + budgetGet);
                    pieData.setValue(budgetGet);
                    isVisible.set(false);
                    setAdapter(budgetGet);
                } else {
                    ToastUtil.show(getApplication(), "输入数据有误");
                }
            } else {
                ToastUtil.show(getApplication(), "请输入正确内容");
            }
        });

        changeProject = new BindingCommand(() -> {


        });
        rechangeBudget = new BindingCommand(() -> {
                isVisible.set(true);
        });

    }

    public void setAdapter(int budgetGet) {
        List<BudgetStyleBen> beforeStyles = new ArrayList<>();

        beforeStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item3, "珠宝首饰", (int) (budgetGet * 0.1)));
        beforeStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item2, "婚纱摄影", (int) (budgetGet * 0.062)));
        beforeAdapter.setNewData(beforeStyles);

        List<BudgetStyleBen> atStyles = new ArrayList<>();
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item1, "请帖喜糖", (int) (budgetGet * 0.03)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item2, "婚礼礼服", (int) (budgetGet * 0.044)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item3, "婚礼跟妆", (int) (budgetGet * 0.009)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item4, "婚礼摄像", (int) (budgetGet * 0.009)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item5, "婚礼摄影", (int) (budgetGet * 0.009)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item1, "婚礼司仪", (int) (budgetGet * 0.017)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item2, "婚礼租赁", (int) (budgetGet * 0.02)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item3, "婚礼策划", (int) (budgetGet * 0.114)));
        atStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item4, "婚礼酒店", (int) (budgetGet * 0.497)));
        atAdapter.setNewData(atStyles);

        List<BudgetStyleBen> afterStyles = new ArrayList<>();
        afterStyles.add(new BudgetStyleBen(R.drawable.icon_wedding_item4, "蜜月旅行", (int) (budgetGet * 0.088)));
        afterAdapter.setNewData(afterStyles);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

}

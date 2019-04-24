package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityCalendarBinding;
import com.example.wedding.mvvm.model.CalendarModel;
import com.example.wedding.mvvm.viewmodel.CalendarViewModel;

@Route(path = ARouterPath.CALENDAR_ACTIVITY)
public class CalendarActivity extends BaseActivity<ActivityCalendarBinding, CalendarViewModel> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_calendar;
    }

    @Override
    protected Class<CalendarViewModel> getModelClass() {
        return CalendarViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}

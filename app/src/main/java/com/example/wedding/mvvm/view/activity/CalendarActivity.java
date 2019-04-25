package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityCalendarBinding;
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
    protected void initView() {
        super.initView();
        mBinding.toolbar.setTitle("结婚吉日");
        initToolbarNav(mBinding.toolbar);

        mBinding.calendarGoodDay.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                mViewModel.getCalendar(year + "-" + (month + 1) + "-" + dayOfMonth);
            }
        });
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}

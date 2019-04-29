package com.example.wedding.mvvm.view.activity;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityWeddingBudgetBinding;
import com.example.wedding.mvvm.viewmodel.BudgetViewModel;
import com.example.wedding.util.SharedPreferencesUtil;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

@Route(path = ARouterPath.BUGDET_ACTIVITY)
public class WeddingBudgetActivity extends BaseActivity<ActivityWeddingBudgetBinding, BudgetViewModel> {
    public static final String KEY_BUDGET = "com.example.wedding.mvvm.view.activity.BUDGET_WEDDING";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wedding_budget;
    }

    @Override
    protected Class<BudgetViewModel> getModelClass() {
        return BudgetViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        super.initView();
        initToolbarWhite(mBinding.toolbar);

        initChart();

        int bugdet = SharedPreferencesUtil.getInstance().getInt(KEY_BUDGET);
        if (bugdet > 0) {
            setData(bugdet);
            mViewModel.isVisible.set(false);
            mViewModel.setAdapter(bugdet);
            mViewModel.allBudget.set("￥" + bugdet);
        }

        mBinding.rvBeforeWedding.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        mBinding.rvAtWedding.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        mBinding.rvAfterWedding.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        mBinding.rvBeforeWedding.setAdapter(mViewModel.beforeAdapter);
        mBinding.rvAtWedding.setAdapter(mViewModel.atAdapter);
        mBinding.rvAfterWedding.setAdapter(mViewModel.afterAdapter);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.pieData.observe(this, this::setData);
    }

    private void initChart() {
        mBinding.pieChart.setUsePercentValues(true);
        mBinding.pieChart.getDescription().setEnabled(false);
        mBinding.pieChart.setExtraOffsets(5, 10, 5, 5);

        mBinding.pieChart.setDragDecelerationFrictionCoef(0.95f);

//        mBinding.pieChart.setCenterText(generateCenterSpannableText());

        mBinding.pieChart.setDrawHoleEnabled(true);
        mBinding.pieChart.setHoleColor(Color.WHITE);

        mBinding.pieChart.setTransparentCircleColor(Color.WHITE);
        mBinding.pieChart.setTransparentCircleAlpha(110);

        mBinding.pieChart.setHoleRadius(53f);
        mBinding.pieChart.setTransparentCircleRadius(61f);

        mBinding.pieChart.setDrawCenterText(true);

        mBinding.pieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mBinding.pieChart.setRotationEnabled(true);
        mBinding.pieChart.setHighlightPerTapEnabled(true);

        mBinding.pieChart.animateY(1400, Easing.EaseInOutQuad);
        // chart.spin(2000, 0, 360);

        mBinding.pieChart.getLegend().setEnabled(false);
    }

    private void setData(int budget) {
        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        entries.add(new PieEntry((float) (budget * 0.162), "婚前消费"));
        entries.add(new PieEntry((float) (budget * 0.75), "婚礼消费"));
        entries.add(new PieEntry((float) (budget * 0.088), "婚后消费"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);
        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);
        //dataSet.setUsingSliceColorAsValueLineColor(true);
        dataSet.setValueTextColor(R.color.back_hui);
        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(mBinding.pieChart));
        data.setValueTextSize(11f);
        data.setValueTextColor(R.color.back_hui);

        mBinding.pieChart.setData(data);

        // undo all highlights
        mBinding.pieChart.highlightValues(null);

        mBinding.pieChart.invalidate();
    }
}

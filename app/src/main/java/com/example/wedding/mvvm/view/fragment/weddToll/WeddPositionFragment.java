package com.example.wedding.mvvm.view.fragment.weddToll;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.databinding.FragmentWeddPositionBinding;
import com.example.wedding.mvvm.model.WeddPositionModel;
import com.example.wedding.mvvm.viewmodel.WeddPositionViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeddPositionFragment extends BaseFragment<FragmentWeddPositionBinding, WeddPositionViewModel> {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wedd_position;
    }

    @Override
    protected Class<WeddPositionViewModel> getModelClass() {
        return WeddPositionViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}

package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.mvvm.model.WeddPositionModel;

public class WeddPositionViewModel extends BaseViewModel<WeddPositionModel> {
    public WeddPositionViewModel(@NonNull Application application) {
        super(application, new WeddPositionModel());
    }
}

package com.example.wedding.mvvm.viewmodel;


import android.app.Application;
import android.support.annotation.NonNull;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.mvvm.model.BusinessModel;

public class BusinessViewModel extends BaseViewModel<BusinessModel> {

    public BusinessViewModel(@NonNull Application application) {
        super(application, new BusinessModel());
    }
}

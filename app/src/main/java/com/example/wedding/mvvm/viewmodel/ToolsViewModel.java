package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.mvvm.view.adapter.WeddingToolAdapter;
import com.example.wedding.mvvm.view.adapter.WeddingTypeAdapter;

public class ToolsViewModel extends BaseViewModel {
    public WeddingToolAdapter mWeddingToolAdapter;

    public ToolsViewModel(@NonNull Application application) {
        super(application);
        initCommand();
    }

    private void initCommand() {
        mWeddingToolAdapter = new WeddingToolAdapter();
    }

}

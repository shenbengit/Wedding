package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.mvvm.model.WeddToolModel;
import com.example.wedding.mvvm.view.adapter.WeddingToolAdapter;
import com.example.wedding.util.LogUtil;

public class ToolsViewModel extends BaseViewModel<WeddToolModel> {

    public WeddingToolAdapter mWeddingToolAdapter;
    public BindingCommand insertDataCommand;

    public MutableLiveData<String> mutableLiveData;
    private Application mContext;
    public ObservableField<Boolean> isVisible;


    public ToolsViewModel(@NonNull Application application) {
        super(application, new WeddToolModel());
        mContext = application;
        mutableLiveData = new MutableLiveData<>();
        initCommand();
    }

    private void initCommand() {
        mWeddingToolAdapter = new WeddingToolAdapter();

        mWeddingToolAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtil.d(position + "点击了");
                if (position == 1) {
                    mutableLiveData.postValue("1");
                }
            }
        });

        insertDataCommand = new BindingCommand(() -> {
            LogUtil.d("insertDataCommand");

            mModel.insertPosition(null, null);
        });

        isVisible = new ObservableField<>();

    }

    @Override
    public void onCreate() {
        super.onCreate();

        mModel.searchWeddPosition(() -> {
            isVisible.set(false);
        }, (e) -> {
            isVisible.set(true);

        });
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}

package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.mvvm.model.WeddPositionModel;
import com.example.wedding.mvvm.view.adapter.WeddPositionAdapter;
import com.example.wedding.mvvm.view.bean.WeddPositionBen;
import com.example.wedding.util.ToastUtil;

import java.util.List;

import cn.bmob.v3.exception.BmobException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class WeddPositionViewModel extends BaseViewModel<WeddPositionModel> {
    public WeddPositionAdapter weddLocationAdapter;
    public MutableLiveData<List<WeddPositionBen>> positionInfo;

    public WeddPositionViewModel(@NonNull Application application) {
        super(application, new WeddPositionModel());
        initCommand();
    }

    private void initCommand() {
        weddLocationAdapter = new WeddPositionAdapter();

        weddLocationAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.show(getApplication(), "点击了" + position);
            }
        });
        positionInfo = new MutableLiveData<>();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mModel.searchWeddPosition(new Consumer<List<WeddPositionBen>>() {
            @Override
            public void accept(List<WeddPositionBen> weddPositionBens) throws Exception {
                weddLocationAdapter.setNewData(weddPositionBens);
            }
        }, new Consumer<BmobException>() {
            @Override
            public void accept(BmobException e) throws Exception {

            }
        });
    }
}

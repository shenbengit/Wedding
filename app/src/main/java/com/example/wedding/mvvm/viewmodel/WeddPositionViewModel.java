package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.http.bean.WeddingPositionBean;
import com.example.wedding.mvvm.model.WeddPositionModel;
import com.example.wedding.mvvm.view.adapter.WeddPositionAdapter;
import com.example.wedding.mvvm.view.bean.PositionCombineBen;
import com.example.wedding.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.exception.BmobException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class WeddPositionViewModel extends BaseViewModel<WeddPositionModel> {
    public WeddPositionAdapter weddLocationAdapter;
    public List<PositionCombineBen> positionInfo;


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
        positionInfo = new ArrayList<>();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mModel.searchWeddingPosition(new Consumer<List<WeddingPositionBean>>() {
            @Override
            public void accept(List<WeddingPositionBean> weddPositionBens) throws Exception {

                for (int i = 0; i < weddPositionBens.size(); i++) {
                    WeddingPositionBean ben = weddPositionBens.get(i);
                    positionInfo.add(new PositionCombineBen(ben.getWeddingName(), ben.getPosition(), ben.getArea(),
                            ben.getWeekStart() + " 至 " + ben.getWeekStop() + "\n上午" + ben.getAmBegin() + " - " + ben.getAmStop() + ",下午" + ben.getPmBegin() + " - " + ben.getPmStop(),
                            ben.getTelephone(), ben.getHoliday() ? "是" : "否"));
                }
                weddLocationAdapter.setNewData(positionInfo);
            }
        }, new Consumer<BmobException>() {
            @Override
            public void accept(BmobException e) throws Exception {

            }
        });
    }
}

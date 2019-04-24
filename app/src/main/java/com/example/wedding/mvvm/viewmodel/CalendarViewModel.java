package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.http.RetrofitClient;
import com.example.wedding.http.bean.CaldendarBen;
import com.example.wedding.http.callback.Callback;
import com.example.wedding.mvvm.model.CalendarModel;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.RxUtil;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CalendarViewModel extends BaseViewModel<CalendarModel> {
    public CalendarViewModel(@NonNull Application application) {
        super(application, new CalendarModel());
        initCommand();
    }

    private void initCommand() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        getCalendar();
    }

    public void getCalendar() {
//        RetrofitClient.getInstance().post("http://v.juhe.cn/calendar/day")
//                .postString("key=df27574dd56e05a1fcec51e51f6b4455&date=2019-4-25")
//                .execute(new Callback<CaldendarBen>() {
//                    @Override
//                    public void onStart() {
//
//                    }
//
//                    @Override
//                    public void onSuccess(CaldendarBen caldendarBen) {
//                        LogUtil.d("onSuccess"+caldendarBen.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogUtil.d("onError" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        LogUtil.d("onCompleted");
//                    }
//                });

        RetrofitClient.getInstance()
                .getApiService()
                .getCaldendar("http://v.juhe.cn/calendar/day", "df27574dd56e05a1fcec51e51f6b4455", "2019-4-25")
                .compose(RxUtil.io_main())
                .compose(mLifecycleProvider.bindToLifecycle())
                .subscribe(new Observer<CaldendarBen>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CaldendarBen caldendarBen) {
                        LogUtil.i("onNext: " + caldendarBen.getError_code() + "\n" + caldendarBen.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}

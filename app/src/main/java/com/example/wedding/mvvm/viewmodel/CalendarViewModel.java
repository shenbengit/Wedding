package com.example.wedding.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.http.RetrofitClient;
import com.example.wedding.http.bean.CaldendarBen;
import com.example.wedding.mvvm.model.CalendarModel;
import com.example.wedding.mvvm.view.bean.CalendarInfoBen;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.RxUtil;

import java.util.Calendar;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CalendarViewModel extends BaseViewModel<CalendarModel> {

    public BindingCommand suitCommand;

    public ObservableField<String> lunar;
    public ObservableField<String> suit;
    public ObservableField<String> avoid;

    public CalendarInfoBen calendarInfo;

    public CalendarViewModel(@NonNull Application application) {
        super(application, new CalendarModel());
        initCommand();
    }

    private void initCommand() {
        suitCommand = new BindingCommand(() -> {
            LogUtil.d("suitCommand");
        });

        calendarInfo = new CalendarInfoBen();

        lunar = new ObservableField<>("");
        suit = new ObservableField<>("");
        avoid = new ObservableField<>("");

        suit.set("宜");
        avoid.set("忌");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        getCalendar(year + "-" + month + "-" + day);
    }

    public void getCalendar(String date) {

        RetrofitClient.getInstance()
                .getApiService()
                .getCaldendar("http://v.juhe.cn/calendar/day", "df27574dd56e05a1fcec51e51f6b4455", date)
                .compose(RxUtil.io_main())
                .compose(mLifecycleProvider.bindToLifecycle())
                .subscribe(new Observer<CaldendarBen>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CaldendarBen caldendarBen) {
                        CaldendarBen.ResultBean.DataBean dataBean = caldendarBen.getResult().getData();

                        calendarInfo = new CalendarInfoBen(dataBean.getAvoid(), dataBean.getSuit(), dataBean.getLunarYear(), dataBean.getLunar());

//                        LogUtil.e("onNext: " + calendarInfo.toString());

                        lunar.set(calendarInfo.getLunarYear() + calendarInfo.getLunar());
                        suit.set(calendarInfo.getSuit());
                        avoid.set(calendarInfo.getAvoid());
                        LogUtil.e(lunar.get() + suit.get() + avoid.get());
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

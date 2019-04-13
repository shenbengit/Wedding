package com.example.wedding.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * @author ShenBen
 * @date 2018/11/8 15:26
 * @email 714081644@qq.com
 */
public class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements IBaseViewModel {

    protected final String TAG = getClass().getSimpleName();

    protected M mModel;
    protected LifecycleProvider mLifecycleProvider;

    private MutableLiveData<String> mBaseLiveData;

    public BaseViewModel(@NonNull Application application) {
        this(application, null);
    }

    public BaseViewModel(@NonNull Application application, M model) {
        super(application);
        mModel = model;
        mBaseLiveData = new MutableLiveData<>();
    }

    /**
     * 注入RxLifecycle生命周期,对应Activity、Fragment
     *
     * @param lifecycleProvider RxLifecycle生命周期
     */
    public void injectLifecycleProvider(LifecycleProvider lifecycleProvider) {
        mLifecycleProvider = lifecycleProvider;
    }

    /**
     * 获取最基本的与Activity通信事例
     * 可以通过约定的字符串进行通信
     *
     * @return mBaseLiveData
     */
    public MutableLiveData<String> getBaseLiveData() {
        return mBaseLiveData;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        if (mModel != null) {
            mModel.onDestroy();
        }
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {

    }
}

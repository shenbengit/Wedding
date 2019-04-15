package com.example.wedding.mvvm.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.wedding.base.BaseModel;
import com.example.wedding.http.bean.UserBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author ShenBen
 * @date 2019/4/15 22:11
 * @email 714081644@qq.com
 */
public class WeModel extends BaseModel {

    private Disposable mUpdateUserDisposable;

    public void updateUserInfo(@NonNull UserBean userBean, @Nullable Action success, @Nullable Consumer<BmobException> error) {
        mUpdateUserDisposable = userBean.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                try {
                    if (e == null) {
                        if (success != null) {
                            success.run();
                        }
                    } else {
                        if (error != null) {
                            error.accept(e);
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUpdateUserDisposable != null) {
            mUpdateUserDisposable.dispose();
        }
    }
}

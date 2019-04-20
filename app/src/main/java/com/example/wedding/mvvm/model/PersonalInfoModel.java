package com.example.wedding.mvvm.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.wedding.base.BaseModel;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.rxbus.RxSubscriptions;

import java.io.File;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author

 */
public class PersonalInfoModel extends BaseModel {

    private Disposable mUploadFileDisposable;

    private Disposable mUpdateUserDisposable;

    public void updateUserInfo(@NonNull UserBean userBean, @NonNull File file, @Nullable Action success, @Nullable Consumer<BmobException> error) {
        BmobFile bmobFile = new BmobFile(file);
        mUploadFileDisposable = bmobFile.upload(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                try {
                    if (e == null) {
                        userBean.setHeadImg(bmobFile);
                        updateUserInfo(userBean, success, error);
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
        if (mUploadFileDisposable != null) {
            mUploadFileDisposable.dispose();
        }
        if (mUpdateUserDisposable != null) {
            mUpdateUserDisposable.dispose();
        }
    }
}

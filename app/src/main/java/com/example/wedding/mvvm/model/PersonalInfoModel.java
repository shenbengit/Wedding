package com.example.wedding.mvvm.model;

import com.example.wedding.base.BaseModel;
import com.example.wedding.http.bean.UserBean;

import java.io.File;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author ShenBen
 * @date 2019/4/13 15:01
 * @email 714081644@qq.com
 */
public class PersonalInfoModel extends BaseModel {


    public void updateUserInfo(UserBean userBean, File file, Action success, Consumer<BmobException> error) {
        BmobFile bmobFile = new BmobFile(file);
        bmobFile.upload(new UploadFileListener() {
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

    public void updateUserInfo(UserBean userBean, Action success, Consumer<BmobException> error) {
        if (userBean != null) {
            userBean.update(new UpdateListener() {
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}

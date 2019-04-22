package com.example.wedding.mvvm.model;

import android.support.annotation.Nullable;

import com.example.wedding.base.BaseModel;
import com.example.wedding.mvvm.view.bean.WeddPositionBen;
import com.example.wedding.util.LogUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class WeddPositionModel extends BaseModel {
    private Disposable mSearchPositionDisposable;

    /**
     * 查询婚姻登记处数据
     */
    public void searchWeddPosition(@Nullable Consumer<List<WeddPositionBen>> success, @Nullable Consumer<BmobException> error) {
        BmobQuery<WeddPositionBen> query = new BmobQuery<>();
        mSearchPositionDisposable = query.findObjects(new FindListener<WeddPositionBen>() {
            @Override
            public void done(List<WeddPositionBen> list, BmobException e) {
                try {
                    if (e == null) {
                        if (list.size() == 0) {
                            if (error != null) {
                                error.accept(e);
                                LogUtil.d("尚未查询到数据");
                                return;
                            }
                        }

                        if (success != null) {
                            success.accept(list);
                            LogUtil.d("成功返回");
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

        if (mSearchPositionDisposable != null) {
            mSearchPositionDisposable.dispose();
        }
    }
}

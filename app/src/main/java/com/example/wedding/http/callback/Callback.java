package com.example.wedding.http.callback;


import com.example.wedding.util.RxUtil;

import java.lang.reflect.Type;

/**
 * @author

 */
public abstract class Callback<T> {
    public abstract void onStart();

    public abstract void onSuccess(T t);

    public abstract void onError(Throwable e);

    public abstract void onCompleted();

    public Type getType() {
        return RxUtil.findNeedClass(getClass());
    }
}

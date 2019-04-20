package com.example.wedding.rxbus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Disposable 管理类
 *
 * @author

 */
public class RxSubscriptions {

    private static CompositeDisposable sSubscriptions = new CompositeDisposable();

    public static synchronized void add(Disposable disposable) {
        if (disposable != null) {
            sSubscriptions.add(disposable);
        }
    }

    public static synchronized void remove(Disposable disposable) {
        if (disposable != null) {
            sSubscriptions.remove(disposable);
        }
    }

    public static void clear() {
        sSubscriptions.clear();
    }

    public static void dispose() {
        sSubscriptions.dispose();
    }
}

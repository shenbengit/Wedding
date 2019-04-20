package com.example.wedding.http.request;


import com.example.wedding.http.callback.Callback;
import com.example.wedding.util.GsonUtil;
import com.example.wedding.util.RxUtil;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * Get请求
 *
 * @author

 */
public class GetRequest extends BaseRequest<GetRequest> {

    public GetRequest(String url) {
        super(url);
    }

    public <T> void execute(Callback<T> callback) {
        if (callback != null) {
            generateRequest().compose(RxUtil.io_main())
                    .subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            callback.onStart();
                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            try {
                                T t = GsonUtil.jsonToBean(responseBody.string(), callback.getType());
                                callback.onSuccess(t);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            callback.onError(e);
                        }

                        @Override
                        public void onComplete() {
                            callback.onCompleted();
                        }
                    });

        }

    }

    @Override
    protected Observable<ResponseBody> generateRequest() {
        return mApiService.get(mUrl, mParamsMap);
    }
}

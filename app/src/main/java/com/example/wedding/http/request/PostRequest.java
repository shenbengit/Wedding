package com.example.wedding.http.request;


import com.example.wedding.http.callback.Callback;
import com.example.wedding.util.GsonUtil;
import com.example.wedding.util.RxUtil;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * POST 请求
 * 请求体只能为一种类型，不可同时设置多种请求体
 *
 * @author
 * @date 2018/9/18
 * Email: 714081644@qq.com
 */
public class PostRequest extends BaseRequest<PostRequest> {
    public static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");

    private String string;                                   //上传的文本内容
    private String json;                                     //上传的Json
    private byte[] bs;                                       //上传的字节数据
    private Object object;                                   //上传的对象
    private RequestBody requestBody;                         //自定义的请求体
    protected transient MediaType mediaType;                 //上传的MIME类型

    public PostRequest(String url) {
        super(url);
    }

    public PostRequest postString(String string) {
        this.string = string;
        return this;
    }

    public PostRequest postJson(String json) {
        this.json = json;
        return this;
    }

    public PostRequest postJson(Object object) {
        if (object != null) {
            this.json = GsonUtil.objectToJson(object);
        }
        return this;
    }

    public PostRequest postBs(byte[] bs) {
        this.bs = bs;
        return this;
    }

    public PostRequest postObject(Object object) {
        this.object = object;
        return this;
    }

    public PostRequest postRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public <T> void execute(Callback<T> callback) {
        if (callback == null) {
            return;
        }
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

    @Override
    protected Observable<ResponseBody> generateRequest() {
        if (requestBody != null) { //自定义的请求体
            return mApiService.postBody(mUrl, requestBody);
        } else if (json != null) {//上传的Json
            RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json);
            return mApiService.postJson(mUrl, body);
        } else if (object != null) {//自定义的请求object
            return mApiService.postBody(mUrl, object);
        } else if (string != null) {//上传的文本内容
            RequestBody body = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), string);
            return mApiService.postBody(mUrl, body);
        } else if (bs != null) {//上传的字节数据
            RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), bs);
            return mApiService.postBody(mUrl, body);
        } else if (!mParamsMap.isEmpty()) {
            return mApiService.post(mUrl, mParamsMap);
        } else {
            throw new IllegalStateException("POST 请求体为null");
        }
    }


}

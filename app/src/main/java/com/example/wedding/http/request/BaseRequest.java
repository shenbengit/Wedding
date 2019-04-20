package com.example.wedding.http.request;

import android.text.TextUtils;

import com.example.wedding.http.RetrofitClient;
import com.example.wedding.http.service.ApiService;

import java.util.LinkedHashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * body请求的基类
 *
 * @author

 */
@SuppressWarnings("unchecked")
public abstract class BaseRequest<T extends BaseRequest> {

    protected String mBaseUrl;
    protected String mUrl;
    protected LinkedHashMap<String, String> mParamsMap;
    protected ApiService mApiService;

    public BaseRequest(String url) {
        this.mUrl = url;
        mParamsMap = new LinkedHashMap<>();
        mApiService = RetrofitClient.getInstance().getApiService();
    }

    public T baseUrl(String baseUrl) {
        if (!TextUtils.isEmpty(baseUrl)) {
            mBaseUrl = baseUrl;
            Retrofit.Builder builder = RetrofitClient.getInstance().getBuilder();
            builder.baseUrl(baseUrl);
            mApiService = builder.build().create(ApiService.class);
        }
        return (T) this;
    }

    /**
     * 设置参数
     */
    public T params(String key, String value) {
        mParamsMap.put(key, value);
        return (T) this;
    }

    /**
     * 移除参数
     *
     * @param key
     * @return
     */
    public T removeParam(String key) {
        mParamsMap.remove(key);
        return (T) this;
    }

    /**
     * 移除所有参数
     *
     * @return
     */
    public T removeAllParams() {
        mParamsMap.clear();
        return (T) this;
    }

    protected abstract Observable<ResponseBody> generateRequest();
}

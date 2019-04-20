package com.example.wedding.http;

import com.example.wedding.http.request.DownloadRequest;
import com.example.wedding.http.request.GetRequest;
import com.example.wedding.http.request.PostRequest;
import com.example.wedding.http.service.ApiService;
import com.example.wedding.util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author

 */
public class RetrofitClient {
    private static final String BASE_URL = "https://www.hunliji.com/";
    private static final long DEFAULT_MILLISECONDS = 60000;      //默认的超时时间
    private static long REFRESH_TIME = 300;                      //回调刷新时间（单位ms）

    private OkHttpClient mClient;
    private Retrofit.Builder mBuilder;
    private ApiService mService;

    private static final class Holder {
        private static final RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return Holder.INSTANCE;
    }

    private RetrofitClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> LogUtil.i(message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        builder.addInterceptor(interceptor);
        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("timestamp", String.valueOf(System.currentTimeMillis()))
                    .addHeader("token","1071272dd8cd687210dfb08b140f8d5f")
                    .build();
            return chain.proceed(request);
        });
        builder.readTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        mClient = builder.build();

        Gson gson = new GsonBuilder().serializeNulls().create();
        mBuilder = new Retrofit.Builder()
                .client(mClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL);
        Retrofit retrofit = mBuilder.build();
        mService = retrofit.create(ApiService.class);
    }

    public OkHttpClient getOkHttpClient() {
        return mClient;
    }

    public Retrofit.Builder getBuilder() {
        return mBuilder;
    }

    public ApiService getApiService() {
        return mService;
    }

    public static GetRequest get(String url) {
        return new GetRequest(url);
    }

    public static PostRequest post(String url) {
        return new PostRequest(url);
    }

    public static DownloadRequest download(String url) {
        return new DownloadRequest(url);
    }

}

package com.example.wedding.http.service;

import com.example.wedding.http.bean.HomeInfoBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 通用的的api接口
 * GET
 * POST
 * 文件下载
 *
 * @author

 */
public interface ApiService {

    @GET()
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String, String> maps);

    @POST()
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<ResponseBody> postJson(@Url String url, @Body RequestBody json);

    @POST()
    Observable<ResponseBody> postBody(@Url String url, @Body RequestBody body);

    @POST()
    @FormUrlEncoded
    Observable<ResponseBody> post(@Url String url, @FieldMap Map<String, String> maps);

    @POST()
    Observable<ResponseBody> postBody(@Url String url, @Body Object object);

    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Header("Range") String start, @Url String url);

    @GET("p/wedding/index.php/home/APIFallGroundV2/firstpage")
    Observable<HomeInfoBean> getHomePage(@Header("city") String city);

}

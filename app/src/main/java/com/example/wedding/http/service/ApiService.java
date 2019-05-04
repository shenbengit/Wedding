package com.example.wedding.http.service;

import com.example.wedding.http.bean.BusinessListBean;
import com.example.wedding.http.bean.BusinessOverviewBean;
import com.example.wedding.http.bean.CaldendarBen;
import com.example.wedding.http.bean.GoodsHttpBen;
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
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 通用的的api接口
 * GET
 * POST
 * 文件下载
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

    /**
     * https://www.hunliji.com/p/wedding/index.php/home/APIFallGroundV2/firstpage
     * <p>
     * 主页信息接口
     *
     * @param locationHeader 请求头
     * @return
     */
    @GET("p/wedding/index.php/home/APIFallGroundV2/firstpage")
    Observable<HomeInfoBean> getHomePage(@Header("city") String locationHeader);

    /**
     * https://www.hunliji.com/p/wedding/index.php/home/APITour/merchant_filter?city=63
     * <p>
     * 获取商家概况信息
     *
     * @param locationHeader 请求头
     * @param cityId         城市id号
     * @return
     */
    @GET("p/wedding/index.php/home/APITour/merchant_filter")
    Observable<BusinessOverviewBean> getBusinessOverview(@Header("city") String locationHeader, @Query("city") int cityId);

    /**
     * https://www.hunliji.com/p/wedding/index.php/home/APIMerchant/merchantV3?per_page=20&page=1&property=13&category_id=0&area_id=0&sort=default&city=63
     * <p>
     * 获取对应商家列表信息
     *
     * @param locationHeader
     * @param page
     * @param perPage
     * @param property
     * @param categoryId
     * @param areaId
     * @param sort
     * @param cityId
     * @return
     */
    @GET("p/wedding/index.php/home/APIMerchant/merchantV3")
    Observable<BusinessListBean> getBusinessList(@Header("city") String locationHeader, @Query("page") int page,
                                                 @Query("per_page") int perPage, @Query("property") int property,
                                                 @Query("category_id") int categoryId, @Query("area_id") int areaId,
                                                 @Query("sort") String sort, @Query("city") int cityId);

    @GET
    Observable<CaldendarBen> getCaldendar(@Url String url, @Query("key") String key, @Query("date") String date);


    /**
     * https://www.hunliji.com/p/wedding/index.php/home/APIPosterBlock/block_info?id=1026&app_version=8.3.3&city=63
     * <p>
     * 主页信息接口
     *
     * @param locationHeader 请求头
     * @return
     */
    @GET("p/wedding/index.php/home/APIPosterBlock/block_info?id=1026&app_version=8.3.3&city=63")
    Observable<GoodsHttpBen> getGoods(@Header("city") String locationHeader);
}

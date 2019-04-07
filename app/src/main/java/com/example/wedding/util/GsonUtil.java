package com.example.wedding.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ShenBen
 * @date 2019/4/5 16:49
 * @email 714081644@qq.com
 */
public class GsonUtil {
    private static Gson sGson;

    static {
        sGson = new GsonBuilder().create();
    }

    private GsonUtil() {

    }

    public static String objectToJson(Object object) {
        return sGson.toJson(object);
    }

    public static <T> T jsonToBean(String json, Class<T> cls) {
        return sGson.fromJson(json, cls);
    }

    public static <T> T jsonToBean(String json, Type typeOfT) {
        return sGson.fromJson(json, typeOfT);
    }

    /**
     * json字符串转成list
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> List<T> jsonToList(String json, Class<T> cls) {
        List<T> list = null;
        if (sGson != null) {
            //根据泛型返回解析指定的类型,TypeToken<List<T>>{}.getType()获取返回类型
            list = sGson.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }
}

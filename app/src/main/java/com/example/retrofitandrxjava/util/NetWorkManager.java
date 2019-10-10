package com.example.retrofitandrxjava.util;

import com.example.retrofitandrxjava.BuildConfig;
import com.example.retrofitandrxjava.net.APIService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {
    static NetWorkManager mInstance;
    Retrofit retrofit;
    private static volatile APIService request = null;

    public static NetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }

    /*
    * 初始化必要的参数和对象
    * */
    public void init(){
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //初始化okhttp
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logger).build();

        //初始化retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVICE_ADDRESS)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public APIService getRequest() {
        if (request == null) {
            synchronized (APIService.class) {
                request = retrofit.create(APIService.class);
            }
        }
        return request;
    }
}

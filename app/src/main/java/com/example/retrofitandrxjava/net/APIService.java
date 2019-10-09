package com.example.retrofitandrxjava.net;

import com.example.retrofitandrxjava.entity.BaseObjectBean;
import com.example.retrofitandrxjava.entity.MessageNotificateEntity;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {


    /*@GET("/loan/app/notices/")
    Observable<BaseObjectBean<List<MessageNotificateEntity>>> getNotificatMessages();*/

    @GET("/loan/app/notices/")
    Observable<List<MessageNotificateEntity>> getNotificatMessages();
}

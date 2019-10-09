package com.example.retrofitandrxjava.mvp.model;

import com.example.retrofitandrxjava.entity.BaseObjectBean;
import com.example.retrofitandrxjava.entity.MessageNotificateEntity;
import com.example.retrofitandrxjava.mvp.Contract;
import com.example.retrofitandrxjava.util.NetWorkManager;

import java.util.List;

import io.reactivex.Observable;

/*
* 网络请求
* */
public class MessageModel implements Contract.Model {
    @Override
    public Observable<List<MessageNotificateEntity>> getNotificatMessages() {
        return NetWorkManager.getInstance().getRequest().getNotificatMessages();
    }
}

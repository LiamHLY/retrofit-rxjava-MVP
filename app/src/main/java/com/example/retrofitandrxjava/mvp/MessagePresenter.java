package com.example.retrofitandrxjava.mvp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.retrofitandrxjava.base.BasePresenter;

import com.example.retrofitandrxjava.entity.BaseObjectBean;
import com.example.retrofitandrxjava.entity.MessageNotificateEntity;
import com.example.retrofitandrxjava.mvp.model.MessageModel;
import com.example.retrofitandrxjava.schedulers.BaseSchedulerProvider;
import com.example.retrofitandrxjava.schedulers.SchedulerProvider;
import com.example.retrofitandrxjava.util.ResponseTransform;

import java.util.List;

import io.reactivex.functions.Consumer;


public class MessagePresenter extends BasePresenter<Contract.View> implements Contract.Presenter {

    private Contract.Model model;
    private BaseSchedulerProvider schedulerProvider = SchedulerProvider.getInstance();

    public MessagePresenter(){
        model = new MessageModel();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void getNotificatMessages() {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        /*model.getNotificatMessages().compose(ResponseTransform.handleResult())
                .compose(schedulerProvider.applySchedulers()).subscribe(new Consumer<List<MessageNotificateEntity>>() {
            @Override
            public void accept(List<MessageNotificateEntity> messageNotificateEntities) throws Exception {
                mView.onSuccsee(messageNotificateEntities);
                mView.hideLoading();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.onError(throwable);
                mView.hideLoading();
            }
        });*/

        model.getNotificatMessages().compose(schedulerProvider.applySchedulers()).subscribe(new Consumer<List<MessageNotificateEntity>>() {
            @Override
            public void accept(List<MessageNotificateEntity> messageNotificates) throws Exception {

                    mView.onSuccsee(messageNotificates);
                    mView.hideLoading();

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
                mView.onError(throwable);
                mView.hideLoading();
            }
        });
    }

}


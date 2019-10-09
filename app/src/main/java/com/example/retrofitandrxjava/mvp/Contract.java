package com.example.retrofitandrxjava.mvp;

import com.example.retrofitandrxjava.base.BaseView;
import com.example.retrofitandrxjava.entity.BaseObjectBean;
import com.example.retrofitandrxjava.entity.MessageNotificateEntity;

import java.util.List;

import io.reactivex.Observable;

/*
* mvp架构下会有很多接口，所以要通过
* [ˈkɑːntrækt]
 * */
public interface Contract {
    public interface Model{
        Observable<List<MessageNotificateEntity>> getNotificatMessages();
    }
    public interface View extends BaseView{
        @Override
        void onError(Throwable throwable);

        @Override
        void hideLoading();

        @Override
        void showLoading();

        //因为请求网络，服务器返回的值是不一样的，在Contract > View接口中根据bean类设置onSuccess()
        void onSuccsee(List<MessageNotificateEntity> messageNotificates);
    }

    interface Presenter{
        void getNotificatMessages();
    }

}

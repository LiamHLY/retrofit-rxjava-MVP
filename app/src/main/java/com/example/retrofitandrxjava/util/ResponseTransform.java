package com.example.retrofitandrxjava.util;


import com.example.retrofitandrxjava.entity.BaseObjectBean;
import com.example.retrofitandrxjava.exception.ApiException;
import com.example.retrofitandrxjava.exception.CustomException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.functions.Function;


public class ResponseTransform {
    public static <T> ObservableTransformer<BaseObjectBean<T>, T> handleResult() {

        return upstream -> upstream.onErrorResumeNext(new ErrorResumeFunction<>()).flatMap(new ResponseFunction<>());
    }

    private static class ResponseFunction<T> implements Function<BaseObjectBean<T>, ObservableSource<T>> {

        @Override
        public ObservableSource<T> apply(BaseObjectBean<T> tResponse) throws Exception {
            int code = tResponse.getCode();
            String message = tResponse.getMsg();
            if(code == 200){
                return Observable.just(tResponse.getResult());
            }else {
                return Observable.error(new ApiException(code,message));
            }
        }

    }

    private static class ErrorResumeFunction<T> implements Function<Throwable, ObservableSource<? extends BaseObjectBean<T>>> {

        @Override
        public ObservableSource<? extends BaseObjectBean<T>> apply(Throwable throwable) throws Exception {
            return Observable.error(CustomException.handleException(throwable));
        }
    }
}

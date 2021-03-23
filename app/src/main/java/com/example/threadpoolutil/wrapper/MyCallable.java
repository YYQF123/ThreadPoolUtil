package com.example.threadpoolutil.wrapper;

import com.example.threadpoolutil.callback.MyCallableCallback;

import java.util.concurrent.Callable;

/**
 * Callable 包装类
 * @param <T>
 */
public class MyCallable<T> implements Callable<T> {
    String name;
    MyCallableCallback<T> callback;
    Callable<T> callable;
    String status=null;

    public MyCallable(String name, MyCallableCallback<T> callback, Callable<T> callable) {
        this.name = name;
        this.callback = callback;
        this.callable = callable;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public T call(){
        if (callback!=null) {
            callback.onStart(name);
            status="START";
        }
        T t=null;
        try {
            t=callable==null?null:callable.call();
            if (t!=null){
                callback.onSuccess(name,t);
                status="SUCCESS";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (callback!=null) {
                callback.onError(name,e);
                status="ERROR";
            }
        }finally {
            if (callback!=null) {
                callback.onCompleted(name);
                status="COMPLETE";
            }
        }
        return t;
    }
}

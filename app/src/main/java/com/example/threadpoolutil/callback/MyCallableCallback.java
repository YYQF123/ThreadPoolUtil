package com.example.threadpoolutil.callback;

public interface MyCallableCallback<T> {
    void onStart(String name);
    void onSuccess(String name,T t);
    void onError(String name,Exception e);
    void onCompleted(String name);
}

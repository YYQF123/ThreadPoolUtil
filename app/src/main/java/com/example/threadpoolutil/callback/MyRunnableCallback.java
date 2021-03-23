package com.example.threadpoolutil.callback;

public interface MyRunnableCallback {
    void onStart(String name);
    void onComplete(String name);
    void onFailed(String name);
}

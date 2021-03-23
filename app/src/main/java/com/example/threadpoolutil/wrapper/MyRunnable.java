package com.example.threadpoolutil.wrapper;

import com.example.threadpoolutil.callback.MyRunnableCallback;

/**
 * Runnable 包装类
 * @param <T>
 */
public class MyRunnable implements Runnable {
    String name;
    MyRunnableCallback callback;
    Runnable runnable;

    public MyRunnable(String name, MyRunnableCallback callback, Runnable runnable) {
        this.name = name;
        this.callback = callback;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        callback.onStart(name);
        if (runnable!=null){
            runnable.run();
        }callback.onComplete(name);
    }

}

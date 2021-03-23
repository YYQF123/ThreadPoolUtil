package com.example.threadpoolutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    public static ExecutorService getFixedPool(int corePoolSize){
        return Executors.newFixedThreadPool(corePoolSize);
    }

    public static ExecutorService getCachedThreadPool(int maxPoolSize){
        return Executors.newCachedThreadPool();
    }

    public static ExecutorService getSingleThreadExecutor(){
        return Executors.newSingleThreadExecutor();
    }

    public static ExecutorService getScheduledThreadPool(int corePoolSize){
        return Executors.newScheduledThreadPool(corePoolSize);
    }
}

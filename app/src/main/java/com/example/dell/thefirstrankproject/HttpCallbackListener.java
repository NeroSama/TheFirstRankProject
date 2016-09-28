package com.example.dell.thefirstrankproject;

/**
 * Created by dell on 2016/9/7.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}

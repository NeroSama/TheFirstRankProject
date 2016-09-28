package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by dell on 2016/9/28.
 */
public class PageChange {
    protected boolean pageChange(String user,Activity activity1,Class class2){
        Intent intent=new Intent();
        intent.putExtra("user",user);
        intent.setClass(activity1,class2);
        activity1.startActivity(intent);
//        activity1.finish();
        return true;
    }
}

package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/9/5.
 */
public class circle_search extends Activity {

    private String user;
    private String[] names;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_search);
        Intent intent=getIntent();
        user=intent.getStringExtra("user");
        GetMyCircleNames getName=new GetMyCircleNames();
        names=getName.getMyCircleNames(user);
        SetListView listView=new SetListView();
        listView.setListView(names,this,R.id.searchCircleName);
    }

}

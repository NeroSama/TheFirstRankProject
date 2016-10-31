package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
    private ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_search);
        //返回按钮
        backButton=(ImageButton)findViewById(R.id.circle_search_back);
        backButton.setOnClickListener(new ButtonListener());
        //获取上一Activity的用户信息
        Intent intent=getIntent();
        user=intent.getStringExtra("user");
        //获取搜索圈信息，设置ListView
        GetMyCircleNames getName=new GetMyCircleNames();
        //names=getName.getMyCircleNames(user,"circle_search");//2:option:获取circle_search信息
        SetListView listView=new SetListView();
        listView.setListView(names,this,R.id.searchCircleName);
    }
    class ButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.circle_search_back:
                    finish();
            }
        }
    }

}

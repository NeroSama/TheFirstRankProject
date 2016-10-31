package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by dell on 2016/9/28.
 */
public class GetMyCircleNames {
    public Activity a;
    public String[] names;
    private String user;
    private String option;
    private String[] my_circle_name;
    public SetListView listView;
    private static final int SHOW_RESULT = 0;
    private static final String SERVER_ADDRESS = "http://172.22.30.48:8080/firstProject_war_exploded/server-plus-demo";
    private static final String TAG = "GetMyCircleName.java";
    private Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_RESULT:
                names=new String[10];
                names=msg.obj.toString().split(" ");
//                SetListView listView=new SetListView();
                listView.setListView(names,a,R.id.circleName);

                //设置监听器
                listView.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent();
                        intent.putExtra("user",user);
                        intent.putExtra("team",names[position]);
                        intent.setClass(a,team_talk_window.class);
                        a.startActivity(intent);
                    }
                });

                break;
            default:
                break;
        }
    }
};
    GetMyCircleNames(){
    }
    public void getMyCircleNames(String user,String option){
        this.option=option;
        this.user=user;
        names=new String[1];
        listView=new SetListView();
        sendRequestToServer();

//        names=new String[]{"洛天依","初音"};
        //System.out.println(names[0]+"hahahah");

    }
    private void sendRequestToServer() {
        HttpUtil.postHttpRequest(SERVER_ADDRESS, user, option, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Message msg = new Message();
                msg.what = SHOW_RESULT;
                msg.obj = response;
                handler.sendMessage(msg);
            }
            @Override
            public void onError(Exception e) {
                Log.e(TAG, "Connection Error");
            }
        });
    }

    public void sendActivity(Activity a){
        this.a=a;
    }
}

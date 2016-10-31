package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/9/28.
 */
public class SetListView {

    protected ListView list;

    protected boolean setListView(String[] names,/*String[] teamID, */Activity activity,int id){
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("name",names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter= new SimpleAdapter(activity,listItems,R.layout.link_people,
                new String[]{"name"},new int[]{R.id.name});
        list=(ListView)activity.findViewById(id);
        list.setAdapter(simpleAdapter);

//
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                System.out.println("hahaha触发");
//                Intent intent=new Intent();
//                intent.putExtra("user",user);
//                intent.putExtra("team",names[position]);
//                intent.setClass(my_circle.this,team_talk_window.class);
//                my_circle.this.startActivity(intent);
//            }
//        });

        return true;
    }


}

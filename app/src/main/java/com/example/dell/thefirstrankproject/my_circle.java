package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by dell on 2016/9/3.
 */
public class my_circle extends Activity {
    private String user=null;
    private ImageButton personal=null;
    private ImageButton mainPage=null;
    private ImageButton circleSearch=null;
    private ButtonListener buttonListener=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_circle);
        Intent intent=getIntent();
        user=intent.getStringExtra("user");
        buttonListener=new ButtonListener();
        mainPage=(ImageButton)findViewById(R.id.mainPage);
        personal=(ImageButton)findViewById(R.id.personal);
        circleSearch=(ImageButton)findViewById(R.id.circleSearch);
        mainPage.setOnClickListener(buttonListener);
        personal.setOnClickListener(buttonListener);
        circleSearch.setOnClickListener(buttonListener);

    }
    class ButtonListener implements View.OnClickListener{
        public void onClick(View v){
            if(v.getId()==R.id.mainPage){
                Intent intent=new Intent();
                intent.putExtra("user",user);
                intent.setClass(my_circle.this,main_page.class);
                my_circle.this.startActivity(intent);
                finish();
            }
            else if(v.getId()==R.id.personal){
                Intent intent=new Intent();
                intent.putExtra("user",user);
                intent.setClass(my_circle.this,personal.class);
                my_circle.this.startActivity(intent);
                finish();
            }
            else if(v.getId()==R.id.circleSearch){
                Intent intent=new Intent();
                intent.putExtra("user",user);
                intent.setClass(my_circle.this,circle_search.class);
                my_circle.this.startActivity(intent);
            }
        }
    }
}

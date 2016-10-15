package com.example.dell.thefirstrankproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by dell on 2016/9/10.
 */
public class circle_build extends Activity{
    private ImageButton haveBuild=null;
    private ImageButton buildBack=null;
    private String user=null;
    private Intent intent=null;
    private Intent intentP=null;
    private ButtonListener buttonListener=null;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_build);
        intent=getIntent();
        user=intent.getStringExtra("user");
        intentP=new Intent();
        buttonListener=new ButtonListener();
        haveBuild=(ImageButton)findViewById(R.id.haveBuild);
        buildBack=(ImageButton)findViewById(R.id.build_back);
        buildBack.setOnClickListener(buttonListener);
        haveBuild.setOnClickListener(buttonListener);
    }
    private class ButtonListener implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.haveBuild:
                    intentP.putExtra("user",user);
                    intentP.setClass(circle_build.this,have_build.class);
                    circle_build.this.startActivity(intentP);
                    break;
                case R.id.build_back:
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}

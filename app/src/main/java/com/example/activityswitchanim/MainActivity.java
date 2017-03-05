package com.example.activityswitchanim;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private View btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //打开下一级activity时，此activity的退出动画
        getWindow().setExitTransition(new Slide());
        setContentView(R.layout.activity_main);
        btn =  findViewById(R.id.btn);
    }

    public void explode(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.ANIM_TYPE,0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void slide(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.ANIM_TYPE,1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void fade(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.ANIM_TYPE,2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void share(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.ANIM_TYPE,3);
        //单个共享元素
        //startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, view,"share").toBundle());
        //多个共享元素
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(view,"share"),Pair.create(btn,"share_two")).toBundle());
    }
}

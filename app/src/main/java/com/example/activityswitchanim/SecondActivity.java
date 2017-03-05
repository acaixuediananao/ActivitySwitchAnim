package com.example.activityswitchanim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

/**
 * Created by xiaolong.wei on 2017/3/5.
 */

public class SecondActivity extends AppCompatActivity {

    public static final String ANIM_TYPE="type";
    public static final int EXPLODE = 0;
    public static final int SLIDE = 1;
    public static final int FADE = 2;
    public static final int SHARE = 3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        switch (getIntent().getIntExtra(ANIM_TYPE,-1)){
            case EXPLODE:
                getWindow().setEnterTransition(new Explode());
                break;
            case SLIDE:
                getWindow().setEnterTransition(new Slide());
                break;
            case FADE:
                getWindow().setEnterTransition(new Fade());
                break;
            case SHARE:
                getWindow().setEnterTransition(new Fade());
                break;
            default:
                break;
        }
        //设置此动画显示的时机
        // false:需要等上一个activity的退出动画显示完成后，才开启此activity的进入动画；
        // true:不必等上一个activity的退出动画执行完，就开始此activity的进入动画；
        getWindow().setAllowEnterTransitionOverlap(false);
        setContentView(R.layout.activity_second);
    }

}

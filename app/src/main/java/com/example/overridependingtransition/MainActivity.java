package com.example.overridependingtransition;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        //创建各种动画
        Transition explode = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);
        Transition fade = TransitionInflater.from(this).inflateTransition(android.R.transition.fade);
        Transition move = TransitionInflater.from(this).inflateTransition(android.R.transition.move);
        Transition slide_left = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_left);

        //使用动画时机
        getWindow().setExitTransition(slide_left);
        //getWindow().setEnterTransition(explode);
        //getWindow().setReenterTransition(explode);

        setContentView(R.layout.activity_main);

    }

    public void customAnim(View view){
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(this,R.anim.enter_up,R.anim.exit_down);
        startActivity(new Intent(this,LoginActivity.class), compat.toBundle());
    }

    public void scaleUpAnim(View view){
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(view,view.getWidth()/2,view.getHeight()/2,0,0);
        startActivity(new Intent(this,LoginActivity.class), compat.toBundle());
    }

    public void thumbnailScale(View view){
        ActivityOptionsCompat options3 = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(view, BitmapFactory.decodeResource(getResources(), R.mipmap.timg), 0, 0);
        ActivityCompat.startActivity(this, new Intent(this, LoginActivity.class), options3.toBundle());
    }

    public void clipRevealAnim(View view){
        ActivityOptionsCompat options4 = ActivityOptionsCompat.makeClipRevealAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 1000, 1000);
        ActivityCompat.startActivity(this, new Intent(this, LoginActivity.class), options4.toBundle());
    }

    public void transitionAnim(View view){
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, getString(R.string.trans));
        ActivityCompat.startActivity(this, new Intent(this, TransitionAnimActivity.class), compat.toBundle());
    }

    public void explode(View view){
        ActivityOptionsCompat options6 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        ActivityCompat.startActivity(this, new Intent(this, LoginActivity.class), options6.toBundle());
    }



}

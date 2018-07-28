package com.example.sahil.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mBallImage;
    private Animation mAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBallImage = (ImageView)findViewById(R.id.imageView);
        mAnim  = AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate);

    }

    public void translate(View view) {
        mAnim  = AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate);
        mBallImage.startAnimation(mAnim);
    }

    public void scale(View view) {
        mAnim  = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
        mBallImage.startAnimation(mAnim);
    }

    public void rotate(View view) {
        mAnim  = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
        mBallImage.startAnimation(mAnim);
    }

    public void fade(View view) {
        mAnim  = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade);
        mBallImage.startAnimation(mAnim);
    }

    public void bounce(View view) {
        mAnim.setInterpolator(new BounceInterpolator());
        mBallImage.startAnimation(mAnim);
    }

    public void overshoot(View view) {
        mAnim.setInterpolator(new OvershootInterpolator());
        mBallImage.startAnimation(mAnim);
    }
}

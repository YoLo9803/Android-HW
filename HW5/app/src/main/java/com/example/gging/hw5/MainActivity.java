package com.example.gging.hw5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private GridView mGridView;
    private ImageSwitcher mImgSwitcher;

    private Integer[] miImgArr = {
            R.drawable.img01,R.drawable.yolo1,R.drawable.yolo2,R.drawable.yolo3,
            R.drawable.yolo4,R.drawable.yolo5,R.drawable.yolo6,R.drawable.yolo7,
            R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,
            R.drawable.img06,R.drawable.img07,R.drawable.img08};

    private Integer[] mThumbImgArr = {
            R.drawable.img01th,R.drawable.yolo1th,R.drawable.yolo2th,R.drawable.yolo3th,
            R.drawable.yolo4th,R.drawable.yolo5th,R.drawable.yolo6th,R.drawable.yolo7th,
            R.drawable.img02th,R.drawable.img03th,R.drawable.img04th,R.drawable.img05th,
            R.drawable.img06th,R.drawable.img07th,R.drawable.img08th };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgSwitcher = findViewById(R.id.imgSwitch);

        mImgSwitcher.setFactory(this);
        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        ImgAdapter imgAdap = new ImgAdapter(this,mThumbImgArr);

        mGridView = findViewById(R.id.gridView);
        mGridView.setAdapter(imgAdap);
        mGridView.setOnItemClickListener(gridOnChick);
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(Color.WHITE);
        return v;
    }

    private AdapterView.OnItemClickListener gridOnChick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Animation alpha_in = new AlphaAnimation(0.0f,1.0f);
            alpha_in.setDuration(1000);
            Animation alpha_out = new AlphaAnimation(1.0f,0.0f);
            alpha_out.setDuration(1000);

            Animation scale_in = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,0.5f,0.5f);
            scale_in.setDuration(1000);
            Animation scale_out = new ScaleAnimation(0.0f,1.0f,1.0f,0.0f,0.5f,0.5f);
            scale_out.setDuration(1000);

            Animation rotate_in = new RotateAnimation(0,360,0.5f,0.5f);
            rotate_in.setDuration(1000);
            Animation rotate_out = new RotateAnimation(0,360,0.5f,0.5f);
            rotate_out.setDuration(1000);

            Animation translate_in = new TranslateAnimation(-1500,0,-1500,0);
            translate_in.setDuration(1000);
            Animation translate_out = new TranslateAnimation(0,1500,0,1500);
            translate_out.setDuration(1000);

            AnimationSet scale_rotate_in = new AnimationSet(false);
            scale_rotate_in.addAnimation(scale_in);
            scale_rotate_in.addAnimation(rotate_in);
            AnimationSet scale_rotate_out = new AnimationSet(false);
            scale_rotate_out.addAnimation(scale_in);
            scale_rotate_out.addAnimation(rotate_in);

            AnimationSet scale_rotate_translate_in = new AnimationSet(false);
            scale_rotate_translate_in.addAnimation(scale_rotate_in);
            scale_rotate_translate_in.addAnimation(translate_in);
            AnimationSet scale_rotate_translate_out = new AnimationSet(false);
            scale_rotate_translate_out.addAnimation(scale_rotate_out);
            scale_rotate_translate_out.addAnimation(translate_out);

            switch ((int)(Math.random()*4+1)) {
                case 1:
                    mImgSwitcher.setInAnimation(alpha_in);
                    mImgSwitcher.setOutAnimation(alpha_out);
                    break;
                case 2:
                    mImgSwitcher.setInAnimation(translate_in);
                    mImgSwitcher.setOutAnimation(translate_out);
                    break;
                case 3:
                    mImgSwitcher.setInAnimation(scale_rotate_in);
                    mImgSwitcher.setOutAnimation(scale_rotate_out);
                    break;
                case 4:
                    mImgSwitcher.setInAnimation(scale_rotate_translate_in);
                    mImgSwitcher.setOutAnimation(scale_rotate_translate_out);
                    break;
            }

            mImgSwitcher.setImageResource(miImgArr[position]);
        }
    };
}

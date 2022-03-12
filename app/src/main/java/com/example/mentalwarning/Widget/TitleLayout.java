package com.example.mentalwarning.Widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.mentalwarning.R;

/**
 * 标题栏
 */
public class TitleLayout extends RelativeLayout {

    private ImageView tit_iv_back;
    private TextView tit_tv_tit;


    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_title, this);

        tit_iv_back = findViewById(R.id.tit_iv_back);
        /*Glide.with(context)
                .load("https://z3.ax1x.com/2021/10/24/5WWs54.png")
                .into(tit_iv_back);*/
        tit_iv_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });

        tit_tv_tit = findViewById(R.id.tit_tv_tit);

    }

    /**
     * 设置标题文字
     */
    public void setTitle(String s){
        tit_tv_tit.setText(s);
    }
}
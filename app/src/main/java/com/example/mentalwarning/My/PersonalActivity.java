package com.example.mentalwarning.My;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.mentalwarning.R;
import com.example.mentalwarning.R;
import com.example.mentalwarning.Widget.TitleLayout;
import com.example.mentalwarning.databinding.ActivityPersonalBinding;


public class PersonalActivity extends AppCompatActivity {

    private ActivityPersonalBinding binding;

    private TitleLayout per_tit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置状态栏黑色字
        }

        binding = ActivityPersonalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView(){
        per_tit = binding.perTit;
        per_tit.setTitle("个人资料");

    }
}
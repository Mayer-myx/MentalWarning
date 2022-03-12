package com.example.mentalwarning.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.mentalwarning.MainActivity;
import com.example.mentalwarning.R;
import com.example.mentalwarning.Util.ActivityUIUtil;
import com.example.mentalwarning.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityLoginBinding binding;
    private Button login_btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivityUIUtil.makeStatusBarTransparent(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView(){
        login_btn_login = binding.loginBtnLogin;
        login_btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_btn_login:
                startActivity(new Intent(this, MainActivity.class));
                this.finish();
                break;
        }
    }
}
package com.example.mentalwarning.Mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mentalwarning.databinding.ActivityShequBinding;

public class ShequActivity extends AppCompatActivity {

    private ActivityShequBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShequBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
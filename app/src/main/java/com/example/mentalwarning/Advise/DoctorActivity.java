package com.example.mentalwarning.Advise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mentalwarning.databinding.ActivityDoctorBinding;

public class DoctorActivity extends AppCompatActivity {

    private ActivityDoctorBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
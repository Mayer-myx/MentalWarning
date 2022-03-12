package com.example.mentalwarning.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mentalwarning.databinding.FragmentWarnBinding;


/**
 * @author Diredre
 * @brief description
 * @date 2022-03-05
 */
public class WarnFrgment extends Fragment {

    private static String TAG = "WarnFrgment";

    private FragmentWarnBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentWarnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();

        return root;
    }

    private void initView(){

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

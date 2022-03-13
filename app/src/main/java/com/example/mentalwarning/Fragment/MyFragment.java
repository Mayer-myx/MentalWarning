package com.example.mentalwarning.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mentalwarning.My.HelpActivity;
import com.example.mentalwarning.My.InformActivity;
import com.example.mentalwarning.My.PersonalActivity;
import com.example.mentalwarning.databinding.FragmentMyBinding;


/**
 * @author Diredre
 * @brief description
 * @date 2022-03-05
 */
public class MyFragment extends Fragment {

    private static String TAG = "MyFragment";

    private FragmentMyBinding binding;

    private TextView myfg_tv_personal;
    private ImageView myfg_iv_message;
    private LinearLayout myfg_ll_help;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();

        return root;
    }

    private void initView(){
        myfg_tv_personal = binding.myfgTvPersonal;
        myfg_tv_personal.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), PersonalActivity.class));
        });

        myfg_ll_help = binding.myfgLlHelp;
        myfg_ll_help.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), HelpActivity.class));
        });

        myfg_iv_message = binding.myfgIvMessage;
        myfg_iv_message.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), InformActivity.class));
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

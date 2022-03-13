package com.example.mentalwarning.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.mentalwarning.Class.SearchActivity;
import com.example.mentalwarning.Mainpage.ImageAdapter;
import com.example.mentalwarning.Mainpage.ImageBean;
import com.example.mentalwarning.databinding.FragmentAdviseBinding;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-05
 */
public class AdviseFragment extends Fragment {

    private static String TAG = "AdviseFragment";

    private FragmentAdviseBinding binding;

    private Banner advisefg_banner;
    private CardView advisefg_cd_search;
    private List<ImageBean> imgList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAdviseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();

        return root;
    }

    private void initView(){
        advisefg_banner = binding.advisefgBanner;
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/09/bfiQPg.png"));
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/10/b4wjyD.png"));
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/10/b40E6S.png"));
        advisefg_banner.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(imgList))
                .setIndicator(new CircleIndicator(getActivity()));

        advisefg_cd_search = binding.advisefgCdSearch;
        advisefg_cd_search.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), SearchActivity.class));
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

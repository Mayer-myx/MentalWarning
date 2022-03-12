package com.example.mentalwarning.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mentalwarning.Mainpage.ImageAdapter;
import com.example.mentalwarning.Mainpage.ImageBean;
import com.example.mentalwarning.Mainpage.MachineActivity;
import com.example.mentalwarning.Mainpage.TeachAdapter;
import com.example.mentalwarning.Mainpage.TeachBean;
import com.example.mentalwarning.databinding.FragmentHomeBinding;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import com.example.mentalwarning.R;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-05
 */
public class HomeFragment extends Fragment implements OnBannerListener, View.OnClickListener {

    private static String TAG = "HomeFragment";

    private FragmentHomeBinding binding;
    private Banner homefg_banner;
    private RecyclerView homefg_rv_teach;
    private ImageView homefg_iv_fm1, homefg_iv_fm2, homefg_iv_machine;
    private TeachAdapter teachAdapter;
    private List<ImageBean> imgList = new ArrayList<>();
    private List<TeachBean> teachBeanList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();

        return root;
    }

    private void initView() {
        homefg_banner = binding.homefgBanner;
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/09/bfiQPg.png"));
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/10/b4wjyD.png"));
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/10/b40E6S.png"));
        homefg_banner.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(imgList))
                .setIndicator(new CircleIndicator(getActivity()));

        homefg_iv_fm1 = binding.homefgIvFm1;
        Glide.with(getActivity())
                .load("https://s1.ax1x.com/2022/03/12/bT20jH.png")
                .into(homefg_iv_fm1);
        homefg_iv_fm2 = binding.homefgIvFm2;
        Glide.with(getActivity())
                .load("https://tse1-mm.cn.bing.net/th/id/R-C.2305359c68b8b5ac228f622ac0fda363?rik=yGw7cY4TipcLhA&riu=http%3a%2f%2fi0.hdslb.com%2fbfs%2farchive%2fef7bebb5a49202199cbc05672801994e53320e58.jpg&ehk=%2f%2fWCZArwzcWmTqQ2VostWdAlP%2btle%2b7iIE17M15kP8Y%3d&risl=&pid=ImgRaw&r=0")
                .into(homefg_iv_fm2);

        homefg_rv_teach = binding.homefgRvTeach;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homefg_rv_teach.setLayoutManager(linearLayoutManager);
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(homefg_rv_teach);
        teachBeanList.add(new TeachBean("杨晓英", "国家二级心理咨询师\t好评如潮",
                "获聘525河南分站主任、安阳分站主任。擅长领域：抑郁症、婚恋情感、人际关系、强迫症、焦虑症",
                "https://img.psy525.cn/upload/AvatarMax/20180926/36c6ba048af340978bae4703a95fe59a.jpg!350"));
        teachBeanList.add(new TeachBean("张志辉", "国家二级心理咨询师\t领域专家",
                "获聘525衡水分站主任。擅长领域：婚恋情感、肿瘤心理咨询、性心理、婚外恋、厌学、焦虑抑郁、强迫症、焦虑症、催眠、失眠",
                "https://img.psy525.cn/upload/AvatarMax/20210611/1d98c974bb6a4bd38d2d60c8b6ff55e1.jpg!350"));
        teachBeanList.add(new TeachBean("丁建蓉", "国家二级心理咨询师\tNLP高级执行师",
                "获聘525湖北分站主任。擅长领域：青少年心理干预、焦虑抑郁、人际关系、失眠、强迫恐惧。",
                "https://img.psy525.cn/upload/avatar/20200414/a06b0c91c68a483ca14bc225010e3ab0.jpg!200"));
        teachAdapter = new TeachAdapter(getActivity(), teachBeanList);
        homefg_rv_teach.setAdapter(teachAdapter);

        homefg_iv_machine = binding.homefgIvMachine;
        homefg_iv_machine.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void OnBannerClick(Object o, int i) {
        Log.i("tag", "你点了第"+i+"张轮播图");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homefg_iv_machine:
                startActivity(new Intent(getActivity(), MachineActivity.class));
                break;
        }
    }
}

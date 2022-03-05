package com.example.mentalwarning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import com.example.mentalwarning.Fragment.AdviseFragment;
import com.example.mentalwarning.Fragment.ClassFragment;
import com.example.mentalwarning.Fragment.HomeFragment;
import com.example.mentalwarning.Fragment.MyFragment;
import com.example.mentalwarning.Fragment.WarmFrgment;
import com.example.mentalwarning.databinding.ActivityMainBinding;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private EasyNavigationBar easyBars;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] strings = {"首页", "心理课程", "心理预警", "心理咨询", "我的"};
//    private int[] unSelectList = {R.drawable.home_f,R.drawable.search_f,R.drawable.shopcar_f,R.drawable.people_f};
//    private int[] selectList = {R.drawable.home_t,R.drawable.search_t,R.drawable.shopcar_t,R.drawable.people_t};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        easyBars = findViewById(R.id.easy_bars);
//
//        fragmentList.add(new HomeFragment());
//        fragmentList.add(new ClassFragment());
//        fragmentList.add(new WarmFrgment());
//        fragmentList.add(new AdviseFragment());
//        fragmentList.add(new MyFragment());
//
//        easyBars.titleItems(strings)//导航栏文字
//                .fragmentList(fragmentList)//存放fragment的集合
//                .fragmentManager(getSupportFragmentManager())//fragment管理器
//                .selectIconItems(selectList)//选中的图片
//                .normalIconItems(unSelectList)//未选中的图片
//                .canScroll(true)//可以滑动
//                .mode(EasyNavigationBar.NavigationMode.MODE_NORMAL)
//                .selectTextColor(Color.parseColor("#ED578A"))//选中的文字颜色
//                .normalTextColor(Color.parseColor("#9D9D9D"))//未选中的文字颜色
//                .build();//最后一定要记得.build
    }
}
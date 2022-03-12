package com.example.mentalwarning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.example.mentalwarning.Fragment.AdviseFragment;
import com.example.mentalwarning.Fragment.ClassFragment;
import com.example.mentalwarning.Fragment.HomeFragment;
import com.example.mentalwarning.Fragment.MyFragment;
import com.example.mentalwarning.Fragment.WarnFrgment;
import com.example.mentalwarning.Util.DisplayUtil;
import com.example.mentalwarning.databinding.ActivityMainBinding;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EasyNavigationBar main_enb_bottom;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] strings = {"首页", "心理课程", "心理咨询", "我的"};
    private int[] unSelectList = {R.mipmap.home_n, R.mipmap.class_n, R.mipmap.advise_n, R.mipmap.my_n};
    private int[] selectList = {R.mipmap.home_s, R.mipmap.class_s, R.mipmap.advise_s, R.mipmap.my_s};

    private Handler mHandler = new Handler();
    private boolean flag = true;


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

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        main_enb_bottom = binding.mainEnbBottom;

        fragmentList.add(new HomeFragment());
        fragmentList.add(new ClassFragment());
        fragmentList.add(new WarnFrgment());
        fragmentList.add(new AdviseFragment());
        fragmentList.add(new MyFragment());

        main_enb_bottom.defaultSetting()
                .navigationHeight(DisplayUtil.px2dip(this,139))
                .navigationHeight(DisplayUtil.px2dip(this,140))
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)   //默认MODE_NORMAL 普通模式  //MODE_ADD 带加号模式
                .titleItems(strings)            //  Tab文字集合  只传文字则只显示文字
                .tabTextSize(DisplayUtil.px2dip(this,24))   //Tab文字大小
                .textSizeType(EasyNavigationBar.TextSizeType.TYPE_DP)  //字体单位 建议使用DP  可切换SP
                .tabTextTop(2)                  //Tab文字距Tab图标的距离
                .fragmentList(fragmentList)
                .iconSize(DisplayUtil.px2dip(this,70))
                .fragmentManager(getSupportFragmentManager())
                .normalTextColor(0xFFCFCCCF)   //Tab未选中时字体颜色
                .selectTextColor(0xFF1664FF)   //Tab选中时字体颜色
                .scaleType(ImageView.ScaleType.CENTER_INSIDE)  //同 ImageView的ScaleType
                .normalIconItems(unSelectList)      //  Tab未选中图标集合
                .selectIconItems(selectList)        //  Tab选中图标集合
                .canScroll(true)    //Viewpager能否左右滑动
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)
                .centerTextStr("心理预警")/*
                .centerNormalTextColor(0xFFCFCCCF)     //加号文字未选中时字体颜色
                .centerSelectTextColor(0xFF1664FF)     //加号文字选中时字体颜色*/
                .centerIconSize(DisplayUtil.px2dip(this,125))    //中间加号图片的大小
                .centerImageRes(R.mipmap.warn_n)
                .centerLayoutHeight(80)    //包含加号的布局高度 背景透明，所以加号看起来突出一块
                .centerTextTopMargin(5)    //加号文字距离加号图片的距离
                .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM)
                .centerAlignBottom(true)    //加号是否同Tab文字底部对齐  RULE_BOTTOM时有效
                .centerAsFragment(true)
                .navigationBackground(Color.parseColor("#FFFFFF"))   //导航栏背景色
                .build();

    }
}
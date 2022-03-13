package com.example.mentalwarning.My;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.mentalwarning.R;
import com.example.mentalwarning.Widget.SlideRecyclerView;
import com.example.mentalwarning.Widget.TitleLayout;
import com.example.mentalwarning.databinding.ActivityInformBinding;

import java.util.ArrayList;
import java.util.List;

public class InformActivity extends AppCompatActivity {

    private ActivityInformBinding binding;

    private TitleLayout inf_tit;
    private SlideRecyclerView inf_srv_news;
    private InformAdapter informAdapter;
    private List<InformBean> informBeanList = new ArrayList<>();


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

        binding = ActivityInformBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView(){
        inf_tit = binding.infTit;
        inf_tit.setTitle("消息中心");

        inf_srv_news = binding.infSrvNews;
        // 垂直滑动
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        inf_srv_news.setLayoutManager(linearLayoutManager);

        // SnapHelper滑动对准
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(inf_srv_news);

        informBeanList.add(new InformBean("https://s1.ax1x.com/2022/03/13/bbyl5V.png",
                "系统通知", "恭喜你，您的资料审核已经通过。", "", true));
        informBeanList.add(new InformBean("https://s1.ax1x.com/2022/03/13/bby056.png",
                "最近访客", "田所浩二刚刚访问了你。", "", true));
        informBeanList.add(new InformBean("https://s1.ax1x.com/2022/03/13/bbftWq.png",
                "多洛丽亚", "你真有意思：)", "20:21", false));
        informBeanList.add(new InformBean("https://s1.ax1x.com/2022/03/13/bb5L11.png",
                "德克萨斯", "咕噜轱辘古路骨碌轱轳", "19:42", false));
        informBeanList.add(new InformBean("https://s1.ax1x.com/2022/03/13/bbIl3n.png",
                "墨镜酷哥", "感谢您的关注~", "19:39", false));
        informBeanList.add(new InformBean("https://s1.ax1x.com/2022/03/13/bbINEF.png",
                "小黄人", "叽哩哇啦！！", "17:07", false));
        informBeanList.add(new InformBean("https://s1.ax1x.com/2022/03/13/bbIgED.png",
                "Peter", "你能不能理我一下？", "16:36", false));

        informAdapter = new InformAdapter(informBeanList, this);
        inf_srv_news.setAdapter(informAdapter);
    }
}
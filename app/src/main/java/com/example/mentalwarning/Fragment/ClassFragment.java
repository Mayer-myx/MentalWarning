package com.example.mentalwarning.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mentalwarning.Class.ClassAdapter;
import com.example.mentalwarning.Class.ClassBean;
import com.example.mentalwarning.Class.SearchActivity;
import com.example.mentalwarning.Mainpage.ImageAdapter;
import com.example.mentalwarning.Mainpage.ImageBean;
import com.example.mentalwarning.databinding.FragmentClassBinding;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Diredre
 * @brief description
 * @date 2022-03-05
 */
public class ClassFragment extends Fragment {

    private static String TAG = "ClassFragment";

    private FragmentClassBinding binding;

    private Banner classfg_banner;
    private List<ImageBean> imgList = new ArrayList<>();

    private RecyclerView classfg_rv_class;
    private ClassAdapter classAdapter;
    private CardView classfg_cd_search;
    private List<ClassBean> classBeanList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentClassBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();

        return root;
    }

    private void initView(){
        classfg_banner = binding.classfgBanner;
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/09/bfiQPg.png"));
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/10/b4wjyD.png"));
        imgList.add(new ImageBean("https://s1.ax1x.com/2022/03/10/b40E6S.png"));
        classfg_banner.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(imgList))
                .setIndicator(new CircleIndicator(getActivity()));

        classfg_rv_class = binding.classfgRvClass;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        classfg_rv_class.setLayoutManager(linearLayoutManager);
        classBeanList.add(new ClassBean("https://book.chouji.net/uploads/2016/0623/20160623041301097801.jpg",
                "情商课程", "令你变得更卓越。"));
        classBeanList.add(new ClassBean("https://img.zcool.cn/community/01827e5542eed00000019ae901ca47.jpg@1280w_1l_2o_100sh.jpg",
                "户外自行车减脂运动", "高效减脂，提高体脂率，变瘦变美从现在开始！"));
        classBeanList.add(new ClassBean("https://tse1-mm.cn.bing.net/th/id/R-C.0e0784ed6e7dfbffe7af2a4c2d37cb10?rik=DIZcpX5sHDESRA&riu=http%3a%2f%2fpicm.photophoto.cn%2f072%2f004%2f038%2f0040380009.jpg&ehk=Ga9zRJoY%2f09wEvwCIRFM%2biIXO1pIfDZED8%2fF1m7L7xg%3d&risl=&pid=ImgRaw&r=0",
                "心理瑜伽运动", "晨跑锻炼，长期见效，重在坚持。"));
        classAdapter = new ClassAdapter(getActivity(), classBeanList);
        classfg_rv_class.setAdapter(classAdapter);

        classfg_cd_search = binding.classfgCdSearch;
        classfg_cd_search.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), SearchActivity.class));
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

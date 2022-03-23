package com.example.mentalwarning.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mentalwarning.Util.LineChartUtil;
import com.example.mentalwarning.databinding.FragmentWarnBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @author Diredre
 * @brief description
 * @date 2022-03-05
 */
public class WarnFrgment extends Fragment {

    private static String TAG = "WarnFrgment";

    private FragmentWarnBinding binding;
    private LineChart warnfg_lc;
    private int xLableCount = 7;
    private int xRangeMaximum = xLableCount - 1;

    private List<Entry> netLineList = new ArrayList<>();
    private List<String> netDateList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentWarnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();

        return root;
    }

    private void initView(){
        warnfg_lc = binding.warnfgLc;
        //折线图初始化
        LineChartUtil.initChart(binding.warnfgLc, true, false, false);

        //设置数据
        setData();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    /**
     *    new Entry(x,y) x: 折线图中数据值的位置索引 y: 具体数据值
     */
    private void setData() {
        netLineList.clear();
        netDateList.clear();

        netDateList.add("08:00");
        netDateList.add("09:00");
        for(int i = 10; i < 15; i++){
            netDateList.add("" + i + ":00");
        }

        float[] lineFloat = {81, 73, 85, 78, 67, 74, 92};
        for (int i = 0; i < netDateList.size(); i++) {
            netLineList.add(new Entry((float) i, lineFloat[i]));
        }

        xLableCount = (netDateList.size() + 3) > 7 ? 7 : (netDateList.size() + 3);
        xRangeMaximum = xLableCount - 1;

        LineChartUtil.setXAxis(warnfg_lc, xLableCount, netDateList.size(), xRangeMaximum);
        LineChartUtil.notifyDataSetChanged(warnfg_lc, netLineList, netDateList);
    }

}

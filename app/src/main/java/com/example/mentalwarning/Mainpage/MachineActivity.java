package com.example.mentalwarning.Mainpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mentalwarning.R;
import com.example.mentalwarning.Widget.TitleLayout;
import com.example.mentalwarning.databinding.ActivityMachineBinding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MachineActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMachineBinding binding;
    private TitleLayout machine_tit;
    private RecyclerView machine_rv_chat;
    private EditText machine_et_con;
    private Button machine_btn_send;

    private MessageAdapter messageAdapter;
    private List<MessageBean> messageBeanList = new ArrayList<>();


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

        binding = ActivityMachineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initMes();
        initView();
    }

    private void initView(){
        machine_tit = binding.machineTit;
        machine_tit.setTitle("机器人客服");

        machine_rv_chat = binding.machineRvChat;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        machine_rv_chat.setLayoutManager(layoutManager);
        messageAdapter = new MessageAdapter(messageBeanList);
        machine_rv_chat.setAdapter(messageAdapter);

        machine_et_con = binding.machineEtCon;

        machine_btn_send = binding.machineBtnSend;
        machine_btn_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.machine_btn_send:
                String content = machine_et_con.getText().toString();
                if(!"".equals(content)) {
                    MessageBean message = new MessageBean(content, MessageBean.TYPE_SENT);
                    messageBeanList.add(message);
                    machine_et_con.setText("");
                    MessageBean message2 = new MessageBean("这是一条自动回复", MessageBean.TYPE_RECEIVED);
                    messageBeanList.add(message2);
                    messageAdapter.notifyItemInserted(messageBeanList.size() - 1);   //通知列表有新数据插入
                    machine_rv_chat.scrollToPosition(messageBeanList.size() - 1);             //定位在最后一行
                }
                break;
        }
    }


    private void initMes(){
        MessageBean mes1 = new MessageBean("您好，我是您的智能助理。", MessageBean.TYPE_RECEIVED);
        messageBeanList.add(mes1);
        MessageBean mes2 = new MessageBean("你好。", MessageBean.TYPE_SENT);
        messageBeanList.add(mes2);
        MessageBean mes3 = new MessageBean("您好，我能为您做点什么呢？", MessageBean.TYPE_RECEIVED);
        messageBeanList.add(mes3);
    }

}
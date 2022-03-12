package com.example.mentalwarning.Mainpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import com.example.mentalwarning.R;
/**
 * @author Diredre
 * @brief description
 * @date 2022-03-10
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<MessageBean> MesList;


    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout y_layout, m_layout;
        TextView y_tv, m_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //绑定控件
            y_layout = itemView.findViewById(R.id.it_mes_y_layout);
            m_layout = itemView.findViewById(R.id.it_mes_m_layout);
            y_tv = itemView.findViewById(R.id.it_tv_y);
            m_tv = itemView.findViewById(R.id.it_tv_m);
        }
    }


    public MessageAdapter(List<MessageBean> mesList) {
        MesList = mesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageBean message = MesList.get(position);
        if(message.getType() == MessageBean.TYPE_RECEIVED){
            //如果是收到消息，显示左边y_layout
            holder.y_layout.setVisibility(View.VISIBLE);
            holder.m_layout.setVisibility(View.GONE);
            holder.y_tv.setText(message.getContent());
        }else if(message.getType() == MessageBean.TYPE_SENT){
            //如果是发送消息，显示右边m_layout
            holder.m_layout.setVisibility(View.VISIBLE);
            holder.y_layout.setVisibility(View.GONE);
            holder.m_tv.setText(message.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return MesList.size();
    }
}
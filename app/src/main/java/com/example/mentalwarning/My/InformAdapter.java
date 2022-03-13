package com.example.mentalwarning.My;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mentalwarning.Widget.RoundImageView;
import com.example.mentalwarning.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-13
 */
public class InformAdapter extends RecyclerView.Adapter<InformAdapter.ViewHolder> {

    private List<InformBean> informBeanList = new ArrayList<>();
    private Context context;


    public InformAdapter(List<InformBean> informBeanList, Context context) {
        this.informBeanList = informBeanList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_inform, parent, false);
        final InformAdapter.ViewHolder viewHolder = new InformAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull InformAdapter.ViewHolder holder, int position) {
        InformBean informBean = informBeanList.get(position);
        holder.item_inf_tv_name.setText(informBean.getName());
        holder.item_inf_tv_con.setText(informBean.getCon());
        holder.item_inf_tv_time.setText(informBean.getTime());

        Glide.with(context)
                .load(informBean.getImgurl())
                .into(holder.item_inf_riv_icon);

        holder.item_inf_view.setVisibility(informBean.isRead() ? View.INVISIBLE : View.VISIBLE);

        holder.item_inf_all.setOnClickListener(v->{
            informBean.setRead(true);
            holder.item_inf_view.setVisibility(View.INVISIBLE);
            Toast.makeText(context, "已阅", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return informBeanList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_inf_all;
        private RoundImageView item_inf_riv_icon;
        private View item_inf_view;
        private TextView item_inf_tv_name, item_inf_tv_time, item_inf_tv_con;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            item_inf_all = itemView.findViewById(R.id.item_inf_all);
            item_inf_riv_icon = itemView.findViewById(R.id.item_inf_riv_icon);
            item_inf_view = itemView.findViewById(R.id.item_inf_view);
            item_inf_tv_name = itemView.findViewById(R.id.item_inf_tv_name);
            item_inf_tv_time = itemView.findViewById(R.id.item_inf_tv_time);
            item_inf_tv_con = itemView.findViewById(R.id.item_inf_tv_con);
        }
    }
}

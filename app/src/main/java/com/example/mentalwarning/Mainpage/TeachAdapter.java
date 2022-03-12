package com.example.mentalwarning.Mainpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mentalwarning.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-10
 */
public class TeachAdapter extends RecyclerView.Adapter<TeachAdapter.ViewHolder> {

    private Context context;
    private List<TeachBean> teachBeanList = new ArrayList<>();


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView item_teach_iv_pic;
        private TextView item_teach_tv_name, item_teach_tv_like, item_teach_tv_intro;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            item_teach_iv_pic = itemView.findViewById(R.id.item_teach_iv_pic);
            item_teach_tv_name = itemView.findViewById(R.id.item_teach_tv_name);
            item_teach_tv_like = itemView.findViewById(R.id.item_teach_tv_like);
            item_teach_tv_intro = itemView.findViewById(R.id.item_teach_tv_intro);
        }
    }

    public TeachAdapter(Context context, List<TeachBean> teachBeanList) {
        this.context = context;
        this.teachBeanList = teachBeanList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_teach, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TeachAdapter.ViewHolder holder, int position) {
        TeachBean teachBean = teachBeanList.get(position);
        holder.item_teach_tv_name.setText(teachBean.getName());
        holder.item_teach_tv_like.setText(teachBean.getLike());
        holder.item_teach_tv_intro.setText(teachBean.getIntro());
        Glide.with(context)
                .load(teachBean.getPicurl())
                .into(holder.item_teach_iv_pic);
    }

    @Override
    public int getItemCount() {
        return teachBeanList != null ? teachBeanList.size() : 0;
    }

}

package com.example.mentalwarning.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.mentalwarning.R;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-12
 */
public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {

    private Context context;
    private List<ClassBean> classBeanList = new ArrayList<>();


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView item_class_iv_fm;
        private TextView item_class_tv_tit, item_class_tv_con;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            item_class_iv_fm = itemView.findViewById(R.id.item_class_iv_fm);
            item_class_tv_tit = itemView.findViewById(R.id.item_class_tv_tit);
            item_class_tv_con = itemView.findViewById(R.id.item_class_tv_con);
        }
    }

    public ClassAdapter(Context context, List<ClassBean> classBeanList) {
        this.context = context;
        this.classBeanList = classBeanList;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_class, parent, false);
        return new ClassAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ClassAdapter.ViewHolder holder, int position) {
        ClassBean classBean = classBeanList.get(position);
        Glide.with(context)
                .load(classBean.getImgurl())
                .into(holder.item_class_iv_fm);
        holder.item_class_tv_tit.setText(classBean.getTit());
        holder.item_class_tv_con.setText(classBean.getCon());
    }

    @Override
    public int getItemCount() {
        return classBeanList.size();
    }
}

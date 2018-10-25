package com.example.asus.feilei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.feilei.R;
import com.example.asus.feilei.bean.RightBean;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private Context context;
    private List<RightBean.DataBean.ListBean> list;

    public RightAdapter(Context context, List<RightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    public RightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_right,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(@NonNull RightAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getIcon()).into(holder.imageright);
        holder.textright.setText(list.get(position).getName());
    }


    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageright;
        private TextView textright;
        public ViewHolder(View itemview){
            super(itemview);
            imageright = itemview.findViewById(R.id.img_right);
            textright = itemview.findViewById(R.id.txt_right);
        }
    }
}

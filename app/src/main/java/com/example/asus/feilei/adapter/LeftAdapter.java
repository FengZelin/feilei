package com.example.asus.feilei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.feilei.R;
import com.example.asus.feilei.bean.LeftBean;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder>{
private Context context;
private List<LeftBean.DataBean> list;

public LeftAdapter(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
        }
public interface OnItemClickListener{
    void onItemClick(View itemview, int position);
}
    private OnItemClickListener clickListener;
    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public LeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context,R.layout.item_list,null);
        LeftAdapter.ViewHolder holder = new LeftAdapter.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.ViewHolder holder, final int position) {
        holder.txtleft.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener !=null){
                    clickListener.onItemClick(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
class ViewHolder extends RecyclerView.ViewHolder{
    private TextView txtleft;
    public ViewHolder(View itemview){
        super(itemview);
        txtleft = itemview.findViewById(R.id.txt_left);
    }
}
}

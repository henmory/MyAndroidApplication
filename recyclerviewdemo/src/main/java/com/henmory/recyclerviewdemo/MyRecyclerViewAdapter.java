package com.henmory.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * author: henmory
 * time:  3/15/18
 * function:
 * description:
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<String> datas;
    private Context context;

    public MyRecyclerViewAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    /**
     *  @author henmory
     *  @date 3/16/18
     *  @description    创建view和viewholder
     *
     *  @param
     *
     *  @return
    */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_recycler,null);
        return new MyViewHolder(view);
    }

    /**
     *  @author henmory
     *  @date 3/16/18
     *  @description    绑定数据，设置position处viewholder中控件的值
     *
     *  @param
     *
     *  @return
    */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String data = datas.get(position);
        holder.textView.setText(data);
        holder.imageView.setImageResource(R.drawable.ic_launcher_background);
    }



    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void add(int position, String data) {
        datas.add(position, data);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;
        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_show);
            imageView = itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(itemView, datas.get(getLayoutPosition()));
                }
            });
        }
    }

    interface onItemClickListener{
        public void onClick(View view, String data);
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    private onItemClickListener onItemClickListener;
}

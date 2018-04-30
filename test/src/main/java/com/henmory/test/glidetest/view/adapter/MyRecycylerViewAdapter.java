package com.henmory.test.glidetest.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.henmory.test.R;
import com.henmory.test.glidetest.Bean;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: henmory
 * time:  4/11/18
 * function:
 * description:
 */
public class MyRecycylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final int HEADER_VIEW = 0;
    private final int FOOT_VIEW = 1;
    private final int MAIN_VIEW = 2;

    private List<Bean> datas;
    private Context context;
    private onItemClickLisenter lisenter; //监听器


    public MyRecycylerViewAdapter(List<Bean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getMode();
    }

    //每一个item需要一个viewHolder，滑出屏幕后，该viewhodler回收到recycyler，复用到下一个要显示的item中，复用是随机的
    //http://www.codexiu.cn/android/blog/24953/
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (HEADER_VIEW == viewType){
            view = LayoutInflater.from(context).inflate(R.layout.item_header, parent, false);
            return new TitleViewHolder(view);
        }else if(FOOT_VIEW == viewType){
            view = LayoutInflater.from(context).inflate(R.layout.item_foot, parent, false);
            return new FootViewHolder(view);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
            return new MainViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MainViewHolder){
            MainViewHolder mainViewHolder = (MainViewHolder) holder;
            //获取图片数据，显示
            Glide.with(context).load(datas.get(position).getUrl())
                    .skipMemoryCache(false)//内存缓存
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)//磁盘缓存原始的图片
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .override(200,200)
                    .centerCrop()
//                .fitCenter()
                    .into(mainViewHolder.imageView);
            mainViewHolder.textView.setText("这是默认的数据");

        }else if(holder instanceof FootViewHolder){
            ((FootViewHolder)holder).textView.setText("正在加载");
            ((FootViewHolder)holder).progressBar.setIndeterminate(true);
        }else{
            ((TitleViewHolder)holder).textView.setText("我是标题");
        }

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv)
        ImageView imageView;
        @BindView((R.id.tv))
        TextView textView;
        @BindView(R.id.relative)
        RelativeLayout relativeLayout;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.relative)
        public void click() {
            if (null != lisenter){
                lisenter.onItemClick(getLayoutPosition());
            }
        }
    }

    class FootViewHolder extends RecyclerView.ViewHolder

    {
        @BindView(R.id.iv_progress)
        ProgressBar progressBar;
        @BindView(R.id.progress_text)
        TextView textView;
        public FootViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_title)
        TextView textView;
        public TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface onItemClickLisenter{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickLisenter onItemClickLisenter){
        lisenter = onItemClickLisenter;
    }

}

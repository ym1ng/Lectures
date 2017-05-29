package com.example.administrator.lecturesmanagerdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.CollectionListResult;
import com.example.administrator.lecturesmanagerdemo.bean.EnrollListResult;
import com.example.administrator.lecturesmanagerdemo.utils.DateFormatUtil;

import java.util.List;


/**
 * Created by jianghejie on 15/11/26.
 */
public class CollectionLectureListAdapter extends
        RecyclerView.Adapter<CollectionLectureListAdapter.ViewHolder> implements View.OnClickListener{
    public List<CollectionListResult.DataBean> datas = null;
    Context context;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int postion);
    }
    public CollectionLectureListAdapter(List<CollectionListResult.DataBean>
                             datas, Context context) {
        this.datas = datas;
        this.context=context;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup
                                                 viewGroup, int viewType) {
        View view = LayoutInflater.from
                (viewGroup.getContext()).inflate
                (R.layout.item_news_template5,viewGroup,false);

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, int position ) {
        holder.itemView.setTag(position);
        String title = datas.get(position).getLectures().getLecturesname() ;
            holder.tvtitle.setText(title);
            holder.tvlectureaddress.setText( datas.get(position).getLectures().getClassroom().getClassroomname());
        long datetime=datas.get(position).getLectures().getLecturestime();
            holder.tvlecturetime.setText(DateFormatUtil.LongToDate(datetime));
            Glide.with(context)
                    .load(GlobalField.ImageURL+datas.get(position).getLectures().getPoster())
                    .diskCacheStrategy
                            (DiskCacheStrategy.ALL)//加快显示速度---缓存在本地磁盘
                    .into(holder.ivlecturepic);//图片

    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends
            RecyclerView.ViewHolder {
        public TextView tvtitle;
        public TextView tvlecturetime;
        public TextView tvlectureaddress;
        ImageView ivlecturepic;

        public ViewHolder(View view){
            super(view);
            tvtitle = (TextView) view.findViewById
                    (R.id.tv_title);
            tvlecturetime = (TextView) view.findViewById
                    (R.id.tv_lecture_time);
            tvlectureaddress = (TextView) view.findViewById
                    (R.id.tv_lecture_address);
            ivlecturepic=(ImageView) view.findViewById
                    (R.id.iv_thumb);
        }
    }

}

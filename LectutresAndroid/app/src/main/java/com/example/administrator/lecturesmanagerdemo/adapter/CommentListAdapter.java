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
import com.example.administrator.lecturesmanagerdemo.bean.CommentListResult;
import com.example.administrator.lecturesmanagerdemo.bean.EnrollListResult;
import com.example.administrator.lecturesmanagerdemo.utils.DateFormatUtil;

import java.util.List;



public class CommentListAdapter extends
        RecyclerView.Adapter<CommentListAdapter.ViewHolder> implements View.OnClickListener{
    public List<CommentListResult.DataBean> datas = null;
    Context context;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int postion);
    }
    public CommentListAdapter(List<CommentListResult.DataBean>
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
                (R.layout.item_comment,viewGroup,false);

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, int position ) {
        holder.itemView.setTag(position);
        String commentcontent = datas.get(position).getCommentcontent();
            holder.commentcontent.setText(commentcontent);
            holder.realname.setText( datas.get(position).getUser().getRealname());
        long datetime=datas.get(position).getConmmentdate();
            holder.commenttime.setText(DateFormatUtil.LongToDate(datetime));
//            Glide.with(context)
//                    .load(GlobalField.ImageURL+datas.get(position).getUser().getHeadpicpath())
//                    .diskCacheStrategy
//                            (DiskCacheStrategy.ALL)//加快显示速度---缓存在本地磁盘
//                    .into(holder.imghead);//图片

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
        public TextView commentcontent;
        public TextView commenttime;
        public TextView realname;
        ImageView imghead;

        public ViewHolder(View view){
            super(view);
            commentcontent = (TextView) view.findViewById
                    (R.id.comment_content);
            commenttime = (TextView) view.findViewById
                    (R.id.commenttime);
            realname = (TextView) view.findViewById
                    (R.id.realname);
            imghead=(ImageView) view.findViewById
                    (R.id.img_head);
        }
    }
}

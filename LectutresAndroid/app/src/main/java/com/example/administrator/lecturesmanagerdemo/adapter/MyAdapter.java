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
import com.example.administrator.lecturesmanagerdemo.bean.Movies;
import com.example.administrator.lecturesmanagerdemo.R;

import java.util.List;


/**
 * Created by jianghejie on 15/11/26.
 */
public class MyAdapter extends
        RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public List<Movies.SubjectsBean> datas = null;
    Context context;
    public MyAdapter(List<Movies.SubjectsBean>
                             datas,Context context) {
        this.datas = datas;
        this.context=context;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup
                                                 viewGroup, int viewType) {
        View view = LayoutInflater.from
                (viewGroup.getContext()).inflate
                (R.layout.movie_item,viewGroup,false);
        return new ViewHolder(view);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, int
            position ) {
        {
            String title = (position ) + "、" +
                    datas.get(position).getTitle() + "/" + datas.get
                    (position).getOriginal_title();
            holder.tvtitle.setText(title);
            String doc = "";
            for (Movies.SubjectsBean.DirectorsBean
                    directorsBean : datas.get(position).getDirectors()) {
                doc += directorsBean.getName() + "  ";
            }
            holder.tvmoviedoc.setText("导演:" + doc);
            String casts = "";
            for (Movies.SubjectsBean.CastsBean castsBean
                    :  datas.get(position).getCasts()) {
                casts += castsBean.getName() + "  ";
            }
            holder.tvmovieart.setText( "主演:" + casts);
            String genres = "";
            for (String genre : datas.get
                    (position).getGenres()) {
                genres += genre + " ";
            }
            holder.tvmovietype.setText( datas.get
                    (position).getYear() + " / " + genres);//年份+分级
            holder.tvmoviegrade.setText( datas.get
                    (position).getRating().getAverage() + "");//评分

            Glide.with(context)
                    .load(datas.get(position).getImages
                            ().getSmall())
                    .diskCacheStrategy
                            (DiskCacheStrategy.ALL)//加快显示速度---缓存在本地磁盘
                    .into(holder.iv_pic);//图片
        }
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends
            RecyclerView.ViewHolder {
        public TextView tvtitle;
        public TextView tvmoviedoc;
        public TextView tvmovieart;
        public TextView tvmovietype;
        public TextView tvmoviegrade;
        ImageView iv_pic;

        public ViewHolder(View view){
            super(view);
            tvtitle = (TextView) view.findViewById
                    (R.id.tv_movie_title);
            tvmoviedoc = (TextView) view.findViewById
                    (R.id.tv_movie_doc);
            tvmovieart = (TextView) view.findViewById
                    (R.id.tv_movie_art);
            tvmovietype = (TextView) view.findViewById
                    (R.id.tv_movie_type);
            tvmoviegrade = (TextView) view.findViewById
                    (R.id.tv_movie_grade);
            tvtitle = (TextView) view.findViewById
                    (R.id.tv_movie_title);
            iv_pic=(ImageView) view.findViewById
                    (R.id.iv_movie_pic);
        }
    }
}

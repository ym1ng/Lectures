package com.example.administrator.lecturesmanagerdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.queryuserenrollBydate;
import com.example.administrator.lecturesmanagerdemo.ui.Lecture.LectureDetailActivity;
import com.example.administrator.lecturesmanagerdemo.utils.DateFormatUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/5/1.
 */

public class LectureListviewAdapter extends BaseAdapter{
    public TextView tvtitle;
    public TextView tvlecturetime;
    public TextView tvlectureaddress;
    ImageView ivlecturepic;
    List<queryuserenrollBydate.DataBean> datas;
    Context context;
    private LayoutInflater inflater;
    public LectureListviewAdapter() {}

    public LectureListviewAdapter(List<queryuserenrollBydate.DataBean> datas,Context context) {
        this.datas = datas;
        this.context=context;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public queryuserenrollBydate.DataBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(  final int position, View convertView, ViewGroup parent) {
        //加载布局为一个视图
        View view=inflater.inflate(R.layout.lecture_item,null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LectureDetailActivity.class);
                intent.putExtra("lecturesid", datas.get(position).getLecturesid());
               context.startActivity(intent);
               // startActivity(intent);
            }
        });
        //在view视图中查找id为image_photo的控件
        tvtitle = (TextView) view.findViewById
                (R.id.tv_lecture_title);
        tvlecturetime = (TextView) view.findViewById
                (R.id.tv_lecture_time);
        tvlectureaddress = (TextView) view.findViewById
                (R.id.tv_lecture_address);
        ivlecturepic=(ImageView) view.findViewById
                (R.id.iv_lecture_pic);
        String title = datas.get(position).getLectures().getLecturesname();
        tvtitle.setText(title);
        tvlectureaddress.setText( datas.get(position).getLectures().getClassroom().getClassroomname());
        long datetime=datas.get(position).getLectures().getLecturestime();
        tvlecturetime.setText(DateFormatUtil.LongToDate(datetime));
        Glide.with(context)
                .load(GlobalField.ImageURL+datas.get(position).getLectures().getPoster())
                .diskCacheStrategy
                        (DiskCacheStrategy.ALL)//加快显示速度---缓存在本地磁盘
                .into(ivlecturepic);//图片
        return view;
    }
}

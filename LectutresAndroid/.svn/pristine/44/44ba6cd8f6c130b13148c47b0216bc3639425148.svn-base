package com.example.administrator.lecturesmanagerdemo.adapter;

/**
 * Created by Administrator on 2017/5/2.
 */
import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.VideoResult;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class VideoAdapter extends CommonAdapter<VideoResult.DataBean> {
    private Context mContext;

    public VideoAdapter(Context context, List<VideoResult.DataBean> datas, int layoutId) {
        super(context, layoutId, datas);
        this.mContext = context;
    }

    @Override
    protected void convert(ViewHolder viewHolder, VideoResult.DataBean item, int position) {
        JCVideoPlayerStandard player = viewHolder.getView(R.id.player_list_video);
        if (player != null) {
            player.release();
        }

        player.setUp(GlobalField.ImageURL+mDatas.get(position).getVideourl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, mDatas.get(position).getVideoname());
        Glide.with(mContext).load(GlobalField.ImageURL+mDatas.get(position).getVideopic()).into(player.thumbImageView);

    }
}
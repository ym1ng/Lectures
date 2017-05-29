package com.example.administrator.lecturesmanagerdemo.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.adapter.VideoAdapter;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.EnrollListResult;
import com.example.administrator.lecturesmanagerdemo.bean.VideoResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.youth.xframe.base.XFragment;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/5/2.
 */

public class VideoFragment extends XFragment {
    private String videoUrl = "http://2449.vod.myqcloud.com/2449_ded7b566b37911e5942f0b208e48548d.f20.mp4";
    private ListView listView;
    private ArrayList<VideoResult.DataBean> datas;
    private JCVideoPlayerStandard currPlayer;
    private VideoAdapter adapter;
    private AbsListView.OnScrollListener onScrollListener;
    private int firstVisible;//当前第一个可见的item
    private int visibleCount;//当前可见的item个数


    public static VideoFragment newInstance( ){
        VideoFragment fragmentCommon=new VideoFragment();
        return fragmentCommon;
    }
    /**
     * 滑动监听
     */
    private void initListener() {
        onScrollListener = new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        //滑动停止自动播放视频
                     //   autoPlayVideo(view);
                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisible == firstVisibleItem) {
                    return;
                }

                firstVisible = firstVisibleItem;
                visibleCount = visibleItemCount;
            }
        };

        listView.setOnScrollListener(onScrollListener);
    }

    /**
     * 滑动停止自动播放视频
     */
    private void autoPlayVideo(AbsListView view) {

        for (int i = 0; i < visibleCount; i++) {
            if (view != null && view.getChildAt(i) != null && view.getChildAt(i).findViewById(R.id.player_list_video) != null) {
                currPlayer = (JCVideoPlayerStandard) view.getChildAt(i).findViewById(R.id.player_list_video);
                Rect rect = new Rect();
                //获取当前view 的 位置
                currPlayer.getLocalVisibleRect(rect);
                int videoheight = currPlayer.getHeight();
                if (rect.top == 0 && rect.bottom == videoheight) {
                    if (currPlayer.currentState == JCVideoPlayer.CURRENT_STATE_NORMAL
                            || currPlayer.currentState == JCVideoPlayer.CURRENT_STATE_ERROR) {
                        currPlayer.startButton.performClick();
                    }
                    return;
                }
            }
        }
        //释放其他视频资源
        JCVideoPlayer.releaseAllVideos();
    }

//    @Override
//    public void onBackPressed() {
//        if (JCVideoPlayer.backPress()) {
//            return;
//        }
//        super.onBackPressed();
//    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        datas=new ArrayList<>();
        queryvideo();
        adapter = new VideoAdapter(getActivity(), datas, R.layout.item_video);
    }

    @Override
    public void initView() {
        listView = (ListView) getView().findViewById(R.id.listview);
        initListener();
        listView.setAdapter(adapter);
    }
    void queryvideo(){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<VideoResult> call = service.getVideolist();
        //进行网络请求
        call.enqueue(new Callback<VideoResult>() {
            @Override
            public void onResponse(Call<VideoResult> call, Response<VideoResult> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    datas.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<VideoResult> call, Throwable t) {

            }
        });
    }


}
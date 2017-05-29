package com.example.administrator.lecturesmanagerdemo.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.User;
import com.example.administrator.lecturesmanagerdemo.bean.UserResult;
import com.example.administrator.lecturesmanagerdemo.bean.baseResult;
import com.example.administrator.lecturesmanagerdemo.fragment.CalendarFragment;
import com.example.administrator.lecturesmanagerdemo.fragment.LectureFragment;
import com.example.administrator.lecturesmanagerdemo.fragment.MainFragment;
import com.example.administrator.lecturesmanagerdemo.fragment.MyFragment;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.ui.SelectLectures;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.fragment.VideoFragment;
import com.example.administrator.lecturesmanagerdemo.widget.CircleTransform;
import com.squareup.picasso.Picasso;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;
import com.youth.xframe.utils.log.XLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends  AppCompatActivity {

    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @InjectView(R.id.search)
    ImageView search;
    @InjectView(R.id.tabView)
    TabView tabView;


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_start_activity);
        ButterKnife.inject(this);
        tvTitle.setText("首页");
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SelectLectures.class);
                startActivity(intent);
            }
        });
        //start add data
        List<TabViewChild> tabViewChildList=new ArrayList<>();
        TabViewChild tabViewChild01=new TabViewChild(R.drawable.tab01_sel,R.drawable.tab01_unsel,"首页", MainFragment.newInstance());
        TabViewChild tabViewChild02=new TabViewChild(R.drawable.tab02_sel,R.drawable.tab02_unsel,"发现", LectureFragment.newInstance());
        TabViewChild tabViewChild04=new TabViewChild(R.drawable.ic_video_selected,R.drawable.ic_video,"视频", VideoFragment.newInstance());
        TabViewChild tabViewChild03=new TabViewChild(R.drawable.tab03_sel,R.drawable.tab03_unsel,"行程", CalendarFragment.newInstance());
        TabViewChild tabViewChild05=new TabViewChild(R.drawable.tab05_sel,R.drawable.tab05_unsel,"我的", MyFragment.newInstance());
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild04);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild05);
        //end add data
        tabView.setTabViewDefaultPosition(0);
        tabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int  position, ImageView currentImageIcon, TextView currentTextView) {
                // Toast.makeText(getApplicationContext(),"position:"+position,Toast.LENGTH_SHORT).show();
                if (position ==0 ){
                    tvTitle.setText("首页");
                    search.setVisibility(View.VISIBLE);
                }else if (position ==1){
                    tvTitle.setText("发现");
                    search.setVisibility(View.VISIBLE);
                }else if (position ==2){
                    tvTitle.setText("视频");
                    search.setVisibility(View.VISIBLE);
                } else if (position ==3){
                    tvTitle.setText("行程");
                    search.setVisibility(View.VISIBLE);
                }else if (position ==4 ){
                    tvTitle.setText("我的");
                    search.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }


}

package com.example.administrator.lecturesmanagerdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.adapter.EnrollLectureListAdapter;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.EnrollListResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.ui.Lecture.LectureDetailActivity;
import com.youth.xframe.base.XActivity;
import com.youth.xframe.utils.log.XLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import me.leefeng.lfrecyclerview.LFRecyclerView;
import me.leefeng.lfrecyclerview.OnItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class EnrollListActivity extends XActivity implements OnItemClickListener, LFRecyclerView.LFRecyclerViewListener, LFRecyclerView.LFRecyclerViewScrollChange{
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.iv_title_back)
     ImageView iv_back;
    @InjectView(R.id.search)
    ImageView Ivsearch;
    @InjectView(R.id.recyclerview)
    LFRecyclerView recycleview;
    int pageNo=1;
    int pageSize=8;
    boolean isHasNextPage=true;
    private EnrollLectureListAdapter adapter;
    List<EnrollListResult.DataBean> dataBeen = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_enrolllist;
    }
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        ButterKnife.inject(this);
        tvTitle.setText("我的讲座");
        Ivsearch.setVisibility(View.GONE);
        iv_back.setVisibility(View.VISIBLE);
        queryLectures();
        adapter = new EnrollLectureListAdapter(dataBeen,getApplication());
        recycleview.setLoadMore(true);
        recycleview.setRefresh(true);
        recycleview.setNoDateShow();
        recycleview.setAutoLoadMore(true);
        recycleview.setOnItemClickListener(this);
        recycleview.setLFRecyclerViewListener(this);
        recycleview.setScrollChangeListener(this);
        recycleview.setItemAnimator(new DefaultItemAnimator());
        recycleview.setAdapter(adapter);
    }
    @OnClick(R.id.iv_title_back)
    void finishA(View view) {
        finish();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataBeen.clear();
                pageNo=1;
                queryLectures();
                adapter.notifyDataSetChanged();
                recycleview.stopRefresh(true);
                if (isHasNextPage==true) recycleview.setLoadMore(true);
                //    adapter.notifyItemInserted(0);
                //      adapter.notifyItemRangeChanged(0,dataBeen.size());
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isHasNextPage==true) {
                    queryLectures();
                    adapter.notifyDataSetChanged();
                    recycleview.stopLoadMore();
                }else {
                    queryLectures();
                    adapter.notifyDataSetChanged();
                    recycleview.setNoDateShow();
                    recycleview.stopLoadMore();
                    recycleview.setLoadMore(false);
                }

//                list.add(list.size(), "leefeng.me" + "==onLoadMore");
                //  adapter.notifyItemRangeInserted(dataBeen.size()-1,1);

            }
        },1000);
    }

    @Override
    public void onRecyclerViewScrollChange(View view, int i, int i1) {

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(EnrollListActivity.this, LectureDetailActivity.class);
        intent.putExtra("lecturesid", dataBeen.get(position).getLecturesid());
        startActivity(intent);
    }

    @Override
    public void onLongClick(int po) {

    }
    void queryLectures(){

        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<EnrollListResult> call = service.lecturesQuerylikebyuserid(pageNo,pageSize,GlobalField.userid);
        //进行网络请求
        call.enqueue(new Callback<EnrollListResult>() {
            @Override
            public void onResponse(Call<EnrollListResult> call, Response<EnrollListResult> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    XLog.i(response.body().getData().size()+"");
                    dataBeen.addAll(response.body().getData());
                    pageNo++;
                    isHasNextPage=response.body().isIsHasNextPage();
                    recycleview.setLoadMore(isHasNextPage);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<EnrollListResult> call, Throwable t) {

            }
        });
    }
}

package com.example.administrator.lecturesmanagerdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.adapter.LectureAdapter;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.LecturesResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.ui.Lecture.LectureDetailActivity;
import com.youth.xframe.base.XActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.leefeng.lfrecyclerview.LFRecyclerView;
import me.leefeng.lfrecyclerview.OnItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/5/1.
 */

public class QueryResultActivity extends XActivity implements OnItemClickListener, LFRecyclerView.LFRecyclerViewListener, LFRecyclerView.LFRecyclerViewScrollChange {
    @InjectView(R.id.recyclerview)
    LFRecyclerView recycleview;
    @InjectView(R.id.et_search)
    EditText et_search;
    private TextView iv_back;
    String serchtext;
    private LectureAdapter adapter;
    int pageNo=1;
    int pageSize=8;
    boolean isHasNextPage=true;
    List<LecturesResult.DataBean> dataBeen = new ArrayList<>();


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(QueryResultActivity.this, LectureDetailActivity.class);
        intent.putExtra("lecturesid", dataBeen.get(position).getLecturesid());
        startActivity(intent);
    }

    @Override
    public void onLongClick(int po) {
        Toast.makeText(getApplication(), "Long:" + po, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataBeen.clear();
                pageNo=1;
                queryLectures(serchtext);
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
                    queryLectures(serchtext);
                    adapter.notifyDataSetChanged();
                    recycleview.stopLoadMore();
                }else {
                    queryLectures(serchtext);
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
    void queryLectures(String lecturesname){

        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<LecturesResult> call = service.queryByPagelikename(pageNo,pageSize,lecturesname);
        //进行网络请求
        call.enqueue(new Callback<LecturesResult>() {
            @Override
            public void onResponse(Call<LecturesResult> call, Response<LecturesResult> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    dataBeen.addAll(response.body().getData());
                    pageNo++;
                    isHasNextPage=response.body().isIsHasNextPage();
                    recycleview.setLoadMore(isHasNextPage);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<LecturesResult> call, Throwable t) {

            }
        });
    }
    @Override
    public int getLayoutId() {
        return R.layout.test;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        ButterKnife.inject(this);
        iv_back=(TextView)findViewById(R.id.back) ;
              /*获取Intent中的Bundle对象*/
        Bundle bundle = this.getIntent().getExtras();
        serchtext=bundle.getString("serchtext");
        et_search.setText(serchtext);
        // 搜索框的键盘搜索键点击回调
        et_search.setOnKeyListener(new View.OnKeyListener() {// 输入完后按键盘上的搜索键

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {// 修改回车键功能
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                   serchtext=et_search.getText().toString();
                    dataBeen.clear();
                    pageNo=1;
                    queryLectures(serchtext);
                    adapter.notifyDataSetChanged();
                    recycleview.stopRefresh(true);
                    if (isHasNextPage==true) recycleview.setLoadMore(true);
                }
                return false;
            }
        });
        queryLectures(serchtext);
        adapter = new LectureAdapter(dataBeen,getApplication());
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
}

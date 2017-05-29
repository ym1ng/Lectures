package com.example.administrator.lecturesmanagerdemo.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.adapter.LectureAdapter;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.LecturesResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.ui.Lecture.LectureDetailActivity;
import com.example.administrator.lecturesmanagerdemo.utils.DividerItemDecoration;
import com.example.administrator.lecturesmanagerdemo.widget.IosSpinner;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.xframe.base.XFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2017/4/11 0011.
 */

public class LectureFragment extends XFragment {

    private LectureAdapter mAdapter;
    int pageNo=1;
    int pageSize=8;
    boolean isHasNextPage=true;
    private ProgressDialog mProgressDialog;
    @InjectView(R.id.recyclerview)
    XRecyclerView rvMovieList;
    @InjectView(R.id.iosspinner)
    IosSpinner mIosSpinner;
    @InjectView(R.id.iosspinner1)
    IosSpinner mIosSpinner1;
    @InjectView(R.id.iosspinner2)
    IosSpinner   mIosSpinner2;
    private int currentSlectedItem,currentSlectedItem1,currentSlectedItem2;
    List<String> items=new ArrayList<>();
    List<String> items1=new ArrayList<>();

    List<String> items2=new ArrayList<>();

    List<LecturesResult.DataBean> dataBeen = new ArrayList<>();
    public static LectureFragment newInstance( ){
        LectureFragment fragmentCommon=new LectureFragment();
        return fragmentCommon;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_lecture;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        items.add("时间");
        items.add("今天");
        items.add("本周");
        items1.add("类型");
        items1.add("人文讲座");
        items1.add("创新讲座");
        items2.add("热门");
        items2.add("人数最多");
    }

    @Override
    public void initView() {
        ButterKnife.inject(this,getView());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMovieList.setLayoutManager(layoutManager);
        rvMovieList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        rvMovieList.setLoadingMoreProgressStyle(ProgressStyle.LineSpinFadeLoader);
        rvMovieList.setArrowImageView(R.drawable.iconfont_downgrey);
        rvMovieList.setLoadingMoreEnabled(true);
        rvMovieList.onScrollStateChanged(3);
        rvMovieList.setLayoutManager(new LinearLayoutManager(getActivity()));//设置为listview的布局
        rvMovieList.setItemAnimator(new DefaultItemAnimator());//设置动画
//        rvMovieList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        rvMovieList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        dataBeen.clear();
                        pageNo=1;
                        queryLectures();
                        mAdapter.notifyDataSetChanged();
                        rvMovieList.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {

                if (isHasNextPage==true) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            queryLectures();
                            rvMovieList.loadMoreComplete();
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            rvMovieList.setNoMore(true);
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
            }
        });


        mAdapter = new LectureAdapter(dataBeen, getContext());
        mAdapter.setOnItemClickListener(new LectureAdapter.OnRecyclerViewItemClickListener(){
            @Override
            public void onItemClick(View view , int postion){
                Intent intent = new Intent(getActivity(), LectureDetailActivity.class);
                intent.putExtra("lecturesid", dataBeen.get(postion).getLecturesid());
                startActivity(intent);
            }
        });
        rvMovieList.setAdapter(mAdapter);
        rvMovieList.refresh();
        mIosSpinner.init(getActivity(),items1);
        mIosSpinner1.init(getActivity(),items);
        mIosSpinner2.init(getActivity(),items2);

        currentSlectedItem=mIosSpinner.getSelectedItemPosition();
        mIosSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //本想是点击自动显示，不需要手动设置 但是会出现错误 没找到很好的解决方案 有办法的小伙伴告知一下
                mIosSpinner.showWindow();
            }
        });
        mIosSpinner.setOnSpinnerItemClickListener(new IosSpinner.OnSpinnerItemClickListener() {
            @Override
            public void OnSpinnerItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSlectedItem=mIosSpinner.getSelectedItemPosition();
                Log.e("当前选中item",""+currentSlectedItem);
                // TODO do someThing
            }
        });
        currentSlectedItem1=mIosSpinner1.getSelectedItemPosition();
        mIosSpinner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //本想是点击自动显示，不需要手动设置 但是会出现错误 没找到很好的解决方案 有办法的小伙伴告知一下
                mIosSpinner1.showWindow();
            }
        });
        mIosSpinner1.setOnSpinnerItemClickListener(new IosSpinner.OnSpinnerItemClickListener() {
            @Override
            public void OnSpinnerItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSlectedItem1=mIosSpinner1.getSelectedItemPosition();
                Log.e("当前选中item",""+currentSlectedItem1);
                // TODO do someThing
            }
        });
        currentSlectedItem2=mIosSpinner2.getSelectedItemPosition();
        mIosSpinner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //本想是点击自动显示，不需要手动设置 但是会出现错误 没找到很好的解决方案 有办法的小伙伴告知一下
                mIosSpinner2.showWindow();
            }
        });
        mIosSpinner2.setOnSpinnerItemClickListener(new IosSpinner.OnSpinnerItemClickListener() {
            @Override
            public void OnSpinnerItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSlectedItem2=mIosSpinner2.getSelectedItemPosition();
                Log.e("当前选中item",""+currentSlectedItem2);
                // TODO do someThing
            }
        });
    }
   void queryLectures(){
       APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
       Call<LecturesResult> call = service.getLectures(pageNo,pageSize);
       //进行网络请求
       call.enqueue(new Callback<LecturesResult>() {
           @Override
           public void onResponse(Call<LecturesResult> call, Response<LecturesResult> response) {
               if (response.body()!=null&&response.body().getCode()==200) {
                   dataBeen.addAll(response.body().getData());
                   pageNo++;
                   isHasNextPage=response.body().isIsHasNextPage();
               }
           }

           @Override
           public void onFailure(Call<LecturesResult> call, Throwable t) {

           }
       });
   }
}

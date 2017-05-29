package com.example.administrator.lecturesmanagerdemo.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.lecturesmanagerdemo.App;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.LecturesResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.ui.Lecture.LectureDetailActivity;
import com.example.administrator.lecturesmanagerdemo.utils.DateFormatUtil;
import com.example.administrator.lecturesmanagerdemo.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.xframe.adapter.XRecyclerViewAdapter;
import com.youth.xframe.adapter.XViewHolder;
import com.youth.xframe.adapter.decoration.DividerDecoration;
import com.youth.xframe.base.XFragment;
import com.youth.xframe.utils.log.XLog;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



/**
 * Created by Administrator on 2017/4/22.
 */

public class MainFragment extends XFragment implements OnBannerListener{
    Banner banner;
    private List<LecturesResult.DataBean> datas;
    int pageNo = 1;
    int pageSize = 8;
    boolean isHasNextPage = true;
    private TestAdapter adapter;
    private RecyclerView recyclerView;
    XRefreshView xRefreshView;

    //    private SwipeRefreshLayout mSwipeLayout;
    private Handler mHandler = new Handler();

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        datas = new ArrayList<>();

    }

    @Override
    public void initView() {
//        mSwipeLayout = (SwipeRefreshLayout)getView().findViewById(R.id.swipe);
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        xRefreshView = (XRefreshView) getView().findViewById(R.id.xrefreshview);
//        mSwipeLayout.setOnRefreshListener(this);
//        mSwipeLayout.setColorSchemeResources(R.color.main_color);
        xRefreshView.setPinnedTime(1000);
        xRefreshView.setMoveForHorizontal(true);
        xRefreshView.setPullLoadEnable(true);
        xRefreshView.setAutoLoadMore(false);
        xRefreshView.setPullLoadEnable(false);
        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        XLog.i("下拉刷新");
                        datas.clear();
                        pageNo=1;
                        queryLectures();
                        adapter.notifyDataSetChanged();
                        adapter.isLoadMore(true);
                        xRefreshView.stopRefresh();
                    }
                }, 1000);
            }
        });
        //添加分割线
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#C4C4C4"), 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        adapter = new TestAdapter(recyclerView, datas);
        //添加header，footer
        final View headerView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, recyclerView, false);
        banner = (Banner) headerView.findViewById(R.id.banner);
        banner.setImages(App.images)
                .setBannerTitles(App.titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
        adapter.addHeaderView(headerView);
        //点击事件
        adapter.setOnItemClickListener(new XRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), LectureDetailActivity.class);
                intent.putExtra("lecturesid", datas.get(position).getLecturesid());
                startActivity(intent);
            }
        });


        adapter.isLoadMore(true);//开启加载更多功能,默认关闭

        adapter.setOnLoadMoreListener(new XRecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onRetry() {//加载失败，重新加载回调方法
                XLog.e("加载失败");
            }

            @Override
            public void onLoadMore() {//加载更多回调方法
                load();
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void load() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                XLog.i("上拉加载更多");
                if (isHasNextPage==true){
                    queryLectures();
                }else
                {

                    adapter.showLoadComplete();//没有更多数据了
                }

//              adapter.showLoadError();//显示加载错误

//                adapter.showLoadComplete();//没有更多数据了

                //           adapter.addAll();//加载更多

//                adapter.addAll(getDatas("新增加"));//加载更多
            }
        }, 1000);
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getContext(),"你点击了："+position,Toast.LENGTH_SHORT).show();

    }

    //单一类型adapter
    class TestAdapter extends XRecyclerViewAdapter<LecturesResult.DataBean> {

        public TestAdapter(RecyclerView recyclerView, List<LecturesResult.DataBean> datas) {
            super(recyclerView, datas, R.layout.item_news_template3);
        }

        @Override
        protected void bindData(XViewHolder holder, LecturesResult.DataBean data, int position) {
            holder.setText(R.id.tv_title, data.getLecturesname());
         //   holder.setText(R.id.tv_lecture_time, DateFormatUtil.LongToDate(data.getLecturestime()));
         //   holder.setText(R.id.tv_lecture_address, data.getColleges().getCollegesname());
            ImageView iv_pic = holder.getView(R.id.iv_thumb);
            Glide.with(getContext())
                    .load(GlobalField.ImageURL+data.getPoster())
                    .diskCacheStrategy
                            (DiskCacheStrategy.ALL)//加快显示速度---缓存在本地磁盘
                    .into(iv_pic);//图片.
        }
    }
    void queryLectures(){

        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<LecturesResult> call = service.getLectures(pageNo,pageSize);
        //进行网络请求
        call.enqueue(new Callback<LecturesResult>() {
            @Override
            public void onResponse(Call<LecturesResult> call, Response<LecturesResult> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    datas.addAll(response.body().getData());
                    pageNo++;
                    isHasNextPage=response.body().isIsHasNextPage();
                }
            }

            @Override
            public void onFailure(Call<LecturesResult> call, Throwable t) {
                XLog.e(t.toString());
                adapter.showLoadError();//显示加载错误
            }
        });
    }
}


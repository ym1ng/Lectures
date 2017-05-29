package com.example.administrator.lecturesmanagerdemo.ui.movie;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.administrator.lecturesmanagerdemo.adapter.MyAdapter;
import com.example.administrator.lecturesmanagerdemo.bean.Movies;
import com.example.administrator.lecturesmanagerdemo.widget.IosSpinner;
import com.example.administrator.lecturesmanagerdemo.widget.ProgressDialogUtil;
import com.example.administrator.lecturesmanagerdemo.R;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.xframe.base.XFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2017/4/11 0011.
 */

public class MovieFragment extends XFragment implements MovieContract.IMovieView {
    private MyAdapter mAdapter;
    private ArrayList<String> listData;
    private int refreshTime = 0;
    private int times = 0;
    MoviePresenter mMoviePresenter;
    private ProgressDialog mProgressDialog;
    @InjectView(R.id.recyclerview)
    XRecyclerView rvMovieList;
    @InjectView(R.id.iosspinner)
    IosSpinner mIosSpinner;
    @InjectView(R.id.iosspinner1)
    IosSpinner   mIosSpinner1;
    @InjectView(R.id.iosspinner2)
    IosSpinner   mIosSpinner2;
    private int currentSlectedItem,currentSlectedItem1,currentSlectedItem2;
    List<Movies.SubjectsBean> mMovies = new ArrayList<>();
    public static MovieFragment newInstance( ){
        MovieFragment fragmentCommon=new MovieFragment();
        return fragmentCommon;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_movie;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mMoviePresenter = new MoviePresenter(this);
    }

    @Override
    public void initView() {
        ButterKnife.inject(this,getView());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMovieList.setLayoutManager(layoutManager);
        rvMovieList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        rvMovieList.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        rvMovieList.setArrowImageView(R.drawable.iconfont_downgrey);


        rvMovieList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime ++;
                times = 0;
                new Handler().postDelayed(new Runnable(){
                    public void run() {

                        mAdapter.notifyDataSetChanged();
                        rvMovieList.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                if(times < 2){
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            mMoviePresenter.loadMoreMovie();
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
                times ++;
            }
        });

        mMovies = mMoviePresenter.getMovie();
        mAdapter = new MyAdapter(mMovies,getCurContext());

        rvMovieList.setAdapter(mAdapter);
        rvMovieList.refresh();
       List<String> items=new ArrayList<>();
        items.add("item1");
        items.add("item2");
        items.add("item3");
        mIosSpinner.init(getActivity(),items);
        mIosSpinner1.init(getActivity(),items);

        mIosSpinner2.init(getActivity(),items);

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


    @Override
    public void showBottom(int lastIndex) {

    }

    @Override
    public Context getCurContext() {
        return getContext();
    }

    @Override
    public void showProgress() {
        mProgressDialog= ProgressDialogUtil.showProgressDialog(getContext()," ","正在读取");
    }

    @Override
    public void hideProgress() {
        ProgressDialogUtil.dismissProgressDialog(mProgressDialog);
    }


    /**
     * 显示数据
     *
     * @param movies
     */
    @Override
    public void  showData(List<Movies.SubjectsBean> movies) {
    }

    @Override
    public void showInfo(String info) {

    }


}

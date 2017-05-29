package com.example.administrator.lecturesmanagerdemo.ui.movie;



import com.example.administrator.lecturesmanagerdemo.base.OnHttpCallBack;
import com.example.administrator.lecturesmanagerdemo.bean.Movies;

import java.util.ArrayList;
import java.util.List;

/**
 * P层
 * Created by HDL on 2016/8/3.
 */
public class MoviePresenter implements MovieContract.IMoviePresenter {
    MovieContract.IMovieModel mIMovieModel;//M层
    MovieContract.IMovieView mIMovieView;//V层
    public  int start = 0;//从第几个开始
    public  int count = 4;//请求多少个
    List<Movies.SubjectsBean> mMovies = new ArrayList<>();//请求到的电影信息对象集合

    public MoviePresenter(MovieContract.IMovieView mIMovieView) {
        this.mIMovieView = mIMovieView;
        mIMovieModel = new MovieModel();
    }

    @Override
    public List<Movies.SubjectsBean> getMovie() {
        //每次刷新加载4个
        mIMovieModel.getMovie(0, 6, new OnHttpCallBack<Movies>() {//有一个请求结果的回调,即我调用请求电影信息的方法了,M层要返回一个成功还是失败的信息给我
            @Override
            public void onSuccessful(Movies movies) {//获取电影信息成功了,返回movies对象
                mMovies.addAll(movies.getSubjects());//追加数据

                mIMovieView.showBottom(start);
            }

            @Override
            public void onFaild(String errorMsg) {
                mIMovieView.hideProgress();//通知V层隐藏对话框
                mIMovieView.showInfo(errorMsg);//通知V层显示错误信息
            }
        });
        start = start + 4;//改变请求的起点
        return mMovies;
    }

    /**
     * 加载更多
     */
    @Override
    public void loadMoreMovie() {
        getMovie();
    }
}



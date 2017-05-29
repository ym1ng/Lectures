package com.example.administrator.lecturesmanagerdemo.ui.Lecture;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.CommentListResult;
import com.example.administrator.lecturesmanagerdemo.bean.LecturesDetail;
import com.example.administrator.lecturesmanagerdemo.bean.baseResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.ui.CommentListActivity;
import com.example.administrator.lecturesmanagerdemo.utils.DateFormatUtil;
import com.example.administrator.lecturesmanagerdemo.utils.ToastUtils;
import com.example.administrator.lecturesmanagerdemo.widget.KeyMapDailog;
import com.example.administrator.lecturesmanagerdemo.R;

import com.youth.xframe.base.XActivity;
import com.youth.xframe.utils.log.XLog;
import com.youth.xframe.widget.XToast;

import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class LectureDetailActivity extends XActivity {
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.search)
    ImageView Ivsearch;
    @InjectView(R.id.comments)
    TextView comment;
    @InjectView(R.id.comment)
    LinearLayout lcomment;
    @InjectView(R.id.tv_collection)
    TextView tvcollection;
    @InjectView(R.id.tv_enroll)
    TextView tvenroll;
    @InjectView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @InjectView(R.id.iv_lectures_img)
    ImageView ivlecturesimg;
    @InjectView(R.id.tv_lecture_title)
    TextView tvlecturetitle;
    @InjectView(R.id.Tour_number)
    TextView Tournumber;
    @InjectView(R.id.collection_number)
    TextView collection_number;
    @InjectView(R.id.enrollcount)
    TextView enrollcount;
    @InjectView(R.id.time)
    TextView time;
    @InjectView(R.id.address)
    TextView address;
    @InjectView(R.id.speechmaker)
    TextView speechmaker;
    @InjectView(R.id.realname)
    TextView realname;
    @InjectView(R.id.comment_content)
    TextView commentcontent;
    @InjectView(R.id.tv_comment_open)
    TextView tvcommentopen;
    @InjectView(R.id.commenttime)
    TextView commenttime;
    @InjectView(R.id.webview)
    WebView webview;
    KeyMapDailog dialog;
    int lecturesid;
    boolean isoverdue;
    boolean iscollection;
    String html;
    LecturesDetail.DataBean lecturesDetail;
    @Override
    public int getLayoutId() {
        return R.layout.lecture_detail;
    }
    @Override
    public void initData(Bundle savedInstanceState) {
        ButterKnife.inject(this);
        Bundle bundle = this.getIntent().getExtras();
        lecturesid=bundle.getInt("lecturesid");
         html = "<html>"
                + "<body>"
                + "图书封面<br>"
                + "<table width='200' border='1' >"
                + "<tr>"
                + "<td><a onclick='alert(\"Java Web开发速学宝典\")' ><img style='margin:10px' src='http://images.china-pub.com/ebook45001-50000/48015/cover.jpg' width='100'/></a></td>"
                + "<td><a onclick='alert(\"大象--Thinking in UML\")' ><img style='margin:10px' src='http://images.china-pub.com/ebook125001-130000/129881/zcover.jpg' width='100'/></td>"
                + "</tr>"
                + "<tr>"
                + "<td><img style='margin:10px' src='http://images.china-pub.com/ebook25001-30000/27518/zcover.jpg' width='100'/></td>"
                + "<td><img  style='margin:10px' src='http://images.china-pub.com/ebook30001-35000/34838/zcover.jpg' width='100'/></td>"
                + "</tr>" + "</table>" + "</body>" + "</html>";

        queryLectures();

    }
    @Override
    public void initView() {

        tvTitle.setText("讲座详情");
        Ivsearch.setVisibility(View.GONE);
        ivTitleBack.setVisibility(View.VISIBLE);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new KeyMapDailog("", new KeyMapDailog.SendBackListener() {
                    @Override
                    public void sendBack(final String inputText) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                spendlecturesComment(GlobalField.userid,lecturesid,inputText);
                                queryLectures();
                            }
                        }, 2000);
                    }
                });
                dialog.show(getSupportFragmentManager(), "dialog");
            }
        });
        tvenroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lecturesDetail.isIsenroll()&&!isoverdue){
                    userenroll();
                }
            }
        });
        tvcollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!iscollection){
                    usercollection();
                }
            }
        });
        tvcommentopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LectureDetailActivity.this, CommentListActivity.class);
                intent.putExtra("lecturesid", lecturesid);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.iv_title_back)
    void finishA(View view) {
        finish();
    }


void spendlecturesComment(long userid, int lecturesid,String commentcontent){
    APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
    Call<baseResult> call = service.spendlecturesComment(userid,lecturesid,commentcontent);
    //进行网络请求
    call.enqueue(new Callback<baseResult>() {
        @Override
        public void onResponse(Call<baseResult> call, Response<baseResult> response) {
            if (response.body()!=null&&response.body().getCode()==200) {
                dialog.hideProgressdialog();
                Toast.makeText(LectureDetailActivity.this, "发表成功", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        }

        @Override
        public void onFailure(Call<baseResult> call, Throwable t) {
            XLog.i(t.toString());

        }
    });
}
    void queryLectures(){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<LecturesDetail> call = service.getlecturesDetail(lecturesid,GlobalField.userid);
        //进行网络请求
        call.enqueue(new Callback<LecturesDetail>() {
            @Override
            public void onResponse(Call<LecturesDetail> call, Response<LecturesDetail> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    XLog.i("成功");
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.getSettings().setBlockNetworkImage(false);
                    lecturesDetail=response.body().getData();
                    tvlecturetitle.setText(lecturesDetail.getLectures().getLecturesname().toString());
                    html=lecturesDetail.getLectures().getLecturescontent();
                    webview.loadDataWithBaseURL(null,"<html>"
                            + "<body>"+ html + "</body>" + "</html>", "text/html", "utf-8", null);
                    XLog.i(lecturesDetail.getLectures().getLecturescontent());
                    Glide.with(getApplication())
                            .load(GlobalField.ImageURL+lecturesDetail.getLectures().getPoster())
                            .placeholder(R.drawable.placeholder)
                            .error(R.drawable.placeholder)
                            .diskCacheStrategy
                                    (DiskCacheStrategy.ALL)//加快显示速度---缓存在本地磁盘
                            .into(ivlecturesimg);//图片
                    time.setText(DateFormatUtil.LongToDate(lecturesDetail.getLectures().getLecturestime()));
                    // Tournumber.setText(response.body().getData().getLectures().getPapeview());
                    address.setText(lecturesDetail.getLectures().getClassroom().getClassroomname());
                    speechmaker.setText(lecturesDetail.getLectures().getSpeechmaker());
                    XLog.i(new Date(lecturesDetail.getLectures().getLecturestime()).after(new Date())+"");
                    if(lecturesDetail.isIsenroll()){
                        tvenroll.setBackgroundResource(R.color.txt_gray_light);
                        tvenroll.setText("已报名");
                    }else if( new Date().after(new Date(lecturesDetail.getLectures().getLecturestime()))){
                        tvenroll.setBackgroundResource(R.color.txt_gray_light);
                        tvenroll.setText("已过期");
                        isoverdue=true;
                    }
                    if(lecturesDetail.getComment().getConmmentdate()!=0){
                        realname.setText(lecturesDetail.getComment().getRealname());
                        commenttime.setText(DateFormatUtil.LongToDate(lecturesDetail.getComment().getConmmentdate()));
                        commentcontent.setText(lecturesDetail.getComment().getConmmenttext());
                        tvcommentopen.setVisibility(View.VISIBLE);
                        lcomment.setVisibility(View.VISIBLE);
                    }else{
                        tvcommentopen.setVisibility(View.GONE);
                        lcomment.setVisibility(View.GONE);
                    }
                    if (lecturesDetail.isIscollection()){
                        Drawable top = getResources().getDrawable(R.drawable.love);
                        tvcollection.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
                        iscollection=lecturesDetail.isIscollection();
                    }
                }
            }

            @Override
            public void onFailure(Call<LecturesDetail> call, Throwable t) {
                XLog.i(t.toString());

            }
        });
    }
    void userenroll(){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<baseResult> call = service.userenroll(lecturesid,GlobalField.userid);
        //进行网络请求
        call.enqueue(new Callback<baseResult>() {
            @Override
            public void onResponse(Call<baseResult> call, Response<baseResult> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    XLog.i("成功");
                    tvenroll.setBackgroundResource(R.color.txt_gray_light);
                    tvenroll.setText("已报名");
                    ToastUtils.showToast(getApplication(),"报名成功");
                }
            }

            @Override
            public void onFailure(Call<baseResult> call, Throwable t) {
                XLog.i(t.toString());

            }
        });
    }
    void usercollection(){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<baseResult> call = service.usercollection(lecturesid,GlobalField.userid);
        //进行网络请求
        call.enqueue(new Callback<baseResult>() {
            @Override
            public void onResponse(Call<baseResult> call, Response<baseResult> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    Drawable top = getResources().getDrawable(R.drawable.love);
                    tvcollection.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
                    iscollection=true;
                    ToastUtils.showToast(getApplication(),"收藏成功");
                }
            }

            @Override
            public void onFailure(Call<baseResult> call, Throwable t) {
                XLog.i(t.toString());

            }
        });
    }
}



package com.example.administrator.lecturesmanagerdemo.fragment;

/**
 * Created by Administrator on 2017/4/16.
 */

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.codbking.calendar.CaledarAdapter;
import com.codbking.calendar.CalendarBean;
import com.codbking.calendar.CalendarDateView;
import com.codbking.calendar.CalendarUtil;
import com.codbking.calendar.CalendarView;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.adapter.LectureListviewAdapter;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.queryuserenrollBydate;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.youth.xframe.base.XFragment;
import com.youth.xframe.utils.log.XLog;
import com.youth.xframe.widget.XToast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.administrator.lecturesmanagerdemo.utils.ImageUtils.px;


public  class CalendarFragment extends XFragment {
    @InjectView(R.id.title)
    TextView mTitle;
    @InjectView(R.id.calendarDateView)
    CalendarDateView mCalendarDateView;
    @InjectView(R.id.list)
    ListView mList;
    List<queryuserenrollBydate.DataBean> datas=new ArrayList<>();
    LectureListviewAdapter lladapter;
    public static CalendarFragment newInstance(){
        CalendarFragment fragmentCommon=new CalendarFragment();
        return fragmentCommon;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_calendar;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
    @Override
    public void initView() {
        ButterKnife.inject(this,getView());
        mCalendarDateView.setAdapter(new CaledarAdapter() {
            @Override
            public View getView(View convertView, ViewGroup parentView, CalendarBean bean) {
                TextView view;
                if (convertView == null) {
                    convertView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.item_calendar, null);
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(px(48), px(48));
                    convertView.setLayoutParams(params);
                }

                view = (TextView) convertView.findViewById(R.id.text);

                view.setText("" + bean.day);
                if (bean.mothFlag != 0) {
                    view.setTextColor(0xff9299a1);
                } else {
                    view.setTextColor(0xffffffff);
                }

                return convertView;
            }
        });

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                XToast.info("test");
            }
        });
        mCalendarDateView.setOnItemClickListener(new CalendarView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion, CalendarBean bean) {
                mTitle.setText(bean.year + "/" + getDisPlayNumber(bean.moth) + "/" + getDisPlayNumber(bean.day));
                queryLecturesByDate( GlobalField.userid  ,bean.year + "/" + getDisPlayNumber(bean.moth) + "/" + getDisPlayNumber(bean.day));
            }
        });

        // 创建日期对象
        Date d = new Date();
        // 给定模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        // public final String format(Date date)
        String s = sdf.format(d);
        queryLecturesByDate( GlobalField.userid ,s);

        lladapter=new LectureListviewAdapter(datas,getContext());
        mList.setAdapter(lladapter);
        int[] data = CalendarUtil.getYMD(new Date());
        mTitle.setText(data[0] + "/" + data[1] + "/" + data[2]);

    }
    private String getDisPlayNumber(int num) {
        return num < 10 ? "0" + num : "" + num;
    }

    void queryLecturesByDate(long userid, final String date){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<queryuserenrollBydate> call = service.queryuserenrollBydate(userid,date);
        //进行网络请求
        call.enqueue(new Callback<queryuserenrollBydate>() {
            @Override
            public void onResponse(Call<queryuserenrollBydate> call, Response<queryuserenrollBydate> response) {
                if (response.body().getData()!=null&&response.body().getCode()==200) {
                    datas.clear();
                    datas.addAll(response.body().getData());
                    lladapter.notifyDataSetChanged();
                }
                }

            @Override
            public void onFailure(Call<queryuserenrollBydate> call, Throwable t) {
                XLog.e("加载失败");
            }
        });
    }
}
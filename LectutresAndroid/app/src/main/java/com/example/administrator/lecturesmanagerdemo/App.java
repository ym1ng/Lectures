package com.example.administrator.lecturesmanagerdemo;

import android.content.Context;
import android.util.DisplayMetrics;

import com.example.administrator.lecturesmanagerdemo.ui.main.MainActivity;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.youth.xframe.XFrame;
import com.youth.xframe.base.XApplication;
import com.zxy.recovery.core.Recovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */

public class App extends XApplication {

    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    public static int H,W;
    public static App app;
        @Override
        public void onCreate() {
            super.onCreate();
            getScreen(this);
            ZXingLibrary.initDisplayOpinion(this);
            XFrame.initXLog();//初始化XLog
            app=this;

            String[] urls = getResources().getStringArray(R.array.url);
            String[] tips = getResources().getStringArray(R.array.title);
            List list = Arrays.asList(urls);
            images = new ArrayList(list);
            List list1 = Arrays.asList(tips);
            titles= new ArrayList(list1);
        }
    public void getScreen(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        H=dm.heightPixels;
        W=dm.widthPixels;
    }
    }


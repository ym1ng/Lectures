package com.example.administrator.lecturesmanagerdemo.base;


import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.lecturesmanagerdemo.utils.ZTLUtils;
import com.youth.xframe.base.XActivity;

/**
 * Created by Administrator on 2016/7/22.
 */
public class BaseActivity extends XActivity {
    public Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        new ZTLUtils(mActivity).setTranslucentStatus();
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

    }
}

package com.example.administrator.lecturesmanagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.lecturesmanagerdemo.R;
import com.youth.xframe.base.XFragment;


/**
 * 作者：yaochangliang on 2016/8/14 08:18
 * 邮箱：yaochangliang159@sina.com
 */
public class FragmentCommon extends XFragment {
    TextView textView;

    public static FragmentCommon newInstance(String text){
        FragmentCommon fragmentCommon=new FragmentCommon();
        Bundle bundle=new Bundle();
        bundle.putString("text",text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_common;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        textView= (TextView) getView().findViewById(R.id.textView);
        textView.setText(getArguments().getString("text"));
    }
}

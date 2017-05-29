package com.example.administrator.lecturesmanagerdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.User;
import com.example.administrator.lecturesmanagerdemo.bean.baseResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.widget.ClearEditText;
import com.youth.xframe.base.XActivity;
import com.youth.xframe.utils.log.XLog;
import com.youth.xframe.widget.XToast;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/5/23.
 */

public class AlertextFormActivity extends XActivity {
    private static final int EDIT_NAME =4;
    private static final int EDIT_EMAIL =5;
    private static final int EDIT_PHONE =6;
    int code;
    String  data;
    @InjectView(R.id.iv_title_back)
    ImageView iv_title_back;
    @InjectView(R.id.search)
    ImageView search;
    @InjectView(R.id.tv_title)
    TextView tv_title;
    @InjectView(R.id.tv_01)
    TextView tv_01;
    @InjectView(R.id.etName)
    ClearEditText etName;
    @Override
    public int getLayoutId() {
        return R.layout.alertext_form;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Intent intent = getIntent();
        code= intent.getIntExtra("code",99);
        data= intent.getStringExtra("data");
        XLog.i(code+"");
    }

    @Override
    public void initView() {
        ButterKnife.inject(this);
        iv_title_back.setVisibility(View.VISIBLE);
        search.setVisibility(View.GONE);
        switch (code){
            case EDIT_NAME:
                tv_title.setText("修改姓名");
                SpannableString name = new SpannableString(data);//这里输入自己想要的提示文字
                etName.setHint(name);
                break;
            case EDIT_PHONE:
                tv_title.setText("修改手机号");
                SpannableString phone = new SpannableString(data);//这里输入自己想要的提示文字
                etName.setHint(phone);
                etName.setInputType(InputType.TYPE_CLASS_PHONE);//电话
                break;
            case EDIT_EMAIL:
                tv_title.setText("修改邮箱");
                SpannableString email = new SpannableString(data);//这里输入自己想要的提示文字
                etName.setHint(email);
                etName.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
        }
       // etName.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        tv_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent=new Intent();
                        intent.putExtra("data",  etName.getText().toString());
                        setResult(-1,intent);
                        finish();
            }
        });
        iv_title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}

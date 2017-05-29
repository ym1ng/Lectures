package com.example.administrator.lecturesmanagerdemo.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.IpInfo;
import com.example.administrator.lecturesmanagerdemo.bean.LecturesClassroomInfo;
import com.example.administrator.lecturesmanagerdemo.bean.UserResult;
import com.example.administrator.lecturesmanagerdemo.bean.VideoResult;
import com.example.administrator.lecturesmanagerdemo.bean.baseResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.ui.CollectionListActivity;
import com.example.administrator.lecturesmanagerdemo.ui.EnrollListActivity;
import com.example.administrator.lecturesmanagerdemo.ui.PersonalActivity;
import com.example.administrator.lecturesmanagerdemo.utils.ImageUtils;
import com.example.administrator.lecturesmanagerdemo.utils.ToastUtils;
import com.example.administrator.lecturesmanagerdemo.widget.CircleTransform;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.widget.RoundImageView;
import com.google.gson.Gson;
import com.leon.lib.settingview.LSettingItem;
import com.squareup.picasso.Picasso;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.xframe.base.XFragment;
import com.youth.xframe.utils.log.XLog;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.Activity.RESULT_OK;

/**
 * 作者：yaochangliang on 2016/8/14 08:18
 * 邮箱：yaochangliang159@sina.com
 */
public class MyFragment extends XFragment  implements AMapLocationListener {
    private static final int REQUEST_CODE =0;
    double lat=0,lon=0;

    //声明AMapLocationClient类对象，定位发起端
    private AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象，定位参数
    public AMapLocationClientOption mLocationOption = null;

    //声明mListener对象，定位监听器
    //标识，用于判断是否只显示一次定位信息和用户重新定位
    private boolean isFirstLoc = true;
    private LSettingItem mSettingItemOne;
    private LSettingItem lectures;
    private LSettingItem mycollection;
    private LSettingItem mSettingItemFour;
    private RoundImageView mIvHead;
    private TextView username;
    UserResult.DataBean user=null;
    public static MyFragment newInstance( ){
        MyFragment fragmentCommon=new MyFragment();
        return fragmentCommon;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //初始化定位
        mLocationClient = new AMapLocationClient(getContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(true);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
    }

    @Override
    public void initView() {
        mSettingItemOne = (LSettingItem) getActivity().findViewById(R.id.item_one);
        username=(TextView)getActivity().findViewById(R.id.username);
        lectures=(LSettingItem)getActivity().findViewById(R.id.lecture_enroll);
        mycollection=(LSettingItem)getActivity().findViewById(R.id.mycollection);
        mSettingItemFour = (LSettingItem)getActivity().findViewById(R.id.item_four);
        mIvHead = (RoundImageView) getActivity().findViewById(R.id.headimage);

        lectures.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent=new Intent(getContext(), EnrollListActivity.class);
                startActivity(intent);
            }
        });

        mycollection.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent=new Intent(getContext(), CollectionListActivity.class);
                startActivity(intent);
            }
        });

        mSettingItemOne.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                mLocationClient.startLocation();
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
        mSettingItemFour.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Toast.makeText(getContext(), "选中开关", Toast.LENGTH_SHORT).show();
            }
        });
        mIvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), PersonalActivity.class);
                startActivity(intent);
            }
        });
        getUser();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                //    Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                    XLog.i(result);
                    Gson gson = new Gson();
                    LecturesClassroomInfo lecturesClassroomInfo = gson.fromJson(result,LecturesClassroomInfo.class);
                    LatLng latLng=new LatLng(lat,lon);
                    XLog.i("讲座编号"+lecturesClassroomInfo.getLecturesid());
                    LatLng latLng2=new LatLng(Double.parseDouble(lecturesClassroomInfo.getLat()),Double.parseDouble(lecturesClassroomInfo.getLng()));
                    float distance = AMapUtils.calculateLineDistance(latLng,latLng2);
                    XLog.i( distance+"米");
                    if(distance<100){
                        usersignin(lecturesClassroomInfo.getLecturesid());
                    }else
                        ToastUtils.showToast(getContext(),"距离太远");

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    void getUser(){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<UserResult> call = service.getuser(GlobalField.userid);
        //进行网络请求
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if (response.body()!=null&&response.body().getCode()==200) {
                    user =  response.body().getData();
                    XLog.i(GlobalField.ImageURL+user.getHeadpicpath());
                    Picasso.with(getContext()).load(GlobalField.ImageURL+user.getHeadpicpath()).error(R.drawable.placeholder).into(mIvHead);
                    username.setText(user.getRealname());
                }
            }
            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                XLog.i(t.toString());
            }
        });
    }
    @Override
    public void onStart(){
        getUser();
        super.onStart();
    }
    void usersignin(int lecturesid){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<baseResult> call = service.usersignin(lecturesid,GlobalField.userid);
        //进行网络请求
        call.enqueue(new Callback<baseResult>() {
            @Override
            public void onResponse(Call<baseResult> call, Response<baseResult> response) {
            ToastUtils.showToast(getContext(),response.body().getMsg()+"");
            }

            @Override
            public void onFailure(Call<baseResult> call, Throwable t) {
                XLog.i(t.toString());

            }
        });
    }
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见官方定位类型表
                lat= aMapLocation.getLatitude();//获取纬度
                lon = aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry();//国家信息
                aMapLocation.getProvince();//省信息
                aMapLocation.getCity();//城市信息
                aMapLocation.getDistrict();//城区信息
                aMapLocation.getStreet();//街道信息
                aMapLocation.getStreetNum();//街道门牌号信息
                aMapLocation.getCityCode();//城市编码
                aMapLocation.getAdCode();//地区编码

                // 如果不设置标志位，此时再拖动地图时，它会不断将地图移动到当前的位置
                if (isFirstLoc) {
                    //设置缩放级别
                    //将地图移动到定位点
                    //点击定位按钮 能够将地图的中心移动到定位点
                    //添加图钉
                    //  aMap.addMarker(getMarkerOptions(amapLocation));
                    //获取定位信息
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(aMapLocation.getCountry() + ""
                            + aMapLocation.getProvince() + ""
                            + aMapLocation.getCity() + ""
                            + aMapLocation.getProvince() + ""
                            + aMapLocation.getDistrict() + ""
                            + aMapLocation.getStreet() + ""
                            + aMapLocation.getStreetNum());
                    XLog.i( buffer.toString()+lat+"*"+lon);

                    //   Toast.makeText(getApplicationContext(), buffer.toString()+la+"*"+lo, Toast.LENGTH_LONG).show();
                    isFirstLoc = false;
                }


            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
                Toast.makeText(getContext(), "定位失败", Toast.LENGTH_LONG).show();
            }
        }
    }
}

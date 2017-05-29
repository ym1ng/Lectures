package com.example.administrator.lecturesmanagerdemo.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.lecturesmanagerdemo.R;
import com.example.administrator.lecturesmanagerdemo.base.APIService;
import com.example.administrator.lecturesmanagerdemo.base.GlobalField;
import com.example.administrator.lecturesmanagerdemo.bean.IpInfo;
import com.example.administrator.lecturesmanagerdemo.bean.User;
import com.example.administrator.lecturesmanagerdemo.bean.UserResult;
import com.example.administrator.lecturesmanagerdemo.bean.baseResult;
import com.example.administrator.lecturesmanagerdemo.http.RetrofitUtils;
import com.example.administrator.lecturesmanagerdemo.utils.ImageUtils;
import com.example.administrator.lecturesmanagerdemo.utils.ToastUtils;

import com.example.administrator.lecturesmanagerdemo.widget.CircleTransform;
import com.example.administrator.lecturesmanagerdemo.widget.RoundImageView;
import com.squareup.picasso.Picasso;
import com.youth.xframe.base.XActivity;
import com.youth.xframe.utils.log.XLog;
import com.youth.xframe.widget.XToast;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.qqtheme.framework.picker.OptionPicker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/5/21.
 */

public class PersonalActivity extends XActivity{
    @InjectView(R.id.tv_area)
    TextView tv_area;
    @InjectView(R.id.layout_name)
    RelativeLayout layout_name;
    @InjectView(R.id.layout_sex)
    RelativeLayout layout_sex;
    @InjectView(R.id.layout_area)
    RelativeLayout layout_area;
    @InjectView(R.id.layout_email)
    RelativeLayout layout_email;
    @InjectView(R.id.layout_phone)
    RelativeLayout layout_phone;
    @InjectView(R.id.tv_email)
    TextView tv_mail;
    @InjectView(R.id.tv_user)
    TextView tv_user;
    @InjectView(R.id.tv_sex)
    TextView tv_sex;
    @InjectView(R.id.tv_phone)
    TextView tv_phone;
//    @InjectView(R.id.tv_area)
//    TextView tv_area;

    @InjectView(R.id.iv_title_back)
    ImageView iv_title_back;
    @InjectView(R.id.search)
    ImageView search;
    @InjectView(R.id.ic_head)
    RoundImageView ic_head;
    private static final int REQUEST_CODE_PICK_CITY =0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static final int CHOOSE_PICTURE =3;
    protected static final int EDITNAME =4;
    private static final int EDIT_EMAIL =5;
    private static final int EDIT_PHONE =6;
    private static final int EDIT_SEX =7;
    protected static Uri tempUri;
    UserResult.DataBean user;
    int code;
    @Override
    public int getLayoutId() {
        return R.layout.activity_personal1;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        ButterKnife.inject(this);
        search.setVisibility(View.GONE);
        iv_title_back.setVisibility(View.VISIBLE);
        layout_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PersonalActivity.this,AlertextFormActivity.class);
                code=EDITNAME;
                intent.putExtra("code",EDITNAME);
                intent.putExtra("data",tv_user.getText().toString());
                startActivityForResult(intent,EDITNAME);

            }
        });
        layout_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PersonalActivity.this,AlertextFormActivity.class);
                code=EDIT_EMAIL;
                intent.putExtra("code",EDIT_EMAIL);
                intent.putExtra("data",tv_mail.getText().toString());

                startActivityForResult(intent,EDIT_EMAIL);
            }
        });
        layout_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PersonalActivity.this,AlertextFormActivity.class);
                code=EDIT_PHONE;
                intent.putExtra("code",EDIT_PHONE);
                intent.putExtra("data",tv_phone.getText().toString());
                startActivityForResult(intent,EDIT_PHONE);
            }
        });
        layout_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          //      startActivityForResult(new Intent(PersonalActivity.this,CityPickerActivity.class),
            //            REQUEST_CODE_PICK_CITY);
            }
        });
        layout_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OptionPicker picker = new OptionPicker(PersonalActivity.this ,new String[]{
                        "男", "女", "保密"
                });
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(11);
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(String option) {
                        code=EDIT_SEX;
                        User user=new User();
                        user.setUserid(GlobalField.userid);
                        if ("男".equals(option)) user.setSex("1");
                       else if ("女".equals(option)) user.setSex("2");
                        else user.setSex("3");
                        updateuser(user);
                        ToastUtils.showToast(getApplication(),option);
                    }
                });
                picker.show();
            }
        });
        ic_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChoosePicDialog();
            }
        });
        iv_title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getUser();
    }

    /**
     * 显示修改头像的对话框
     */
    protected void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items = { "选择本地照片", "拍照" };
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent,CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }
    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
                case REQUEST_CODE_PICK_CITY:
                    if (data != null){
                    /*    String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                        ToastUtils.showToast(getApplication(),city);
                        User user=new User();
                        user.setUserid(GlobalField.userid);
                        user.setAddress(city);
                        updateuser(user);
                        tv_area.setText(city);*/
                        //  resultTV.setText("当前选择：" + city);
                    }
                    break;
                case EDITNAME:
                    if (data != null) {
                        User user = new User();
                        XLog.i("EDITNAME返回到个人信息界面 ");
                        String data1 = data.getStringExtra("data");
                        user.setUserid(GlobalField.userid);
                        user.setRealname(data1);
                        updateuser(user);
                    }
                    break;
                case EDIT_EMAIL:
                    if (data != null) {
                        User user = new User();
                        XLog.i("EDIT_EMAIL返回到个人信息界面");
                        String data1 = data.getStringExtra("data");
                        user.setUserid(GlobalField.userid);
                        user.setEmail(data1);
                        updateuser(user);
                    }
                    break;
                case EDIT_PHONE:
                    if (data != null) {
                        User user = new User();
                        XLog.i("EDIT_PHONE返回到个人信息界面");
                        String data1 = data.getStringExtra("data");
                        user.setUserid(GlobalField.userid);
                        user.setPhone(data1);
                        updateuser(user);
                    }
                    break;

            }
        }
    }
    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     *
     * @param data
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = ImageUtils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
            uploadPic(photo);
        }
    }
    private void uploadPic(final Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了
        String imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath+"");
        if(imagePath != null){

            // 拿着imagePath上传了
            // ...
            String image =ImageUtils.Bitmap2StrByBase64(bitmap);
            XLog.i(image);


            APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
            Call<IpInfo> call = service.getImage(image,String.valueOf(System.currentTimeMillis()),GlobalField.userid);
            //进行网络请求
            call.enqueue(new Callback<IpInfo>() {
                @Override
                public void onResponse(Call<IpInfo> call, Response<IpInfo> response) {
                    if (response.body()!=null) {
                        XLog.i(response.body().getResults()+"");
                        if (response.body().getResults()=="true"){
                            ic_head.setImageBitmap(bitmap);
                        }

                    }
                }

                @Override
                public void onFailure(Call<IpInfo> call, Throwable t) {
                    XLog.e(t.getMessage());
                }
            });

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
                    Picasso.with(PersonalActivity.this).load( GlobalField.ImageURL+user.getHeadpicpath()).error(R.drawable.placeholder) .into(ic_head);
                   // Glide.with(getApplication()).load(GlobalField.ImageURL+user.getHeadpicpath()).into(ic_head);
                    XLog.i(GlobalField.ImageURL+user.getHeadpicpath());
                    tv_phone.setText(user.getPhone());
                    tv_mail.setText(user.getEmail());
                    if ("1".equals(user.getSex()))    tv_sex.setText("男");
                    else if("2".equals(user.getSex())) tv_sex.setText("女");
                    else tv_sex.setText("保密");
                    tv_user.setText(user.getRealname());
                    tv_area.setText(user.getAddress());
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                XLog.i(t.toString());


            }
        });
    }
    void updateuser(final User user){
        APIService service = RetrofitUtils.newInstence(GlobalField.BASEURL).create(APIService.class);
        Call<baseResult> call = service.updateuser(user);
        //进行网络请求
        call.enqueue(new Callback<baseResult>() {
            @Override
            public void onResponse(Call<baseResult> call, Response<baseResult> response) {
                switch(code){
                    case EDITNAME :
                        tv_user.setText(user.getRealname());
                        break;
                    case  EDIT_SEX:   if("1".equals(user.getSex()))tv_sex.setText("男");else if("2".equals(user.getSex()));
                        else tv_sex.setText("保密");
                        break;
                    case EDIT_EMAIL:          tv_mail.setText(user.getEmail());break;
                    case EDIT_PHONE   :       tv_phone.setText(user.getPhone());

                }
            }

            @Override
            public void onFailure(Call<baseResult> call, Throwable t) {
                XLog.i(t.toString());
                XToast.error(t.toString());
            }
        });
    }
}

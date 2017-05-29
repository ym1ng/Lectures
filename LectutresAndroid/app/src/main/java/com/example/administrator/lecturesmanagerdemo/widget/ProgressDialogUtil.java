package com.example.administrator.lecturesmanagerdemo.widget;
/**
 * Created by Administrator on 2017/4/13.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.lecturesmanagerdemo.R;


public class ProgressDialogUtil {

    public static ProgressDialog showProgressDialog(Context context, String title, String message) {
        if (context == null) {
            return null;
        }
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_progress, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        TextView tvMessage = (TextView) view.findViewById(R.id.tv_message);
        tvTitle.setText(title);
        tvMessage.setText(message);

        //tvTitle.setVisibility(View.GONE);      //can hide the title if not necessary

        ProgressDialog progressDialog = ProgressDialog.show(context, title, message, true, false);
        progressDialog.setContentView(view);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            WindowManager.LayoutParams params = progressDialog.getWindow().getAttributes();
            params.width = (int) (200 * (context.getResources().getDisplayMetrics().density) + 0.5f);
            params.height = (int) (150 * (context.getResources().getDisplayMetrics().density) + 0.5f);
            progressDialog.getWindow().setAttributes(params);
        }
        return progressDialog;
    }

    public static void dismissProgressDialog(ProgressDialog progressDialog) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
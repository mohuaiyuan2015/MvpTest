package com.example.mohuaiyuan.civilian;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mohuaiyuan.mvptest.R;

public abstract class BaseActivity extends Activity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void showLoading() {

    }
    @Override
    public void hideLoading() {

    }
    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showErr() {
        showToast(getResources().getString(R.string.api_error_msg));
    }
    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}

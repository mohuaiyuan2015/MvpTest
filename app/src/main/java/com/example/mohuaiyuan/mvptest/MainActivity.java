package com.example.mohuaiyuan.mvptest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohuaiyuan.civilian.BaseActivity;

public class MainActivity extends BaseActivity implements MvpView  {

    private  TextView text;
    private Button successResult;
    private Button failureResult;
    private Button errorResult;

    MvpPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        initData();

        initListener();

        init();


    }

    private void init() {
        //初始化
    }

    private void initListener() {
        successResult.setOnClickListener(onClickListener);
        failureResult.setOnClickListener(onClickListener);
        errorResult.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.successResult:
                    getDataForSuccess();
                    break;

                case R.id.failureResult:
                    getDataForFailure();
                    break;

                case R.id.errorResult:
                    getDataForError();
                    break;

                default:
                    break;

            }

        }
    };

    private void initData() {

        //初始化Presenter
        presenter = new MvpPresenter();
        // 绑定View引用
        presenter.attachView(this);
    }

    private void initUI() {
        text = (TextView)findViewById(R.id.text);
        successResult=findViewById(R.id.successResult);
        failureResult=findViewById(R.id.failureResult);
        errorResult=findViewById(R.id.errorResult);
    }

    // button 点击事件调用方法
    public void getDataForSuccess(){
        presenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(){
        presenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(){
        presenter.getData("error");
    }


    @Override
    public void showLoading() {
        super.showLoading();
        String str=text.getText().toString();
        if(!TextUtils.isEmpty(str)){
            text.setText("");
        }
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {
        text.setText(msg);
    }

    @Override
    public void showErrorMessage() {
        text.setText("网络请求数据出现异常");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 断开View引用
        presenter.detachView();
    }

}

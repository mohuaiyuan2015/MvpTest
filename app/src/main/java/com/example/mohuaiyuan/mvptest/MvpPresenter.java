package com.example.mohuaiyuan.mvptest;

import com.example.mohuaiyuan.civilian.BasePresenter;
import com.example.mohuaiyuan.civilian.Callback;
import com.example.mohuaiyuan.fashion.DataModel;
import com.example.mohuaiyuan.fashion.Token;

public class MvpPresenter extends BasePresenter<MvpView>{

    /**
     * 获取网络数据
     * @param params 参数
     */
    public void getData(String params) {
        //显示正在加载进度条
        getView().showLoading();
        // 调用Model请求数据
        DataModel
                // 设置请求标识token
                .request(Token.API_USER_DATA)
                // 添加请求参数，没有则不添加
                .params(params)
                // 注册监听回调
                .execute(new Callback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        //调用view接口显示数据
                        getView().showData(data);
                    }

                    @Override
                    public void onFailure(String msg) {
                        //调用view接口提示失败信息
                        getView().showFailureMessage(msg);
                    }

                    @Override
                    public void onError() {
                        //调用view接口提示请求异常
                        getView().showErrorMessage();
                    }

                    @Override
                    public void onComplete() {
                        // 隐藏正在加载进度条
                        getView().hideLoading();
                    }
                });

    }
}

package com.example.mohuaiyuan.mvptest;

import com.example.mohuaiyuan.civilian.BasePresenter;

public class MvpPresenter extends BasePresenter<MvpView>{

    /**
     * 获取网络数据
     * @param params 参数
     */
    public void getData(String params){
        //显示正在加载进度条
        getView().showLoading();
        // 调用Model请求数据
        MvpModel.getNetData(params,new MvpCallback<String>(){
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                if(isViewAttached()){
                    getView().showData(data);
                }
            }
            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                if(isViewAttached()){
                    getView().showFailureMessage(msg);
                }
            }
            @Override
            public void onError() {
                //调用view接口提示请求异常
                if(isViewAttached()){
                    getView().showErrorMessage();
                }
            }
            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                if(isViewAttached()){
                    getView().hideLoading();
                }
            }
        } );
    }
}

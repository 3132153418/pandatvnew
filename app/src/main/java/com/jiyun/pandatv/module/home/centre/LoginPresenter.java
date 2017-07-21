package com.jiyun.pandatv.module.home.centre;

import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.home.LoginMoudle;
import com.jiyun.pandatv.moudle.biz.home.LoginMoudleIpl;
import com.jiyun.pandatv.moudle.entity.LoginEntity;

/**
 * Created by Administrator on 2017/7/21.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View loginView;
    private LoginMoudle loginMoudle;
    public LoginPresenter(LoginContract.View loginView){
        this.loginView = loginView;
        loginView.setPresenter(this);
        loginMoudle = new LoginMoudleIpl();
    }

    @Override
    public void start() {

    }

    @Override
    public void loge(String name, String pwd) {
        loginMoudle.getLogin(name, pwd, new MyHttpCallBack<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                loginView.setLogin(loginEntity);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}

package com.jiyun.pandatv.module.home;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.apputils.ACache;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.home.HomeMoudle;
import com.jiyun.pandatv.moudle.biz.home.HomeMoudleIpl;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.UpdateBean;
import com.jiyun.pandatv.moudle.entity.Video_home_TuiJianBean;
public class Homepresenter implements HomeContract.Presenter {
    //持有View层对象
    private HomeContract.View homeView;
    //持有Moudle层对象
    private HomeMoudle homeMoudle;
    private ACache aCache = ACache.get(App.context);

    //持有Moudle层对象
    public Homepresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        homeView.setPresenter(this);
        homeMoudle = new HomeMoudleIpl();
    }


    //p层的网络请求
    @Override
    public void start() {
        FirstBean firstbean = (FirstBean) aCache.getAsObject("FirstBean");
        if (firstbean == null) {
            homeMoudle.getLunBo(new MyHttpCallBack<FirstBean>() {
                @Override
                public void onSuccess(final FirstBean firstBean) {
                    //成功的回调
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            homeView.setResult(firstBean);

                        }
                    });
                }

                @Override
                public void onError(int errorCode, String errorMsg) {
                    //失败的回调
                    L.d("LiveChinapresenter", errorMsg);
                    homeView.showMessage(errorMsg);
                }
            });
        } else
            homeView.setResult(firstbean);
    }

    @Override
    public void homevideo(String pid, MyHttpCallBack<Video_home_TuiJianBean> myHttpCallBack) {
        String head = "http://202.108.8.115/api/getVideoInfoForCBox.do?pid=";
        String s = head + pid;
        homeMoudle.video_home_tuijian(s, myHttpCallBack);
    }

    @Override
    public void version() {
            homeMoudle.version(new MyHttpCallBack<UpdateBean>() {
                @Override
                public void onSuccess(final UpdateBean updateBean) {
                    //成功的回调
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            homeView.getVersion(updateBean);
                            L.d("版本更新bean打印",updateBean.getData().getVersionsinfo().toString());

                        }
                    });
                }

                @Override
                public void onError(int errorCode, String errorMsg) {
                    L.d("版本更新网络请求错误",errorMsg.toString());
                }
            });
        }

}

package com.jiyun.pandatv.module.livechina.bdl;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

/**
 * Created by Administrator on 2017/7/12.
 */

public interface BDLChinaLiveContract {
    interface View extends BaseView<Presenter> {
        void onShowDialog();
        void onRefresh();
        void onLoadMore();
        void showError(String msg);
        void setResult(LiveChina_BaDaBean tablistBean);

    }
    interface Presenter extends BasePresenter {

        void setUrl(String url);
    }
}

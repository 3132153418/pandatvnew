package com.jiyun.pandatv.apputils;

import android.app.Dialog;
import android.content.Context;

import com.jiyun.pandatv.R;


/**
 * Created by Administrator on 2017/7/20.
 */

public class ShowPopuUtils {
    private static ShowPopuUtils showPopuUtils;

    private ShowPopuUtils() {
    }

    private Dialog loadDialog;

    public static ShowPopuUtils getInsent() {
        if (showPopuUtils == null) {
            synchronized (ShowPopuUtils.class) {
                if (showPopuUtils == null) {
                    showPopuUtils = new ShowPopuUtils();
                }
            }
        }
        return showPopuUtils;
    }

    public ShowPopuUtils create(Context context) {

        loadDialog = new Dialog(context, R.style.dialog);
        loadDialog.setCanceledOnTouchOutside(false);
        loadDialog.setContentView(R.layout.progressdialog_item);
        loadDialog.show();

        return this;
    }

    public ShowPopuUtils popuUtilsDismiss() {

        loadDialog.dismiss();
        return this;
    }
}

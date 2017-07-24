package com.jiyun.pandatv.module.home.centre;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/24.
 */

public class GeRenXinXiActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout name_TiaoZhuan;
    private ImageView geRenXinXi_Back_Image,shangchuan_Image;
    private TextView gerenXinXi_name;
    private Button tuichu_Login,mButPz,mButPhoto,mButCancel;
    private PopupWindow popupWindow;
    private Bitmap head;// 头像Bitmap
    private static String path = "/sdcard/myHead/";// sd路径
    private LinearLayout touXiang_TiaoZhuan;

    @Override
    protected int getLayoutId() {
        return R.layout.login_tiaozhuan_geren;
    }

    @Override
    protected void initView() {

        shangchuan_Image = (ImageView) findViewById(R.id.shangchuan_Image);
        name_TiaoZhuan = (LinearLayout) findViewById(R.id.name_TiaoZhuan);
        name_TiaoZhuan.setOnClickListener(this);
        geRenXinXi_Back_Image = (ImageView) findViewById(R.id.geRenXinXi_Back_Image);
        geRenXinXi_Back_Image.setOnClickListener(this);
        gerenXinXi_name = (TextView) findViewById(R.id.gerenXinXi_name);
        tuichu_Login = (Button) findViewById(R.id.tuichu_Login);
        tuichu_Login.setOnClickListener(this);

        touXiang_TiaoZhuan = (LinearLayout) findViewById(R.id.touXiang_TiaoZhuan);
        touXiang_TiaoZhuan.setOnClickListener(this);
        Intent intent = getIntent();
        String uesrname = intent.getStringExtra("name");
        gerenXinXi_name.setText(uesrname);

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.touXiang_TiaoZhuan:
                init();
                popwindow();
                break;
            case R.id.name_TiaoZhuan:
                Intent intent = new Intent(GeRenXinXiActivity.this,XiuGaiNameActivity.class);
                intent.putExtra("user",gerenXinXi_name.getText().toString());
                startActivity(intent);
                break;
            case R.id.geRenXinXi_Back_Image:
                finish();
                break;
            case R.id.tuichu_Login:
                Intent intent1 = getIntent();
                intent1.putExtra("user","点击登录");
                setResult(20,intent1);
                finish();
                break;

        }
    }

    /**
     * 判断是否有存储卡，有返回TRUE，否则FALSE
     * @return
     */
    public static boolean isSDcardExist() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
        startActivityForResult(intent2, 2);// 采用ForResult打开
        popupWindow.dismiss();
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }

    private void init() {

        Bitmap bt = BitmapFactory.decodeFile(path + "head.jpg");// 从SD卡中找头像，转换成Bitmap
        if (bt != null) {
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bt);// 转换成drawable
            shangchuan_Image.setImageDrawable(drawable);
        } else {
            /**
             * 如果SD里面没有则需要从服务器取头像，取回来的头像再保存在SD中
             *
             */
        }
    }
    public void popwindow() {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(this).inflate(
                R.layout.add_popup_dialog, null);
        popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);// 取得焦点
        ColorDrawable colorDrawable = new ColorDrawable(0x30000000);
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(colorDrawable);
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        mButPhoto = (Button) view.findViewById(R.id.add_photo);
        mButPz = (Button) view.findViewById(R.id.add_pz);
        mButCancel = (Button) view.findViewById(R.id.add_cancel);

        mButPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 从本地相册选取图片作为头像
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 1);
                popupWindow.dismiss();
            }
        });
        mButPz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choseHeadImageFromCameraCapture();
            }
        });
        mButCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());// 裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }

                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {
                        /**
                         * 上传服务器代码
                         */
                        setPicToView(head);// 保存在SD卡中
                        shangchuan_Image.setImageBitmap(head);// 用ImageView显示出来
                    }
                }
                break;
            default:
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 调用系统的裁剪功能
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

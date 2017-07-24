package com.jiyun.pandatv;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.pandatv.jcvideoplayer_lib.JCMediaManager;
import com.jiyun.pandatv.jcvideoplayer_lib.JCVideoPlayer;
import com.jiyun.pandatv.jcvideoplayer_lib.NetUtil;
import com.jiyun.pandatv.jcvideoplayer_lib.PandaVedioPlayer;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class JCFullScreenActivity extends Activity implements PandaVedioPlayer.Switchlistener {
  /**
   * 刚启动全屏时的播放状态
   */

  static int CURRENT_STATE = -1;      //当前的状态
  public static String GAOQINGURL;     //高清
  public static String LIUCHANGURL;     //流畅
  public static Map<String, String> mapHeadData = null;//视屏播放参数的集合
  static boolean DIRECT_FULLSCREEN = true;//是否直接充满全屏
  static Class VIDEO_PLAYER_CLASS;//采用哪个视频播放类
  static Object[] OBJECTS;
  PandaVedioPlayer pandaVedioPlayer;
  private AudioManager audioManager;
  private MyVolumeReceiver mVolumeReceiver;

  //从正常状态下进入视频播放
  public static void toActivityFromNormal(Context context, int state, String GAOQINGURL, Class videoPlayClass, Object... obj) {
    CURRENT_STATE = state;
    DIRECT_FULLSCREEN = false;
    GAOQINGURL = GAOQINGURL;
    VIDEO_PLAYER_CLASS = videoPlayClass;
    OBJECTS = obj;
    Intent intent = new Intent(context, JCFullScreenActivity.class);
    context.startActivity(intent);
  }

  //直接开启全屏Activity播放视频
  public static void toActivity(Context context, String gaoqingurl,String liuchangurl, Map<String, String> headData, Class videoPlayClass, Object... obj) {
    if (headData!=null) {
      mapHeadData = new HashMap<>();
      mapHeadData.clear();
      mapHeadData.putAll(mapHeadData);
    }
    CURRENT_STATE = JCVideoPlayer.CURRENT_STATE_NORMAL;
    GAOQINGURL = gaoqingurl;
    LIUCHANGURL = liuchangurl;
    VIDEO_PLAYER_CLASS = videoPlayClass;
    OBJECTS = obj;
    Intent intent = new Intent(context,JCFullScreenActivity.class);
    context.startActivity(intent);
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    UMShareAPI.get(JCFullScreenActivity.this);
    //注册广播接受者获取系统音量
    audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
    setAndRegisterVolumeReceiver();
    getReflex();
    //得到反射对象之后设置一些成员变量
    pandaVedioPlayer.IF_CURRENT_IS_FULLSCREEN = true;//当前是否充满全屏
    pandaVedioPlayer.IF_FULLSCREEN_IS_DIRECTLY = DIRECT_FULLSCREEN;//是否直接充满全屏
    pandaVedioPlayer.setUrlAndObject(GAOQINGURL,mapHeadData==null?null:mapHeadData,OBJECTS);
    pandaVedioPlayer.setStateAndUi(CURRENT_STATE);
    pandaVedioPlayer.setSwitchListener(this);

    if (!NetUtil.isWifiConnected(this)) {
      //如果是移动流量链接
      new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
          showTipPop();
        }
      }, 1000);
    }else{
      //如果不是流量链接自动播放
      automaticPlay();
    }
  }

  private void automaticPlay() {
    if (pandaVedioPlayer.IF_FULLSCREEN_IS_DIRECTLY) {
      //如果直接充满全屏，就点击播放按钮自动播放
      pandaVedioPlayer.ivStart.performClick();
    } else {
      //如果不是直接充满全屏，设置mediaplayer自定义接口回调
      JCVideoPlayer.IF_RELEASE_WHEN_ON_PAUSE = true;
      JCMediaManager.intance().listener = pandaVedioPlayer;
    }
  }

  private void getReflex() {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    View decor = this.getWindow().getDecorView();
    decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    try {
      Constructor<PandaVedioPlayer> constructor = VIDEO_PLAYER_CLASS.getConstructor(Context.class);
      pandaVedioPlayer = constructor.newInstance(this);
      pandaVedioPlayer = new PandaVedioPlayer(this);
      setContentView(pandaVedioPlayer);
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void showTipPop() {
    View dialogView = View.inflate(JCFullScreenActivity.this, com.jiyun.pandatv.jcvideoplayer_lib.R.layout.popwindow_iswifi,null);
    // 提示信息
    final TextView tipTv = (TextView) dialogView.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.tv_tip);
    // 创建弹出对话框，设置弹出对话框的背景为圆角
    final PopupWindow tipPw = new PopupWindow(dialogView, FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT, true);
    // 响应返回键
    tipPw.setFocusable(true);
    // Cancel按钮及其处理事件
    final TextView btnCancel = (TextView) dialogView
            .findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.btn_cancel);
    btnCancel.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        if (tipPw != null && tipPw.isShowing()) {
          tipPw.dismiss();// 关闭
        }
      }
    });
    final TextView btnOk = (TextView) dialogView.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.btn_ok);
    btnOk.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        if (tipPw != null && tipPw.isShowing()) {
          tipPw.dismiss();// 关闭
        }
        //dosomething
        automaticPlay();
      }
    });
    // 显示RoundCorner对话框
    tipPw.showAtLocation(dialogView, Gravity.CENTER, 0, 0);
  }
  private void setAndRegisterVolumeReceiver() {
    mVolumeReceiver = new MyVolumeReceiver();
    IntentFilter filter = new IntentFilter();
    filter.addAction("android.media.VOLUME_CHANGED_ACTION");
    registerReceiver(mVolumeReceiver, filter);
  }

  @Override
  public void onBackPressed() {
    pandaVedioPlayer.backFullscreen();
  }


  @Override
  protected void onPause() {
    super.onPause();
    JCVideoPlayer.releaseAllVideos();
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d("JC", "销毁了Activity");
    unregisterReceiver(mVolumeReceiver);
  }

  @Override
  public void ChangetoLiuchang(int currentPosition) {

//    String s = Environment.getExternalStorageDirectory() + "/Download/b.mp4";
//    JCMediaManager.mediaPlayer = null;
    JCMediaManager.intance().listener =  null;
    Log.d("JcFullScreenActivity", currentPosition + "");
    //得到反射对象之后设置一些成员变量
    pandaVedioPlayer.IF_CURRENT_IS_FULLSCREEN = true;//当前是否充满全屏
    pandaVedioPlayer.IF_FULLSCREEN_IS_DIRECTLY = DIRECT_FULLSCREEN;//是否直接充满全屏
    pandaVedioPlayer.setUrlAndObject(LIUCHANGURL,mapHeadData==null?null:mapHeadData,OBJECTS);
    pandaVedioPlayer.setStateAndUi(CURRENT_STATE);
    pandaVedioPlayer.setSwitchListener(this);
    if (pandaVedioPlayer.IF_FULLSCREEN_IS_DIRECTLY) {
      //如果直接充满全屏，就点击播放按钮自动播放
      pandaVedioPlayer.ivStart.performClick();
    } else {
      //如果不是直接充满全屏，设置mediaplayer自定义接口回调
      JCVideoPlayer.IF_RELEASE_WHEN_ON_PAUSE = true;
      JCMediaManager.intance().listener = pandaVedioPlayer;
    }

  }

  @Override
  public void ChangetoGaoQing(int currentPosition) {

    String s = Environment.getExternalStorageDirectory() + "/Download/a.mp4";
//    JCMediaManager.mediaPlayer = null;
    JCMediaManager.intance().listener =  null;
    //得到反射对象之后设置一些成员变量
    pandaVedioPlayer.IF_CURRENT_IS_FULLSCREEN = true;//当前是否充满全屏
    pandaVedioPlayer.IF_FULLSCREEN_IS_DIRECTLY = DIRECT_FULLSCREEN;//是否直接充满全屏
    pandaVedioPlayer.setUrlAndObject(GAOQINGURL,mapHeadData==null?null:mapHeadData,OBJECTS);
    pandaVedioPlayer.setStateAndUi(CURRENT_STATE);
    pandaVedioPlayer.setSwitchListener(this);
    if (pandaVedioPlayer.IF_FULLSCREEN_IS_DIRECTLY) {
      //如果直接充满全屏，就点击播放按钮自动播放
      pandaVedioPlayer.ivStart.performClick();
    } else {
      //如果不是直接充满全屏，设置mediaplayer自定义接口回调
      JCVideoPlayer.IF_RELEASE_WHEN_ON_PAUSE = true;
      JCMediaManager.intance().listener = pandaVedioPlayer;
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d("TAG","走了欧娜resume");

  }

  @Override
  public void onShare() {
    pandaVedioPlayer.ivStart.performClick();
    UMWeb web = new UMWeb("www.baidu.com");
    web.setTitle("This is music title");//标题
    web.setThumb(new UMImage(JCFullScreenActivity.this, R.drawable.logo_ipnda));  //缩略图
    web.setDescription("my description");//描述
    new ShareAction(JCFullScreenActivity.this)
            .setPlatform(SHARE_MEDIA.QQ)//传入平台
            .withText("hello")//分享内容
            .withMedia(web)
            .setCallback(new UMShareListener() {
              @Override
              public void onStart(SHARE_MEDIA share_media) {
                Toast.makeText(JCFullScreenActivity.this, "开始分享", Toast.LENGTH_SHORT).show();
              }

              @Override
              public void onResult(SHARE_MEDIA share_media) {
                Toast.makeText(JCFullScreenActivity.this, "分享返回值", Toast.LENGTH_SHORT).show();
              }

              @Override
              public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                Toast.makeText(JCFullScreenActivity.this, "分享异常", Toast.LENGTH_SHORT).show();
//                pandaVedioPlayer.setStateAndUi(JCVideoPlayer.CURRENT_STATE_PLAYING);
//                pandaVedioPlayer.ivStart.performClick();

              }

              @Override
              public void onCancel(SHARE_MEDIA share_media) {
                Toast.makeText(JCFullScreenActivity.this, "取消分享", Toast.LENGTH_SHORT).show();
                pandaVedioPlayer.ivStart.performClick();
              }
            })//回调监听器
            .share();

  }

  private class MyVolumeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      //广播接受者内监听系统音量变化更新音量进度条
      if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
        int currVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        pandaVedioPlayer.seekbar_volume.setProgress(currVolume);
      }
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);//完成回调
  }
}

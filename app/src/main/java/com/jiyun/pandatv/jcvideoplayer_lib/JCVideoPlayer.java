package com.jiyun.pandatv.jcvideoplayer_lib;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.pandatv.JCFullScreenActivity;
import com.jiyun.pandatv.apputils.L;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Manage MediaPlayer
 * Created by Nathen
 * On 2016/04/10 15:45
 */
public abstract class JCVideoPlayer extends FrameLayout implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener, SurfaceHolder.Callback, JCMediaManager.JCMediaPlayerListener {

  public static final String TAG = "JCVideoPlayer";
  public int CURRENT_STATE = -1;//-1相当于null
  public static final int CURRENT_STATE_PREPAREING = 0;
  public static final int CURRENT_STATE_PAUSE = 1;
  public static final int CURRENT_STATE_PLAYING = 2;
  public static final int CURRENT_STATE_OVER = 3;
  public static final int CURRENT_STATE_NORMAL = 4;
  public static final int CURRENT_STATE_ERROR = 5;
  protected boolean touchingProgressBar = false;//拖动进度条
  public boolean IF_CURRENT_IS_FULLSCREEN = false;//是否充满全屏
  public boolean IF_FULLSCREEN_IS_DIRECTLY = false;//是否直接充满全屏
  protected static boolean IF_FULLSCREEN_FROM_NORMAL = false;//从正常状态充满全屏
  public static boolean IF_RELEASE_WHEN_ON_PAUSE = true;//从暂停状态释放
  protected boolean BACK_FROM_FULLSCREEN = false;//从全屏状态返回
  protected static long CLICK_QUIT_FULLSCREEN_TIME = 0;//退出充满全屏的时间
  public static final int FULL_SCREEN_NORMAL_DELAY = 1000;//正常充满全屏的延迟

  public ImageView ivStart;//开始按钮
  public SeekBar skProgress;//播放进度条
  public ImageView ivFullScreen;//点击全屏按钮ImageView
  public TextView tvTimeCurrent, tvTimeTotal;//当前播放时间TextView
  public JCResizeSurfaceView surfaceView;//surfaceview
  public ViewGroup rlSurfaceContainer;//surfaceview容器
  public ViewGroup llTopContainer, llBottomContainer;//顶部和底部视图组

  public SurfaceHolder surfaceHolder;//surfaceholder

  public String url;//播放网址
  public Object[] objects;//数据（比如标题）
  public Map<String, String> mapHeadData = new HashMap<>();//请求参数

  public static Timer mUpdateProgressTimer;//更新进度条计时器
  protected static JCBuriedPoint JC_BURIED_POINT;//节操隐藏指示器
  protected int screenWidth;//屏幕宽度
  protected int screenHeight;//屏幕高度
  protected AudioManager mAudioManager;//音频管理器

  protected int threshold = 40;
  protected float downX;//按下的x轴坐标点
  protected float downY;//按下的y轴坐标点
  protected boolean changeVolume = false;//是否改变音量
  protected boolean changePosition = false;//是否改变进度
  protected int downPosition;//按下的进度
  protected int downVolume;//按下的音量

  public Dialog dlgProgress;//进度对话框
  public ProgressBar dlgProgressProgressBar;//进度对话框中的进度条
  public TextView dlgProgressCurrent;//进度对话框中的当前进度
  public TextView dlgProgressTotal;//进度对话框中的剩余进度
  public ImageView dlgProgressIcon;//进度对话框中的icon
  protected int resultTimePosition;//change postion when finger up

  public Dialog dlgVolume;//音量对话框
  public ProgressBar dlgVolumeProgressBar;//音量对话框中的进度条

  public JCVideoPlayer(Context context) {
    super(context);
    init(context);
  }

  public JCVideoPlayer(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  //初始化基本的控件
  protected void init(Context context) {
    View inflate = View.inflate(context, getLayoutId(), this);
//    showTipPop(inflate);
    ivStart = (ImageView) findViewById(R.id.start);
    ivFullScreen = (ImageView) findViewById(R.id.fullscreen);
    skProgress = (SeekBar) findViewById(R.id.progress);
    tvTimeCurrent = (TextView) findViewById(R.id.current);
    tvTimeTotal = (TextView) findViewById(R.id.total);
    llBottomContainer = (ViewGroup) findViewById(R.id.layout_bottom);
    llTopContainer = (ViewGroup) findViewById(R.id.layout_top);
    rlSurfaceContainer = (RelativeLayout) findViewById(R.id.surface_container);
    surfaceView = (JCResizeSurfaceView) this.findViewById(R.id.surfaceView);
    surfaceHolder = surfaceView.getHolder();
    surfaceHolder.addCallback(this);

    ivStart.setOnClickListener(this);
    ivFullScreen.setOnClickListener(this);
    skProgress.setOnSeekBarChangeListener(this);
    llBottomContainer.setOnClickListener(this);
    rlSurfaceContainer.setOnClickListener(this);
    skProgress.setOnTouchListener(this);

    rlSurfaceContainer.setOnTouchListener(this);
    screenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
    screenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
    mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
  }

  //子类需要重写的方法
  public abstract int getLayoutId();

  //设置节操隐藏指示器
  protected static void setJcBuriedPoint(JCBuriedPoint jcBuriedPoint) {
    JC_BURIED_POINT = jcBuriedPoint;
  }

  //设置视频地址和对象
  public void setUrlAndObject(String url, Map<String, String> mapHeadData, Object... objects) {
    //如果设置了监听器则return
    if (JCMediaManager.intance().listener == this && (System.currentTimeMillis() - CLICK_QUIT_FULLSCREEN_TIME) < FULL_SCREEN_NORMAL_DELAY)
      return;
    //如果没有设置监听器,则初始化播放器的一些状态
    CURRENT_STATE = CURRENT_STATE_NORMAL;
    this.url = url;
    this.objects = objects;
    setStateAndUi(CURRENT_STATE_NORMAL);

  }

  //set ui
  protected void setStateAndUi(int state) {
    CURRENT_STATE = state;
    switch (CURRENT_STATE) {
      case CURRENT_STATE_NORMAL://正常状态时
        if (JCMediaManager.intance().listener == this) {
          //如果设置了监听器则清空播放器
          JCMediaManager.intance().mediaPlayer.release();
        }
        break;
      case CURRENT_STATE_PREPAREING:
        break;
      case CURRENT_STATE_PLAYING:
        startProgressTimer();
        break;
      case CURRENT_STATE_PAUSE:
        startProgressTimer();
        break;
      case CURRENT_STATE_ERROR:
        JCMediaManager.intance().mediaPlayer.release();
        break;
    }
  }

  @Override
  public void onClick(View v) {
    int i = v.getId();
    if (i == R.id.start) {
      if (TextUtils.isEmpty(url)) {
        Toast.makeText(getContext(), "No url", Toast.LENGTH_SHORT).show();
        return;
      }
      //如果当前状态为正常状态或异常状态,就监听回调后准备视频
      if (CURRENT_STATE == CURRENT_STATE_NORMAL || CURRENT_STATE == CURRENT_STATE_ERROR) {
        if (JC_BURIED_POINT != null && CURRENT_STATE == CURRENT_STATE_NORMAL) {
          JC_BURIED_POINT.onClickStartIcon(url, objects);
        } else if (JC_BURIED_POINT != null) {
          JC_BURIED_POINT.onClickStartError(url, objects);
        }
        prepareVideo();
      }
      //如果当前状态为播放状态就让mediaplayer暂停
      else if (CURRENT_STATE == CURRENT_STATE_PLAYING) {
        JCMediaManager.intance().mediaPlayer.pause();
        setStateAndUi(CURRENT_STATE_PAUSE);
        if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
          if (IF_CURRENT_IS_FULLSCREEN) {
            JC_BURIED_POINT.onClickStopFullscreen(url, objects);
          } else {
            JC_BURIED_POINT.onClickStop(url, objects);
          }
        }
      }

      else if (CURRENT_STATE == CURRENT_STATE_PAUSE) {
        if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
          if (IF_CURRENT_IS_FULLSCREEN) {
            JC_BURIED_POINT.onClickResumeFullscreen(url, objects);
          } else {
            JC_BURIED_POINT.onClickResume(url, objects);
          }
        }
        JCMediaManager.intance().mediaPlayer.start();
        if (PandaVedioPlayer.currentPosition!=0) {
          JCMediaManager.intance().mediaPlayer.seekTo(PandaVedioPlayer.currentPosition);
        }
        setStateAndUi(CURRENT_STATE_PLAYING);
      }
    } else if (i == R.id.fullscreen) {
      if (IF_CURRENT_IS_FULLSCREEN) {
        //quit fullscreen
        backFullscreen();
      } else {
        if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
          JC_BURIED_POINT.onEnterFullscreen(url, objects);
        }
        //to fullscreen
        JCMediaManager.intance().mediaPlayer.setDisplay(null);
        JCMediaManager.intance().lastListener = this;
        JCMediaManager.intance().listener = null;
        IF_FULLSCREEN_FROM_NORMAL = true;
        IF_RELEASE_WHEN_ON_PAUSE = false;
        JCFullScreenActivity.toActivityFromNormal(getContext(), CURRENT_STATE, url, JCVideoPlayer.this.getClass(), this.objects);
      }
    } else if (i == R.id.surface_container && CURRENT_STATE == CURRENT_STATE_ERROR) {
      if (JC_BURIED_POINT != null) {
        JC_BURIED_POINT.onClickStartError(url, objects);
      }
      prepareVideo();
    }
  }

  protected void prepareVideo() {
    //准备状态时判断mediaplayer监听器是否为空，如果不为空则回调完成播放
    if (JCMediaManager.intance().listener != null) {
      JCMediaManager.intance().listener.onCompletion();
    }
    //如果监听器为空则设置监听器
    JCMediaManager.intance().listener = this;
    addSurfaceView();
    JCMediaManager.intance().prepareToPlay(getContext(),url,mapHeadData);
    if (!IF_CURRENT_IS_FULLSCREEN) {
      setDisplayCaseFailse();
    }
    setStateAndUi(CURRENT_STATE_PREPAREING);
  }

  private void addSurfaceView() {
    if (rlSurfaceContainer.getChildCount() > 0) {
      rlSurfaceContainer.removeAllViews();
    }
    surfaceView = new JCResizeSurfaceView(getContext());
    surfaceHolder = surfaceView.getHolder();
    surfaceHolder.addCallback(this);
//    surfaceView.setOnClickListener(this);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
    rlSurfaceContainer.addView(surfaceView, layoutParams);
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    float x = event.getX();
    float y = event.getY();
    int id = v.getId();
    if (id == R.id.surface_container) {
      switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
          touchingProgressBar = true;
          downX = x;
          downY = y;
          changeVolume = false;
          changePosition = false;
          /////////////////////
          cancelProgressTimer();
          break;
        case MotionEvent.ACTION_MOVE:
          float deltaX = x - downX;
          float deltaY = y - downY;
          float absDeltaX = Math.abs(deltaX);
          float absDeltaY = Math.abs(deltaY);
          //如果是全屏状态下，判断是改变进度还是改变音量
          if (IF_CURRENT_IS_FULLSCREEN) {
            if (!changePosition && !changeVolume) {
              if (absDeltaX > threshold || absDeltaY > threshold) {
                if (absDeltaX >= threshold) {
                  if (CURRENT_STATE == CURRENT_STATE_PLAYING || CURRENT_STATE == CURRENT_STATE_PAUSE) {
                    changePosition = true;
                    //获取当时的进度
                    downPosition = JCMediaManager.intance().mediaPlayer.getCurrentPosition();
                    if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
                      JC_BURIED_POINT.onTouchScreenSeekPosition(url, objects);
                    }
                  }
                } else {
                  changeVolume = true;
                  //获取当时的系统音量
                  downVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                  if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
                    JC_BURIED_POINT.onTouchScreenSeekVolume(url, objects);
                  }
                }
              }
            }
          }
          //如果是改变进度
          if (changePosition) {
            showProgressDialog(deltaX);
          }
          //如果是改变音量
          if (changeVolume) {
//            showVolumDialog(-deltaY);
          }
          break;
        case MotionEvent.ACTION_UP:
          touchingProgressBar = false;
          if (dlgProgress != null) {
            dlgProgress.dismiss();
          }
          if (dlgVolume != null) {
            dlgVolume.dismiss();
          }
          if (changePosition) {
            JCMediaManager.intance().mediaPlayer.seekTo(resultTimePosition);
            int duration = JCMediaManager.intance().mediaPlayer.getDuration();
            int progress = resultTimePosition * 100 / (duration == 0 ? 1 : duration);
            skProgress.setProgress(progress);
          }
          /////////////////////
          startProgressTimer();
          if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
            if (IF_CURRENT_IS_FULLSCREEN) {
              JC_BURIED_POINT.onClickSeekbarFullscreen(url, objects);
            } else {
              JC_BURIED_POINT.onClickSeekbar(url, objects);
            }
          }
          break;
      }
    } else if (id == R.id.progress) {//if I am seeking bar,no mater whoever can not intercept my event
      switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
          cancelProgressTimer();
          ViewParent vpdown = getParent();
          while (vpdown != null) {
            vpdown.requestDisallowInterceptTouchEvent(true);
            vpdown = vpdown.getParent();
          }
          break;
        case MotionEvent.ACTION_UP:
          startProgressTimer();
          ViewParent vpup = getParent();
          while (vpup != null) {
            vpup.requestDisallowInterceptTouchEvent(false);
            vpup = vpup.getParent();
          }
          break;
      }
    }

    return false;
  }

  private void showProgressDialog(float deltaX) {
    if (dlgProgress == null) {
      View localView = LayoutInflater.from(getContext()).inflate(com.jiyun.pandatv.jcvideoplayer_lib.R.layout.jc_progress_dialog, null);
      dlgProgressProgressBar = ((ProgressBar) localView.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.duration_progressbar));
      dlgProgressCurrent = ((TextView) localView.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.tv_current));
      dlgProgressTotal = ((TextView) localView.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.tv_duration));
      dlgProgressIcon = ((ImageView) localView.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.duration_image_tip));

      dlgProgress = new Dialog(getContext(), com.jiyun.pandatv.jcvideoplayer_lib.R.style.jc_style_dialog_progress);
      dlgProgress.setContentView(localView);
      dlgProgress.getWindow().addFlags(Window.FEATURE_ACTION_BAR);
      dlgProgress.getWindow().addFlags(32);
      dlgProgress.getWindow().addFlags(16);
      dlgProgress.getWindow().setLayout(-2, -2);
      WindowManager.LayoutParams localLayoutParams = dlgProgress.getWindow().getAttributes();
      localLayoutParams.gravity = 49;
      localLayoutParams.y = getResources().getDimensionPixelOffset(com.jiyun.pandatv.jcvideoplayer_lib.R.dimen.jc_progress_dialog_margin_top);
      dlgProgress.getWindow().setAttributes(localLayoutParams);
    }
    if (!dlgProgress.isShowing()) {
      dlgProgress.show();
    }
    int totalTime = JCMediaManager.intance().mediaPlayer.getDuration();
    resultTimePosition = (int) (downPosition + deltaX * totalTime / screenWidth);
    dlgProgressCurrent.setText(JCUtils.stringForTime(resultTimePosition));
    dlgProgressTotal.setText(" / " + JCUtils.stringForTime(totalTime) + "");
    dlgProgressProgressBar.setProgress(resultTimePosition * 100 / totalTime);
    if (deltaX > 0) {
      dlgProgressIcon.setBackgroundResource(R.drawable.jc_forward_icon);
    } else {
      dlgProgressIcon.setBackgroundResource(R.drawable.jc_backward_icon);
    }
  }

  private void showVolumDialog(float deltaY) {
    if (dlgVolume == null) {
      View localView = LayoutInflater.from(getContext()).inflate(R.layout.jc_volume_dialog, null);
      dlgVolumeProgressBar = ((ProgressBar) localView.findViewById(R.id.volume_progressbar));
      dlgVolume = new Dialog(getContext(), R.style.jc_style_dialog_progress);
      dlgVolume.setContentView(localView);
      dlgVolume.getWindow().addFlags(8);
      dlgVolume.getWindow().addFlags(32);
      dlgVolume.getWindow().addFlags(16);
      dlgVolume.getWindow().setLayout(-2, -2);
      WindowManager.LayoutParams localLayoutParams = dlgVolume.getWindow().getAttributes();
      localLayoutParams.gravity = 19;
      localLayoutParams.x = getContext().getResources().getDimensionPixelOffset(R.dimen.jc_volume_dialog_margin_left);
      dlgVolume.getWindow().setAttributes(localLayoutParams);
    }
    if (!dlgVolume.isShowing()) {
      dlgVolume.show();
    }
    int max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    int deltaV = (int) (max * deltaY * 3 / screenHeight);
    mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, downVolume + deltaV, 0);
    int transformatVolume = (int) (downVolume * 100 / max + deltaY * 3 * 100 / screenHeight);
    dlgVolumeProgressBar.setProgress(transformatVolume);
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    if (fromUser) {
      int time = progress * JCMediaManager.intance().mediaPlayer.getDuration() / 100;
      JCMediaManager.intance().mediaPlayer.seekTo(time);
    }
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {

  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {

  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    if (FalseSetDisPlay) {//case setDisplay faild in prepared();
      FalseSetDisPlay = false;
      setDisplayCaseFailse();
    }
    if (IF_CURRENT_IS_FULLSCREEN) {//fullscreen from normal
      setDisplayCaseFailse();
    }
    if (BACK_FROM_FULLSCREEN) {
      BACK_FROM_FULLSCREEN = false;
      setDisplayCaseFailse();
    }
    ifNeedCreateSurfaceView = false;
  }

  private boolean FalseSetDisPlay = false;

  private void setDisplayCaseFailse() {
    try {
      L.d("JC", "JCMediaManager.intance().mediaPlayer"+(JCMediaManager.intance().mediaPlayer == null)+"");
      L.d("JC", "surfaceHolder"+(surfaceHolder == null)+"");
      JCMediaManager.intance().mediaPlayer.setDisplay(surfaceHolder);
    } catch (IllegalArgumentException e) {
      L.i(TAG, "recreate surfaceview from IllegalArgumentException");
      FalseSetDisPlay = true;
//      addSurfaceView();
      e.printStackTrace();
    } catch (IllegalStateException e1) {
      L.i(TAG, "recreate surfaceview from IllegalStateException");
      FalseSetDisPlay = true;
//      addSurfaceView();
      e1.printStackTrace();
    }
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    ifNeedCreateSurfaceView = true;
  }

  private boolean ifNeedCreateSurfaceView = false;

  @Override
  public void onPrepared() {
    if (CURRENT_STATE != CURRENT_STATE_PREPAREING) return;
    JCMediaManager.intance().mediaPlayer.start();
    //切换以后自动快进到上次播放位置
    if (PandaVedioPlayer.currentPosition!=0) {
      JCMediaManager.mediaPlayer.seekTo(PandaVedioPlayer.currentPosition);
    }
    startProgressTimer();
    setStateAndUi(CURRENT_STATE_PLAYING);
  }

  @Override
  public void onAutoCompletion() {
    //make me normal first
    if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
      if (IF_CURRENT_IS_FULLSCREEN) {
        JC_BURIED_POINT.onAutoCompleteFullscreen(url, objects);
      } else {
        JC_BURIED_POINT.onAutoComplete(url, objects);
      }
    }
    onCompletion();
  }

  @Override
  public void onCompletion() {
    //make me normal first
    cancelProgressTimer();
    resetProgressAndTime();
    setStateAndUi(CURRENT_STATE_NORMAL);

    //if fullscreen finish activity what ever the activity is directly or click fullscreen
    finishMyFullscreen();

    if (IF_FULLSCREEN_FROM_NORMAL) {//如果在进入全屏后播放完就初始化自己非全屏的控件
      IF_FULLSCREEN_FROM_NORMAL = false;
      JCMediaManager.intance().lastListener.onCompletion();
    }
  }

  @Override
  public void onBufferingUpdate(int percent) {
    if (CURRENT_STATE != CURRENT_STATE_NORMAL && CURRENT_STATE != CURRENT_STATE_PREPAREING) {
      setTextAndProgress(percent);
    }
  }

  @Override
  public void onSeekComplete() {

  }

  @Override
  public void onError(int what, int extra) {
    if (what != 38) {
      setStateAndUi(CURRENT_STATE_ERROR);
    }
  }

  @Override
  public void onVideoSizeChanged() {
    int mVideoWidth = JCMediaManager.intance().currentVideoWidth;
    int mVideoHeight = JCMediaManager.intance().currentVideoHeight;
    if (mVideoWidth != 0 && mVideoHeight != 0) {
      surfaceHolder.setFixedSize(mVideoWidth, mVideoHeight);
      surfaceView.requestLayout();
    }
  }

  @Override
  public void onBackFullscreen() {
    CURRENT_STATE = JCMediaManager.intance().lastState;
    BACK_FROM_FULLSCREEN = true;
    setStateAndUi(CURRENT_STATE);
  }

  protected void startProgressTimer() {
    cancelProgressTimer();
    mUpdateProgressTimer = new Timer();
    mUpdateProgressTimer.schedule(new TimerTask() {
      @Override
      public void run() {
        if (getContext() != null && getContext() instanceof Activity) {
          ((Activity) getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
              if (CURRENT_STATE == CURRENT_STATE_PLAYING) {
                setTextAndProgress(0);
              }
            }
          });
        }
      }
    }, 0, 300);
  }

  protected void cancelProgressTimer() {
    if (mUpdateProgressTimer != null) {
      mUpdateProgressTimer.cancel();
    }
  }

  //设置文字和进度
  protected void setTextAndProgress(int secProgress) {
    int position = JCMediaManager.intance().mediaPlayer.getCurrentPosition();
    int duration = JCMediaManager.intance().mediaPlayer.getDuration();
    // if duration == 0 (e.g. in HLS streams) avoids ArithmeticException
    int progress = position * 100 / (duration == 0 ? 1 : duration);
    setProgressAndTime(progress, secProgress, position, duration);
  }

  protected void setProgressAndTime(int progress, int secProgress, int currentTime, int totalTime) {
    if (!touchingProgressBar) {
      if (progress != 0) skProgress.setProgress(progress);
    }
    if (secProgress != 0) skProgress.setSecondaryProgress(secProgress);
    tvTimeCurrent.setText(JCUtils.stringForTime(currentTime));
    tvTimeTotal.setText(JCUtils.stringForTime(totalTime));
  }

  protected void resetProgressAndTime() {
    skProgress.setProgress(0);
    skProgress.setSecondaryProgress(0);
    tvTimeCurrent.setText(JCUtils.stringForTime(0));
    tvTimeTotal.setText(JCUtils.stringForTime(0));
  }

  protected void quitFullScreenGoToNormal() {
    if (JC_BURIED_POINT != null && JCMediaManager.intance().listener == this) {
      JC_BURIED_POINT.onQuitFullscreen(url, objects);
    }
    JCMediaManager.intance().mediaPlayer.setDisplay(null);
    JCMediaManager.intance().listener = JCMediaManager.intance().lastListener;
    JCMediaManager.intance().lastState = CURRENT_STATE;//save state
    JCMediaManager.intance().listener.onBackFullscreen();
    finishMyFullscreen();
  }

  protected void finishMyFullscreen() {
    if (getContext() instanceof JCFullScreenActivity) {
      ((JCFullScreenActivity) getContext()).finish();
    }
  }

  public void backFullscreen() {
    if (IF_FULLSCREEN_IS_DIRECTLY) {
      //如果是充满全屏
      JCMediaManager.intance().mediaPlayer.stop();
      finishMyFullscreen();
    } else {
      //如果没有充满全屏
      CLICK_QUIT_FULLSCREEN_TIME = System.currentTimeMillis();
      IF_RELEASE_WHEN_ON_PAUSE = false;
      quitFullScreenGoToNormal();
    }
  }

  public static void releaseAllVideos() {
    if (IF_RELEASE_WHEN_ON_PAUSE) {
      L.d(TAG, "IF_RELEASE_WHEN_ON_PAUSE:" + IF_RELEASE_WHEN_ON_PAUSE);
      JCMediaManager.intance().mediaPlayer.release();
      if (JCMediaManager.intance().listener != null) {
        JCMediaManager.intance().listener.onCompletion();
      }
    } else {
      IF_RELEASE_WHEN_ON_PAUSE = true;
    }
  }
}

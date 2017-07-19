package fm.jiecao.jcvideoplayer_lib;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nathen
 * On 2016/04/18 16:15
 */
public class JCVideoPlayerStandard extends JCVideoPlayer {

    public ImageView ivBack;//顶部返回按钮
    public ProgressBar pbBottom;//底部播放进度条
    public ProgressBar pbLoading;
    public TextView tvTitle;//顶部标题
    public ImageView ivThumb;//全屏背景
    public ImageView ivCover;//覆盖的图片(不确定)

    protected static Timer mDismissControlViewTimer;//  1.5秒的消失计时器
    protected static JCBuriedPointStandard jc_BuriedPointStandard;//节操隐藏标准

    //两种构造方法
    public JCVideoPlayerStandard(Context context) {
        super(context);
    }

    public JCVideoPlayerStandard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //获取布局id
    @Override
    public int getLayoutId() {
        return R.layout.jc_layout_standard;
    }


    //初始化布局id中的控件
    @Override
    protected void init(Context context) {
        super.init(context);
        pbBottom = (ProgressBar) findViewById(R.id.bottom_progressbar);
        tvTitle = (TextView) findViewById(R.id.title);
        ivBack = (ImageView) findViewById(R.id.back);
        ivThumb = (ImageView) findViewById(R.id.thumb);
        ivCover = (ImageView) findViewById(R.id.cover);
        pbLoading = (ProgressBar) findViewById(R.id.loading);

        //为背景图片设置点击
        ivThumb.setOnClickListener(this);

        //为返回按钮设置点击
        ivBack.setOnClickListener(this);

    }


    //开始准备
    @Override
    public void setUrlAndObject(String url, Map<String, String> mapHeadData, Object... objects) {
        if (objects.length == 0) return;
        //这里调用了父类的
        super.setUrlAndObject(url, mapHeadData,objects);
        //设置标题
        tvTitle.setText(objects[0].toString());
        if (IF_CURRENT_IS_FULLSCREEN) {
            //如果进入这个判断代表当前状态为全屏状态
            //设置进入全屏的图片为关闭全屏
            ivFullScreen.setImageResource(R.drawable.jc_shrink);
        } else {
            //如果进入这个判断代表当前状态为非全屏状态
            //设置进入全屏的图片为开启全屏
            ivFullScreen.setImageResource(R.drawable.jc_enlarge);
            //设置返回按钮为隐藏
            ivBack.setVisibility(View.GONE);
        }

    }


    //设置状态改变ui
    @Override
    public void setStateAndUi(int state) {
        //调用父类的设置ui状态的方法
        super.setStateAndUi(state);

        switch (CURRENT_STATE) {
            case CURRENT_STATE_NORMAL:
                //在正常状态时
                changeUiToNormal();
                break;
            case CURRENT_STATE_PREPAREING:
                //在准备状态时
                changeUiToShowUiPrepareing();
                startDismissControlViewTimer();
                break;
            case CURRENT_STATE_PLAYING:
                //在播放状态时
                changeUiToShowUiPlaying();
                startDismissControlViewTimer();
                break;
            case CURRENT_STATE_PAUSE:
                //在暂停状态时
                changeUiToShowUiPause();
                startDismissControlViewTimer();
                break;
            case CURRENT_STATE_ERROR:
                //在异常状态时
                changeUiToError();
                break;
        }
    }

    //屏幕触摸事件监听
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (id == R.id.surface_container) {
            //当触摸最外层布局时
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.d(TAG, "按下了最外层布局");
                    //按下的时候如果计时器存在就取消
                    cancelDismissControlViewTimer();
                    break;
                case MotionEvent.ACTION_UP:
                    Log.d(TAG, "抬起了最外层布局");
                    //抬起时开启计时器
                    startDismissControlViewTimer();
                    //如果改变了进度就更新底部进度条
                    if (changePosition) {
                        int duration = JCMediaManager.intance().mediaPlayer.getDuration();
                        int progress = resultTimePosition * 100 / (duration == 0 ? 1 : duration);
                        pbBottom.setProgress(progress);
                    }
                    //如果没有改变进度就更新ui的状态
                    if (!changePosition && !changeVolume) {
                        onClickUiToggle();
                    }
                    break;
            }
        } else if (id == R.id.progress) {
            //当触摸进度条时

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.d(TAG, "按下了进度条");
                    //按下的时候如果计时器存在就取消
                    cancelDismissControlViewTimer();
                    break;
                case MotionEvent.ACTION_UP:
                    Log.d(TAG, "抬起了进度条");
                    //抬起时开启计时器
                    startDismissControlViewTimer();
                    break;
            }
        }
        return super.onTouch(v, event);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();

        //点击背景图i == R.id.thumb播放改为点击播放按钮播放i == R.id.start
        if (i == R.id.start) {
            Log.d(TAG, "点击了播放按钮");
            if (TextUtils.isEmpty(url)) {
                Toast.makeText(getContext(), "No url", Toast.LENGTH_SHORT).show();
                return;
            }
            if (CURRENT_STATE == CURRENT_STATE_NORMAL) {
                if (jc_BuriedPointStandard != null) {
                    jc_BuriedPointStandard.onClickStartThumb(url, objects);
                }
                prepareVideo();
                startDismissControlViewTimer();
            }
        } else /*if (i == R.id.surface_container) {
            Log.d(TAG, "点击了最外层布局");
            //当点击最外层时
            if (jc_BuriedPointStandard != null && JCMediaManager.intance().listener == this) {
                if (IF_CURRENT_IS_FULLSCREEN) {
                    jc_BuriedPointStandard.onClickBlankFullscreen(url, objects);
                } else {
                    jc_BuriedPointStandard.onClickBlank(url, objects);
                }
            }
            startDismissControlViewTimer();
        } else*/ if (i == R.id.back) {

            Log.d(TAG, "点击了返回键");
            //当点击返回键时
            backFullscreen();
        }
    }


    //点击  ui  切换
    private void onClickUiToggle() {
        if (CURRENT_STATE == CURRENT_STATE_PREPAREING) {
              if (llBottomContainer.getVisibility() == View.VISIBLE) {
                changeUiToClearUiPrepareing();
                Log.d(TAG, "在      准备状态下      隐藏了播放器两边");
            } else {
                changeUiToShowUiPrepareing();
                  Log.d(TAG, "在      准备状态下      显示了播放器两边");
            }
        } else if (CURRENT_STATE == CURRENT_STATE_PLAYING) {

            if (llBottomContainer.getVisibility() == View.VISIBLE) {
                changeUiToClearUiPlaying();
                Log.d(TAG, "在      播放状态下      隐藏了播放器两边");
            } else {
                changeUiToShowUiPlaying();
                Log.d(TAG, "在      播放状态下      显示了播放器两边");
            }
        } else if (CURRENT_STATE == CURRENT_STATE_PAUSE) {

            if (llBottomContainer.getVisibility() == View.VISIBLE) {
                changeUiToClearUiPause();
                Log.d(TAG, "在      暂停状态下      隐藏了播放器两边");
            } else {
                changeUiToShowUiPause();
                Log.d(TAG, "在      暂停状态下      显示了播放器两边");
            }
        }
    }

    //调用父类方法设置进度条时间
    @Override
    protected void setProgressAndTime(int progress, int secProgress, int currentTime, int totalTime) {
        Log.d(TAG, "设置了进度条时间");
        super.setProgressAndTime(progress, secProgress, currentTime, totalTime);
        if (progress != 0) pbBottom.setProgress(progress);
        if (secProgress != 0) pbBottom.setSecondaryProgress(secProgress);
    }

    @Override
    protected void resetProgressAndTime() {
        Log.d(TAG, "重置了进度条时间");
        super.resetProgressAndTime();
        pbBottom.setProgress(0);
        pbBottom.setSecondaryProgress(0);
    }

    
    
    //Unified management Ui
    private void changeUiToNormal() {
        llTopContainer.setVisibility(View.VISIBLE);
        llBottomContainer.setVisibility(View.INVISIBLE);
        ivStart.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.INVISIBLE);
        ivThumb.setVisibility(View.VISIBLE);
        ivCover.setVisibility(View.VISIBLE);
        pbBottom.setVisibility(View.INVISIBLE);
        updateIvStartState();
    }

    private void changeUiToShowUiPrepareing() {
        llTopContainer.setVisibility(View.VISIBLE);
        llBottomContainer.setVisibility(View.VISIBLE);
        ivStart.setVisibility(View.INVISIBLE);
        pbLoading.setVisibility(View.VISIBLE);
        ivThumb.setVisibility(View.INVISIBLE);
        ivCover.setVisibility(View.VISIBLE);
        pbBottom.setVisibility(View.INVISIBLE);
    }

    private void changeUiToClearUiPrepareing() {
//        changeUiToClearUi();
        llTopContainer.setVisibility(View.INVISIBLE);
        llBottomContainer.setVisibility(View.INVISIBLE);
        ivStart.setVisibility(View.INVISIBLE);
        ivThumb.setVisibility(View.INVISIBLE);
        pbBottom.setVisibility(View.INVISIBLE);
//        pbLoading.setVisibility(View.VISIBLE);
        ivCover.setVisibility(View.VISIBLE);
    }

    private void changeUiToShowUiPlaying() {
        llTopContainer.setVisibility(View.VISIBLE);
        llBottomContainer.setVisibility(View.VISIBLE);
        ivStart.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.INVISIBLE);
        ivThumb.setVisibility(View.INVISIBLE);
        ivCover.setVisibility(View.INVISIBLE);
        pbBottom.setVisibility(View.INVISIBLE);
        updateIvStartState();
    }

    private void changeUiToClearUiPlaying() {
        changeUiToClearUi();
        pbBottom.setVisibility(View.VISIBLE);
    }

    private void changeUiToShowUiPause() {
        llTopContainer.setVisibility(View.VISIBLE);
        llBottomContainer.setVisibility(View.VISIBLE);
        ivStart.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.INVISIBLE);
        ivThumb.setVisibility(View.INVISIBLE);
        ivCover.setVisibility(View.INVISIBLE);
        pbBottom.setVisibility(View.INVISIBLE);
        updateIvStartState();
    }

    private void changeUiToClearUiPause() {
        changeUiToClearUi();
        pbBottom.setVisibility(View.VISIBLE);
    }

    private void changeUiToClearUi() {
        llTopContainer.setVisibility(View.INVISIBLE);
        llBottomContainer.setVisibility(View.INVISIBLE);
        ivStart.setVisibility(View.INVISIBLE);
        pbLoading.setVisibility(View.INVISIBLE);
        ivThumb.setVisibility(View.INVISIBLE);
        ivCover.setVisibility(View.INVISIBLE);
        pbBottom.setVisibility(View.INVISIBLE);
    }

    private void changeUiToError() {
        llTopContainer.setVisibility(View.INVISIBLE);
        llBottomContainer.setVisibility(View.INVISIBLE);
        ivStart.setVisibility(View.VISIBLE);
        pbLoading.setVisibility(View.INVISIBLE);
        ivThumb.setVisibility(View.INVISIBLE);
        ivCover.setVisibility(View.VISIBLE);
        pbBottom.setVisibility(View.INVISIBLE);
        updateIvStartState();
    }


    //更新开始播放的按钮
    private void updateIvStartState() {
        Log.d(TAG, "开始更新播放按钮状态");
        if (CURRENT_STATE == CURRENT_STATE_PLAYING) {
            ivStart.setImageResource(R.drawable.jc_click_pause_selector);
        } else if (CURRENT_STATE == CURRENT_STATE_ERROR) {
            ivStart.setImageResource(R.drawable.jc_click_error_selector);
        } else {
            ivStart.setImageResource(R.drawable.jc_click_play_selector);
        }
    }

    private void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        mDismissControlViewTimer = new Timer();
        mDismissControlViewTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (getContext() != null && getContext() instanceof Activity) {
                    ((Activity) getContext()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (CURRENT_STATE != CURRENT_STATE_NORMAL
                                    && CURRENT_STATE != CURRENT_STATE_ERROR) {
                                //当前状态不在正常并且不在异常状态时

                                llBottomContainer.setVisibility(View.INVISIBLE);
                                llTopContainer.setVisibility(View.INVISIBLE);
                                pbBottom.setVisibility(View.VISIBLE);
                                ivStart.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }
        }, 1500);
    }

    private void cancelDismissControlViewTimer() {
        Log.d(TAG, "计时器结束");
        if (mDismissControlViewTimer != null) {
            mDismissControlViewTimer.cancel();
            mDismissControlViewTimer = null;
        }
    }

    public static void setJcBuriedPointStandard(JCBuriedPointStandard jcBuriedPointStandard) {
        jc_BuriedPointStandard = jcBuriedPointStandard;
        JCVideoPlayer.setJcBuriedPoint(jcBuriedPointStandard);
    }

    @Override
    public void onCompletion() {
        super.onCompletion();
        cancelDismissControlViewTimer();
    }
}

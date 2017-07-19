package com.jiyun.pandatv.module.livechina.viewtwo;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.jiyun.pandatv.R;

import java.util.List;


/**
 * Created by Administrator on 2017/5/18.
 */

public class MyGridView extends GridLayout {
    private View mGridView;
    private onClickListener listener;
    private List<String> mList;
    public void remove(View view) {
        this.removeView(view);
    }

    public void add(String addItem) {
        addItem(addItem);
    }

    public void setListener(onClickListener listener) {
        this.listener = listener;
    }

    //在另一个类中，new对象时调用
    public MyGridView(Context context) {
        this(context, null);
    }

    //在XML布局中调用
    public MyGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //在XML布局中style中进行调用
    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //设置当前Gridlayout每个条目个数
        setColumnCount(4);
        //设置动画
        setLayoutTransition(new LayoutTransition());
    }

    //    // TODO: 2017/5/18 向外提供添加条目的方法，集合
    public void setItems(List<String> mList) {
        //遍历集合添加条目
        for (String s : mList) {
            addItem(s);
        }
    }

    //这是设置点击事件的集合添加数据
    public void setmList(List<String> mList) {
        this.mList = mList;
        for (String s : mList) {
            addItem(s);
        }

    }

    //向gridlayout里面设置添加条目
    private int margin = 25;
    private boolean boo;

    // TODO: 2017/5/18 向GridLayout里面添加条目
    public void addItem(String stritem) {
        final TextView mText = new TextView(getContext());
        LayoutParams gl = new LayoutParams();
        //获取当前屏幕的宽高
        gl.width = getResources().getDisplayMetrics().widthPixels / 4 - margin * 2;
        gl.height = LayoutParams.WRAP_CONTENT;

        gl.setGravity(Gravity.CENTER);
        mText.setGravity(Gravity.CENTER);
        gl.setMargins(margin, margin, margin, margin);


        //把这两个进行相关联
        mText.setLayoutParams(gl);
        //设置选中之后的变化
        mText.setBackgroundResource(R.drawable.tv_item_selector);
        //设置当前文本为添加的内容
        mText.setText(stritem);
        //添加textview这个对象
        addView(mText);


        //可以拖拽
        if (boo) {
            mText.setOnLongClickListener(ol);
        } else {
            //不能拖拽
            mText.setOnLongClickListener(null);
            //每个textview的点击事件
            mText.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //遍历这个集合，
                    for (int i = 0; i < mList.size(); i++) {
                        //得到这个集合里面的每个值，如果包含每个textview，这就得到了每个索引值
                        if (mList.get(i).equals(mText.getText())) {
                            listener.setOnItemClickListener(v, i);
                        }
                    }
                }
            });
        }

    }

    // TODO: 2017/5/18  //向外提供可以进行拖拽的方法

    public void setBoo(boolean boo) {
        this.boo = boo;
        if (boo) {
            this.setOnDragListener(od);
        } else {
            this.setOnDragListener(null);
        }
    }

    // TODO: 2017/5/18 textview的监听
    //TextView的长按监听事件（就是mGridLayout的每个条目）
    private OnLongClickListener ol = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            mGridView = v;
            v.startDrag(null, new DragShadowBuilder(), null, 0);
            v.setEnabled(false);

            return false;
        }
    };
    // TODO: 2017/5/18  /这是拖拽的监听器
    private OnDragListener od = new OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //开始进行拖拽
                    initRect();
                    break;
                //实时监听的拖拽的事件
                case DragEvent.ACTION_DRAG_LOCATION:
                    int index = getIntouchIndex(event);
                    if (index > -1 && mGridView != null
                            && mGridView != getChildAt(index)) {
                        removeView(mGridView);//移除一个view
                        addView(mGridView, index);//添加一个view对象,添加到对应拖拽的所在位置
                    }

                    break;
                //停止拖拽时的操作
                case DragEvent.ACTION_DRAG_ENDED:
                    if (mGridView != null) {
                        mGridView.setEnabled(true);
                    }

                    break;

            }
            return true;
        }


    };

    private Rect[] mRectArr;

    // TODO: 2017/5/18  总的来说把所有条目封装成矩形，并存入数组

    private void initRect() {
        //得到每个孩子的个数
        int childCount = getChildCount();
        //并把这些孩子（条目）添加到数组中，并遍历这些孩子
        mRectArr = new Rect[childCount];
        for (int i = 0; i < childCount; i++) {
            //得到每个孩子对象，返回一个view
            View childAt = getChildAt(i);
            //得到每个view对象的坐标点
            Rect rect = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            //并且返回给数组
            mRectArr[i] = rect;

        }


    }

    // TODO: 2017/5/18 进行拖拽的实时监听事件，实时监听每一个点是否进入到某一控件的位置
    //
    private int getIntouchIndex(DragEvent event) {
        for (int i = 0; i < mRectArr.length; i++) {
            /**getX()
             * .getX():这里面得到的是你进行拖拽的那个条目的坐标，位置
             */
            if (mRectArr[i].contains((int) event.getX(), (int) event.getY())) {
                //这是返回的你拖拽到某一条目所在的位置
                return i;
            }

        }
        return -1;
    }
    /**
     * 接口的回调，进行点击事件的处理
     */
    public interface onClickListener {
        void setOnItemClickListener(View view, int Position);
    }
}

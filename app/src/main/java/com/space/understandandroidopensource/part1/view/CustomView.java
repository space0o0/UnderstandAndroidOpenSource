package com.space.understandandroidopensource.part1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by space on 2018/3/22.
 */

public class CustomView extends View {

    private static final String TAG = "、、、CustomView、、、";

    public CustomView(Context context) {
        super(context);
        Log.d(TAG, "CustomView()");
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "CustomView()");
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "CustomView()");
    }

    /**
     * view在xml文件中加载完成时调用
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "View onFinishInflate()");
    }

    /**
     * 测量view和子view大小时调用
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "View onMeasure()");
    }

    /**
     * 布局view和子view时调用
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "View onLayout() left=" + left + " top=" + top + " right=" + right + " bottom=" + bottom);
    }

    /**
     * 绘制view和子view时调用
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "View onDraw()");
    }

    /**
     * 物理按键事件发生时调用
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "View onKeyDown() event="+event.getAction());
        return super.onKeyDown(keyCode, event);
    }
}

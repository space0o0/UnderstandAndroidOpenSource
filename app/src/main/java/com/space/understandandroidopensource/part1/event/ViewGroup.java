package com.space.understandandroidopensource.part1.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by space on 2018/3/23.
 */

public class ViewGroup extends LinearLayout {
    final String TAG = "///爸爸///";

    public ViewGroup(Context context) {
        super(context);
    }

    public ViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d(TAG, "viewGroup dispatchTouchEvent: 爸爸从爷爷那得到一颗糖~");
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction()==MotionEvent.ACTION_DOWN){
            Log.d(TAG, "viewGroup onInterceptTouchEvent:我也不要吃 ");
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            Log.d(TAG, "viewGroup onTouchEvent: true 儿子不吃，那我吃");
            return true;
        }
        return super.onTouchEvent(event);
    }
}

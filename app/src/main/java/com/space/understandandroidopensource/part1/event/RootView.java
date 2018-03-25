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

public class RootView extends LinearLayout {

    final String TAG = "///爷爷///";

    public RootView(Context context) {
        super(context);
    }

    public RootView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RootView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d(TAG, "rootview dispatchTouchEvent: 我得到了一个糖果");
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d(TAG, "rootview onInterceptTouchEvent:false 我不要吃这个糖果");
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d(TAG, "rootview onTouchEvent:true 爷爷自己吃了糖果");
            return true;
        }
        return super.onTouchEvent(event);
    }
}

package com.space.understandandroidopensource.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class EmojiImageView extends AppCompatImageView {
    public EmojiImageView(Context context) {
        super(context);
    }

    public EmojiImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EmojiImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTranslatexy(ViewPoint viewPoint){
        setTranslationX(viewPoint.x);
        setTranslationY(viewPoint.y);
    }
}

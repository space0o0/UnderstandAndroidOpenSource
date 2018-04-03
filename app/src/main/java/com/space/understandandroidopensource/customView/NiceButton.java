package com.space.understandandroidopensource.customView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.space.understandandroidopensource.R;
import com.space.understandandroidopensource.utils.ScreenUtils;


public class NiceButton extends RelativeLayout {

    private static String TAG = "NiceButton";

    int normalImgRes = R.mipmap.nice_gray;
    int favorImgRes = R.mipmap.nice_red;

    private int num = 5;

    private int mX = 0, mY = 0;//控件的中心点位置

    ImageView imageView;

    public NiceButton(Context context) {
        super(context);
    }

    public NiceButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NiceButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NiceButton, defStyleAttr, 0);
        normalImgRes = ta.getResourceId(R.styleable.NiceButton_nickbutton_normal_imgres, R.mipmap.nice_gray);
        favorImgRes = ta.getResourceId(R.styleable.NiceButton_nickbutton_favor_imgres, R.mipmap.nice_red);

        ta.recycle();

        init();
    }

    private void init() {
        Log.d(TAG, "init: xxxxxxxxxxxxxxxx");

        setGravity(Gravity.CENTER);
        imageView = new ImageView(getContext());
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), normalImgRes));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        addView(imageView);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        Log.d(TAG, "onLayout: l=" + l + " t=" + t + " r=" + r + " b=" + b);

        mX = (l + r) / 2;
        mY = (t + b) / 2;

        Log.d(TAG, "onLayout: mX=" + mX + "mY=" + mY);
        super.onLayout(changed, l, t, r, b);

    }

    public void favorOnes() {

    }

    /**
     * 计算出emoji的路径
     */
    public void calculatePath() {
        //贝塞尔曲线起始点（mX，mY）。
        //定义三阶贝塞尔曲线

        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), favorImgRes));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.2f, 1f, 1.2f);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setDuration(200);
        imageView.startAnimation(scaleAnimation);

        int[] res = new int[]{R.mipmap._726, R.mipmap._741, R.mipmap._742, R.mipmap._743, R.mipmap._747};
        for (int i = 0; i < res.length; i++) {
            addEmoji(res[i]);
        }

    }

    private void addEmoji(int res) {

        double random = Math.random();

        float x = getX() + getWidth() / 2;
        float screenWidth = ScreenUtils.getWidthPixels((Activity) getContext());

        int x1, y1, x2, y2;

        if (random > (x / screenWidth)) {
            //偏右喷射
            x1 = (int) (mX + Math.random() * 400);
            y1 = (int) (mY - Math.random() * 600);

            x2 = (int) (mX + Math.random() * 800);
            y2 = (int) (mY + Math.random() * 800);

        } else {
            //偏左喷射
            x1 = (int) (mX - Math.random() * 400);
            y1 = (int) (mY - Math.random() * 600);

            x2 = (int) (mX - Math.random() * 800);
            y2 = (int) (mY + Math.random() * 800);
        }

        final EmojiImageView view = new EmojiImageView(getContext());
        view.setImageDrawable(ContextCompat.getDrawable(getContext(), res));
        ((ViewGroup) getParent()).addView(view);

        ViewPath viewPath = new ViewPath();
        viewPath.moveTo(mX, mY);
        viewPath.quadTo(x1, y1, x2, y2);

        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(view, "translatexy", new ViewPathEvaluator(), viewPath.getPoints().toArray());
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        ValueAnimator alphaAnimator = ValueAnimator.ofInt(255, 0);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int alpha = (int) animation.getAnimatedValue();
                view.setImageAlpha(alpha);
            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator).with(alphaAnimator);
        set.setDuration(1000);
        set.start();
    }
}

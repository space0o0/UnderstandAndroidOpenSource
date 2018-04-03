package com.space.understandandroidopensource.favor;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

import com.space.understandandroidopensource.R;
import com.space.understandandroidopensource.customView.EmojiImageView;
import com.space.understandandroidopensource.customView.ViewPath;
import com.space.understandandroidopensource.customView.ViewPathEvaluator;
import com.space.understandandroidopensource.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class FavorViewHelper {

    private static final String TAG = "FavorViewHelper";
    //点赞喷射的imageview
    private int favorImageNum = 5;

    private View anchorView;

    private List<Integer> favorImageRes;//

    private int mX = 0, mY = 0;//控件的中心点位置

    ScaleAnimation scaleAnimation;

    public void favorOnce() {
        for (int i = 0; i < favorImageNum; i++) {
            int res=favorImageRes.get(i);
            startFavorImagesAnim(res);
        }

        anchorView.startAnimation(scaleAnimation);
    }

    private void init() {

        anchorView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                mX = (left + right) / 2;
                mY = (top + bottom) / 2;
                Log.d(TAG, "onLayoutChange: mX=" + mX + " mY=" + mY);
            }
        });

        createAnchorViewScaleAnim();

    }

    /**
     * anchorView点击时候的动画
     */
    private void createAnchorViewScaleAnim() {
        scaleAnimation = new ScaleAnimation(1f, 1.2f, 1f, 1.2f);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setDuration(200);
    }

    private void startFavorImagesAnim(int res) {
        double random = Math.random();
        float screenWidth = ScreenUtils.getWidthPixels((Activity) anchorView.getContext());
        int x1, y1, x2, y2;

        if (random > (mX / screenWidth)) {
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

        final EmojiImageView view = new EmojiImageView(anchorView.getContext());
        view.setImageDrawable(ContextCompat.getDrawable(anchorView.getContext(), res));
        ((ViewGroup)anchorView.getParent()).addView(view);

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

    private FavorViewHelper(Builder builder) {
        if (builder.favorImageNum == 0) {
            favorImageNum = 5;
        }

        if (builder.anchorView == null) {
            return;
        }
        anchorView = builder.anchorView;

        if (builder.favorImageRes == null) {
            favorImageRes = new ArrayList<>();
            favorImageRes.add(R.mipmap._726);
            favorImageRes.add(R.mipmap._741);
            favorImageRes.add(R.mipmap._742);
            favorImageRes.add(R.mipmap._743);
            favorImageRes.add(R.mipmap._747);
        } else {
            favorImageRes = builder.favorImageRes;
        }

        init();
    }

    public static final class Builder {
        private int favorImageNum;
        private View anchorView;
        private List<Integer> favorImageRes;

        public Builder() {
        }

        public Builder favorImageNum(int val) {
            favorImageNum = val;
            return this;
        }

        public Builder anchorView(View val) {
            anchorView = val;
            return this;
        }

        public Builder favorImageRes(List<Integer> val) {
            favorImageRes = val;
            return this;
        }

        public FavorViewHelper build() {
            return new FavorViewHelper(this);
        }
    }


}

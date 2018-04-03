package com.space.understandandroidopensource.customView;

import android.annotation.SuppressLint;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.space.understandandroidopensource.R;
import com.space.understandandroidopensource.favor.FavorViewHelper;

public class NiceButtonActivity extends AppCompatActivity {

    Button button;
    ImageView goodImg;

    FavorViewHelper helper, helper2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nice_button);

        button = findViewById(R.id.button);
        goodImg = findViewById(R.id.good);

        helper = new FavorViewHelper.Builder()
                .anchorView(goodImg)
                .build();

        goodImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goodImg.setImageDrawable(ContextCompat.getDrawable(NiceButtonActivity.this,R.mipmap.nice_red));
                helper.favorOnce();

            }
        });

//        goodImg.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                helper.favorOnce();
//                return true;
//            }
//        });

        goodImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Log.d(getClass().getSimpleName(), "onLongClick: ");

                return true;
            }
        });



    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {

        return super.onKeyLongPress(keyCode, event);
    }
}

package com.space.understandandroidopensource.part1.view;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.space.understandandroidopensource.R;

public class CustomViewActivity extends AppCompatActivity {

    public static final String TAG = "//CustomViewActivity//";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.part1_activity_custom_view);
        Log.d(TAG, "onCreate: ");

    }

    public void onClickCustomView(View view) {
        Log.d(TAG, "onClickCustomView: ");
    }
}

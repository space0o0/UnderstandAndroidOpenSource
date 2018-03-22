package com.space.understandandroidopensource;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.space.understandandroidopensource.part1.view.CustomViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void goToCustomView(View view) {
        Toast.makeText(this, "xxx", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(this, CustomViewActivity.class);
        startActivity(intent);
    }
}

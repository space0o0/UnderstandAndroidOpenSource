package com.space.understandandroidopensource.part2_ipc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.space.understandandroidopensource.R;

public class IpcSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_second);

        Log.d(getClass().getSimpleName(), "onCreate: userid="+UserManager.userId);
    }
}

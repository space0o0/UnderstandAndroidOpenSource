package com.space.understandandroidopensource.app;

import android.util.Log;

import com.space.understandandroidopensource.utils.IpcUtils;

/**
 * Created by space on 2018/3/27.
 */

public class Application extends android.app.Application {

    static final String TAG = "Application";

    @Override
    public void onCreate() {
        super.onCreate();

        String processName = IpcUtils.getProcessName(this, android.os.Process.myPid());

        Log.d(TAG, "onCreate: processName"+processName);

    }
}

package com.space.understandandroidopensource.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by space on 2018/3/27.
 */

public class IpcUtils {

    public static String getProcessName(Context context, int pid) {
        String processName = "";

        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        assert manager != null;
        for (ActivityManager.RunningAppProcessInfo info :
                manager.getRunningAppProcesses()) {

            if (info.pid == pid) {
                processName = info.processName;
            }
        }

        return processName;
    }
}

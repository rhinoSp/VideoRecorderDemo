package com.rhino.videorecorderdemo.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

/**
 * @author rhino
 * @since Create on 2019/6/9.
 **/
public class PermissionsUtils {

    public static final int REQUEST_CODE_PERMISSIONS = 1;
    public static final String[] VIDEO_PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
    };

    /**
     * Requests permissions needed for recording video.
     */
    public static void requestVideoPermissions(@NonNull Activity activity) {
        ActivityCompat.requestPermissions(activity, VIDEO_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
    }

    /**
     * Requests permissions needed for recording video.
     */
    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] permissions) {
        ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE_PERMISSIONS);
    }

    /**
     * Check permissions
     */
    public static boolean checkVideoPermission(@NonNull Context context) {
        for (String permission : VIDEO_PERMISSIONS) {
            if (ActivityCompat.checkSelfPermission(context, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check permissions
     */
    public static boolean checkSelfPermission(@NonNull Context context, @NonNull String[] permissions) {
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(context, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

}

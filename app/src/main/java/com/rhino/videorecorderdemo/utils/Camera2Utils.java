package com.rhino.videorecorderdemo.utils;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;

/**
 * @author rhino
 * @since Create on 2019/6/9.
 **/
public class Camera2Utils {

    private Context appContext;
    private CameraManager cameraManager;

    private static Camera2Utils instance = new Camera2Utils();

    public static Camera2Utils getInstance() {
        return instance;
    }

    private Camera2Utils() {
    }

    public void init(Context context) {
        if (appContext == null) {
            appContext = context.getApplicationContext();
            cameraManager = (CameraManager) appContext.getSystemService(Context.CAMERA_SERVICE);
        }
    }

    /**
     * 获取CameraManager
     */
    public CameraManager getCameraManager() {
        return cameraManager;
    }

    /**
     * 获取前置相机id
     *
     * @return 前置相机id
     */
    public String getFrontCameraId() {
        return getCameraId(true);
    }

    /**
     * 获取后置相机id
     *
     * @return 后置相机id
     */
    public String getBackCameraId() {
        return getCameraId(false);
    }

    /**
     * 获取相机id
     *
     * @param useFrontCamera 是否使用前置相机
     * @return CameraCharacteristics.LENS_FACING_FRONT or CameraCharacteristics.LENS_FACING_BACK
     */
    public String getCameraId(boolean useFrontCamera) {
        try {
            String[] cameraIds = cameraManager.getCameraIdList();
            for (String cameraId : cameraIds) {
                CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
                int cameraFacing = characteristics.get(CameraCharacteristics.LENS_FACING);
                if (useFrontCamera) {
                    if (cameraFacing == CameraCharacteristics.LENS_FACING_FRONT) {
                        return cameraId;
                    }
                } else {
                    if (cameraFacing == CameraCharacteristics.LENS_FACING_BACK) {
                        return cameraId;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

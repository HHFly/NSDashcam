package nshine.com.nsdashcam.common.util;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import nshine.com.nsdashcam.common.handle.LocationCallback;
import nshine.com.nsdashcam.common.handle.LocationUtil;

public class LocationManagerUtil {
    private LocationUtil util;
    private List<LocationCallback> callbackList;

    private LocationManagerUtil(LocationUtil util) {
        this.util = util;
    }

    public static LocationManagerUtil getInstance(LocationUtil util) {
        return new LocationManagerUtil(util);
    }

    public void register(Activity activity, LocationCallback callback) {
        if (callback != null) {
            if (this.util != null) {
                this.util.register(activity, callback);
            }

            if (!callback.isLocationOne()) {
                if (this.callbackList == null) {
                    this.callbackList = new ArrayList();
                }

                this.callbackList.add(callback);
            }
        }

    }

    public void unRegisterForThisCallback() {
        if (this.util != null) {
            this.util.unRegister(this.callbackList);
        }

        if (this.callbackList != null) {
            this.callbackList.clear();
            this.callbackList = null;
        }

    }

    public void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (this.util != null) {
            this.util.onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
        }

    }
}

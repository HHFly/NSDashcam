package nshine.com.nsdashcam.common.handle;

import nshine.com.nsdashcam.common.model.LocationModel;

public interface LocationCallback {
    void getLastKnownLocation(LocationModel var1);

    void onLocationChanged(LocationModel var1);

    boolean isLocationOne();
}

package nshine.com.nsdashcam.app;



import android.support.multidex.MultiDexApplication;


import nshine.com.nsdashcam.common.util.FrescoUtils;
import nshine.com.nsdashcam.common.util.NSLifecycleHandle;
import nshine.com.nsdashcam.common.util.ToastUtils;


/**
 * Created by z on 2018/4/10.
 */

public class App extends MultiDexApplication {

    private static App s_app;

    public static App get() {
        return s_app;
    }





    @Override
    public void onCreate() {
        super.onCreate();

        s_app = this;
        //初始化服务


        ToastUtils.init(this);
        registerActivityLifecycleCallbacks(new NSLifecycleHandle());
        //初始化Fresco
        FrescoUtils.initialize(this);


    }



}

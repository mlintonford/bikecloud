package info.unitool.app3.myapplication;

import android.app.Activity;
import android.app.Application;

/**
 * Created by Matthew on 20/02/2017.
 */

public class MyApp extends Application {
    public void onCreate() {
        super.onCreate();
    }

    private Activity mCurrentActivity = null;
    public Activity getCurrentActivity(){
        return mCurrentActivity;
    }
    public void setCurrentActivity(Activity mCurrentActivity){
        this.mCurrentActivity = mCurrentActivity;
    }
}
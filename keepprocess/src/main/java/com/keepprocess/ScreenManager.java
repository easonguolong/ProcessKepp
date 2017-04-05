package com.keepprocess;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/04/05.
 */

public class ScreenManager {
    private Context mContext;

    private WeakReference<Activity> mActivityWref;
    public static ScreenManager gDefault;

    public static ScreenManager getInsatance(Context pContext)
    {
        if(gDefault ==null){
            gDefault = new ScreenManager(pContext.getApplicationContext());
        }
        return gDefault;
    }

    private ScreenManager(Context context){
        this.mContext = context;
    }

    public void setActivity(Activity pActivity){
        mActivityWref = new WeakReference<Activity>(pActivity);
    }
    public void startActivity(){
        LiveActivity.actionToLiveActivity(mContext);
    }
    public void finishActivity(){
        if(mActivityWref!=null){
            Activity activity = mActivityWref.get();
            if(activity!=null){
                activity.finish();
            }
        }
    }
}

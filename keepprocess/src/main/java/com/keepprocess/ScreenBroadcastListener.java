package com.keepprocess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by Administrator on 2017/04/05.
 */

public class ScreenBroadcastListener {

    private Context  mContext;
    private ScreenBroadcastReceiver mScreenReceiver;
    private ScreenStateListener mListener;

    public ScreenBroadcastListener(Context context) {
        mContext = context.getApplicationContext();
        mScreenReceiver = new ScreenBroadcastReceiver();
    }

    interface ScreenStateListener{
        void onScreenOn();
        void onScreenOff();
    }

    //screen 状态广播接受者
    private class ScreenBroadcastReceiver extends BroadcastReceiver{
        private String action=null;
        @Override
        public void onReceive(Context context, Intent intent) {
            action = intent.getAction();
            if(Intent.ACTION_SCREEN_ON.equals(action)){
                mListener.onScreenOn();
            }else if(Intent.ACTION_SCREEN_OFF.equals(action)){
                mListener.onScreenOff();
            }
        }
    }

    public void registerListener(ScreenStateListener listener){
        mListener = listener;
        registerListener();
    }

    private void registerListener(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mContext.registerReceiver(mScreenReceiver,filter);
    }

}

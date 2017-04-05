package com.keepprocess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/04/05.
 */

public class LiveActivity extends Activity {
    public static final String TAG = LiveActivity.class.getSimpleName();

    public static void actionToLiveActivity(Context pContetx){
        Intent intent = new Intent(pContetx,LiveActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        pContetx.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setGravity(Gravity.START | Gravity.TOP);
        WindowManager.LayoutParams attributes = window.getAttributes();
        //宽高设计1个像素
        attributes.width=1;
        attributes.height=1;
        //起始坐标
        attributes.x = 0;
        attributes.y =0;
        window.setAttributes(attributes);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

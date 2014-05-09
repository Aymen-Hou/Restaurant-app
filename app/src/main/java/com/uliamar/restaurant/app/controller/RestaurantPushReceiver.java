package com.uliamar.restaurant.app.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;

import android.util.Log;
import android.widget.Toast;
/**
 * Created by Bigred on 2014/5/9.
 */
public class RestaurantPushReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context,Intent intent){
        if(intent.getAction().equals(PushConstants.ACTION_RECEIVE)){
            final String method = intent
                    .getStringExtra(PushConstants.EXTRA_METHOD);
            int errorCode = intent
                    .getIntExtra(PushConstants.EXTRA_ERROR_CODE,
                            PushConstants.ERROR_SUCCESS);
            String content = "";
            if (intent.getByteArrayExtra(PushConstants.EXTRA_CONTENT) != null) {
                content = new String(
                        intent.getByteArrayExtra(PushConstants.EXTRA_CONTENT));
            }
            Log.i("bigred","method : " + method + "\n result: " + errorCode
                    + "\n content = " + content);
            Toast.makeText(
                    context,
                    "method : " + method + "\n result: " + errorCode
                            + "\n content = " + content, Toast.LENGTH_SHORT)
                    .show();
        }else if(intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
            String message = intent.getExtras().getString(
                    PushConstants.EXTRA_PUSH_MESSAGE_STRING);
            Toast.makeText(context, "receive message："+message, Toast.LENGTH_SHORT).show();
        }
    }
}

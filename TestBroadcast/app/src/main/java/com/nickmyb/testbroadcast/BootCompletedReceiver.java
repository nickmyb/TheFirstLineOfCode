package com.nickmyb.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Broadcast Receiver不允许开线程，避免耗时操作
        Toast.makeText(context, "收到 BOOT_COMPLETED 消息", Toast.LENGTH_SHORT).show();
    }
}
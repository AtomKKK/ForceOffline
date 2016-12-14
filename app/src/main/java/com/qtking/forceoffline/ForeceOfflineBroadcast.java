package com.qtking.forceoffline;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class ForeceOfflineBroadcast extends BroadcastReceiver {

    public  static final String ACTION = "com.qtking.forceoffline.ForeceOfflineBroadcast";
    public ForeceOfflineBroadcast() {
    }

    @Override
    public void onReceive(final Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示")
                .setMessage("您已在别处上线")
                .setCancelable(false)
                .setPositiveButton("退出应用", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCollector.removeAll();

                        context.startActivity(new Intent(context, LoginActivity.class));
                    }
                })
                .show();

    }
}

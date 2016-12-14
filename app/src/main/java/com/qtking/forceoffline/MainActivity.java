package com.qtking.forceoffline;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_force_offline)
    Button mButton;
    private ForeceOfflineBroadcast mForeceOfflineBroadcast;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mForeceOfflineBroadcast = new ForeceOfflineBroadcast();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(ForeceOfflineBroadcast.ACTION);
        registerReceiver(mForeceOfflineBroadcast, mIntentFilter);
    }

    @OnClick(R.id.btn_force_offline)
    public void btnForceOfflineOnclick() {

        // TODO: 2016/12/14 发广播强制下线

        sendBroadcast(new Intent(ForeceOfflineBroadcast.ACTION));


    }

    public static void startMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        if (mForeceOfflineBroadcast != null) {
            unregisterReceiver(mForeceOfflineBroadcast);
        }
        super.onDestroy();
    }
}

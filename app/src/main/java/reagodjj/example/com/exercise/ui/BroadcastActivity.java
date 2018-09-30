package reagodjj.example.com.exercise.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import reagodjj.example.com.exercise.R;

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RealgodJJ";
    private AirPlayReceiver airPlayReceiver;
    private MyNewReceiver myNewReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Button btStaticSendDisorderBroadcast = findViewById(R.id.bt_static_send_disorder_broadcast);
        Button btDynamicSendDisorderBroadcast = findViewById(R.id.bt_dynamic_send_disorder_broadcast);
        Button btStaticSendOrderBroadcast = findViewById(R.id.bt_static_send_order_broadcast);
        Button btDynamicSendOrderBroadcast = findViewById(R.id.bt_dynamic_send_order_broadcast);
        btStaticSendDisorderBroadcast.setOnClickListener(this);
        btDynamicSendDisorderBroadcast.setOnClickListener(this);
        btStaticSendOrderBroadcast.setOnClickListener(this);
        btDynamicSendOrderBroadcast.setOnClickListener(this);

        //动态注册监听飞行模式广播
        airPlayReceiver = new AirPlayReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        registerReceiver(airPlayReceiver, intentFilter);

        //动态注册MYFUCK广播
        myNewReceiver = new MyNewReceiver();
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("DYNAMIC_MYFUCK");
        registerReceiver(myNewReceiver, intentFilter1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_static_send_disorder_broadcast:
                Intent disorderIntent = new Intent();
                disorderIntent.setAction("MYFUCK");
                sendBroadcast(disorderIntent);
                break;

            case R.id.bt_dynamic_send_disorder_broadcast:
                Intent disorderIntent1 = new Intent("DYNAMIC_MYFUCK");
                sendBroadcast(disorderIntent1);
                break;

            case R.id.bt_static_send_order_broadcast:
                Intent orderIntent = new Intent();
                orderIntent.setAction("MYFUCK");
                sendOrderedBroadcast(orderIntent, null, null,
                        null, 0, "这是初始数据", null);
                break;

            case R.id.bt_dynamic_send_order_broadcast:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(airPlayReceiver);
        unregisterReceiver(myNewReceiver);
    }

    class AirPlayReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: -动态注册");
        }
    }

    class MyNewReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: -动态发送无序广播");
        }
    }
}

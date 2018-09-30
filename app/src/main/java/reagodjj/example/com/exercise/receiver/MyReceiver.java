package reagodjj.example.com.exercise.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import reagodjj.example.com.exercise.R;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "RealgodJJ";

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: -静态注册");
    }
}

package reagodjj.example.com.exercise.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FirstReceiver extends BroadcastReceiver {
    private static final String TAG = "RealgodJJ";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: --1--");
    }
}

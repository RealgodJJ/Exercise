package reagodjj.example.com.exercise.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

@SuppressLint("Registered")
public class MyService extends Service {
    private static final String TAG = "RealgodJJ";
    private MyBinder myBinder;
    private String data = "这是服务";

    @Override
    public void onCreate() {
        super.onCreate();
        myBinder = new MyBinder();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        Log.d(TAG, "onStartCommand: 当前线程的名称：" + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return myBinder;
    }

    public class MyBinder extends Binder {
        public void setData(String data) {
            MyService.this.data = "这是服务-" + data;
        }

        public String getData() {
            return data;
        }
    }
}

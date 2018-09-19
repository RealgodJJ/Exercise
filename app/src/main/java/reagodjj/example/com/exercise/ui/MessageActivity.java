package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import reagodjj.example.com.exercise.R;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btInner, btExtend;
    private Handler innerHandler;
    private ExtendHandler extendHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        btInner = findViewById(R.id.bt_inner);
        btExtend = findViewById(R.id.bt_extend);

        btInner.setOnClickListener(this);
        btExtend.setOnClickListener(this);

        innerHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                String currentThreadName = Thread.currentThread().getName();
                String data = (String) msg.obj;
                Log.d("RealgodJJ", currentThreadName + ": " + data);
                return false;
            }
        });

        extendHandler = new ExtendHandler();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_inner:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String currentThreadName = Thread.currentThread().getName();
                        String data = currentThreadName + "-- 这是内部类的形式";
                        Message message = new Message();
                        message.what = 1;
                        message.obj = data;
                        innerHandler.sendMessage(message);
                    }
                }).start();
                break;

            case R.id.bt_extend:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String currentThreadName = Thread.currentThread().getName();
                        String data = currentThreadName + "-- 这是继承类的形式";
                        Message message = new Message();
                        message.what = 1;
                        message.obj = data;
                        extendHandler.sendMessage(message);
                    }
                }).start();
                break;
        }
    }

    @SuppressLint("HandlerLeak")
    class ExtendHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String currentThreadName = Thread.currentThread().getName();
            String data = (String) msg.obj;
            Log.d("RealgodJJ", currentThreadName + ": " + data);
        }
    }
}

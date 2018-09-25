package reagodjj.example.com.exercise.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import reagodjj.example.com.exercise.R;
import reagodjj.example.com.exercise.service.MyService;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private ServiceConnection connection;
    private MyService.MyBinder myBinder;
    private Button btUnbindService, btSendService, btReceiveService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button btStartService = findViewById(R.id.bt_start_service);
        Button btStopService = findViewById(R.id.bt_stop_service);
        Button btBindService = findViewById(R.id.bt_bind_service);
        btUnbindService = findViewById(R.id.bt_unbind_service);
        btSendService = findViewById(R.id.bt_send_service);
        btReceiveService = findViewById(R.id.bt_receive_service);

        btStartService.setOnClickListener(this);
        btStopService.setOnClickListener(this);
        btBindService.setOnClickListener(this);
        btUnbindService.setOnClickListener(this);
        btSendService.setOnClickListener(this);
        btReceiveService.setOnClickListener(this);

        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBinder = (MyService.MyBinder) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                myBinder = null;
            }
        };
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MyService.class);
        switch (v.getId()) {
            case R.id.bt_start_service:
                startService(intent);
                break;
            case R.id.bt_stop_service:
                stopService(intent);
                break;
            case R.id.bt_bind_service:
                bindService(intent, connection, BIND_AUTO_CREATE);
                btUnbindService.setEnabled(true);
                btSendService.setEnabled(true);
                break;
            case R.id.bt_unbind_service:
                if (connection != null) {
                    unbindService(connection);
                    btUnbindService.setEnabled(false);
                    btSendService.setEnabled(false);
                    btReceiveService.setEnabled(false);
                }
                break;
            case R.id.bt_send_service:
                if (myBinder != null) {
                    myBinder.setData("这是Activity发送的数据");
                    btReceiveService.setEnabled(true);
                }
                break;
            case R.id.bt_receive_service:
                if (myBinder != null) {
                    String data = myBinder.getData();
                    Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

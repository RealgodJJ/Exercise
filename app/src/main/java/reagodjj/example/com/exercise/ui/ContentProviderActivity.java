package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import reagodjj.example.com.exercise.R;

public class ContentProviderActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RealgodJJ";
    private TextView tvNumberShow, tvDatabaseShow;
    private Handler contentProviderHandler, myProviderHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        Button btGetCallLog = findViewById(R.id.bt_get_call_log);
        Button btGetDataBase = findViewById(R.id.bt_get_my_provider);
        tvNumberShow = findViewById(R.id.tv_number_show);
        tvDatabaseShow = findViewById(R.id.tv_database_show);

        btGetCallLog.setOnClickListener(this);
        btGetDataBase.setOnClickListener(this);

        contentProviderHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                tvNumberShow.setText(String.valueOf(msg.obj));
                return false;
            }
        });


        myProviderHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                tvDatabaseShow.setText(msg.obj.toString());
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_get_call_log:
                StringBuilder number = new StringBuilder();
                ContentResolver contentResolver = getContentResolver();
                @SuppressLint({"Recycle", "MissingPermission"})
                Cursor cursor = contentResolver.query(CallLog.Calls.CONTENT_URI,
                        null, null, null, null);

                assert cursor != null;
                while (cursor.moveToNext()) {
                    String number_temp = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
                    Log.d(TAG, "onClick: " + number_temp);
                    number.append(number_temp).append("\n");
                }
                cursor.close();

                Message message = new Message();
                message.what = 1;
                message.obj = number.toString();
                contentProviderHandler.sendMessage(message);
                break;

            case R.id.bt_get_my_provider:
                StringBuilder info = new StringBuilder();
                Uri uri = Uri.parse("content://reagodjj.example.com.myprovider/person");
                Cursor myCursor = getContentResolver().query(uri, null,
                        null, null, null);

                assert myCursor != null;
                while (myCursor.moveToNext()) {
                    String name_temp = myCursor.getString(myCursor.getColumnIndex("name"));
                    int age_temp = myCursor.getInt(myCursor.getColumnIndex("age"));
                    Log.d(TAG, "onClick: " + "\nname: " + name_temp + "\nage: " + age_temp);
                    info.append(name_temp).append("\t\t").append(age_temp).append("\n");
                }
                myCursor.close();

                Message myMessage = new Message();
                myMessage.what = 2;
                myMessage.obj = info;
                myProviderHandler.sendMessage(myMessage);
                break;
        }
    }
}

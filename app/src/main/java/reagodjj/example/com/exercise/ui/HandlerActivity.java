package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;

import reagodjj.example.com.exercise.R;

public class HandlerActivity extends AppCompatActivity {
    private static final String TAG = "HandlerActivity";
    private static final int DOWNLOAD_SUCCESS = 1;
    private static final int DOWNLOAD_FAIL = -1;
    public static final int COUNT_DOWN_TIME = 2;
    public static final int DELAY_MILLIS = 1000;
    public static final int COUNT_DOWN_MAX_TIME = 10;
    public static final String HTTP_DOWNLOAD = "http://download.sj.qq.com/upload/connAssitantDownload/upload/MobileAssistant_1.apk";
    private TextView tvShowHandlerMessage, tvShowCountDownTime;
    private Button btReceiveMessage, btDownload;
    private ProgressBar pbDownload;
    private Handler downloadHandler;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        tvShowHandlerMessage = findViewById(R.id.tv_show_handler_message);
        btReceiveMessage = findViewById(R.id.bt_receive_handler_message);
        btDownload = findViewById(R.id.bt_download);
        pbDownload = findViewById(R.id.pb_download);
        tvShowCountDownTime = findViewById(R.id.tv_show_count_down_time);

        final CountDownHandler countDownHandler = new CountDownHandler(this);
        Message message = Message.obtain();
        message.what = COUNT_DOWN_TIME;
        message.arg1 = COUNT_DOWN_MAX_TIME;
        countDownHandler.sendMessage(message);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //处理消息
                Log.i(TAG, "HandlerActivity: " + msg);

                if (msg.what == 1001) {
                    tvShowHandlerMessage.setText(R.string.realgodjj);
                }
            }
        };

        downloadHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //发送下载进度信息
                switch (msg.what) {
                    case DOWNLOAD_SUCCESS:
                        pbDownload.setProgress((Integer) msg.obj);
                        break;

                    case DOWNLOAD_FAIL:
                        tvShowHandlerMessage.setText(R.string.download_fail);
                        break;
                }
            }
        };


        btReceiveMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(1001);
            }
        });

        /*
         * 主线程 -->start
         * 点击按钮 |
         * 发起下载 |
         * 开启子线程做下载 |
         * 下载完成后通知主线程 | -->主线程更新进度条
         */
        btDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        download(HTTP_DOWNLOAD);
                    }
                }).start();
            }
        });
    }

    private void download(String appUrl) {
        try {
            URL url = new URL(appUrl);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            //获取文件的总长度
            int contentLength = urlConnection.getContentLength();
            //设置文件存储的路径
            String downloadFolderName = Environment.getExternalStorageDirectory() + File.separator
                    + "imooc" + File.separator;

            //判断文件夹是否存在
            File folder = new File(downloadFolderName);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //判断文件是否存在
            String filename = downloadFolderName + "imooc.apk";
            File file = new File(filename);
            if (file.exists()) {
                file.delete();
            }

            int downloadSize = 0;//当前下载文件大小
            byte bytes[] = new byte[1024];
            int length;

            //将输入流转换成输出流到文件中
            OutputStream outputStream = new FileOutputStream(filename);
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
                downloadSize += length;

                //更新UI
                Message message = Message.obtain();
                message.obj = downloadSize * 100 / contentLength;
                message.what = DOWNLOAD_SUCCESS;
                downloadHandler.sendMessage(message);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            DownloadFail(e);
        }
    }

    private void DownloadFail(IOException e) {
        //更新UI
        Message message = Message.obtain();
        message.what = DOWNLOAD_FAIL;
        downloadHandler.sendMessage(message);
        e.printStackTrace();
    }

    private static class CountDownHandler extends Handler {
        static final int COUNT_DOWN_MIN_TIME = 0;
        final WeakReference<HandlerActivity> handlerActivityWeakReference;

        CountDownHandler(HandlerActivity handlerActivity) {
            handlerActivityWeakReference = new WeakReference<>(handlerActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            HandlerActivity handlerActivity = handlerActivityWeakReference.get();
            //处理倒计时(先判断弱引用中的对象是否被清理)
            if (handlerActivity != null) {
                switch (msg.what) {
                    case COUNT_DOWN_TIME:
                        int value = msg.arg1;
                        handlerActivity.tvShowCountDownTime.setText(String.valueOf(value--));
                        if (value >= COUNT_DOWN_MIN_TIME) {
                            Message message = Message.obtain();
                            message.what = COUNT_DOWN_TIME;
                            message.arg1 = value;
                            sendMessageDelayed(message, DELAY_MILLIS);
                        }
                        break;
                }
            }
        }
    }
}

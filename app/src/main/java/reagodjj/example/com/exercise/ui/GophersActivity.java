package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Random;

import reagodjj.example.com.exercise.R;

public class GophersActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    public static final int NEXT_GOPHER = 1;
    private ImageView ivGophers;
    private Button btStartGame;
    private TextView tvShowScore;
    private GophersHandler gophersHandler;

    private int[][] positions = new int[][]{
            {342, 180}, {432, 880},
            {521, 256}, {429, 780},
            {456, 976}, {145, 665},
            {123, 678}, {564, 567},
    };
    private int beatCount = 0, count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gophers);

        initView();
        initListener();
        gophersHandler = new GophersHandler(this);
    }

    private void initView() {
        setTitle(R.string.beat_gophers);
        ivGophers = findViewById(R.id.iv_gophers);
        btStartGame = findViewById(R.id.bt_start_game);
        tvShowScore = findViewById(R.id.tv_show_score);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initListener() {
        btStartGame.setOnClickListener(this);
        ivGophers.setOnTouchListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start_game:
                start();
                break;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        beatCount++;
        ivGophers.setVisibility(View.GONE);
        tvShowScore.setText(String.valueOf(beatCount * 10));
        return false;
    }

    private void start() {
        btStartGame.setText(R.string.in_game);
        btStartGame.setEnabled(false);
        tvShowScore.setText(String.valueOf(beatCount * 10));
        next(0);
    }

    private void next(int delayTime) {
        int position = new Random().nextInt(positions.length);

        Message message = Message.obtain();
        message.what = NEXT_GOPHER;
        message.obj = position;

        gophersHandler.sendMessageDelayed(message, delayTime);
        count++;
    }

    private static class GophersHandler extends Handler {
        static final int MAX_TIME = 2000;
        static final int MAX_COUNT = 10;
        final WeakReference<GophersActivity> gophersActivityWeakReference;

        GophersHandler(GophersActivity gophersActivity) {
            gophersActivityWeakReference = new WeakReference<>(gophersActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            GophersActivity gophersActivity = gophersActivityWeakReference.get();

            switch (msg.what) {
                case NEXT_GOPHER:
                    if (gophersActivity.count == MAX_COUNT) {
                        gophersActivity.clear();
                        return;
                    }
                    int position = (int) msg.obj;

                    //显示下一个地鼠
                    gophersActivity.ivGophers.setX(gophersActivity.positions[position][0]);
                    gophersActivity.ivGophers.setY(gophersActivity.positions[position][1]);
                    gophersActivity.ivGophers.setVisibility(View.VISIBLE);

                    int delayTime = new Random().nextInt(MAX_TIME);
                    gophersActivity.next(delayTime);
                    break;

            }
        }
    }

    private void clear() {
        beatCount = 0;
        count = 0;
        ivGophers.setVisibility(View.GONE);
        btStartGame.setText(R.string.game_begin);
        btStartGame.setEnabled(true);
        Toast.makeText(this, R.string.game_over, Toast.LENGTH_SHORT).show();
    }
}

package reagodjj.example.com.exercise.ui;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import reagodjj.example.com.exercise.R;

public class RadioButtonActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup rgSex;
    private RadioButton rbMale, rbFemale;
    private ImageView ivHappy;
    private ToggleButton tbHappy;
    private SeekBar sbProcess;
    private ProgressBar pbProcess;
    private Button btMaimProcess, btSecondProcess;
    private RatingBar rbRate;
    private TextView tvRate;
    private static final String TAG = "RealgodJJ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        initView();
        initListener();
    }

    private void initListener() {
        rgSex.setOnCheckedChangeListener(this);
        tbHappy.setOnClickListener(this);
        sbProcess.setMax(100);
        sbProcess.setProgress(30);
        sbProcess.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged: " + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onProgressChanged(Start): " + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onProgressChanged(Stop): " + seekBar.getProgress());
            }
        });
        btMaimProcess.setOnClickListener(this);
        btSecondProcess.setOnClickListener(this);
        rbRate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                DecimalFormat df = new DecimalFormat("0.0");
                tvRate.setText(String.format(getResources().getString(R.string.rate_information),
                        df.format(rating), df.format(ratingBar.getStepSize()), fromUser));
            }
        });
    }

    private void initView() {
        rgSex = findViewById(R.id.rg_sex);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        ivHappy = findViewById(R.id.iv_happy);
        tbHappy = findViewById(R.id.tb_happy);
        sbProcess = findViewById(R.id.sb_process);
        pbProcess = findViewById(R.id.pb_process);
        btMaimProcess = findViewById(R.id.bt_main_process);
        btSecondProcess = findViewById(R.id.bt_second_process);
        rbRate = findViewById(R.id.rb_rate);
        tvRate = findViewById(R.id.tv_rate);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_male:
                Toast.makeText(this,
                        String.format(getResources().getString(R.string.sex_choice), rbMale.getText().toString()),
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb_female:
                Toast.makeText(this,
                        String.format(getResources().getString(R.string.sex_choice), rbFemale.getText().toString()),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tb_happy:
                if (tbHappy.isChecked()) {
                    ivHappy.setImageResource(R.mipmap.happy);
                    sbProcess.setThumb(getDrawable(R.mipmap.happy));
                } else {
                    ivHappy.setImageResource(R.mipmap.unhappy);
                    sbProcess.setThumb(getDrawable(R.mipmap.unhappy));
                }
                Toast.makeText(this, tbHappy.getText().toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.bt_main_process:
                pbProcess.incrementProgressBy(10);
                break;

            case R.id.bt_second_process:
                pbProcess.incrementSecondaryProgressBy(5);
                break;
        }
    }
}

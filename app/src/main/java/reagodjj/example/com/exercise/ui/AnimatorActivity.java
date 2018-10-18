package reagodjj.example.com.exercise.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import reagodjj.example.com.exercise.R;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btSetAlpha, btSetScale, btSetTranslate, btSetRotate;
    private ImageView imageChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        imageChanged = findViewById(R.id.iv_change);
        btSetAlpha = findViewById(R.id.bt_set_alpha);
        btSetScale = findViewById(R.id.bt_set_scale);
        btSetTranslate = findViewById(R.id.bt_set_translate);
        btSetRotate = findViewById(R.id.bt_set_rotate);

        btSetAlpha.setOnClickListener(this);
        btSetScale.setOnClickListener(this);
        btSetTranslate.setOnClickListener(this);
        btSetRotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Animation loadAnimation;
        switch (v.getId()) {
            case R.id.bt_set_alpha:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                imageChanged.startAnimation(loadAnimation);
                break;

            case R.id.bt_set_scale:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                imageChanged.startAnimation(loadAnimation);
                break;

            case R.id.bt_set_translate:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                imageChanged.startAnimation(loadAnimation);
                break;

            case R.id.bt_set_rotate:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                imageChanged.startAnimation(loadAnimation);
                break;
        }
    }
}

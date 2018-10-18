package reagodjj.example.com.exercise.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import reagodjj.example.com.exercise.R;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btSetAlpha, btSetScale, btSetTranslate, btSetRotate, btSetContinue1,
            btSetContinue2, btSetFlash, btChangeActivity;
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
        btSetContinue1 = findViewById(R.id.bt_set_continue_1);
        btSetContinue2 = findViewById(R.id.bt_set_continue_2);
        btSetFlash = findViewById(R.id.bt_set_flash);
        btChangeActivity = findViewById(R.id.bt_change_activity);

        btSetAlpha.setOnClickListener(this);
        btSetScale.setOnClickListener(this);
        btSetTranslate.setOnClickListener(this);
        btSetRotate.setOnClickListener(this);
        btSetContinue1.setOnClickListener(this);
        btSetContinue2.setOnClickListener(this);
        btSetFlash.setOnClickListener(this);
        btChangeActivity.setOnClickListener(this);
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

            case R.id.bt_set_continue_1:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                imageChanged.startAnimation(loadAnimation);
                final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.rotate);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imageChanged.startAnimation(loadAnimation2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                break;

            case R.id.bt_set_continue_2:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.continue_anim);
                imageChanged.startAnimation(loadAnimation);
                break;

            case R.id.bt_set_flash:
                AlphaAnimation flashAnimation = new AlphaAnimation(0.1f, 1.0f);
                flashAnimation.setDuration(100);
                flashAnimation.setRepeatCount(10);
                flashAnimation.setRepeatMode(Animation.RESTART);
                imageChanged.startAnimation(flashAnimation);
                break;

            case R.id.bt_change_activity:
                Intent intent = new Intent(AnimatorActivity.this, ChangePageActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
        }
    }
}

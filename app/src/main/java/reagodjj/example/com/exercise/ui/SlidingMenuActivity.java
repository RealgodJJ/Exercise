package reagodjj.example.com.exercise.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import reagodjj.example.com.exercise.R;

public class SlidingMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sliding_menu);
    }
}

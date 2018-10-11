package reagodjj.example.com.exercise.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;

import reagodjj.example.com.exercise.R;
import reagodjj.example.com.exercise.view.MyHorizontalScrollView;

public class SlidingMenuActivity extends Activity {
    private MyHorizontalScrollView myHorizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sliding_menu);

        myHorizontalScrollView = findViewById(R.id.ms_menu);
    }

    public void toggleMenu(View view) {
        myHorizontalScrollView.toggle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}

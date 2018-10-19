package reagodjj.example.com.exercise.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import reagodjj.example.com.exercise.R;

public class LayoutAnimationActivity extends AppCompatActivity {
    private ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);

        lvMain = findViewById(R.id.lv_main);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvMain.setAdapter(adapter);

        LayoutAnimationController lac = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lvMain.setLayoutAnimation(lac);
        lvMain.startLayoutAnimation();
    }
}

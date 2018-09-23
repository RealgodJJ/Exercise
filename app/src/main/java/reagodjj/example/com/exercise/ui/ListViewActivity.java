package reagodjj.example.com.exercise.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reagodjj.example.com.exercise.R;

public class ListViewActivity extends AppCompatActivity {
    private ListView lv_main;
    //    private String[] data = new String[20];
    private List<Map<String, Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv_main = findViewById(R.id.lv_main);
//        for (int i = 0; i < 20; i++) {
//            data[i] = "RealgodJJ -" + i;
//        }
//
//        ArrayAdapter<String> arrayAdapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
//
//        lv_main.setAdapter(arrayAdapter);

        data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> info = new HashMap<>();
            info.put("img", R.mipmap.ic_launcher);
            info.put("title", "这是标题" + i);
            data.add(info);
        }

        SimpleAdapter simpleAdapter =
                new SimpleAdapter(this, data, R.layout.list_item,
                        new String[]{"img", "title"}, new int[]{R.id.iv_item, R.id.tv_item});
        lv_main.setAdapter(simpleAdapter);
    }
}

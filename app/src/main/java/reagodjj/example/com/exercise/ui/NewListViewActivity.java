package reagodjj.example.com.exercise.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import reagodjj.example.com.exercise.R;
import reagodjj.example.com.exercise.adapter.MyBaseAdapter;
import reagodjj.example.com.exercise.entity.Person;

public class NewListViewActivity extends AppCompatActivity {
    private ListView lv_new_main;
    private MyBaseAdapter myBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list_view);

        lv_new_main = findViewById(R.id.lv_new_main);

        final List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person person = new Person(R.mipmap.ic_launcher, "name-" + i);
            personList.add(person);
        }

        myBaseAdapter = new MyBaseAdapter(personList);
        lv_new_main.setAdapter(myBaseAdapter);

        lv_new_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NewListViewActivity.this, "点击了item-" + String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

        lv_new_main.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NewListViewActivity.this, "长按了item-" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                myBaseAdapter.deleteItem(position);
                return true;
            }
        });
    }
}

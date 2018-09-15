package reagodjj.example.com.exercise.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import reagodjj.example.com.exercise.R;
import reagodjj.example.com.exercise.ui.fragment.AFragment;
import reagodjj.example.com.exercise.ui.fragment.BFragment;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvShowUsername, tvActivityShow;
    private EditText etInput;
    private Button btAddA, btAddB, btFragmentShow;
    private AFragment aFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvShowUsername = findViewById(R.id.tv_show_username);
        tvActivityShow = findViewById(R.id.tv_activity_show);
        etInput = findViewById(R.id.et_input);
        btAddA = findViewById(R.id.add_a);
        btAddB = findViewById(R.id.add_b);
        btFragmentShow = findViewById(R.id.bt_fragment_show);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        tvShowUsername.setText(username);

        //Activity向Fragment发送消息
        aFragment = new AFragment();
        String s = "这是初始值";
        Bundle bundle = new Bundle();
        bundle.putString("data", s);
        aFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_content, aFragment).commit();

        aFragment.setDataChangeListener(new DataChangeListener() {
            @Override
            public void onDataChange(String data) {
                tvActivityShow.setText(data);
            }
        });

        btAddA.setOnClickListener(this);
        btAddB.setOnClickListener(this);
        btFragmentShow.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.add_a:
                String s = "这是初始值";
                Bundle bundle = new Bundle();
                bundle.putString("data", s);
                aFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fl_content, aFragment);
                break;
            case R.id.add_b:
                fragmentTransaction.replace(R.id.fl_content, new BFragment());
                break;
            case R.id.bt_fragment_show:
                aFragment.setData(etInput.getText().toString());
                break;
        }
        fragmentTransaction.commit();
    }
}

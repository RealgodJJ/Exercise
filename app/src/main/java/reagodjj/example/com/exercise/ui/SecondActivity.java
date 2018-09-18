package reagodjj.example.com.exercise.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import reagodjj.example.com.exercise.Listener.DataChangeListener;
import reagodjj.example.com.exercise.R;
import reagodjj.example.com.exercise.ui.fragment.AFragment;

public class SecondActivity extends AppCompatActivity {
    private TextView tvShowUsername;
    private Button btAddA, btAddB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvShowUsername = findViewById(R.id.tv_show_username);
        btAddA = findViewById(R.id.add_a);
        btAddB = findViewById(R.id.add_b);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        tvShowUsername.setText(username);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        btAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.fl_content, new AFragment());
                fragmentTransaction.commit();
            }
        });

        btAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.fl_content, new AFragment());
                fragmentTransaction.commit();
            }
        });
    }
}

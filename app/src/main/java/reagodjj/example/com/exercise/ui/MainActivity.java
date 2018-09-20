package reagodjj.example.com.exercise.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import reagodjj.example.com.exercise.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RealgodJJ";
    private TextView tvHello;
    private EditText etUsername, etPassword;
    private Button btLogin, btRegister, btViewPager, btFragmentViewPager, btHandler, btConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        tvHello = findViewById(R.id.tv_hello);
        etUsername = findViewById(R.id.et_user);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);
        btRegister = findViewById(R.id.bt_register);
        btViewPager = findViewById(R.id.bt_view_pager);
        btFragmentViewPager = findViewById(R.id.bt_fragment_view_pager);
        btHandler = findViewById(R.id.bt_handler);
        btConnection = findViewById(R.id.bt_connection);

        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
        btViewPager.setOnClickListener(this);
        btFragmentViewPager.setOnClickListener(this);
        btHandler.setOnClickListener(this);
        btConnection.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                Intent intent_login = new Intent(MainActivity.this, SecondActivity.class);
                intent_login.putExtra("username", etUsername.getText().toString());
                startActivity(intent_login);
                break;

            case R.id.bt_register:
                Intent intent_register = new Intent(MainActivity.this, RegisterActivity.class);
                intent_register.setAction("reagodjj.example.com.exercise.register");
                startActivityForResult(intent_register, 1);
                break;

            case R.id.bt_view_pager:
                Intent intent_view = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent_view);
                break;

            case R.id.bt_fragment_view_pager:
                Intent intent_fragment_view = new Intent(MainActivity.this, FragmentViewPagerActivity.class);
                startActivity(intent_fragment_view);
                break;

            case R.id.bt_handler:
                Intent intent_handler = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent_handler);
                break;

            case R.id.bt_connection:
                Intent intent_connection = new Intent(MainActivity.this, HTTPURLConnectionActivity.class);
                startActivity(intent_connection);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String username = data.getStringExtra("username");
        String password = data.getStringExtra("password");
        etUsername.setText(username);
        etPassword.setText(password);
    }

    public void changeText(View view) {
//        tvHello.setText(R.string.new_word);
        String text = etPassword.getText().toString();
        tvHello.setText(text);
    }
}

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        tvHello = findViewById(R.id.tv_hello);
        etUsername = findViewById(R.id.et_user);
        etPassword = findViewById(R.id.et_password);
        Button btLogin = findViewById(R.id.bt_login);
        Button btRegister = findViewById(R.id.bt_register);
        Button btViewPager = findViewById(R.id.bt_view_pager);
        Button btFragmentViewPager = findViewById(R.id.bt_fragment_view_pager);
        Button btHandler = findViewById(R.id.bt_handler);
        Button btConnection = findViewById(R.id.bt_connection);
        Button btListView = findViewById(R.id.bt_list_view);
        Button btNewListView = findViewById(R.id.bt_new_list_view);
        Button btService = findViewById(R.id.bt_service);
        Button btBroadcast = findViewById(R.id.bt_broadcast);
        Button btContentProvider = findViewById(R.id.bt_content_provider);
        Button btSlideMenu = findViewById(R.id.bt_slide_menu);
        Button btSetAnimator = findViewById(R.id.bt_set_animator);
        Button btSetRadioButton = findViewById(R.id.bt_set_radio_button);
        Button btSetOptionMenu = findViewById(R.id.bt_set_option_menu);
        Button btSetContextMenu = findViewById(R.id.bt_set_context_menu);
        Button btSetHandler = findViewById(R.id.bt_set_handler);
        Button btBeatGophers = findViewById(R.id.bt_beat_gophers);

        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
        btViewPager.setOnClickListener(this);
        btFragmentViewPager.setOnClickListener(this);
        btHandler.setOnClickListener(this);
        btConnection.setOnClickListener(this);
        btListView.setOnClickListener(this);
        btNewListView.setOnClickListener(this);
        btService.setOnClickListener(this);
        btBroadcast.setOnClickListener(this);
        btContentProvider.setOnClickListener(this);
        btSlideMenu.setOnClickListener(this);
        btSetAnimator.setOnClickListener(this);
        btSetRadioButton.setOnClickListener(this);
        btSetOptionMenu.setOnClickListener(this);
        btSetContextMenu.setOnClickListener(this);
        btSetHandler.setOnClickListener(this);
        btBeatGophers.setOnClickListener(this);
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

            case R.id.bt_list_view:
                Intent intent_list_view = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent_list_view);

            case R.id.bt_new_list_view:
                Intent intent_new_list_view = new Intent(MainActivity.this, NewListViewActivity.class);
                startActivity(intent_new_list_view);
                break;

            case R.id.bt_service:
                Intent intent_service = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent_service);
                break;

            case R.id.bt_broadcast:
                Intent intent_broadcast = new Intent(MainActivity.this, BroadcastActivity.class);
                startActivity(intent_broadcast);
                break;

            case R.id.bt_content_provider:
                Intent intent_content_provider = new Intent(MainActivity.this, ContentProviderActivity.class);
                startActivity(intent_content_provider);
                break;

            case R.id.bt_slide_menu:
                Intent intent_slide_menu = new Intent(MainActivity.this, SlidingMenuActivity.class);
                startActivity(intent_slide_menu);
                break;

            case R.id.bt_set_animator:
                Intent intent_set_animator = new Intent(MainActivity.this, AnimatorActivity.class);
                startActivity(intent_set_animator);
                break;

            case R.id.bt_set_radio_button:
                Intent intent_set_radio_button = new Intent(MainActivity.this, RadioButtonActivity.class);
                startActivity(intent_set_radio_button);
                break;

            case R.id.bt_set_option_menu:
                Intent intent_set_menu = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent_set_menu);
                break;

            case R.id.bt_set_context_menu:
                Intent intent_set_context_menu = new Intent(MainActivity.this, TableAndGridActivity.class);
                startActivity(intent_set_context_menu);
                break;

            case R.id.bt_set_handler:
                Intent intent_set_handler = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intent_set_handler);
                break;

            case R.id.bt_beat_gophers:
                Intent intent_beat_gophers = new Intent(MainActivity.this, GophersActivity.class);
                startActivity(intent_beat_gophers);
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
        String text = etPassword.getText().toString();
        tvHello.setText(text);
    }
}

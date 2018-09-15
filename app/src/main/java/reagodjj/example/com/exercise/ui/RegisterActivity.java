package reagodjj.example.com.exercise.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import reagodjj.example.com.exercise.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.et_register_username);
        etPassword = findViewById(R.id.et_register_password);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("username", username).putExtra("password", password);
                setResult(1, intent);
                finish();
            }
        });
    }
}

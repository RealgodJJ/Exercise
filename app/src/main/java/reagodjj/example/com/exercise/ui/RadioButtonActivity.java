package reagodjj.example.com.exercise.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import reagodjj.example.com.exercise.R;

public class RadioButtonActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rgSex;
    private RadioButton rbMale, rbFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        rgSex = findViewById(R.id.rg_sex);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        rgSex.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_male:
                Toast.makeText(this,
                        String.format(getResources().getString(R.string.sex_choice), rbMale.getText().toString()),
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb_female:
                Toast.makeText(this,
                        String.format(getResources().getString(R.string.sex_choice), rbFemale.getText().toString()),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

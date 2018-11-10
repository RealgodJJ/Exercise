package reagodjj.example.com.exercise.ui;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.Button;

import reagodjj.example.com.exercise.R;

public class MyDialog extends Dialog {

    //参数2：制定对话框的样式风格
    MyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.diy_dialog);

        Button yesBtn = findViewById(R.id.yes_btn);
        Button noBtn = findViewById(R.id.no_btn);

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();      //控制对话框消失
            }
        });
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}

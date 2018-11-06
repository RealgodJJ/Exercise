package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

import reagodjj.example.com.exercise.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    /**
     * 设置菜单栏可添加图标
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    @SuppressLint("PrivateApi") Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        menu.getItem(0).setIcon(R.mipmap.save);
        menu.getItem(1).setIcon(R.mipmap.settings);
        menu.getItem(2).setIcon(R.mipmap.more);
        menu.getItem(3).setIcon(R.mipmap.exit);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.i_save:
                Toast.makeText(MenuActivity.this, R.string.save, Toast.LENGTH_SHORT).show();
                break;

            case R.id.i_settings:
                Toast.makeText(MenuActivity.this, R.string.settings, Toast.LENGTH_SHORT).show();
                break;

            case R.id.i_more:
                Toast.makeText(MenuActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                break;

            case R.id.i_exit:
                Toast.makeText(MenuActivity.this, R.string.exit, Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.i_more_1:
                Toast.makeText(MenuActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                break;

            case R.id.i_more_2:
                Toast.makeText(MenuActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

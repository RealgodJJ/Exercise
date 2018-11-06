package reagodjj.example.com.exercise.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;


import reagodjj.example.com.exercise.R;

public class TableAndGridActivity extends AppCompatActivity {
    private Button btContextMenu, btPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_and_grid);
//        registerForContextMenu(findViewById(R.id.bt_context_menu));

        btContextMenu = findViewById(R.id.bt_context_menu);
        btPopupMenu = findViewById(R.id.bt_popup_menu);

        btContextMenu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActionMode(cb);
                return false;
            }
        });

        btPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(TableAndGridActivity.this, btPopupMenu);
                popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.i_save:
                                Toast.makeText(TableAndGridActivity.this, R.string.save, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.i_settings:
                                Toast.makeText(TableAndGridActivity.this, R.string.settings, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.i_more:
                                Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.i_exit:
                                Toast.makeText(TableAndGridActivity.this, R.string.exit, Toast.LENGTH_SHORT).show();
                                finish();
                                break;

                            case R.id.i_more_1:
                                Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.i_more_2:
                                Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.option_menu, menu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.i_save:
//                Toast.makeText(TableAndGridActivity.this, R.string.save, Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.i_settings:
//                Toast.makeText(TableAndGridActivity.this, R.string.settings, Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.i_more:
//                Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.i_exit:
//                Toast.makeText(TableAndGridActivity.this, R.string.exit, Toast.LENGTH_SHORT).show();
//                finish();
//                break;
//
//            case R.id.i_more_1:
//                Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.i_more_2:
//                Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }

    ActionMode.Callback cb = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.option_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.i_save:
                    Toast.makeText(TableAndGridActivity.this, R.string.save, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.i_settings:
                    Toast.makeText(TableAndGridActivity.this, R.string.settings, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.i_more:
                    Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.i_exit:
                    Toast.makeText(TableAndGridActivity.this, R.string.exit, Toast.LENGTH_SHORT).show();
                    finish();
                    break;

                case R.id.i_more_1:
                    Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.i_more_2:
                    Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };
}

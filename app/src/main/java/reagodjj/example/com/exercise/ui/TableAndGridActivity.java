package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

import reagodjj.example.com.exercise.R;

public class TableAndGridActivity extends AppCompatActivity {
    private Button btContextMenu, btPopupMenu, btNormalDialog, btNormalDialog1, btListDialog,
            btSingleChoiceDialog, btMultiChoiceDialog, btProgressDialog, btProgressHorizontalDialog,
            btInputDialog, btDiyDialog, btArrayDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_and_grid);
//        registerForContextMenu(findViewById(R.id.bt_context_menu));

        btContextMenu = findViewById(R.id.bt_context_menu);
        btPopupMenu = findViewById(R.id.bt_popup_menu);
        btNormalDialog = findViewById(R.id.bt_normal_dialog);
        btNormalDialog1 = findViewById(R.id.bt_normal_dialog1);
        btListDialog = findViewById(R.id.bt_list_dialog);
        btSingleChoiceDialog = findViewById(R.id.bt_single_choice_dialog);
        btMultiChoiceDialog = findViewById(R.id.bt_multi_choice_dialog);
        btProgressDialog = findViewById(R.id.bt_progress_dialog);
        btProgressHorizontalDialog = findViewById(R.id.bt_progress_horizontal_dialog);
        btInputDialog = findViewById(R.id.bt_input_dialog);
        btDiyDialog = findViewById(R.id.bt_diy_dialog);
        btArrayDialog = findViewById(R.id.bt_array_dialog);

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

        btNormalDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TableAndGridActivity.this);
                builder.setTitle(R.string.exit).setMessage(R.string.ask_exit)
                        .setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, null)
                        .setNeutralButton(R.string.exit, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
            }
        });

        btNormalDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(TableAndGridActivity.this).create();
                alertDialog.setTitle("提示");
                alertDialog.setMessage("请为本次课堂打分");
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "5分", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TableAndGridActivity.this, "5分", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "3分", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TableAndGridActivity.this, "3分", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        btListDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String items[] = {"项目1", "项目2", "项目3", "项目4"};
                AlertDialog.Builder builder = new AlertDialog.Builder(TableAndGridActivity.this);
                builder.setTitle("FUCK").setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TableAndGridActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        btSingleChoiceDialog.setOnClickListener(new View.OnClickListener() {
            int index = 0;

            @Override
            public void onClick(View v) {
                final String stars[] = {"林俊杰", "周杰伦", "Derrick Rose", "江疏影"};
                AlertDialog.Builder builder = new AlertDialog.Builder(TableAndGridActivity.this);
                builder.setTitle("您最喜欢的明星是：").setSingleChoiceItems(stars, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        index = which;
                    }
                }).setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TableAndGridActivity.this, stars[index], Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        btMultiChoiceDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String sports[] = {"篮球", "保龄球", "乒乓球", "羽毛球", "游泳", "跑步"};
                final boolean checked[] = {true, true, true, true, false, false};
                AlertDialog.Builder builder = new AlertDialog.Builder(TableAndGridActivity.this);
                builder.setTitle("您喜欢的运动：").setMultiChoiceItems(sports, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //Do nothing(checked = isChecked)
                    }
                }).setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder msg = new StringBuilder("您喜欢的运动：");
                        for (int i = 0; i < checked.length; i++) {
                            if (checked[i]) {
                                msg.append(sports[i]).append(" ");
                            }
                        }
                        Toast.makeText(TableAndGridActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        btProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(TableAndGridActivity.this);
                progressDialog.setTitle("我是一个等待对话框");
                progressDialog.setMessage("请等待......");
                progressDialog.setCancelable(false);//默认是true，即不可手动取消
                progressDialog.show();

                //3秒后自动关闭
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        progressDialog.dismiss();
                    }
                }, 3000);

            }
        });

        btProgressHorizontalDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(TableAndGridActivity.this);
                progressDialog.setTitle("");
                progressDialog.setMessage("资源加载中......");
                progressDialog.setCancelable(true);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(50);
                                progressDialog.setProgress(i);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        progressDialog.dismiss();
                    }
                }).start();
            }
        });

        btInputDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(TableAndGridActivity.this);
                AlertDialog.Builder builder = new AlertDialog.Builder(TableAndGridActivity.this);
                builder.setTitle("请输入您的姓名：").setView(editText)
                        .setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(TableAndGridActivity.this,
                                        "欢迎您，" + editText.getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        btDiyDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog myDialog = new MyDialog(TableAndGridActivity.this, R.style.myDialog);
                myDialog.show();
            }
        });

        btArrayDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String items[] = {"Java", "Mysql", "Android", "HTML", "C", "JavaScript"};
                //默认操作方式
//                ArrayAdapter adapter = new ArrayAdapter(TableAndGridActivity.this,
//                        android.R.layout.simple_dropdown_item_1line, items);
                //自定义选项方式
                ArrayAdapter adapter = new ArrayAdapter(TableAndGridActivity.this,
                        R.layout.array_item_layout, R.id.tv_text, items);
                AlertDialog.Builder builder = new AlertDialog.Builder(TableAndGridActivity.this);
                builder.setTitle("请选择").setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TableAndGridActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
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
        menu.add(1, 1, 1, R.string.settings).setIcon(R.mipmap.settings);
        SubMenu subMenu = menu.addSubMenu(1, 2, 2, R.string.more).setIcon(R.mipmap.more);
        subMenu.add(2, 3, 1, R.string.more1).setIcon(R.mipmap.more1);
        subMenu.add(2, 4, 2, R.string.more2).setIcon(R.mipmap.more2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(TableAndGridActivity.this, R.string.settings, Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(TableAndGridActivity.this, R.string.more, Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(TableAndGridActivity.this, R.string.more1, Toast.LENGTH_SHORT).show();
                break;

            case 4:
                Toast.makeText(TableAndGridActivity.this, R.string.more2, Toast.LENGTH_SHORT).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
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
                    Toast.makeText(TableAndGridActivity.this, R.string.more1, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.i_more_2:
                    Toast.makeText(TableAndGridActivity.this, R.string.more2, Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
        }
    };
}

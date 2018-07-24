package com.smailnet.demo;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smailnet.islands.BaseDialog;
import com.smailnet.islands.Islands;
import com.smailnet.islands.OnClickListener;
import com.smailnet.islands.OnEditDialogListener;
import com.smailnet.islands.OnMultiChoiceClickListener;
import com.smailnet.islands.OnRunningListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        Button button_0 = findViewById(R.id.bt_0);
        Button button_1 = findViewById(R.id.bt_1);
        Button button_2 = findViewById(R.id.bt_2);
        Button button_3 = findViewById(R.id.bt_3);
        Button button_4 = findViewById(R.id.bt_4);
        Button button_5 = findViewById(R.id.bt_5);
        Button button_6 = findViewById(R.id.bt_6);

        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_0:
                new Islands.OrdinaryDialog(this)
                        .setText(null, "当前网络连接异常，请稍后再尝试")
                        .setButton("关闭", null, null)
                        .click()
                        .show();
                break;
            case R.id.bt_1:
                new Islands.OrdinaryDialog(this)
                        .setText("发现新版本", "修复已知漏洞")
                        .setButton("立即更新", "暂不更新", "不再提示")
                        .setCancelable(false)
                        .click(new OnClickListener() {
                            @Override
                            public void onClick(int which) {
                                if (0 == which){
                                    Toast.makeText(MainActivity.this, "立即更新", Toast.LENGTH_SHORT).show();
                                }else if (1 == which){
                                    Toast.makeText(MainActivity.this, "暂不更新", Toast.LENGTH_SHORT).show();
                                }else if (2 == which){
                                    Toast.makeText(MainActivity.this, "不再提示", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .show();
                break;
            case R.id.bt_2:
                final String items_1[] = {"语文", "数学", "英语", "物理", "化学", "生物"};
                new Islands.ListDialog(this)
                        .setItem(items_1, new OnClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, items_1[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setText("选择你最喜欢的一个科目", null)
                        .show();
                break;
            case R.id.bt_3:
                final String items_2[] = {"男", "女", "保密"};
                new Islands.SingleChoiceDialog(this)
                        .setSingleChoiceItems(items_2, 2, new OnClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, items_2[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setText("性别", null)
                        .show();
                break;
            case R.id.bt_4:
                final String items_3[] = {"语文", "数学", "英语", "物理", "化学", "生物"};
                final  boolean checkeditems[] = {true, false, true, false, true, false};
                new Islands.MultiChoiceDialog(this)
                        .setMultiChoiceItems(items_3, checkeditems, new OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(int which, boolean isChecked) {

                            }
                        })
                        .setText("选择你喜欢的科目", null)
                        .setButton("确定", "取消", null)
                        .click()
                        .show();
                break;
            case R.id.bt_5:
                new Islands.EditDialog(this)
                        .setEditTextHint("1-16个字符")
                        .setText("修改昵称", null)
                        .setButton("保存", "取消", null)
                        .click(new OnEditDialogListener() {
                            @Override
                            public void getText(String text, int which) {
                                if (0 == which){
                                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .show();
                break;
            case R.id.bt_6:
                new Islands.CircularProgress(this)
                        .setMessage("加载中...")
                        .setCancelable(false)
                        .show()
                        .run(new OnRunningListener() {
                            @Override
                            public void onRunning(final ProgressDialog dialog) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        dialog.dismiss();
                                    }
                                }, 5000);
                            }
                        });
                break;
        }
    }
}

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
                //普通消息提示对话框，只用于提示信息给用户，并不会处理其他事件
                new Islands.OrdinaryDialog(this)
                        //第一个参数对话框的Title，第二个参数是对话框的Message，若不设置标题传入参数null
                        .setText(null, "当前网络连接异常，请稍后再尝试")
                        //分别设置对话框positiveButton，negativeButton，neutralButton的名称，不需要显
                        //示的按钮，传入参数null
                        .setButton("关闭", null, null)
                        //只显示提示信息，不处理事件，调用.click()，注：先.setButton()后.click()
                        .click()
                        .show();        //显示对话框
                break;
            case R.id.bt_1:
                //普通消息对话框
                new Islands.OrdinaryDialog(this)
                        .setText("发现新版本", "修复已知漏洞")
                        .setButton("立即更新", "暂不更新", "不再提示")
                        .setCancelable(false)
                        .click(new OnClickListener() {
                            @Override
                            public void onClick(int which) {
                                //点击对话框按钮响应回调
                                //点击positiveButton，which为0
                                //点击negativeButton，which为1
                                //点击neutralButton，which为2
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
                //设置一组字符串数组
                final String listItems[] = {"语文", "数学", "英语", "物理", "化学", "生物"};
                //列表对话框
                new Islands.ListDialog(this)
                        //设置列表对话框的items
                        .setItem(listItems, new OnClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, listItems[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        //设置对话框第一个参数Title，第二个参数Message必须为null，否则列表对话框不显示
                        .setText("选择一个科目", null)
                        .show();
                break;
            case R.id.bt_3:
                //设置一组字符串数组和默认选中的item
                final String singleItems[] = {"男", "女", "保密"};
                int checkeditem = 2;
                //单选对话框
                new Islands.SingleChoiceDialog(this)
                        .setSingleChoiceItems(singleItems, checkeditem, new OnClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, singleItems[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setText("性别", null)
                        .show();
                break;
            case R.id.bt_4:
                //设置一组字符串数组和默认选中的items
                final String items_3[] = {"语文", "数学", "英语", "物理", "化学", "生物"};
                final  boolean checkeditems[] = {true, false, true, false, true, false};
                //多选对话框
                new Islands.MultiChoiceDialog(this)
                        .setMultiChoiceItems(items_3, checkeditems, new OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(int which, boolean isChecked) {

                            }
                        })
                        .setText("选择多个科目", null)
                        .setButton("确定", "取消", null)
                        .click()
                        .show();
                break;
            case R.id.bt_5:
                //编辑对话框
                new Islands.EditDialog(this)
                        .setEditTextHint("1-16个字符")         //文本提示，参数可以为null
                        .setText("修改昵称", null)
                        .setCancelable(false)
                        .setButton("保存", "取消", null)
                        .click(new OnEditDialogListener() {
                            @Override
                            public void getText(String text, int which) {
                                if (0 == which){
                                    //回调获得用户输入的text，which判断用户点击了哪个按钮
                                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .show();
                break;
            case R.id.bt_6:
                //圆形进度条对话框
                new Islands.CircularProgress(this)
                        .setMessage("加载中...")             //设置提示信息
                        .setCancelable(false)               //设置是否可以取消
                        .show()                             //显示进度条对话框
                        .run(new OnRunningListener() {      //先.show()后.run()
                            @Override
                            public void onRunning(final ProgressDialog dialog) {
                                //这里写处理事件逻辑，处理完毕调用dialog.dismiss();关闭对话框。
                                //例如下面代码延时5s关闭进度条对话框。
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

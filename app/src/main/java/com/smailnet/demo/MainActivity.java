package com.smailnet.demo;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.smailnet.islands.Islands;
import com.smailnet.islands.Interface.OnClickListener;
import com.smailnet.islands.Interface.OnDateSelectListener;
import com.smailnet.islands.Interface.OnEditListener;
import com.smailnet.islands.Interface.OnListItemClickListener;
import com.smailnet.islands.Interface.OnMultiChoiceClickListener;
import com.smailnet.islands.Interface.OnRunningListener;
import com.smailnet.islands.Interface.OnSingeChoiceListener;
import com.smailnet.islands.Interface.OnTimeSelectListener;
import com.smailnet.islands.Utils.SelectDate;
import com.smailnet.islands.Utils.SelectTime;

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
        Button button_7 = findViewById(R.id.bt_7);
        Button button_8 = findViewById(R.id.bt_8);

        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_0:
                //普通消息提示对话框，只用于提示信息给用户，并不会处理其他事件
                Islands.ordinaryDialog(this)
                        .setText(null, "当前网络连接异常，请稍后再尝试")
                        .setButton("关闭", null, null)
                        .show();
                break;
            case R.id.bt_1:
                //普通消息对话框
                Islands.ordinaryDialog(this)
                        .setText("发现新版本", "修复已知漏洞")
                        .setCancelable(false)
                        .setButton("立即更新", "暂不更新", "不再提示", new OnClickListener() {
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
                        }).show();
                break;
            case R.id.bt_2:
                //设置一组字符串数组
                final String listItems[] = {"语文", "数学", "英语", "物理", "化学", "生物"};
                //列表对话框
                Islands.listDialog(this)
                        .setCancelable(false)
                        .setText("选择一个科目")                                 //设置Title
                        .setItems(listItems, new OnListItemClickListener() {    //设置列表对话框的items
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, listItems[which], Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                break;
            case R.id.bt_3:
                //设置一组字符串数组和默认选中的item
                final String singleItems[] = {"男", "女", "保密"};
                //单选对话框
                Islands.singleChoiceDialog(this)
                        .setText("性别")
                        .setCancelable(false)
                        .setSingleChoiceItems(singleItems, 2, new OnSingeChoiceListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, singleItems[which], Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                break;
            case R.id.bt_4:
                //多选对话框
                final String multiItems[] = new String[]{"语文", "数学", "英语", "物理", "化学", "生物"};
                final boolean checkedItems[] = new boolean[]{true, false, true, false, true, false};
                Islands.multiChoiceDialog(this)
                        .setItems(multiItems)
                        .setCheckedItems(checkedItems)
                        .setText("选择多个科目")
                        .setButton("确定", "取消", null, new OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(String[] items, boolean[] checkedItems) {
                                for (int i = 0; i < checkedItems.length; i++){
                                    if (checkedItems[i]){
                                        Log.i("oversee", items[i]);
                                    }
                                }
                            }
                        }).show();
                break;
            case R.id.bt_5:
                //编辑对话框
                Islands.editDialog(this)
                        .setEditText("百年小糊涂")
                        .setEditTextHint("1-16个字符")
                        .setText("修改昵称", null)
                        .setCancelable(false)
                        .setButton("保存", "取消", null, new OnEditListener() {
                            @Override
                            public void getText(String text, int which) {
                                if (0 == which){
                                    //回调获得用户输入的text，which判断用户点击了哪个按钮
                                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).show();
                break;
            case R.id.bt_6:
                //圆形进度条对话框
                Islands.circularProgress(this)
                        .setMessage("加载中...")             //设置提示信息
                        .setCancelable(false)               //设置是否可以取消
                        .run(new OnRunningListener() {
                            @Override
                            public void onRunning(final ProgressDialog dialog) {
                                //这里写处理事件逻辑，处理完毕调用dialog.dismiss();关闭对话框。
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        dialog.dismiss();
                                    }
                                }, 5000);
                            }
                        }).show();
                break;
            case R.id.bt_7:
                //日历对话框
                Islands.dateDialog(this)
                        .select(new OnDateSelectListener() {                //选择日期
                            @Override
                            public void OnDateSelect(SelectDate date) {     //得到结果
                                Log.e("oversee", date.getYear() + "年" + date.getMonth() + "月" + date.getDay() + "日");
                            }
                        }).show();
                break;
            case R.id.bt_8:
                //时钟对话框
                Islands.timeDialog(this)
                        .select(new OnTimeSelectListener() {                //选择时间
                            @Override
                            public void onTimeSelect(SelectTime time) {     //得到结果
                                Log.e("oversee", time.getHour() + "时" + time.getMinute() + "分");
                            }
                        }).show();
                break;
        }
    }
}

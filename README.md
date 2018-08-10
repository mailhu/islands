<img src="https://github.com/mailhu/islands/blob/master/app/src/main/res/drawable-xxhdpi/logo.png"  height="80" width="80">

# Islands
[![](https://jitpack.io/v/mailhu/islands.svg)](https://jitpack.io/#mailhu/islands)

Islands是Android一个已对原生对话框进行封装的工具库。其中包括普通对话框、列表对话框、单选对话框、多选对话框、编辑对话框、进度条对话框、日历对话框，时钟对话框。只需简单的调用，即快速创建对话框。
</br></br></br>

# Screenshot
<img src="https://github.com/mailhu/islands/blob/master/image/image_1.png"  height="384" width="216"><img src="https://github.com/mailhu/islands/blob/master/image/image_2.png"  height="384" width="216"><img src="https://github.com/mailhu/islands/blob/master/image/image_3.png"  height="384" width="216"><img src="https://github.com/mailhu/islands/blob/master/image/image_7.png"  height="384" width="216">
<img src="https://github.com/mailhu/islands/blob/master/image/image_8.png"  height="384" width="216"><img src="https://github.com/mailhu/islands/blob/master/image/image_9.png"  height="384" width="216"><img src="https://github.com/mailhu/islands/blob/master/image/image_4.png"  height="384" width="216"><img src="https://github.com/mailhu/islands/blob/master/image/image_5.png"  height="384" width="216">


更多示例截图，请[点击这里](https://github.com/mailhu/islands/tree/master/image)
</br></br></br>

# Update log
1. 重构Islands内部代码
2. 完善多选列表对话框接口

</br></br></br>

# Install
## 远程下载 JitPack 的仓库里的
步骤一，将 JitPack 存储库添加到构建文件中：
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
步骤二，在项目的app模块下的build.gradle里加：
```gradle
dependencies {
    implementation 'com.github.mailhu:islands:2.0'
}
```
</br></br></br>

# How do I use Islands?
使用教程的讲解先易后难
##### 一、创建圆形进度条对话框
```java
//圆形进度条对话框
Islands
        .circularProgress(this)
        .setMessage("加载中...")            //设置提示信息
        .setCancelable(false)               //设置是否可以取消
        .show()                             //显示进度条对话框
        .run(new OnRunningListener() {      //先.show()后.run()
            @Override
            public void onRunning(final ProgressDialog dialog) {
                //这里写处理事件逻辑，处理完毕调用dialog.dismiss();
                //dialog.dismiss();
            }
        });
```

##### 二、创建普通消息提示对话框，只用于提示信息给用户，并不会处理其他事件
```java
//普通消息提示对话框
Islands
        .ordinaryDialog(this)
        .setText(null, "当前网络连接异常，请稍后再尝试")           //设置Title和Message
        .setButton("关闭", null, null)                          //设置按钮名称
        .click()        //只显示提示信息，不处理事件，调用.click()，注：先.setButton()后.click()
        .show();        //显示对话框

```

##### 三、创建普通消息对话框
```java
//普通消息对话框
Islands
        .ordinaryDialog(this)
        .setText("发现新版本", "修复已知漏洞")
        .setCancelable(false)
        .setButton("立即更新", "暂不更新", "不再提示")
        .click(new OnClickListener() {
            @Override
            public void onClick(int which) {
                //点击positiveButton、negativeButton、neutralButton，which的值分别为0、1，2。
                if (0 == which){
                    Toast.makeText(MainActivity.this, "立即更新", Toast.LENGTH_SHORT).show();
                }else if (1 == which){
                    Toast.makeText(MainActivity.this, "暂不更新", Toast.LENGTH_SHORT).show();
                }else if (2 == which){
                    Toast.makeText(MainActivity.this, "不再提示", Toast.LENGTH_SHORT).show();
                }
            }
        }).show();
```

##### 四、创建列表对话框
```java
//设置一组字符串数组
final String listItems[] = {"语文", "数学", "英语", "物理", "化学", "生物"};
//列表对话框
Islands
        .listDialog(this)
        .setCancelable(false)
        .setText("选择一个科目", null)        //设置Title，Message必须为null，否则列表对话框不显示
        .setItems(listItems)                 //设置列表对话框的items
        .click(new OnListItemClickListener() {
            @Override
            public void onClick(int which) {
                Toast.makeText(MainActivity.this, listItems[which], Toast.LENGTH_SHORT).show();
            }
        }).show();
```

##### 五、创建单选对话框
```java
//设置一组字符串数组
final String singleItems[] = {"男", "女", "保密"};
//单选对话框
Islands
        .singleChoiceDialog(this)
        .setText("性别", null)
        .setCancelable(false)
        .setItems(singleItems)
        .setCheckedItem(2)
        .click(new OnSingeChoiceListener() {
            @Override
            public void onClick(int which) {
                Toast.makeText(MainActivity.this, singleItems[which], Toast.LENGTH_SHORT).show();
            }
        }).show();
```

##### 六、创建编辑对话框
```java
//编辑对话框
Islands
        .editDialog(this)
        .setEditText("小学生")
        .setEditTextHint("1-16个字符")         //文本提示，参数可以为null
        .setText("修改昵称", null)
        .setCancelable(false)
        .setButton("保存", "取消", null)
        .click(new OnEditListener() {
            @Override
            public void getText(String text, int which) {
                if (0 == which){
                    //回调获得用户输入的text，which判断用户点击了哪个按钮
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            }
        }).show();
```

##### 七、创建多选对话框(改接口设计不完善，谨慎使用)
```java
//多选对话框
Islands
        .multiChoiceDialog(this)
        .setItems(new String[]{"语文", "数学", "英语", "物理", "化学", "生物"})
        .setCheckedItems(new boolean[]{true, false, true, false, true, false})
        .setText("选择多个科目", null)
        .setButton("确定", "取消", null)
        .click(new OnMultiChoiceClickListener() {
            @Override
            public void onClick(String[] items, boolean[] checkedItems) {
                for (int i = 0; i < checkedItems.length; i++){
                    if (checkedItems[i]){
                        Log.i("oversee", items[i]);
                    }
                }
            }
        }).show();
```

##### 八、创建日期对话框
```java
//日历对话框
Islands
        .dateDialog(this)
        .select(new OnDateSelectListener() {                //选择日期
            @Override
            public void OnDateSelect(SelectDate date) {
                Log.e("oversee", date.getYear() + "年" + date.getMonth() + "月" + date.getDay() + "日");
            }
        }).show();
```

##### 九、创建时钟对话框
```java
//时钟对话框
Islands
        .timeDialog(this)
        .select(new OnTimeSelectListener() {                //选择时间
            @Override
            public void onTimeSelect(SelectTime time) {
                Log.e("oversee", time.getHour() + "时" + time.getMinute() + "分");
            }
        }).show();
```
</br></br></br>

# Link
Islands使用示例，请[点击这里](https://github.com/mailhu/islands/blob/master/app/src/main/java/com/smailnet/demo/MainActivity.java)
</br></br></br>

# License
```
Copyright 2018 Lake Zhang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
/*
 * Copyright 2018 Lake Zhang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smailnet.islands;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.smailnet.islands.Dialog.CircularProgress;
import com.smailnet.islands.Dialog.DateDialog;
import com.smailnet.islands.Dialog.EditDialog;
import com.smailnet.islands.Dialog.ListDialog;
import com.smailnet.islands.Dialog.MultiChoiceDialog;
import com.smailnet.islands.Dialog.OrdinaryDialog;
import com.smailnet.islands.Dialog.SingleChoiceDialog;
import com.smailnet.islands.Dialog.TimeDialog;

import java.util.Date;

/**
 * Islands是Android一个已对原生对话框进行封装的工具库。
 * 其中包括普通对话框，列表对话框，单选对话框，多选对话框，
 * 编辑对话框，进度条对话框。只需只需简单的调用，即快速创
 * 建对话框。
 *
 * @author 张观湖
 * @author E-mail: zguanhu@foxmail.com
 * @version 1.1
 */
public class Islands{

    /**
     *普通对话框
     */
    public static OrdinaryDialog ordinaryDialog(Context context){
        return new OrdinaryDialog(context);
    }

    /**
     * 列表对话框
     */
    public static ListDialog listDialog(Context context){
        return new ListDialog(context);
    }

    /**
     * 单选对话框
     */
    public static SingleChoiceDialog singleChoiceDialog(Context context) {
        return new SingleChoiceDialog(context);
    }

    /**
     * 多选对话框
     */
    public static MultiChoiceDialog multiChoiceDialog(Context context) {
        return new MultiChoiceDialog(context);
    }

    /**
     * 编辑对话框
     */
    public static EditDialog editDialog(Context context) {
        return new EditDialog(context);
    }

    /**
     * 圆形进度条对话框
     */
    public static CircularProgress  circularProgress(Context context) {
        return new CircularProgress(context);
    }

    /**
     * 日历对话框
     */
    public static DateDialog dateDialog(Context context) {
        return new DateDialog(context);
    }

    /**
     * 时钟对话框
     */
    public static TimeDialog timeDialog(Context context){
        return new TimeDialog(context);
    }

}

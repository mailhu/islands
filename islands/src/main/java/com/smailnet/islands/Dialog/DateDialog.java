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

package com.smailnet.islands.Dialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.widget.DatePicker;

import com.smailnet.islands.Utils.DateUtil;
import com.smailnet.islands.Interface.OnDateSelectListener;
import com.smailnet.islands.Utils.SelectDate;

import java.util.Date;

/**
 * 日期选择对话框
 */
public class DateDialog {

    private Context context;
    private DatePickerDialog datePickerDialog;

    public DateDialog(Context context){
        this.context = context;
    }

    /**
     * 选择日期
     * @param onDateSelectListener
     * @return
     */
    public DateDialog select(final OnDateSelectListener onDateSelectListener){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog = new DatePickerDialog(context);
            datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    onDateSelectListener.OnDateSelect(new SelectDate(view));
                }
            });
        }else {
            Date date = new Date();
            datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    onDateSelectListener.OnDateSelect(new SelectDate(view));
                }
            }, DateUtil.getYear(date), DateUtil.getMonth(date) - 1, DateUtil.getDay(date));
        }
        return this;
    }


    public void show(){
        datePickerDialog.show();
    }
}

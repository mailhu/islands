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

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import com.smailnet.islands.Utils.DateUtil;
import com.smailnet.islands.Interface.OnTimeSelectListener;
import com.smailnet.islands.Utils.SelectTime;

import java.util.Date;

/**
 * 时间选择对话框
 */
public class TimeDialog {

    private Context context;
    private TimePickerDialog timePickerDialog;

    public TimeDialog(Context context){
        this.context = context;
    }

    public TimeDialog select(final OnTimeSelectListener onTimeSelectListener){
        Date date = new Date();
        timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                onTimeSelectListener.onTimeSelect(new SelectTime(hourOfDay, minute));
            }
        }, DateUtil.getHour(date), DateUtil.getMinute(date), true);
        return this;
    }

    public TimeDialog show(){
        timePickerDialog.show();
        return this;
    }

}

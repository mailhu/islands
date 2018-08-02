package com.smailnet.islands;
/**
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

import android.widget.DatePicker;

/**
 * 获取选择的日期结果
 */
public class SelectDate {

    private DatePicker datePicker;

    public SelectDate(DatePicker datePicker){
        this.datePicker = datePicker;
    }

    public int getYear(){
        return datePicker.getYear();
    }

    public int getMonth(){
        return datePicker.getMonth() + 1;
    }

    public int getDay(){
        return datePicker.getDayOfMonth();
    }
}

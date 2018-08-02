package com.smailnet.islands;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateUtil {

    @SuppressLint("SimpleDateFormat")
    public static int getYear(Date date){
        return Integer.valueOf((new SimpleDateFormat("yyyy")).format(date));
    }

    @SuppressLint("SimpleDateFormat")
    public static int getMonth(Date date){
        return Integer.valueOf((new SimpleDateFormat("MM")).format(date));
    }

    @SuppressLint("SimpleDateFormat")
    public static int getDay(Date date){
        return Integer.valueOf((new SimpleDateFormat("dd")).format(date));
    }

   @SuppressLint("SimpleDateFormat")
    public static int getHour(Date date){
        return Integer.valueOf((new SimpleDateFormat("HHH")).format(date));
    }

    @SuppressLint("SimpleDateFormat")
    public static int getMinute(Date date){
        return Integer.valueOf((new SimpleDateFormat("mm")).format(date));
    }
}

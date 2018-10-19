package com.smailnet.islands.Dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;

public class BaseDialog {

    protected AlertDialog.Builder alertDialog;
    protected ProgressDialog progressDialog;
    private int index = 0;

    BaseDialog(Context context){
        alertDialog = new AlertDialog.Builder(context);
    }

    BaseDialog(Context context, int index){
        progressDialog = new ProgressDialog(context);
        this.index = index;
    }

    public void show(){
        if (1 == index){
            progressDialog.show();
        }else {
            alertDialog.show();
        }
    }
}

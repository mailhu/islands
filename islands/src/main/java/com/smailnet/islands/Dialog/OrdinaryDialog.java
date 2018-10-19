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

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.smailnet.islands.Interface.OnClickListener;

/**
 * 普通对话框
 */
public class OrdinaryDialog extends BaseDialog{

    public OrdinaryDialog(Context context){
        super(context);
    }

    /**
     * 设置图标
     *
     * @param iconId
     * @return
     */
    public OrdinaryDialog setIcon(int iconId){
        alertDialog.setIcon(iconId);
        return this;
    }

    /**
     * 设置标题和文本信息
     *
     * @param title
     * @param message
     * @return
     */
    public OrdinaryDialog setText(String title, String message) {
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param cancelable
     * @return
     */
    public OrdinaryDialog setCancelable(boolean cancelable){
        alertDialog.setCancelable(cancelable);
        return this;
    }


    /**
     * 设置按钮
     *
     * @param positive
     * @param negative
     * @param neutral
     * @return
     */
    public OrdinaryDialog setButton(String positive, String negative, String neutral){
        alertDialog.setPositiveButton(positive, null);
        alertDialog.setNegativeButton(negative, null);
        alertDialog.setNeutralButton(neutral, null);
        return this;
    }

    /**
     * 设置按钮，回调OnClickListener
     *
     * @param positive
     * @param negative
     * @param neutral
     * @return
     */
    public OrdinaryDialog setButton(String positive, String negative, String neutral, final OnClickListener onClickListener){
        alertDialog.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickListener.onClick(0);
                dialog.dismiss();
            }
        });

        alertDialog.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickListener.onClick(1);
                dialog.dismiss();
            }
        });

        alertDialog.setNeutralButton(neutral, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickListener.onClick(2);
                dialog.dismiss();
            }
        });
        return this;
    }
}

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

import com.smailnet.islands.Interface.OnSingeChoiceListener;

/**
 * 单选对话框
 */
public class SingleChoiceDialog extends BaseDialog{

    public SingleChoiceDialog(Context context){
        super(context);
    }

    /**
     * 设置图标
     *
     * @param iconId
     * @return
     */
    public SingleChoiceDialog setIcon(int iconId){
        alertDialog.setIcon(iconId);
        return this;
    }

    /**
     * 设置标题和文本信息
     *
     * @param title
     * @return
     */
    public SingleChoiceDialog setText(String title) {
        alertDialog.setTitle(title);
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param cancelable
     * @return
     */
    public SingleChoiceDialog setCancelable(boolean cancelable){
        alertDialog.setCancelable(cancelable);
        return this;
    }

    /**
     * 设置items
     *
     * @param items
     * @return
     */
    public SingleChoiceDialog setSingleChoiceItems(String[] items, int checkedItem, final OnSingeChoiceListener onSingeChoiceListener){
        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onSingeChoiceListener.onClick(which);
                dialog.dismiss();
            }
        });
        return this;
    }


}

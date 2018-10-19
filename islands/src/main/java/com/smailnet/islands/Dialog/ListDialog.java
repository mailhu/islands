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

import com.smailnet.islands.Interface.OnListItemClickListener;

/**
 * 列表对话框
 */
public class ListDialog extends BaseDialog{

    public ListDialog(Context context){
        super(context);
    }

    /**
     * 设置图标
     *
     * @param iconId
     * @return
     */
    public ListDialog setIcon(int iconId){
        alertDialog.setIcon(iconId);
        return this;
    }

    /**
     * 设置标题和文本信息
     *
     * @param title
     * @return
     */
    public ListDialog setText(String title) {
        alertDialog.setTitle(title);
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param cancelable
     * @return
     */
    public ListDialog setCancelable(boolean cancelable){
        alertDialog.setCancelable(cancelable);
        return this;
    }

    /**
     * 设置列表
     * @param items
     * @return
     */
    public ListDialog setItems(String items[], final OnListItemClickListener onListItemClickListener){
        alertDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onListItemClickListener.onClick(which);
            }
        });
        return this;
    }
}

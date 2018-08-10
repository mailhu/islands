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
public class ListDialog {

    private int iconId;                     //图标
    private String title;                   //标题
    private String message;                 //文本信息
    private boolean cancelable = true;      //是否可取消
    private String[] items;
    private OnListItemClickListener onListItemClickListener;
    private AlertDialog.Builder dialog;

    public ListDialog(Context context){
        dialog = new AlertDialog.Builder(context);
    }

    /**
     * 设置图标
     *
     * @param iconId
     * @return
     */
    public ListDialog setIcon(int iconId){
        this.iconId = iconId;
        return this;
    }

    /**
     * 设置标题和文本信息
     *
     * @param title
     * @param message
     * @return
     */
    public ListDialog setText(String title, String message) {
        this.title = title;
        this.message = message;
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param cancelable
     * @return
     */
    public ListDialog setCancelable(boolean cancelable){
        this.cancelable = cancelable;
        return this;
    }

    /**
     * 设置列表
     * @param items
     * @return
     */
    public ListDialog setItems(String items[]){
        this.items = items;
        return this;
    }

    /**
     * 设置点击监听
     *
     * @param onListItemClickListener
     * @return
     */
    public ListDialog click(OnListItemClickListener onListItemClickListener){
        this.onListItemClickListener = onListItemClickListener;
        return this;
    }

    /**
     * 显示对话框
     *
     * @return
     */
    public ListDialog show(){
        dialog.setIcon(iconId);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setCancelable(cancelable);
        dialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onListItemClickListener.onClick(which);
            }
        });
        dialog.show();
        return this;
    }

}

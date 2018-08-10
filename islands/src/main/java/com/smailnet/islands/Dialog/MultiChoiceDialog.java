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

import com.smailnet.islands.Interface.OnMultiChoiceClickListener;

/**
 * 多选对话框
 */
public class MultiChoiceDialog {

    private int iconId;                     //图标
    private String title;                   //标题
    private String message;                 //文本信息
    private boolean cancelable = true;      //是否可取消
    private String positiveButton;          //positive按钮
    private String negativeButton;          //negative按钮
    private String neutralButton;           //neutral按钮
    private String[] items;
    private boolean[] checkedItems;
    private OnMultiChoiceClickListener onMultiChoiceClickListener;
    private AlertDialog.Builder dialog;

    public MultiChoiceDialog(Context context){
        dialog = new AlertDialog.Builder(context);
    }

    /**
     * 设置图标
     *
     * @param iconId
     * @return
     */
    public MultiChoiceDialog setIcon(int iconId){
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
    public MultiChoiceDialog setText(String title, String message) {
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
    public MultiChoiceDialog setCancelable(boolean cancelable){
        this.cancelable = cancelable;
        return this;
    }

    /**
     * 设置items
     *
     * @param items
     * @return
     */
    public MultiChoiceDialog setItems(String[] items){
        this.items = items;
        return this;
    }

    /**
     * 设置checkedItems
     *
     * @param checkedItems
     * @return
     */
    public MultiChoiceDialog setCheckedItems(boolean[] checkedItems){
        this.checkedItems = checkedItems;
        return this;
    }

    /**
     * 设置按钮
     *
     * @param positiveButton
     * @param negativeButton
     * @param neutralButton
     * @return
     */
    public MultiChoiceDialog setButton(String positiveButton, String negativeButton, String neutralButton){
        this.positiveButton = positiveButton;
        this.negativeButton = negativeButton;
        this.neutralButton = neutralButton;
        return this;
    }

    /**
     * 设置点击，无回调
     *
     * @return
     */
    public MultiChoiceDialog click(OnMultiChoiceClickListener onMultiChoiceClickListener){
        this.onMultiChoiceClickListener = onMultiChoiceClickListener;
        return this;
    }

    /**
     * 显示对话框
     *
     * @return
     */
    public MultiChoiceDialog show(){
        dialog.setIcon(iconId);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setCancelable(cancelable);
        dialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });
        dialog.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onMultiChoiceClickListener.onClick(items, checkedItems);
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onMultiChoiceClickListener.onClick(items, checkedItems);
                dialog.dismiss();
            }
        });

        dialog.setNeutralButton(neutralButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onMultiChoiceClickListener.onClick(items, checkedItems);
                dialog.dismiss();
            }
        });
        dialog.show();
        return this;
    }
}

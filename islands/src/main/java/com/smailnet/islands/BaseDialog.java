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

package com.smailnet.islands;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

/**
 * 父类对话框
 */
public class BaseDialog {

    private int iconId;                     //图标
    private String title;                   //标题
    private String message;                 //文本信息
    private String positiveButton;          //positive按钮
    private String negativeButton;          //negative按钮
    private String neutralButton;           //neutral按钮
    private boolean cancelable = true;      //是否可取消
    protected Context context;
    protected AlertDialog.Builder dialog;
    protected View view;
    protected EditText editText;

    public BaseDialog(Context context) {
        this.dialog = new AlertDialog.Builder(context);
        view = View.inflate(context, R.layout.dialog_layout, null);
        editText = view.findViewById(R.id.dialog_EditText);
    }

    /**
     * 设置图标
     *
     * @param iconId
     * @return
     */
    public BaseDialog setIcon(int iconId){
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
    public BaseDialog setText(String title, String message) {
        this.title = title;
        this.message = message;
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
    public BaseDialog setButton(String positiveButton, String negativeButton, String neutralButton){
        this.positiveButton = positiveButton;
        this.negativeButton = negativeButton;
        this.neutralButton = neutralButton;
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param cancelable
     * @return
     */
    public BaseDialog setCancelable(boolean cancelable){
        this.cancelable = cancelable;
        return this;
    }

    /**
     * 设置点击回调，回调OnClickListener
     * @param onClickListener
     * @return
     */
    public BaseDialog click(final OnClickListener onClickListener){
        dialog.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickListener.onClick(0);
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickListener.onClick(1);
                dialog.dismiss();
            }
        });

        dialog.setNeutralButton(neutralButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickListener.onClick(2);
                dialog.dismiss();
            }
        });

        return this;
    }

    /**
     * 设置点击回调，回调onEditDialogListener
     *
     * @param onEditDialogListener
     * @return
     */
    public BaseDialog click(final OnEditDialogListener onEditDialogListener){
        dialog.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onEditDialogListener.getText(editText.getText().toString(), 0);
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onEditDialogListener.getText(editText.getText().toString(), 1);
                dialog.dismiss();
            }
        });

        dialog.setNeutralButton(neutralButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onEditDialogListener.getText(editText.getText().toString(), 2);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * 设置点击，无回调
     *
     * @return
     */
    public BaseDialog click(){
        dialog.setPositiveButton(positiveButton, null);
        dialog.setNegativeButton(negativeButton, null);
        dialog.setNeutralButton(neutralButton, null);
        return this;
    }

    /**
     * 显示对话框
     *
     * @return
     */
    public BaseDialog show(){
        dialog.setIcon(iconId);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setCancelable(cancelable);
        dialog.show();
        return this;
    }
}

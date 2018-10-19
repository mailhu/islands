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
import android.view.View;
import android.widget.EditText;

import com.smailnet.islands.Interface.OnEditListener;
import com.smailnet.islands.R;

/**
 * 编辑对话框
 */
public class EditDialog extends BaseDialog{

    private EditText editText;

    public EditDialog(Context context){
        super(context);
        View view = View.inflate(context, R.layout.dialog_layout, null);
        editText = view.findViewById(R.id.dialog_EditText);
        alertDialog.setView(view);
    }

    /**
     * 设置图标
     *
     * @param iconId
     * @return
     */
    public EditDialog setIcon(int iconId){
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
    public EditDialog setText(String title, String message) {
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        return this;
    }

    /**
     * 设置编辑框的文本
     * @param text
     * @return
     */
    public EditDialog setEditText(String text){
        editText.setText(text);
        editText.setSelection(text.length());
        return this;
    }

    /**
     * 设置编辑框的提示文本
     * @param textHint
     * @return
     */
    public EditDialog setEditTextHint(String textHint){
        editText.setHint(textHint);
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
    public EditDialog setButton(String positive, String negative, String neutral, final OnEditListener onEditListener){
        alertDialog.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onEditListener.getText(editText.getText().toString(), 0);
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onEditListener.getText(editText.getText().toString(), 1);
                dialog.dismiss();
            }
        });
        alertDialog.setNeutralButton(neutral, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onEditListener.getText(editText.getText().toString(), 2);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param cancelable
     * @return
     */
    public EditDialog setCancelable(boolean cancelable){
        alertDialog.setCancelable(cancelable);
        return this;
    }

}

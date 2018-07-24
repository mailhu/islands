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

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Islands是Android一个已对原生对话框进行封装的工具库。
 * 其中包括普通对话框，列表对话框，单选对话框，多选对话框，
 * 编辑对话框，进度条对话框。只需只需简单的调用，即快速创
 * 建对话框。
 *
 * @author 张观湖
 * @author E-mail: zguanhu@foxmail.com
 * @version 1.0
 */
public class Islands{

    /**
     *普通对话框
     */
    public static class OrdinaryDialog extends BaseDialog{
        public OrdinaryDialog(Context context) {
            super(context);
        }
    }

    /**
     * 列表对话框
     */
    public static class ListDialog extends BaseDialog{

        public ListDialog(Context context) {
            super(context);
        }

        /**
         * 设置列表
         * @param item
         * @param onClickListener
         * @return
         */
        public ListDialog setItem(String item[], final OnClickListener onClickListener){
            dialog.setItems(item, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(which);
                }
            });
            return this;
        }
    }

    /**
     * 单选对话框
     */
    public static class SingleChoiceDialog extends BaseDialog{

        public SingleChoiceDialog(Context context) {
            super(context);
        }

        /**
         * 设置单选列表
         * @param items
         * @param checkedItem
         * @param onClickListener
         * @return
         */
        public SingleChoiceDialog setSingleChoiceItems(String items[], int checkedItem, final OnClickListener onClickListener){
            dialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(which);
                    dialog.dismiss();
                }
            });
            return this;
        }
    }

    /**
     * 多选对话框
     */
    public static class MultiChoiceDialog extends BaseDialog{

        public MultiChoiceDialog(Context context) {
            super(context);
        }

        /**
         * 设置多选列表
         * @param items
         * @param checkedItems
         * @param onMultiChoiceClickListener
         * @return
         */
        public MultiChoiceDialog setMultiChoiceItems(String items[], boolean checkedItems[], final OnMultiChoiceClickListener onMultiChoiceClickListener) {
            dialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    onMultiChoiceClickListener.onClick(which, isChecked);
                }
            });
            return this;
        }
    }

    /**
     * 编辑对话框
     */
    public static class EditDialog extends BaseDialog{

        public EditDialog(Context context) {
            super(context);
            this.context = context;
        }

        /**
         * 设置编辑框的提示文本
         * @param textHint
         * @return
         */
        public EditDialog setEditTextHint(String textHint){
            dialog.setView(view);
            editText.setHint(textHint);
            return this;
        }
    }

    /**
     * 圆形进度条对话框
     */
    public static class CircularProgress{

        private ProgressDialog dialog;          //进度条对话框
        private String message;                 //message
        private boolean cancelable = true;      //是否可取消

        public CircularProgress(Context context){
            this.dialog = new ProgressDialog(context);
        }

        public CircularProgress setMessage(String message){
            this.message = message;
            return this;
        }

        /**
         * 设置是否可以取消
         * @param cancelable
         * @return
         */
        public CircularProgress setCancelable(boolean cancelable){
            this.cancelable = cancelable;
            return this;
        }

        /**
         * 显示进度条对话框
         *
         * @return
         */
        public CircularProgress show(){
            dialog.setMessage(message);
            dialog.setCancelable(cancelable);
            dialog.show();
            return this;
        }

        /**
         * 运行过程的事件处理
         *
         * @param onRunningListener
         * @return
         */
        public CircularProgress run(OnRunningListener onRunningListener){
            onRunningListener.onRunning(dialog);
            return this;
        }
    }
}

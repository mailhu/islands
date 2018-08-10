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

import android.app.ProgressDialog;
import android.content.Context;

import com.smailnet.islands.Interface.OnRunningListener;

/**
 * 圆形进度条对话框
 */
public class CircularProgress {

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

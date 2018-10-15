package com.hykj.liuzhi.androidcomponents.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hykj.liuzhi.R;

/**
 * @author: lujialei
 * @date: 2018/10/9
 * @describe:
 */


public class SignDialog extends Dialog {

    public SignDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_sign);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }
}

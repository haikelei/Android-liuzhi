package com.hykj.liuzhi.androidcomponents.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.hykj.liuzhi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/9
 * @describe:
 */


public class SignDialog extends Dialog {

    @BindView(R.id.iv_close)
    ImageView ivClose;

    public SignDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_sign);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowing()){
                    dismiss();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setCancelable(false);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }
}

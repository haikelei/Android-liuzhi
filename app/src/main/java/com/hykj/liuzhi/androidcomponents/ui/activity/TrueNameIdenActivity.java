package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hykj.liuzhi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TrueNameIdenActivity extends BaseActivity {
    @BindView(R.id.tv_truename_identyfy_back)
    ImageView tvTruenameIdentyfyBack;
    @BindView(R.id.tv_truename_identyfy_commit)
    TextView tvTruenameIdentyfyCommit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truename_identyfy);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_truename_identyfy_back, R.id.tv_truename_identyfy_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_truename_identyfy_back:
                finish();
                break;
            case R.id.tv_truename_identyfy_commit:
                Toast.makeText(this, "提交成功了", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

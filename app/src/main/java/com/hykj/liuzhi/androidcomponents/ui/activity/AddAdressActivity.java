package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.AddAddressBean;
import com.hykj.liuzhi.androidcomponents.net.http.HttpHelper;
import com.hykj.liuzhi.androidcomponents.ui.activity.min.bean.AllAddBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.min.dailog.Dlg_AddChose;
import com.hykj.liuzhi.androidcomponents.ui.adapter.SelectAdressListAdapter;
import com.hykj.liuzhi.androidcomponents.utils.ACache;
import com.hykj.liuzhi.androidcomponents.utils.ErrorStateCodeUtils;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;
import com.suke.widget.SwitchButton;

public class AddAdressActivity extends BaseActivity implements View.OnClickListener, Dlg_AddChose.OnClick {
    private Dlg_AddChose addChose;
    private TextView tvAddr;
    EditText name, phone, addr;
    private SwitchButton switchButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaddress);
        initView();
    }

    private void initView() {
        new TitleBuilder(AddAdressActivity.this).setTitleText("新增收货地址").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.addr_region).setOnClickListener(this);
        addChose = new Dlg_AddChose(this, this);
        tvAddr = findViewById(R.id.tv_addr);
        name = findViewById(R.id.address_name);
        phone = findViewById(R.id.address_phone);
        addr = findViewById(R.id.address_address);
        switchButton = findViewById(R.id.add_switch);
        findViewById(R.id.add_commit).setOnClickListener(this);
    }

    private ACache aCache;
    String st_name, st_phone, allname, address, regionid, status;

    public void postAdd() {
        Log.e("aa","-----------"+switchButton.isChecked());
        aCache = ACache.get(this);
        st_name = name.getText().toString();
        if (TextUtils.isEmpty(st_name)) {
            Toast.makeText(AddAdressActivity.this, "请输入姓名！", Toast.LENGTH_SHORT).show();
            return;
        }
        st_phone = phone.getText().toString();
        if (TextUtils.isEmpty(st_phone)) {
            Toast.makeText(AddAdressActivity.this, "请输入您的手机号！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(allname)) {
            Toast.makeText(AddAdressActivity.this, "请选择省市区！", Toast.LENGTH_SHORT).show();
            return;
        }
        address = addr.getText().toString();
        if (TextUtils.isEmpty(address)) {
            Toast.makeText(AddAdressActivity.this, "请输入详细地址！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (switchButton.isChecked()) {
            status = 1 + "";
        } else {
            status = 0 + "";
        }
        HttpHelper.Addshopaddress(aCache.getAsString("user_id"),
                st_name + "",
                st_phone + "",
                allname + "",
                address + "",
                regionid + "",
                status + "",
                new HttpHelper.HttpUtilsCallBack<String>() {
                    @Override
                    public void onFailure(String failure) {
                        Toast.makeText(AddAdressActivity.this, failure, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSucceed(String succeed) {
                        Log.e("aa", regionid);
                        AddAddressBean entity = FastJSONHelper.getPerson(succeed, AddAddressBean.class);
                        if(entity.getCode()==0) {
                            Toast.makeText(AddAdressActivity.this,entity.getMsg(), Toast.LENGTH_SHORT).show();
                            setResult(1);
                            finish();
                        }
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(AddAdressActivity.this, ErrorStateCodeUtils.getRegisterErrorMessage(error), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addr_region://选择地区
                addChose.show();
                break;
            case R.id.add_commit:
                postAdd();
                break;
        }
    }

    @Override
    public void onItem(String province, String city, String area, String regionid1) {
        allname = province + city + area;
        tvAddr.setText(allname);
        regionid = regionid1;
    }
}

package com.tjeit.banklistfromserver02;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tjeit.banklistfromserver02.databinding.ActivityMainBinding;
import com.tjeit.banklistfromserver02.utils.ConnectServer;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        setUpEvents();
        setValues();
    }

    @Override
    public void setUpEvents() {

        act.serverTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectServer.getRequestInfoBank(mContext, null);
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}

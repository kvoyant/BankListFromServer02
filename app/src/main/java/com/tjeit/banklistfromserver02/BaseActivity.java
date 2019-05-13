package com.tjeit.banklistfromserver02;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setUpEvents();
    public abstract void setValues();
    public abstract void bindView();

}

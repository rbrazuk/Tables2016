package com.rbrazuk.ross.tables;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    protected void setUpUI(ArrayList<Object> arrayList, RecyclerView.Adapter adapter) {

    }
}

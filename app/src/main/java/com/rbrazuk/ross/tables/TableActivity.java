package com.rbrazuk.ross.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableActivity extends AppCompatActivity {

    ApiService mApiService;
    JsonService mJsonService;

    private ArrayList<Team> mTeamsArrayList;

    @BindView(R.id.rv_table) RecyclerView mTableRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        ButterKnife.bind(this);

        mApiService = new ApiService();
        mJsonService = new JsonService();

        String url = getIntent().getStringExtra("URL");

        mApiService.setOnJsonLoadedListener(new ApiService.OnJsonLoadedListener() {
            @Override
            public void onJsonLoaded(String json) {
                try {
                    mTeamsArrayList = mJsonService.parseTableJson(json);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(mTeamsArrayList);
                            setUpRecyclerView(mTeamsArrayList);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            mApiService.getJsonFromUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUpRecyclerView(ArrayList<Team> teams) {
        TableAdapter adapter = new TableAdapter(this, teams);
        mTableRecyclerView.setAdapter(adapter);
        mTableRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

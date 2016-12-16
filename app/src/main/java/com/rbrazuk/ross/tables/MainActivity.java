package com.rbrazuk.ross.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ApiService mApiService;
    private  JsonService mJsonService;

    private static ArrayList<Competition> mCompetitions;

    private static final String COMPETITIONS_URL = "http://api.football-data.org/v1/competitions";

    @BindView(R.id.rvCompetitions) RecyclerView mCompetitionsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mApiService = new ApiService();
        mJsonService = new JsonService();

        mApiService.setOnJsonLoadedListener(new ApiService.OnJsonLoadedListener() {
            @Override
            public void onJsonLoaded(String json)  {
                try {
                    mCompetitions = mJsonService.parseCompetitionsJson(json);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setUpRecyclerView(mCompetitions);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            mApiService.getJsonFromUrl(COMPETITIONS_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void setUpRecyclerView(ArrayList<Competition> competitions) {
        CompetitionsAdapter adapter = new CompetitionsAdapter(this, competitions);

        mCompetitionsRecyclerView.setAdapter(adapter);
        mCompetitionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}

package com.rbrazuk.ross.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String mCompetitionsJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = new ApiService();

        apiService.setOnJsonLoadedListener(new ApiService.OnJsonLoadedListener() {
            @Override
            public void onJsonLoaded(String json)  {
                mCompetitionsJson = json;

                try {
                    JSONArray competitionsArray = new JSONArray(json);

                    System.out.println(competitionsArray.get(0).toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            apiService.getCompetitionsJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

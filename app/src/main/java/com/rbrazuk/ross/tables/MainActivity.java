package com.rbrazuk.ross.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String mJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = new ApiService();

        apiService.setOnJsonLoadedListener(new ApiService.OnJsonLoadedListener() {
            @Override
            public void onJsonLoaded(String json) {
                System.out.println(json);
            }
        });

        try {
            apiService.run();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

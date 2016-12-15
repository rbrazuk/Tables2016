package com.rbrazuk.ross.tables;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiService {

    private String competitionsUrl = "http://api.football-data.org/v1/competitions";

    private final OkHttpClient mClient = new OkHttpClient();
    Request request = new Request.Builder().url(competitionsUrl).addHeader("X-Auth-Token","95468454664049ca81f3fc478ede7ef2").build();

    public void run() throws Exception {
        Request request = new Request.Builder().url(competitionsUrl).addHeader("X-Auth-Token","95468454664049ca81f3fc478ede7ef2").build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }
}

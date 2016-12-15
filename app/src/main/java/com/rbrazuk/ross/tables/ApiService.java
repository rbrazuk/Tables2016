package com.rbrazuk.ross.tables;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiService {

    private String apiKey = "95468454664049ca81f3fc478ede7ef2";
    private String competitionsUrl = "http://api.football-data.org/v1/competitions";

    private OnJsonLoadedListener mOnJsonLoadedListener;

    private final OkHttpClient mClient = new OkHttpClient();
    private final Request request = new Request.Builder().url(competitionsUrl).addHeader("X-Auth-Token", apiKey).build();

    public interface OnJsonLoadedListener {
        void onJsonLoaded(String json);
    }

    public ApiService() {
        this.mOnJsonLoadedListener = null;
    }

    public void setOnJsonLoadedListener(OnJsonLoadedListener listener) {
        this.mOnJsonLoadedListener = listener;
    }

    public void getCompetitionsJson() throws Exception {

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonResponse = response.body().string();

                mOnJsonLoadedListener.onJsonLoaded(jsonResponse);
            }
        });
    }
}

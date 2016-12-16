package com.rbrazuk.ross.tables;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiService {

    private static final String API_KEY = "95468454664049ca81f3fc478ede7ef2";

    private OnJsonLoadedListener mOnJsonLoadedListener;

    private final OkHttpClient mClient = new OkHttpClient();

    public interface OnJsonLoadedListener {
        void onJsonLoaded(String json);
    }

    public ApiService() {
        this.mOnJsonLoadedListener = null;
    }

    public void setOnJsonLoadedListener(OnJsonLoadedListener listener) {
        this.mOnJsonLoadedListener = listener;
    }

    public void getJsonFromUrl(String url) throws Exception {

        Request request = new Request.Builder().url(url).addHeader("X-Auth-Token", API_KEY).build();

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

package com.tanamo.osm;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.mapbox.mapboxsdk.Mapbox;
import com.tanamo.osm.util.Utils;

public class MyApplication extends Application {

    private static final String LOG_TAG = MyApplication.class.getSimpleName();

    private static final String DEFAULT_TOKEN = "pk.eyJ1IjoidGFuYW1vIiwiYSI6ImNqcjk5dGhrMzA1bmI0YWxoenZzajZuNTcifQ.CKdwRFeNzSuMFos9e9djfw";

    @Override
    public void onCreate() {
        super.onCreate();

        // Set access token
        String aToken = Utils.getMapboxAccessToken(getApplicationContext());

        if (TextUtils.isEmpty(aToken) || aToken.equals(DEFAULT_TOKEN)) {
            Log.w(LOG_TAG, "Warning: access token isn't set.");
        }

        Mapbox.getInstance(getApplicationContext(), aToken);

    }

}

package com.example.didaktikapp.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppModule {

    private Application mApp;

    public AppModule(Application application) {
        mApp = application;
    }

    Context provideContext() {
        return mApp;
    }

    SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}

package com.example.didaktikapp;

import android.app.Application;

import com.example.didaktikapp.di.component.AppComponent;
import com.example.didaktikapp.di.component.DaggerAppComponent;
import com.example.didaktikapp.di.modules.AppModule;


public class WordSearchApp extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}

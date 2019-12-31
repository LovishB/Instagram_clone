package com.example.instagram_clone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("uQUqndrDlJmtLIgsBfBHIWhG3G70haSomVyVm7sw")
                .clientKey("BERCIu7G0RgQu201c9cPczL08Jwu6zgXbVMSvvsH")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}

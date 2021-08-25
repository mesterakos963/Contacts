package codeyard.contacts.base;

import android.app.Application;

import org.androidannotations.annotations.EApplication;

@EApplication
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}

package com.example.googlefitstepcount.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.googlefitstepcount.R;

public class SplashActivity extends AppCompatActivity {
    protected int splashTime = 4000;
    private Thread splashTread;
    private TextView txtVersion;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        txtVersion = (TextView) findViewById(R.id.txtVersion);
        setVersion();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            splashCall();
        }
    }

    private void setVersion() {
        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            txtVersion.setText("Version. " + pInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void splashCall() {
        final SplashActivity sPlashScreen = this;

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(splashTime);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent();
                    i.setClass(sPlashScreen, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        splashTread.start();
    }
}

package com.example.quanlyagile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prog();
    }

    private void prog() {
        progressBar=findViewById(R.id.progressBar);
        final Timer t=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if(counter==100){
                    t.cancel();
                }
            }
        };
        t.schedule(task,0,100);
    }
}
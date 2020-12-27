package com.globals.netconnect.kaka.Activity;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.globals.netconnect.kaka.App.Cons;
import com.globals.netconnect.kaka.R;
import com.spark.submitbutton.SubmitButton;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private TextView mFirstText;

    private SubmitButton btSubmit;
    private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;
    private static final Random rgenerator = new Random();
    private String[] title = {"hello", "bonjour", "sveiki", "tere", "namaste", "aloha", "labas", "hallo", "moin", "terve", "ciao", "ola", "salaam", "szia"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Toast.makeText(this, ""+android_id, Toast.LENGTH_SHORT).show();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.splash_activity);
        mFirstText = (TextView) findViewById(R.id.txt_welcome_first);
        constraintLayout = (ConstraintLayout) findViewById(R.id.rl_view);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String q = title[rgenerator.nextInt(title.length)];
                                if (q != mFirstText.getText().toString()) {
                                    mFirstText.setText(q);
                                } else {
                                    String p = title[rgenerator.nextInt(title.length)];
                                    mFirstText.setText(p);
                                }


                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(Cons.CHANNEL_ID, Cons.CHANNEL_NAME, importance);
            mChannel.setDescription(Cons.CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mNotificationManager.createNotificationChannel(mChannel);
        }


    }


}
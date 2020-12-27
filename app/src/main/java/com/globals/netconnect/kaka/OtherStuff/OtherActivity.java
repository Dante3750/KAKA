package com.globals.netconnect.kaka.OtherStuff;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.globals.netconnect.kaka.Activity.IntroActivity;
import com.globals.netconnect.kaka.Activity.WelcomeActivity;
import com.globals.netconnect.kaka.App.PrefManager;
import com.globals.netconnect.kaka.MainActivity;
import com.globals.netconnect.kaka.R;

public class OtherActivity extends AppCompatActivity {
    private static final String TAG = "OtherActivity";
    private PrefManager pref;
    private AnimationDrawable animationDrawable;
    private ConstraintLayout flView;
    private TextView tvAboutUs,tvPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_other);
        tvAboutUs=(TextView)findViewById(R.id.tvAboutUs);
        tvPlay=(TextView)findViewById(R.id.tv_play);
        tvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OtherActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        tvAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OtherActivity.this, KnowAboutNCActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        flView = (ConstraintLayout) findViewById(R.id.rl_view);
        animationDrawable = (AnimationDrawable) flView.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }
}

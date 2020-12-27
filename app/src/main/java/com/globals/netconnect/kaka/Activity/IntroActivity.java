package com.globals.netconnect.kaka.Activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.globals.netconnect.kaka.R;
import com.spark.submitbutton.SubmitButton;

public class IntroActivity extends AppCompatActivity {
    private static final String TAG = "IntroActivity";
    private TextView mFirstText;
    private SubmitButton startButton;
    private AnimationDrawable animationDrawable;
    private ConstraintLayout clAnim;
    private TextView tvGrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_intro);
        mFirstText = (TextView) findViewById(R.id.txt_welcome_first);
        tvGrt=(TextView)findViewById(R.id.txt_grt);
        clAnim = (ConstraintLayout) findViewById(R.id.rl_view);
        animationDrawable = (AnimationDrawable) clAnim.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        mFirstText.setText("hi,hope\nyou are\ndoing");
        clAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroActivity.this, FirstInterval.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }
}

package com.globals.netconnect.kaka.OtherStuff;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.globals.netconnect.kaka.Activity.WelcomeActivity;
import com.globals.netconnect.kaka.App.PrefManager;
import com.globals.netconnect.kaka.R;

public class IntroSecondActivity extends Activity {
    private ConstraintLayout clView;
    private PrefManager pref;
    private TextView mFirstText;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_intro_second);
        pref =new PrefManager(this);
        clView=(ConstraintLayout)findViewById(R.id.cl_view);
        mFirstText=(TextView)findViewById(R.id.txt_welcome_first) ;
        animationDrawable = (AnimationDrawable) clView.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        mFirstText.setText("I m\nnc\nrobo\nassistant");
        clView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroSecondActivity.this, WelcomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });



    }
}

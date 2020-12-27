package com.globals.netconnect.kaka.OtherStuff;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.globals.netconnect.kaka.Activity.ContactActivity;
import com.globals.netconnect.kaka.Activity.HomeActivity;
import com.globals.netconnect.kaka.R;

public class KnowAboutNCActivity extends Activity {
    private AnimationDrawable animationDrawable;
    private RelativeLayout rlView;
    private TextView aboutUs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_know_about_nc);
        rlView = (RelativeLayout) findViewById(R.id.rl_view);
        aboutUs=(TextView)findViewById(R.id.tv_about_us) ;
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KnowAboutNCActivity.this, OtherActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        });
        animationDrawable = (AnimationDrawable) rlView.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }
}

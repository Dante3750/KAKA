package com.globals.netconnect.kaka.Activity;

import android.content.Intent;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.globals.netconnect.kaka.App.PrefManager;
import com.globals.netconnect.kaka.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ContactActivity";
    private AnimationDrawable animationDrawable;
    private ConstraintLayout flView;
    private EditText etMobileNo;
    private Button btSubmit;
    private PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_contact);
        pref = new PrefManager(this);
        flView = (ConstraintLayout) findViewById(R.id.rl_view);
        btSubmit=(Button)findViewById(R.id.bt_Mobile);
        etMobileNo=(EditText)findViewById(R.id.editText) ;
        btSubmit.setOnClickListener(this);
        animationDrawable = (AnimationDrawable) flView.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_Mobile:
                String Mobile_no=etMobileNo.getText().toString();
                pref.createLoginDetails(Mobile_no);
                Intent i = new Intent(ContactActivity.this, HomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

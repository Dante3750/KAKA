package com.globals.netconnect.kaka.Activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.globals.netconnect.kaka.App.Cons;
import com.globals.netconnect.kaka.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirstInterval extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "FirstInterval";
    private AnimationDrawable animationDrawable;
    private ConstraintLayout flView;
    private TextView tvText1;
    private Button btMeeting,btWalkin,btInterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_first_interval);
        flView = (ConstraintLayout) findViewById(R.id.rl_view);
        tvText1 = (TextView) findViewById(R.id.txt_one);
        btInterView=(Button)findViewById(R.id.bt_interview);
        btMeeting=(Button)findViewById(R.id.bt_meeting);
        btWalkin=(Button)findViewById(R.id.bt_walkin);
        btWalkin.setOnClickListener(this);
        btMeeting.setOnClickListener(this);
        btInterView.setOnClickListener(this);
        animationDrawable = (AnimationDrawable) flView.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        getOptionData();
    }

    private void getOptionData() {
        RequestQueue queuegetIssue = Volley.newRequestQueue(this);
        StringRequest Options= new StringRequest(Request.Method.GET, Cons.URL_GET_LIST_OPTION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);
                try {
                    JSONObject OptionObject = new JSONObject(response);
                    String message = OptionObject.getString("message");
                    String status = OptionObject.getString("status");
                    Log.d(TAG, "onResponse: "+message+status);
                    if (status.equals(0)) {
                        Toast.makeText(getApplicationContext(), "" + message, Toast.LENGTH_SHORT).show();
                    } else {
                        JSONArray jsonArray = OptionObject.getJSONArray("options");
                        JSONObject FirstObject=jsonArray.getJSONObject(0);
                        Log.d(TAG, "onResponse: "+FirstObject.getString("name"));
                        btMeeting.setText(FirstObject.getString("name"));

                        JSONObject SecondObject=jsonArray.getJSONObject(1);
                        btInterView.setText(SecondObject.getString("name"));

                        JSONObject ThirdObject=jsonArray.getJSONObject(2);
                       btWalkin.setText(ThirdObject.getString("name"));

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        queuegetIssue.add(Options);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_meeting:
                Intent m = new Intent(FirstInterval.this, ContactActivity.class);
                m.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(m);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.bt_interview:
                Intent i = new Intent(FirstInterval.this, ContactActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.bt_walkin:
                Intent w = new Intent(FirstInterval.this, ContactActivity.class);
                w.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(w);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;


        }


    }
}

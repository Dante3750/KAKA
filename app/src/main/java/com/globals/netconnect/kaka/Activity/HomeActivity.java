package com.globals.netconnect.kaka.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.globals.netconnect.kaka.App.AppController;
import com.globals.netconnect.kaka.App.Cons;
import com.globals.netconnect.kaka.App.PrefManager;
import com.globals.netconnect.kaka.OtherStuff.OtherActivity;
import com.globals.netconnect.kaka.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "HomeActivity";
    private TextView tvRname,tvName;
    private String name,rName;
    private PrefManager pref;
    private Button btCont;
    private AnimationDrawable animationDrawable;
    private ConstraintLayout flView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_home);
        tvName=(TextView)findViewById(R.id.tvMobile);
        tvRname=(TextView)findViewById(R.id.tvMessage) ;
        btCont= (Button)findViewById(R.id.bt_cont);
        btCont.setOnClickListener(this);
        flView = (ConstraintLayout) findViewById(R.id.rl_view);
        animationDrawable = (AnimationDrawable) flView.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        pref = new PrefManager(this);
        String mobile =pref.getEmpDetail().get(Cons.KEY_MOBILE_NO);
        getDataFrmServer(mobile);
    }

    private void getDataFrmServer(final String mobile) {
        if (Cons.isNetworkAvailable(this)) {
            final StringRequest getspinnerData = new StringRequest(Request.Method.POST, Cons.URL_GET_USER_DATA, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject= new JSONObject(response);
                        Log.d(TAG, "RewardsData: " + jsonObject);
                        String status = jsonObject.getString("status");
                        if (status.equals("0")) {

                        } else {
                            JSONObject userData =jsonObject.getJSONObject("userData");
                            name =userData.getString("name");
                            rName=userData.getString("recruiterName");
                            tvName.setText("hello, " + name);
                            tvRname.setText("I have notified " + rName +".\n he will be there in 5 min.");

                            Log.d(TAG, "onResponse: "+name+rName);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, "Error : " + error.toString());
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("mobileNo","9874563215" );
                    Log.d(TAG, "getParams: "+mobile);
                    return params;
                }
            };
            AppController.getInstance().addToRequestQueue(getspinnerData, TAG);
        } else {

        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_cont:
                Intent intent = new Intent(HomeActivity.this,OtherActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;

        }

    }
}

package com.globals.netconnect.kaka.App;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.widget.RecyclerView;
import android.util.Patterns;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Cons {
    public static final String CHANNEL_ID = "my_channel_01";
    public static final String CHANNEL_NAME = "";
    public static final String CHANNEL_DESCRIPTION = "";
    public static final String URL_BASE = "http://192.168.0.6:8080/TechTrack";
    public static final String URL_GET_LIST_OPTION =URL_BASE+"/getOption";
    public static final String URL_GET_SELECTED_OPTION =URL_BASE+"/getSelectedOption";
    public static final String URL_GET_USER_DATA =URL_BASE+"/getUserData";
    public static final String KEY_LOGGED_IN = "isLoggedIn";
    public static final String KEY_MOBILE_NO="Mobile_no";
    public static final String NETWORK_ERROR = "Please connect to Internet!";

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public static void ShowToast(Context activity, String str) {
        if (str != null)
            Toast.makeText(activity, str, Toast.LENGTH_LONG).show();
    }

    // validate email address.
    public static boolean validEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String mobile) {
        String regEx = "^[0-9]{10}$";
        return mobile.matches(regEx);
    }

    //Recycler View On touch Listener
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }


    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView rv, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = rv.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, rv.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {

                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

    }

}

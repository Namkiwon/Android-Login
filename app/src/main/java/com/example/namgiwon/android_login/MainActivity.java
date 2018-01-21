package com.example.namgiwon.android_login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.concurrent.ExecutionException;


public class MainActivity extends FragmentActivity {

    Intent loginIntent;
    Intent HomeIntent;

    String token;
    String token1;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        loginIntent = new Intent(this,LoginActivity.class);
//        HomeIntent = new Intent(this,HomeActivity.class);

        //토큰값을 받기위해 브로드캐스트 리시버 설
        LocalBroadcastManager.getInstance(this).registerReceiver(tokenReceiver,
                new IntentFilter("tokenReceiver"));

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(loginIntent);
                finish();
            }
        }, 3000);





    }
    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            switch (v.getId()){

            }
        }
    };

    BroadcastReceiver tokenReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            token = intent.getStringExtra("token");
            if(token != null)
            {
                //send token to your server or what you want to do
                Log.d("토큰",token+"<<<<<<<<<<<<<<<<<<<<<");
                startActivity(loginIntent);
                finish();

            }
        }
    };

}
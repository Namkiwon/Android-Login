package com.example.namgiwon.android_login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

/**
 * Created by namgiwon on 2018. 1. 21..
 */

public class LoginActivity extends AppCompatActivity {
    EditText ID;
    EditText PW;
    Button SignUp;
    Button SignIn;
    Intent SignupIntent;
    InputMethodManager imm1;
    LinearLayout loginLayout;
    String answer;
    String token;
    UserInfoVO userinfo;
    Gson gson;
    SharedMemory sharedMemory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int titlecolor = Color.parseColor("#00BBBB");
        getSupportActionBar().setTitle("Log In");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(titlecolor));

        gson = new Gson();
        imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        SignupIntent = new Intent(this,SignUpActivity.class);


        ID = (EditText) findViewById(R.id.id);
        PW = (EditText) findViewById(R.id.passwd);

        SignIn = (Button) findViewById(R.id.signIn);
        SignIn.setOnClickListener(bListener);

        SignUp = (Button) findViewById(R.id.signUp);
        SignUp.setOnClickListener(bListener);

        loginLayout = (LinearLayout) findViewById(R.id.loginlayout);
        loginLayout.setOnClickListener(bListener);

    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override

        public void onClick(View v) {
            hidekeyboard();
            switch (v.getId()){
                case R.id.signUp :  startActivity(SignupIntent); break;
                case R.id.signIn :
                    break;
            }
        }
    };

    private void hidekeyboard(){
        imm1.hideSoftInputFromWindow(ID.getWindowToken(),0);
        imm1.hideSoftInputFromWindow(PW.getWindowToken(),0);
    }
}

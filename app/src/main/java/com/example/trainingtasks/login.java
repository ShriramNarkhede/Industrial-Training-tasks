package com.example.trainingtasks;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class login extends AppCompatActivity {

    boolean doubletaptoexit=false;
    public  static  String PREFS_NAME="MYPRREFFILE";
    @Override
    public void onBackPressed() {
        if(doubletaptoexit){
            super.onBackPressed();
            return;
        }
        else {
            Toast.makeText(this, "press again to exit ", Toast.LENGTH_SHORT).show();
            doubletaptoexit = true;
            Handler handler= new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletaptoexit = false;
                }
            },2000);

        }
    }

    EditText pass,username;
    Button logi;
    String checkUn,checkpass;
    CheckBox cb;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username= findViewById(R.id.username);
        pass= findViewById(R.id.pass);
        logi = findViewById(R.id.logi);
        cb = findViewById(R.id.cb_show_pass);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb.isChecked()){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUn=username.getText().toString();
                checkpass = pass.getText().toString();
                String mail1="Shreeram";
                String pass1 ="9999";

                if(checkUn.isEmpty() ||  checkpass.isEmpty()){
                    Toast.makeText(login.this, "please enter username or password", Toast.LENGTH_SHORT).show();
                }
                else if(checkUn.length()<4  ){
                    username.setError("Username must contain it least four character");
                }
                else if( checkpass.length()<4) {
                    pass.setError("password must contain it least four character");
                }
                else if(checkUn.equals(mail1) && checkpass.equals(pass1)){
                    Toast.makeText(login.this, "login successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences=getSharedPreferences(login.PREFS_NAME,0);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putBoolean("hasLoggedIn",true);
                    editor.commit();



                    Intent i = new Intent(login.this,home.class);
                    i.putExtra("username_home",checkUn);
                    i.putExtra("password_home",checkpass);
                    startActivity(i);
                    finish();
//                  Intent intent = new Intent(login.this,blank.class);
//                  startActivity(intent);
                }
                else{
                    Toast.makeText(login.this, "Incorrect Information", Toast.LENGTH_SHORT).show();
                }
            }
        });
        TextView want ;


        want = findViewById(R.id.want);
        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, home.class);
                startActivity(intent);
            }
        });
    }
}
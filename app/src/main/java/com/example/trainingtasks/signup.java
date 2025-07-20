package com.example.trainingtasks;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    ImageView profile;
    private final int req_code=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        TextView already;
        EditText name,no,email,set_pass,conform_pass;
        Button register ;
        String gmail,setpass,conpass;
        TextView upload;
        CheckBox cb;

        name= findViewById(R.id.et_name);
//      profile= findViewById(R.id.img_profile);
        no= findViewById(R.id.et_no);
        email = findViewById(R.id.et_mail);
        set_pass = findViewById(R.id.et_set_pass);
        conform_pass = findViewById(R.id.et_con_pass);
        cb = findViewById(R.id.cb_show_pass);
        register=findViewById(R.id.btn_register);
        already=findViewById(R.id.tv_already);
        upload=findViewById(R.id.tv_upload_img);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb.isChecked()){
                    set_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    conform_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    set_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    conform_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.getText().toString().isEmpty() ) {
                    name.setError("please enter name");
                }
               else if( no.getText().toString().isEmpty()){
                    no.setError("please enter mobile number ");
                }

                else if(email.getText().toString().isEmpty() ||  conform_pass.getText().toString().isEmpty()|| set_pass.getText().toString().isEmpty()) {
                    Toast.makeText(signup.this, "please enter email or password", Toast.LENGTH_SHORT).show();
                }

                else if(no.getText().toString().length()<10  ){
                    no.setError("Invalid mobile number");
                }
                else if( set_pass.getText().toString().length() <6 && conform_pass.getText().toString().length()<6) {
                    set_pass.setError("password must contain it least six character");
                }
                else if(set_pass.getText().toString().equals(conform_pass.getText().toString())){
                    Toast.makeText(signup.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signup.this, home.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(signup.this, "Set password or conform password aren't same", Toast.LENGTH_SHORT).show();
                }
            }

        });
        
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this,login.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(signup.this,login.class);
        startActivity(intent);
        finish();
    }
}
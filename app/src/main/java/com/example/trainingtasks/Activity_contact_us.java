package com.example.trainingtasks;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Activity_contact_us extends AppCompatActivity {

    EditText mobile_no,message;
    Button send_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us2);
        mobile_no=findViewById(R.id.et_mobile_no);
        message=findViewById(R.id.et_msg);
        send_msg=findViewById(R.id.btn_send);

    //  ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Contact Us");


        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){

                        sendSms();
                    }else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);

                    }
                }
            }
        });
    }
    private void sendSms(){
        String  msg=message.getText().toString();
        String mob_no=mobile_no.getText().toString();
                //mobile_no.getText().toString();

               //"9921908795";
        try{
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(mob_no,null,msg,null,null);
            Toast.makeText(Activity_contact_us.this, "message sent successfully", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(Activity_contact_us.this, "failed to sent message", Toast.LENGTH_SHORT).show();

        }
    }
}

//    String  msg=message.getText().toString();
//    String mob_no=mobile_no.getText().toString();

//    Intent intent= new Intent(Activity_contact_us.this,Activity_contact_us.class);
//    PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);
//    SmsManager sms=SmsManager.getDefault();
//    sms.sendTextMessage(mob_no,null,msg,null,null);
//    Toast.makeText(Activity_contact_us.this, "message sent successfully", Toast.LENGTH_SHORT).show();





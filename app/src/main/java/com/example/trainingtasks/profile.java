package com.example.trainingtasks;


import static com.example.trainingtasks.home.setname;
import static com.example.trainingtasks.home.shree;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends AppCompatActivity {
public ImageView pick;
public static final int CAMERA_REQUEST=100;
public  static  final  int STORAGE_REQUEST=101;


    // One Preview Image


    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;
    String usern_prof;
    CircleImageView c1;
    ImageView imageView;
    ImageView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText editText=findViewById(R.id.get_token);
        String myn="Shreeram narkhede 111";
        setname(myn);

        SharedPreferences preferences= getSharedPreferences("token",0);
        String s1=preferences.getString("token","");
        if (editText.getText().equals("")){
            editText.setText(shree);
        }else {
            editText.setText(s1);
        }
        Toast.makeText(this, s1, Toast.LENGTH_SHORT).show();


            Button b1=findViewById(R.id.hom);
            TextView t1=findViewById(R.id.name);
            Intent i= getIntent();
            usern_prof=i.getStringExtra("username_prof");
            t1.setText(usern_prof);
            c1= findViewById(R.id.profimage);
            t2= findViewById(R.id.shree);



        // handle the Choose Image button to trigger
        // the image chooser function
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1= new Intent(profile.this, home.class);
                    startActivity(intent1);

                }
            });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(profile.this, home.class);
        startActivity(intent);
        finish();
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    c1.setImageURI(selectedImageUri);
                }
            }
        }
    }

}
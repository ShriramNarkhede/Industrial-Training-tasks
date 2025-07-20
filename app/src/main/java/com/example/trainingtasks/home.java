package com.example.trainingtasks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainingtasks.adapters.RecycyleV_Adapter;
import com.example.trainingtasks.models.valueset_get;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    RecyclerView recyclerView;
    public static String shree;
    ArrayList<valueset_get> list = new ArrayList<>();
    String usern,pass;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Dialog dialog;
        dialog=new Dialog(home.this);
        dialog.setContentView(R.layout.alert_box);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.backgroundwhite));
        Button yes=dialog.findViewById(R.id.btn_yes);
        Button no = dialog.findViewById(R.id.btn_no);
        // dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);



        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=  new Intent(home.this,login.class);
                SharedPreferences sharedPreferences=getSharedPreferences(login.PREFS_NAME,0);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",false);
                editor.commit();

                startActivity(i);
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        switch (item.getItemId()){



            case
                    R.id.Aco:
                Intent i1=  new Intent(home.this, profile.class);
                i1.putExtra("username_prof",usern);
                i1.putExtra("password_prof",pass);
                startActivity(i1);
                break;
            case
                R.id.g_map:
                Intent i2=  new Intent(home.this, MapsActivity.class);
                startActivity(i2);
                break;
            case
                    R.id.Contact:
                Toast.makeText(home.this, "Contact us", Toast.LENGTH_SHORT).show();
                Intent i3=  new Intent(home.this, Activity_contact_us.class);
                startActivity(i3);
                break;
            case R.id.bluetooth:

                Intent i5=  new Intent(home.this, BluetoothActivity.class);
                startActivity(i5);
                break;
            case
                    R.id.Feed:
                        Toast.makeText(home.this, "Contact us", Toast.LENGTH_SHORT).show();
                        Intent i4=  new Intent(home.this, text_to_speech.class);
                        startActivity(i4);
                        break;
            case
                    R.id.logout:
                dialog.show();
                break;
            case
                    R.id.About:
                Toast.makeText(home.this, "About Us", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.parademediagroup.com/parade/"));
                startActivity(i);
            break;
            default:
                break;
        }
        return true;
    }
public boolean doubletaptoexit=false;
    @Override
    public void onBackPressed() {
        if(doubletaptoexit){
            super.onBackPressed();
            return;

        }
        else {
            Toast.makeText(this, "press again to exit ", Toast.LENGTH_SHORT).show();
            doubletaptoexit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletaptoexit = false;
                }
            },2000);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i = getIntent();
         usern = i.getStringExtra("username_home");
         pass = i.getStringExtra("password_home");


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SharedPreferences sharedPreferences = getSharedPreferences("firstTime",MODE_PRIVATE);
        boolean firstTime=sharedPreferences.getBoolean("firstTime",true);

        if(firstTime){
            welcome();
        }
//        boolean abc = sharedPreferences.getBoolean("hasLoggedIn",Boolean.parseBoolean("hasLoggedIn"));
//        String username=sharedPreferences.getString("hasLoggedIn","");
//        Toast.makeText(this, ""+abc, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "My username is "+usern, Toast.LENGTH_SHORT).show();

        //recycler view

        recyclerView = findViewById(R.id.recyclerv);
        list.add(new valueset_get(R.drawable.sardar, "Sardar Patel"));
        list.add(new valueset_get(R.drawable.im7, "Johnny depp"));
        list.add(new valueset_get(R.drawable.elon, "Elon musk"));
        list.add(new valueset_get(R.drawable.abdul, "APJ Abdul kalam"));
        list.add(new valueset_get(R.drawable.bhagat, "Bhagat singh"));
        list.add(new valueset_get(R.drawable.biil, "Bill gates"));
        list.add(new valueset_get(R.drawable.download2, "steve jobs"));
        list.add(new valueset_get(R.drawable.ganpati, "Rune lazuli"));
        list.add(new valueset_get(R.drawable.im3, "Albert Einstein"));
        list.add(new valueset_get(R.drawable.im4, "Sardar Vallabhbhai Patel"));
        list.add(new valueset_get(R.drawable.im6, "Unknown"));
        list.add(new valueset_get(R.drawable.im9, "swami Sivananda"));
        list.add(new valueset_get(R.drawable.images, "Dolly parton"));
        list.add(new valueset_get(R.drawable.lal, "Lal Bahadur Shastri"));
        list.add(new valueset_get(R.drawable.im8, "Unknown"));
        list.add(new valueset_get(R.drawable.modiji, "Modi Ji"));
        list.add(new valueset_get(R.drawable.om, "Unknown"));

        RecycyleV_Adapter adapter = new RecycyleV_Adapter(list, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void welcome() {
//        new AlertDialog.Builder(blank.this)
//                .setIcon(R.drawable.ic_baseline_warning_24)
//                .setTitle("Welcome")
//                .setMessage("Welcome to our application")
//                .setPositiveButton("Thank you", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                }).show();

        Dialog welcome_dialog;
        welcome_dialog=new Dialog(home.this);
        welcome_dialog.setContentView(R.layout.welcome_abox);
      // welcome_dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.mynewview));
       welcome_dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView thank=welcome_dialog.findViewById(R.id.thank);
        thank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcome_dialog.dismiss();
            }
        });

        welcome_dialog.show();

        SharedPreferences sharedPreferences=getSharedPreferences("firstTime",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean("firstTime",false);
        editor.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu me) {
        getMenuInflater().inflate(R.menu.toolbar_menu,me);
        return true;
    }
    public static final void setname(String name){
        shree=name;
    }
}
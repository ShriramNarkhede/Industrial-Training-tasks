package com.example.trainingtasks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    TextView t;
    public static  int spash_time=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
//                            Log.w("MyTaskStatus", "Fetching FCM registration token failed", task.getException());
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast

//                        Log.d("myTaskMessage", token);
                        System.out.println(token);
                     //   Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences=getSharedPreferences("token",0);
                        SharedPreferences.Editor editor= preferences.edit();
                        editor.putString("token",token);
                        editor.commit();
                    }
                });




        t=findViewById(R.id.tv_Title);
        Animation animation= new AnimationUtils().loadAnimation(this,R.anim.exfadeintext);
        animation.setFillAfter(true);
        t.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(login.PREFS_NAME,0);
                boolean hasloggedIn=sharedPreferences.getBoolean("hasLoggedIn",false);

                if (hasloggedIn){
                    Intent intent= new Intent(MainActivity.this, home.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,login.class);
                    startActivity(intent);
                    finish();
                }


                finish();
            }
        },spash_time);



//
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent= new Intent(MainActivity.this,login.class);
//                startActivity(intent);
//
//
//                finish();
//            }
//        },2500);

        //****we can also use Thread class*****//


//                    Thread thread= new Thread(){
//                    @Override
//                    public void run() {
//                        try {
//                            sleep(4000);
//                        }
//                        catch (Exception e){
//                            e.printStackTrace();
//                        }
//                        finally {
//                                Intent intent= new Intent(MainActivity.this ,loginBackEnd.class);
//                                startActivity(intent);
//                                finish();
//                        }
//                    }
//                };thread.start();


    }
}








//
//
//import android.app.Activity;
//        import android.content.Context;
//        import android.media.AudioManager;
//        import android.os.Bundle;
//        import android.widget.SeekBar;
//        import android.widget.SeekBar.OnSeekBarChangeListener;
//
//public class TestExample extends Activity
//{
//    /** Called when the activity is first created. */
//
//    private SeekBar volumeSeekbar = null;
//    private AudioManager audioManager = null;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setVolumeControlStream(AudioManager.STREAM_MUSIC);
//        setContentView(R.layout.main);
//        initControls();
//    }
//
//    private void initControls()
//    {
//        try
//        {
//            volumeSeekbar = (SeekBar)findViewById(R.id.seekBar1);
//            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//            volumeSeekbar.setMax(audioManager
//                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
//            volumeSeekbar.setProgress(audioManager
//                    .getStreamVolume(AudioManager.STREAM_MUSIC));
//
//
//            volumeSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
//            {
//                @Override
//                public void onStopTrackingTouch(SeekBar arg0)
//                {
//                }
//
//                @Override
//                public void onStartTrackingTouch(SeekBar arg0)
//                {
//                }
//
//                @Override
//                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
//                {
//                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
//                            progress, 0);
//                }
//            });
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
package com.example.trainingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Locale;

public class text_to_speech extends AppCompatActivity {

    Button Speck;
    EditText Enter_text;
    SeekBar sk_Speed,sk_pitch;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        Speck=findViewById(R.id.btn_speck);
        Enter_text = findViewById(R.id.et_TTS_text);
        sk_Speed = findViewById(R.id.seekBar_speed);
        sk_pitch = findViewById(R.id.seekBar_pitch);
        
        
        Speck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });
        textToSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS)
                {
                    int result = textToSpeech.setLanguage(Locale.US);


                    if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA)
                    {
                        Toast.makeText(text_to_speech.this, "This Language is Not Supported", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                     speak();
                    }
                }
                else
                {
                    Toast.makeText(text_to_speech.this, "Failed To Understand", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }

    }

    private void speak() {


        String text = Enter_text.getText().toString();


        float pitch = (float)sk_pitch.getProgress()/50;
        if(pitch<0.1) pitch = 0.1f;

        float speed = (float)sk_Speed.getProgress()/50;
        if(speed<0.1) speed = 0.1f;


        textToSpeech.setSpeechRate(speed);
        textToSpeech.setPitch(pitch);

        if(text.equals(""))
        {
            Toast.makeText(text_to_speech.this, "Please Enter Your Text To Speak", Toast.LENGTH_SHORT).show();
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
        }
        else
        {
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }


    }
    }

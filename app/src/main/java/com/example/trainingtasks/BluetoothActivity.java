package com.example.trainingtasks;

import static com.example.trainingtasks.R.drawable.bluetooth2;
import static com.example.trainingtasks.R.drawable.bluetooth3;
import static com.example.trainingtasks.R.drawable.bluetooth_deactivate;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    Button turn_on, turn_of, get_visible, show_devices;
    ListView listView;
    BluetoothAdapter bluetooth;
    LottieAnimationView ic;
    Set<BluetoothDevice> bluetoothDevices;

    private static final int REQUEST1 = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        turn_on = findViewById(R.id.btn_turn_on);
        turn_of = findViewById(R.id.btn_turn_off);
        get_visible = findViewById(R.id.btn_getvisible);
        show_devices = findViewById(R.id.btn_show_devices);
        listView = findViewById(R.id.list_view);
        ic = findViewById(R.id.imageView1);

        bluetooth=BluetoothAdapter.getDefaultAdapter();
        if ((checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) &&
           (checkSelfPermission(Manifest.permission.BLUETOOTH_ADVERTISE)==PackageManager.PERMISSION_GRANTED)){

        }else {
            requestPermissions(new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 1);
            requestPermissions(new String[]{Manifest.permission.BLUETOOTH_ADVERTISE}, 1);
        }

if(bluetooth.isEnabled()){
    ic.setImageResource(R.drawable.bluetooth);
}
else{
    ic.setImageResource(bluetooth_deactivate);
}

        turn_on.setOnClickListener(new View.OnClickListener() {

            @SuppressLint({"MissingPermission", "ResourceType"})
            @Override
            public void onClick(View view) {

                if (bluetooth.isEnabled()) {
                    Toast.makeText(BluetoothActivity.this, "bluetooth is already enabled", Toast.LENGTH_SHORT).show();
                    ic.setAnimation(R.raw.bluetooth_anim);

                } else {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST1);
                    Toast.makeText(BluetoothActivity.this, "bluetooth enabled", Toast.LENGTH_SHORT).show();
                    ic.setAnimation(R.raw.bluetooth_anim);
                    Animation animation= new AnimationUtils().loadAnimation(BluetoothActivity.this,R.anim.exfadeintext);
                    animation.setFillAfter(true);
                    ic.startAnimation(animation);
                }
            }
        });

        turn_of.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {

                bluetooth.disable();
                ic.setImageResource(bluetooth_deactivate);
            }
        });


        get_visible.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(intent1, 0);
                ic.setAnimation(R.raw.bluetooth_anim);
            }
        });


        show_devices.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                bluetoothDevices =bluetooth.getBondedDevices();
                ArrayList list = new ArrayList();
                for(BluetoothDevice bt : bluetoothDevices){
                    list.add(bt.getName());
                    Toast.makeText(BluetoothActivity.this, "showing devices", Toast.LENGTH_SHORT).show();
                }
                ArrayAdapter adapter = new ArrayAdapter(BluetoothActivity.this,R.layout.support_simple_spinner_dropdown_item,list);
                listView.setAdapter(adapter);

                ic.setAnimation(R.raw.bluetooth_anim);



            }
        });
    }
}
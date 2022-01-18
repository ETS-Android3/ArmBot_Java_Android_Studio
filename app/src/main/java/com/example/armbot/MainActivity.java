package com.example.armbot;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.armbot.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Context context;
    private static BluetoothAdapter bluetoothAdapter;
    private ArmConnection armConnection;

    private final int LOCATION_PERMISSION_REQUEST = 101;
    private final int SELECT_DEVICE = 102;

    public static final int MESSAGE_STATE_CHANGED = 0;
    public static final int MESSAGE_READ = 1;
    public static final int MESSAGE_WRITE = 2;
    public static final int MESSAGE_DEVICE_NAME = 3;
    public static final int MESSAGE_TOAST = 4;

    public static final String DEVICE_NAME = "deviceName";
    public static final String TOAST = "toast";
    private String connectedDevice;
    public static boolean bluetoothEnabled = false;

    private final Handler handler = new Handler(new Handler.Callback() {
        @SuppressLint("HardwareIds")
        @Override
        public boolean handleMessage(Message message) {
            if (message.what == MESSAGE_STATE_CHANGED) {
                switch (message.arg1) {
                    case ArmConnection.STATE_NONE:
                    case ArmConnection.STATE_LISTEN:
                        setState("Not Connected");
                        break;
                    case ArmConnection.STATE_CONNECTING:
                        setState("Connecting...");
                        break;
                    case ArmConnection.STATE_CONNECTED:
                        setState("Connected: " + connectedDevice);
                        String messageSent = "Hello world";
                        armConnection.write(messageSent.getBytes());

                        messageSent = "My address is: " + bluetoothAdapter.getAddress();
                        armConnection.write(messageSent.getBytes());
                        break;
                }
            }
            return false;
        }
    });

    public void setState(CharSequence subTitle) {
        Objects.requireNonNull(getSupportActionBar()).setSubtitle(subTitle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_controller, R.id.nav_settings)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        context = this;

        armConnection = new ArmConnection(handler);
        initBluetooth();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_search_devices:
                checkPermission();
                return true;
            case R.id.menu_enable_bluetooth:
                enableBluetooth();
                return true;
            case R.id.menu_home:
                Intent intent2 = new Intent(context, MainActivity.class);
                startActivityForResult(intent2,SELECT_DEVICE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initBluetooth(){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null){
            Toast.makeText(context, "No Bluetooth found", Toast.LENGTH_SHORT).show();
        } else {
            if (!bluetoothAdapter.isEnabled()){
                Objects.requireNonNull(getSupportActionBar()).setSubtitle("Bluetooth Disabled");
            } else {
                if(bluetoothAdapter.getProfileConnectionState(BluetoothHeadset.HEADSET) != BluetoothAdapter.STATE_CONNECTED){
                    Objects.requireNonNull(getSupportActionBar()).setSubtitle("Not Connected");
                } else {
                    Objects.requireNonNull(getSupportActionBar()).setSubtitle("Connected: " + connectedDevice);
                }
            }
        }
    }

    private void enableBluetooth(){
        if (bluetoothAdapter.isEnabled()){
            Toast.makeText(context, "Bluetooth already enabled", Toast.LENGTH_SHORT).show();
        }
        else {
            bluetoothAdapter.enable();
            Toast.makeText(context, "Bluetooth enabled", Toast.LENGTH_SHORT).show();
            if (Objects.requireNonNull(getSupportActionBar()).getSubtitle() == "Bluetooth Disabled"){
                    getSupportActionBar().setSubtitle("Not Connected");
            }
            try {
                findViewById(R.id.enter_button).setEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new  String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST);
        }
        Intent intent = new Intent(context, DeviceListActivity.class);
        startActivityForResult(intent, SELECT_DEVICE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST){
            if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                new AlertDialog.Builder(context)
                        .setCancelable(false)
                        .setMessage("Location permission is required.\nPlease grant.")
                        .setPositiveButton("Grant", (dialog, which) -> checkPermission())
                        .setNegativeButton("Deny", (dialog, which) -> MainActivity.this.finish())
                        .show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int SELECT_DEVICE = 102;
        if (requestCode == SELECT_DEVICE && resultCode == RESULT_OK) {
            String address = data.getStringExtra("deviceAddress");
            armConnection.connect(bluetoothAdapter.getRemoteDevice(address));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (armConnection != null) {
            armConnection.stop();
        }
    }

    public static BluetoothAdapter getBluetoothAdapter() {
        return bluetoothAdapter;
    }
}
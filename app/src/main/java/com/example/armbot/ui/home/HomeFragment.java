package com.example.armbot.ui.home;

import static android.content.ContentValues.TAG;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.armbot.R;
import com.example.armbot.databinding.FragmentHomeBinding;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private final static int REQUEST_ENABLE_BT = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.enter_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_nav_home_to_nav_controller);
            }
        });

        /*BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        // Device doesn't support Bluetooth
        view.findViewById(R.id.enter_button).setEnabled(bluetoothAdapter != null);

        assert bluetoothAdapter != null;
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
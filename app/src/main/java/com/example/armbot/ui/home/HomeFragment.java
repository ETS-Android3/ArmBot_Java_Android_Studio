//
//  HomeFragment
//  ArmBot Android Application
//
//  Created by Anthony FERREYROLLES on 18/01/2022.
//  Copyright © 2022 ArmBot. All rights reserved.
//

package com.example.armbot.ui.home;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.armbot.MainActivity;
import com.example.armbot.R;
import com.example.armbot.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.enter_button).setOnClickListener(view1 -> NavHostFragment.findNavController(HomeFragment.this)
                .navigate(R.id.action_nav_home_to_nav_controller));

        /*BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        // Device doesn't support Bluetooth
        view.findViewById(R.id.enter_button).setEnabled(bluetoothAdapter != null);

        assert bluetoothAdapter != null;
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }*/

        BluetoothAdapter bluetoothAdapter = MainActivity.getBluetoothAdapter();

        if (!bluetoothAdapter.isEnabled()){
            view.findViewById(R.id.enter_button).setEnabled(false);
            MainActivity.bluetoothEnabled = false;
        } else {
            view.findViewById(R.id.enter_button).setEnabled(true);
            MainActivity.bluetoothEnabled = true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
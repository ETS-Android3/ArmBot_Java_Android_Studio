//
//  SettingsFragment
//  ArmBot Android Application
//
//  Created by Anthony FERREYROLLES on 18/01/2022.
//  Copyright © 2022 ArmBot. All rights reserved.
//

package com.example.armbot.ui.settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.armbot.MainActivity;
import com.example.armbot.R;
import com.example.armbot.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {
    //Variables declaration
    private FragmentSettingsBinding binding;

    /*
    Creates the view
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    /*
    When the view is created, call the init function
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @SuppressLint("SetTextI18n")
    private void init(View view) {
        /*
        Get the ArmSpeed button
         */
        Button buttonArmSpeed = view.findViewById(R.id.buttonArmSpeed);

        /*
        Set an on click listener
         */
        buttonArmSpeed.setOnClickListener(v -> {
            /*
            When the app is connected to the Raspberry
             */
            if (!MainActivity.getState().equals("Not Connected") && !MainActivity.getState().equals("No Connection") && !MainActivity.getState().equals("Connecting...")) {
                /*
                Get the speed
                 */
                String speed = MainActivity.getArmSpeed();
                switch (speed){
                    case "x 0.5":
                        /*
                        Changes the speed and sends the nex speed to the Raspberry
                         */
                        buttonArmSpeed.setText("x 0.75");
                        MainActivity.setArmSpeed("x 0.75");
                        MainActivity.SendAction("v_0.75");
                        break;
                    case "x 0.75":
                        buttonArmSpeed.setText("x 1");
                        MainActivity.setArmSpeed("x 1");
                        MainActivity.SendAction("v_1");
                        break;
                    case "x 1":
                        buttonArmSpeed.setText("x 1.25");
                        MainActivity.setArmSpeed("x 1.25");
                        MainActivity.SendAction("v_1.25");
                        break;
                    case "x 1.25":
                        buttonArmSpeed.setText("x 1.5");
                        MainActivity.setArmSpeed("x 1.5");
                        MainActivity.SendAction("v_1.5");
                        break;
                    case "x 1.5":
                        buttonArmSpeed.setText("x 0.5");
                        MainActivity.setArmSpeed("x 0.5");
                        MainActivity.SendAction("v_0.5");
                        break;
                    default:
                        buttonArmSpeed.setText("x 1");
                        MainActivity.setArmSpeed("x 1");
                        MainActivity.SendAction("v_1");
                        break;
                }
            } else {
                /*
                If not connected, shows the user a message saying to connect to the Raspberry
                 */
                Toast.makeText(getContext(), "Connection to arm needed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    Destoys the view
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
//
//  ControllerButtonsFragment
//  ArmBot Android Application
//
//  Created by Anthony FERREYROLLES on 18/01/2022.
//  Copyright © 2022 ArmBot. All rights reserved.
//

package com.example.armbot.ui.controller_buttons;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.armbot.ArmConnection;
import com.example.armbot.MainActivity;
import com.example.armbot.R;
import com.example.armbot.databinding.FragmentControllerButtonsBinding;

public class ControllerButtonsFragment extends Fragment {
    //Variables declaration
    private FragmentControllerButtonsBinding binding;

    /*
    Creates the view
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentControllerButtonsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Variables declaration
        ImageButton buttonUp            = view.findViewById(R.id.buttonUpArrow);
        ImageButton buttonDown          = view.findViewById(R.id.buttonDownArrow);
        ImageButton buttonRight         = view.findViewById(R.id.buttonRightArrow);
        ImageButton buttonLeft          = view.findViewById(R.id.buttonLeftArrow);
        ImageButton buttonForward       = view.findViewById(R.id.buttonForwardArrow);
        ImageButton buttonBackward      = view.findViewById(R.id.buttonBackwardArrow);
        ImageButton buttonOpen          = view.findViewById(R.id.buttonOpenArrow);
        ImageButton buttonClose         = view.findViewById(R.id.buttonCloseArrow);
        ImageButton buttonRightRotation = view.findViewById(R.id.buttonRightRotationArrow);
        ImageButton buttonLeftRotation  = view.findViewById(R.id.buttonLeftRotationArrow);

        Button buttonReset              = view.findViewById(R.id.buttonReset);

        /*
        On click listener to move to the Seekbar controller view.
        Had to be removed due to a lack of time.
         */
        /*
        view.findViewById(R.id.buttonSeekbarController).setOnClickListener(view1 -> NavHostFragment.findNavController(ControllerButtonsFragment.this)
                .navigate(R.id.action_nav_button_controller_to_nav_seekbar_controller));
         */

        Handler mHandler = new Handler();

        /*
        repeats the action while the user touches the button
        */
        buttonUp.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /*
                        Sends an action to the raspberry
                         */
                        MainActivity.SendAction("1");

                        /*
                        The first thought was to control the arm by sending the angle the motor had to move to
                        by increasing or decreasing it directly from the app. Now, it is the raspberry that controls
                        the motors.
                         */
                        //ControllerButtonsViewModel.setDegreesMotor4(ControllerButtonsViewModel.getDegreesMotor4() + 1);

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonDown.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("2");

                        //ControllerButtonsViewModel.setDegreesMotor4(ControllerButtonsViewModel.getDegreesMotor4() - 1);

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonForward.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("3");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor2(ControllerButtonsViewModel.getDegreesMotor2() + 1);
                        ControllerButtonsViewModel.setDegreesMotor3(ControllerButtonsViewModel.getDegreesMotor3() + 1);
                        */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonBackward.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("4");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor2(ControllerButtonsViewModel.getDegreesMotor2() - 1);
                        ControllerButtonsViewModel.setDegreesMotor3(ControllerButtonsViewModel.getDegreesMotor3() - 1);
                        */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonLeft.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("5");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor1(ControllerButtonsViewModel.getDegreesMotor1() - 1);
                         */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonRight.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("6");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor1(ControllerButtonsViewModel.getDegreesMotor1() + 1);
                         */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonOpen.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("7");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor6(ControllerButtonsViewModel.getDegreesMotor6() + 1);
                         */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonClose.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("8");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor6(ControllerButtonsViewModel.getDegreesMotor6() - 1);
                         */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonLeftRotation.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("9");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor5(ControllerButtonsViewModel.getDegreesMotor5() - 1);
                         */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        buttonRightRotation.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.SendAction("10");

                        /*
                        ControllerButtonsViewModel.setDegreesMotor5(ControllerButtonsViewModel.getDegreesMotor5() + 1);
                         */

                        mHandler.postDelayed(this, 500); // 0.5 seconds
                    }
                }, 0); // 0 seconds
                return false;
            }
            if (event.getAction() == MotionEvent.ACTION_UP){
                mHandler.removeCallbacksAndMessages(null);
                return false;
            }
            return false;
        });

        /*
        Sends a "0" to the Raspberry
         */
        buttonReset.setOnClickListener(v -> MainActivity.SendAction("0"));
    }


    /*
    Destroys the view
    */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
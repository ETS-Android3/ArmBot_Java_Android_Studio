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
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.armbot.R;
import com.example.armbot.databinding.FragmentControllerButtonsBinding;

public class ControllerButtonsFragment extends Fragment {

    private FragmentControllerButtonsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentControllerButtonsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.buttonSeekbarController).setOnClickListener(view1 -> NavHostFragment.findNavController(ControllerButtonsFragment.this)
                .navigate(R.id.action_nav_button_controller_to_nav_seekbar_controller));

        ImageButton buttonUp = (ImageButton) view.findViewById(R.id.buttonUpArrow);
        ImageButton buttonDown = view.findViewById(R.id.buttonDownArrow);
        ImageButton buttonRight = view.findViewById(R.id.buttonRightArrow);
        ImageButton buttonLeft = view.findViewById(R.id.buttonLeftArrow);
        ImageButton buttonForward = view.findViewById(R.id.buttonForwardArrow);
        ImageButton buttonBackward = view.findViewById(R.id.buttonBackwardArrow);
        ImageButton buttonOpen = view.findViewById(R.id.buttonOpenArrow);
        ImageButton buttonClose = view.findViewById(R.id.buttonCloseArrow);
        ImageButton buttonRightRotation = view.findViewById(R.id.buttonRightRotationArrow);
        ImageButton buttonLeftRotation = view.findViewById(R.id.buttonLeftRotationArrow);

        Handler mHandler = new Handler();

        buttonUp.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //Button pressed
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ControllerButtonsViewModel.setDegreesMotor4(ControllerButtonsViewModel.getDegreesMotor4() + 1);
                        System.out.println(ControllerButtonsViewModel.getDegreesMotor4());
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
                        ControllerButtonsViewModel.setDegreesMotor4(ControllerButtonsViewModel.getDegreesMotor4() - 1);
                        System.out.println(ControllerButtonsViewModel.getDegreesMotor4());
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
                        ControllerButtonsViewModel.setDegreesMotor2(ControllerButtonsViewModel.getDegreesMotor2() + 1);
                        ControllerButtonsViewModel.setDegreesMotor3(ControllerButtonsViewModel.getDegreesMotor3() + 1);
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
                        ControllerButtonsViewModel.setDegreesMotor2(ControllerButtonsViewModel.getDegreesMotor2() - 1);
                        ControllerButtonsViewModel.setDegreesMotor3(ControllerButtonsViewModel.getDegreesMotor3() - 1);
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
                        ControllerButtonsViewModel.setDegreesMotor1(ControllerButtonsViewModel.getDegreesMotor1() - 1);
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
                        ControllerButtonsViewModel.setDegreesMotor1(ControllerButtonsViewModel.getDegreesMotor1() + 1);
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
                        ControllerButtonsViewModel.setDegreesMotor6(ControllerButtonsViewModel.getDegreesMotor6() + 1);
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
                        ControllerButtonsViewModel.setDegreesMotor6(ControllerButtonsViewModel.getDegreesMotor6() - 1);
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
                        ControllerButtonsViewModel.setDegreesMotor5(ControllerButtonsViewModel.getDegreesMotor5() - 1);
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
                        ControllerButtonsViewModel.setDegreesMotor5(ControllerButtonsViewModel.getDegreesMotor5() + 1);
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
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
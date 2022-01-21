//
//  ControllerSeekbarsFragment
//  ArmBot Android Application
//
//  Created by Anthony FERREYROLLES on 18/01/2022.
//  Copyright © 2022 ArmBot. All rights reserved.
//

package com.example.armbot.ui.controller_seekbars;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.armbot.R;
import com.example.armbot.databinding.FragmentControllerSeekbarsBinding;

public class ControllerSeekbarsFragment extends Fragment {
    //Variables declaration
    private FragmentControllerSeekbarsBinding binding;

    /*
    Creates the view
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentControllerSeekbarsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        On click listener to move to the Button controller view.
         */
        view.findViewById(R.id.buttonButtonsController).setOnClickListener(view1 -> NavHostFragment.findNavController(ControllerSeekbarsFragment.this)
                .navigate(R.id.action_nav_seekbar_controller_to_nav_button_controller));
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
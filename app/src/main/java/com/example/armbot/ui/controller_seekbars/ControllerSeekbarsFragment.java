package com.example.armbot.ui.controller_seekbars;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.armbot.R;
import com.example.armbot.databinding.FragmentControllerSeekbarsBinding;

public class ControllerSeekbarsFragment extends Fragment {

    private ControllerSeekbarsViewModel controllerSeekbarsViewModel;
    private FragmentControllerSeekbarsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        controllerSeekbarsViewModel =
                new ViewModelProvider(this).get(ControllerSeekbarsViewModel.class);

        binding = FragmentControllerSeekbarsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.buttonButtonsController).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.armbot.ui.controller_seekbars.ControllerSeekbarsFragment.this)
                        .navigate(R.id.action_nav_seekbar_controller_to_nav_button_controller);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
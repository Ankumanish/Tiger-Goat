package com.example.game;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class setting_setup extends Dialog {

    ToggleButton soundButton;

    MainActivity mainActivity;

    public setting_setup(@NonNull Context context,MainActivity mainActivity){
        super(context);
        this.mainActivity=mainActivity;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_setup);

        // Set the dialog width to match the activity width
        if (getWindow() != null) {
            // Set layout width to match_parent
            getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        // Initialize the Music ToggleButton
        soundButton = findViewById(R.id.btn1);

        // Set ToggleButton state based on SoundManager for Movement Sound
        soundButton.setChecked(SoundManager.getInstance(getContext()).isMovementSoundPlaying());

        // Set an OnCheckedChangeListener for the Sound ToggleButton
        soundButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                SoundManager.getInstance(getContext()).setPlaySound();
                SoundManager.getInstance(getContext()).playMovementSound();
            } else {
                SoundManager.getInstance(getContext()).setPauseSound();
            }
        });


        // Back Button
        setOnKeyListener((dialog, keyCode, event) -> {
            if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP){
                showExitDialog();
                return true;
            }
            return false;
        });

    }

    private void showExitDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.exit_dialog, null);
        builder.setView(customView);

        AlertDialog exitDialog = builder.create();

        Button yesButton = customView.findViewById(R.id.yesButton);
        Button noButton = customView.findViewById(R.id.noButton);

        yesButton.setOnClickListener(v -> {
            dismiss();
            finishAffinity(mainActivity);
        });

        noButton.setOnClickListener(v -> exitDialog.dismiss());

        exitDialog.show();
    }

}
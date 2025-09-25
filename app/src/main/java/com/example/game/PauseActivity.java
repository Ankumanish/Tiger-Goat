package com.example.game;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class PauseActivity extends Dialog {

    private final Context mContext;
    ToggleButton soundButton;

    public PauseActivity(@NonNull Context context){
        super(context);
        this.mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_activity);

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


        final Button homeButton=findViewById(R.id.img1);
        final Button rePlayButton=findViewById(R.id.img2);
        final Button resumeButton=findViewById(R.id.resumeBtn);

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(),MainActivity.class);
            getContext().startActivity(intent);
            dismiss();

            if (mContext instanceof Design) {
                ((Design) mContext).overridePendingTransition(R.anim.slide_in_center, R.anim.slide_out_center);
            } else if (mContext instanceof Design2) {
                ((Design2) mContext).overridePendingTransition(R.anim.slide_in_center, R.anim.slide_out_center);
            }

        });

        rePlayButton.setOnClickListener(v -> {
            Intent intent;

            if (mContext instanceof Design) {
                intent=new Intent(getContext(), Design.class);
                getContext().startActivity(intent);

                ((Design) mContext).overridePendingTransition(R.anim.slide_in_center, R.anim.slide_out_center);
            }

            else if (mContext instanceof Design2) {
                intent=new Intent(getContext(), Design2.class);
                getContext().startActivity(intent);

                ((Design2) mContext).overridePendingTransition(R.anim.slide_in_center, R.anim.slide_out_center);
            }

            dismiss();

        });

        resumeButton.setOnClickListener(v -> dismiss());

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
            if (mContext instanceof Design) {
                finishAffinity((Design) mContext);
            }
            if (mContext instanceof Design2){
                finishAffinity((Design2) mContext);
            }
        });

        noButton.setOnClickListener(v -> exitDialog.dismiss());

        exitDialog.show();

    }

}
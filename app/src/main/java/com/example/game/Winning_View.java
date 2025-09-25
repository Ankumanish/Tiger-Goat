package com.example.game;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class Winning_View extends Dialog {

    private final Context mContext;
    private TextView textView;
    private String winningText;

    public Winning_View(@NonNull Context context){
        super(context);
        this.mContext=context;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winning_view);

        textView=findViewById(R.id.peice1);
        // Check if winningText is not null, then set it to the TextView
        if (winningText != null) {
            textView.setText(winningText);
        }

        // Set the dialog width to match the activity width
        if (getWindow() != null) {
            // Set layout width to match_parent
            getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        final Button homeButton=findViewById(R.id.img1);
        final Button rePlayButton=findViewById(R.id.img2);

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

        setOnKeyListener((dialog, keyCode, event) -> {
            if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP){
                showExitDialog();
                return true;
            }
            return false;
        });


    }

    // Method to set the string in the TextView
    public void setWinningText(String text) {

        this.winningText = text;

        // If textView is already initialized, set the text directly
        if (textView != null) {
            textView.setText(text);
        }

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
package com.example.game;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BackPressHandler {

    public static void showExitDialog(Context context) {
        // Create a custom dialog
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.exit_dialog);
        dialog.setCancelable(true); // Allow it to be canceled by tapping outside

        // Get dialog elements
        dialog.findViewById(R.id.title);
        dialog.findViewById(R.id.message);
        Button yesButton = dialog.findViewById(R.id.yesButton);
        Button noButton = dialog.findViewById(R.id.noButton);

        // Set up button click handlers
        yesButton.setOnClickListener(v -> {
            // Exit the app
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).finishAffinity();
            }
            dialog.dismiss(); // Dismiss the dialog
        });

        noButton.setOnClickListener(v -> {
            // Dismiss the dialog
            dialog.dismiss();
        });

        // Show the dialog
        dialog.show();
    }
}

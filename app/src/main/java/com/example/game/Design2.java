package com.example.game;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class Design2 extends AppCompatActivity {

    TextView remaining1,kills1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design2);

        remaining1=findViewById(R.id.remaining);
        kills1=findViewById(R.id.kills);

        // Initialize the board and pass the TextViews to it
        board2 gameBoard = findViewById(R.id.board);
        gameBoard.setTextViews(remaining1, kills1);

        // Back Button
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                BackPressHandler.showExitDialog(Design2.this);
            }
        });


    }

    public void pauseButtonClick(View view) {

        PauseActivity pause=new PauseActivity(Design2.this);
        // st.setCancelable(false);
        pause.show();
        overridePendingTransition(R.anim.slide_in_center,R.anim.slide_out_center);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release SoundManager resources when the app is closed
        SoundManager.getInstance(this).release();
    }

}
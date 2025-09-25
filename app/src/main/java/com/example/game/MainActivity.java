package com.example.game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;


import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public static int width;
    public static int height;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the screen size
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        width = metrics.widthPixels;
        height = metrics.heightPixels;

        // Back Button
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                BackPressHandler.showExitDialog(MainActivity.this);
            }
        });


    }


    public void settingButtonClick(View view){

        setting_setup st=new setting_setup(MainActivity.this,this);
        st.show();
        overridePendingTransition(R.anim.slide_in_center,R.anim.slide_out_center);

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void board1Click(View view) {
        Intent intent = new Intent(this,Design.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_center,R.anim.slide_out_center);
    }

    public void board2Click(View view) {
        Intent intent = new Intent(this,Design2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_center,R.anim.slide_out_center);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release SoundManager resources when the app is closed
        SoundManager.getInstance(this).release();
    }

}
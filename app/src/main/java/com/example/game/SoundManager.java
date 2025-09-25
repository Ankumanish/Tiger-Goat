package com.example.game;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {
    private static SoundManager instance;
    private MediaPlayer movementPlayer;
    private MediaPlayer capturePlayer;

    private boolean isSoundPlaying = true;

    private SoundManager(Context context) {
        movementPlayer = MediaPlayer.create(context, R.raw.move);
        capturePlayer = MediaPlayer.create(context,R.raw.capture);
    }

    public static synchronized SoundManager getInstance(Context context) {
        if (instance == null) {
            instance = new SoundManager(context.getApplicationContext());
        }
        return instance;
    }

    public void setPlaySound(){
        isSoundPlaying=true;
    }

    public void setPauseSound(){
        isSoundPlaying=false;
    }

    public void playMovementSound() {
        if (isSoundPlaying) {
            movementPlayer.start();
        }
    }

    public void playCaptureSound() {
        if (isSoundPlaying) {
            capturePlayer.start();
        }
    }

    public boolean isMovementSoundPlaying() {
        return isSoundPlaying;
    }

    public void release() {
        if (movementPlayer != null) {
            movementPlayer.release();
            movementPlayer = null;
        }
        if(capturePlayer != null){
            capturePlayer.release();
            capturePlayer = null;
        }

    }

}

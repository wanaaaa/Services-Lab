package com.example.ubun17.player02;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by ubun17 on 8/8/16.
 */
public class MyService extends Service implements MediaPlayer.OnPreparedListener {
    private static final String ACTION_PLAY = "com.example.action.PLAY";
    MediaPlayer mMediaPlayer = null;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3"; // your URL here
        mMediaPlayer = new MediaPlayer();
        //mMediaPlayer = MediaPlayer.create(this, R.raw.s);// raw/s.mp3
        mMediaPlayer.setOnCompletionListener(this);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(ACTION_PLAY)) {

            String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3"; // your URL here
            mMediaPlayer = new MediaPlayer();
            try {
                mMediaPlayer.setDataSource(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            mMediaPlayer.prepareAsync();
        }
    }



    /** Called when MediaPlayer is ready */
    public void onPrepared(MediaPlayer player) {
        player.start();
    }
}


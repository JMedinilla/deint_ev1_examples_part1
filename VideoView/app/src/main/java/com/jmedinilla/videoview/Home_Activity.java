package com.jmedinilla.videoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Home_Activity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mc = new MediaController(Home_Activity.this);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.spook);
        videoView.setMediaController(mc);
    }

    @Override
    protected void onResume() {
        super.onResume();

        videoView.resume();
    }

    @Override
    protected void onStart() {
        super.onStart();

        videoView.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("position", videoView.getCurrentPosition());

        boolean playing = getIntent().getExtras().getBoolean("playing");
        if(!playing){

            videoView.pause();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        videoView.seekTo(savedInstanceState.getInt("position"));

        boolean playing = getIntent().getExtras().getBoolean("playing");
        if(!playing){

            videoView.pause();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        boolean playing = videoView.isPlaying();
        getIntent().putExtra("playing", playing);
        if(!playing){

            videoView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        videoView.suspend();
    }
}

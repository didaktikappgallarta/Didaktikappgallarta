package com.example.didaktikapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class VideoCrucigramaActivity extends AppCompatActivity {
    private VideoView video;
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_crucigrama);

        video= (VideoView) findViewById(R.id.videoView);
        video.setVideoURI(Uri.parse(String.valueOf("android.resource://" + getPackageName() + "/" + R.raw.conchabideoa)));

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);

    }


    public void pasarActividadCrucigrama(View v) {
        Intent intent = new Intent(VideoCrucigramaActivity.this, CrucigramaActivity.class);
        startActivity(intent);
    }
}

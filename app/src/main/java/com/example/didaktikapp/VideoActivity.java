package com.example.didaktikapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    private VideoView video;
    private String localizacion;
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Bundle extras = getIntent().getExtras();
        localizacion = extras.getString("localizacion");

        switch (localizacion)
        {
            case "concha":
                video = (VideoView) findViewById(R.id.videoView);
                video.setVideoURI(Uri.parse(String.valueOf("android.resource://" + getPackageName() + "/" + R.raw.conchabideoa)));
                break;
            case "aliron":
                video = (VideoView) findViewById(R.id.videoView);
                video.setVideoURI(Uri.parse(String.valueOf("android.resource://" + getPackageName() + "/" + R.raw.alironbideoa)));
                break;
        }

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
    }


    public void pasarActividadDesdeVideo(View v) {
        switch (localizacion)
        {
            case "concha":
                Intent intent = new Intent(VideoActivity.this, CrucigramaActivity.class);
                startActivity(intent);
                break;
            case "aliron":
                Intent intento = new Intent(VideoActivity.this, MensajeMisteriosoActivity.class);
                startActivity(intento);
                break;
        }

    }
}

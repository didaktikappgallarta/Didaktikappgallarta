package com.example.didaktikapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamineto_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        ImageView logo = findViewById(R.id.logo);
        TextView nombre1 = findViewById(R.id.nombre1);
        TextView nombre2 = findViewById(R.id.nombre2);

        logo.setAnimation(animacion1);
        nombre1.setAnimation(animacion2);
        nombre2.setAnimation(animacion2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MemoramaActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
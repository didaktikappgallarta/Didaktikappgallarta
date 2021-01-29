package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DialogoActivity extends AppCompatActivity {
    TextView dialogo;
    String marca;
    TextView actividad;
    InputStream fraw = null;
    ImageView karmele;
    int contTeoria1 = 1;
    int contTeoria6 = 1;
    int contTeoria7 = 1;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo);
        dialogo = findViewById(R.id.dialogo);
        actividad = findViewById(R.id.actividad);
        karmele = findViewById(R.id.karmele);

        Bundle extras = getIntent().getExtras();
        marca = extras.getString("marca");

        try{
            switch (marca)
            {
                case "Zugaztieta":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera1);
                    actividad.setText("Zugaztieta");

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_sarrera_zugaztieta);
                    mediaPlayer.start();
                    break;

                case "MinaConcha":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera2);
                    actividad.setText("MinaConcha");

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_sarrera_concha);
                    mediaPlayer.start();
                    break;

                case "MuseoMineria":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera3);
                    actividad.setText("MuseoMineria");

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_sarrera_museo);
                    mediaPlayer.start();
                    break;

                case "Transporte":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera4);
                    actividad.setText("Transporte");

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_sarrera_transporte);
                    mediaPlayer.start();
                    break;

                case "DoctorAreilza":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera5);
                    actividad.setText("DoctorAreilza");

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_sarrera_doctor);
                    mediaPlayer.start();
                    break;

                case "Pasionaria":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera6);
                    actividad.setText("Pasionaria");

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_sarrera_pasionaria);
                    mediaPlayer.start();
                    break;

                case "AllIron":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera7);
                    actividad.setText("AllIron");

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_sarrera_aliron);
                    mediaPlayer.start();
                    break;
            }

            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

            String linea = brin.readLine();
            while (linea != null)
            {
                dialogo.setText(linea);
                linea = brin.readLine();
            }
            fraw.close();
        }catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero de recursos en Assets");
        }
    }

    public void pasarActividad(View v) throws IOException {
        String accion = actividad.getText().toString();
        Intent intent;
        BufferedReader brin;
        String linea;

        switch (accion) {
            case "Zugaztieta":
                intent = new Intent(DialogoActivity.this, PuzzleActivity.class);
                startActivity(intent);

                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_teoria_zugaztieta);
                mediaPlayer.start();
                break;

            case "MinaConcha":
                switch (contTeoria1)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt1);

                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_teoria_concha);
                        mediaPlayer.start();

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria1++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt2);

                        mediaPlayer.seekTo(33);
                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria1++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt3);

                        mediaPlayer.seekTo(113);
                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria1++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt5);

                        mediaPlayer.seekTo(137);
                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria1++;
                        break;

                    case 5:
                        karmele.setImageResource(R.drawable.karmele_animazioa6);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt4);

                        mediaPlayer.seekTo(153);
                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria1++;
                        break;

                    case 6:
                        intent = new Intent(DialogoActivity.this, VideoActivity.class);
                        intent.putExtra("localizacion", "concha");
                        startActivity(intent);
                        
                        break;
                }
                break;

            case "MuseoMineria":
                intent = new Intent(DialogoActivity.this, MemoramaActivity.class);
                startActivity(intent);

                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_teoria_museo);
                mediaPlayer.start();
                break;
/////////////////////////////Actividades sin codificar///////////////////////////////////////

            case "Transporte":
                //intent = new Intent(DialogoActivity.this, RellenarHuecosActivity.class);
                //startActivity(intent);

                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_teoria_transporte);
                mediaPlayer.start();
                break;

            case "DoctorAreilza":
                //intent = new Intent(DialogoActivity.this, CrossWordActivity.class);
                //startActivity(intent);

                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_teoria_doctor);
                mediaPlayer.start();
                break;

/////////////////////////////Actividades sin codificar///////////////////////////////////////

            case "Pasionaria":
                switch (contTeoria6)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt1);

                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_teoria_pasionaria);
                        mediaPlayer.start();

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt2);

                        mediaPlayer.seekTo(20);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt3);

                        mediaPlayer.seekTo(51);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt4);

                        mediaPlayer.seekTo(111);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 5:
                        intent = new Intent(DialogoActivity.this, AhorcadoActivity.class);
                        startActivity(intent);
                        break;
                }
                break;


            case "AllIron":
                switch (contTeoria7)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt1);

                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.karmele_teoria_aliron);
                        mediaPlayer.start();

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt2);

                        mediaPlayer.seekTo(20);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt3);

                        mediaPlayer.seekTo(45);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt4);

                        mediaPlayer.seekTo(112);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 5:
                        intent = new Intent(DialogoActivity.this, VideoActivity.class);
                        intent.putExtra("localizacion", "aliron");
                        startActivity(intent);
                        break;
                }
                break;
        }

    }
}
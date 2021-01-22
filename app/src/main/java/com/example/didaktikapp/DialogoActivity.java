package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    int contTeoria2 = 1;
    int contTeoria3 = 1;
    int contTeoria4 = 1;
    int contTeoria6 = 1;
    int contTeoria7 = 1;
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
                    break;

                case "MinaConcha":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera2);
                    actividad.setText("MinaConcha");
                    break;

                case "MuseoMineria":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera3_pt1);
                    actividad.setText("MuseoMineria");
                    break;

                case "Transporte":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera4_pt1);
                    actividad.setText("Transporte");
                    break;

                case "DoctorAreilza":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera5);
                    actividad.setText("DoctorAreilza");
                    break;

                case "Pasionaria":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera6);
                    actividad.setText("Pasionaria");
                    break;

                case "AllIron":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera7);
                    actividad.setText("AllIron");
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

    public void avanzar(View v) throws IOException {
        String accion = actividad.getText().toString();
        Intent intent;
        BufferedReader brin;
        String linea;

        switch (accion) {
            case "Zugaztieta":
                intent = new Intent(DialogoActivity.this, PuzzleActivity.class);
                startActivity(intent);
                finish();
                break;

            case "MinaConcha":
                switch (contTeoria2)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt1);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria2++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria2++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt3);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria2++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt4);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria2++;
                        break;

                    case 5:
                        karmele.setImageResource(R.drawable.karmele_animazioa6);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria2_pt5);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria2++;
                        break;

                    case 6:
                        intent = new Intent(DialogoActivity.this, VideoActivity.class);
                        intent.putExtra("localizacion", "concha");
                        startActivity(intent);
                        finish();
                        break;
                }
                break;

            case "MuseoMineria":
                switch (contTeoria3) {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_sarrera3_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria3++;
                        break;

                    case 2:
                        intent = new Intent(DialogoActivity.this, MemoramaActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                break;

            case "Transporte":
                switch (contTeoria4) {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_sarrera4_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria4++;
                        break;

                    case 2:
                        intent = new Intent(DialogoActivity.this, RellenarHuecosActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                break;

            case "DoctorAreilza":
                //intent = new Intent(DialogoActivity.this, CrossWordActivity.class);
                //startActivity(intent);
                finish();
                break;

            case "Pasionaria":
                switch (contTeoria6)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt1);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt3);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria6_pt4);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria6++;
                        break;

                    case 5:
                        intent = new Intent(DialogoActivity.this, AhorcadoActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                break;


            case "AllIron":
                switch (contTeoria7)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt1);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt3);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria7_pt4);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria7++;
                        break;

                    case 5:
                        intent = new Intent(DialogoActivity.this, VideoActivity.class);
                        intent.putExtra("localizacion", "aliron");
                        startActivity(intent);
                        finish();
                        break;
                }
                break;
        }

    }
}
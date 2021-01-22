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

public class PostJuegoActivity extends AppCompatActivity {
    TextView dialogo;
    String localizacion;
    TextView actividad;
    InputStream fraw = null;
    ImageView karmele;
    int contTeoria1 = 1;
    int contTeoria3 = 1;
    int contTeoria4 = 1;
    int contTeoria5 = 1;
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
        localizacion = extras.getString("localizacion");

        try {
            switch (localizacion) {
                case "Zugaztieta":
                    actividad.setText("Zugaztieta");
                    fraw = getResources().openRawResource(R.raw.karmele_teoria1_pt1);
                    break;

                case "MinaConcha":
                    actividad.setText("MinaConcha");
                    fraw = getResources().openRawResource(R.raw.karmele_letra2);
                    break;

                case "MuseoMineria":
                    actividad.setText("MuseoMineria");
                    fraw = getResources().openRawResource(R.raw.karmele_teoria3_pt1);
                    break;

                case "Transporte":
                    actividad.setText("Transporte");
                    fraw = getResources().openRawResource(R.raw.karmele_teoria4_pt1);
                    break;

                case "DoctorAreilza":
                    actividad.setText("DoctorAreilza");
                    fraw = getResources().openRawResource(R.raw.karmele_teoria5_pt1);
                    break;

                case "Pasionaria":
                    actividad.setText("Pasionaria");
                    fraw = getResources().openRawResource(R.raw.karmele_letra6);
                    break;

                case "AllIron":
                    actividad.setText("AllIron");
                    fraw = getResources().openRawResource(R.raw.karmele_letra7);
                    break;
            }

            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

            String linea = brin.readLine();
            while (linea != null) {
                dialogo.setText(linea);
                linea = brin.readLine();
            }
            fraw.close();
        } catch (Exception ex) {
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
                switch (contTeoria1)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria1_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria1++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_letra1);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria1++;
                        break;

                    case 3:
                        //////////////////////Escribir letra en un fichero///////////////////////////////////
                        finish();
                        break;
                }
                break;

            case "MinaConcha":
                //////////////////////Escribir letra en un fichero///////////////////////////////////
                finish();

                break;

            case "MuseoMineria":
                switch (contTeoria3)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria3_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria3++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria3_pt3);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria3++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria3_pt4);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria3++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria3_pt5);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria3++;
                        break;

                    case 5:
                        karmele.setImageResource(R.drawable.karmele_animazioa6);
                        fraw = getResources().openRawResource(R.raw.karmele_letra3);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria3++;
                        break;

                    case 6:
                        //////////////////////Escribir letra en un fichero///////////////////////////////////
                        finish();
                        break;

                }
                break;

            case "Transporte":
                switch (contTeoria4)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria4_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria4++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria4_pt3);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria4++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria4_pt4);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria4++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria4_pt5);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria4++;
                        break;

                    case 5:
                        karmele.setImageResource(R.drawable.karmele_animazioa6);
                        fraw = getResources().openRawResource(R.raw.karmele_letra4);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria4++;
                        break;

                    case 6:
                        //////////////////////Escribir letra en un fichero///////////////////////////////////
                        finish();
                        break;

                }
                break;

            case "DoctorAreilza":
                switch (contTeoria5)
                {
                    case 1:
                        karmele.setImageResource(R.drawable.karmele_animazioa2);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria5_pt2);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria5++;
                        break;

                    case 2:
                        karmele.setImageResource(R.drawable.karmele_animazioa3);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria5_pt3);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria5++;
                        break;

                    case 3:
                        karmele.setImageResource(R.drawable.karmele_animazioa4);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria5_pt4);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria5++;
                        break;

                    case 4:
                        karmele.setImageResource(R.drawable.karmele_animazioa5);
                        fraw = getResources().openRawResource(R.raw.karmele_teoria5_pt5);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria5++;
                        break;

                    case 5:
                        karmele.setImageResource(R.drawable.karmele_animazioa6);
                        fraw = getResources().openRawResource(R.raw.karmele_letra5);

                        brin = new BufferedReader(new InputStreamReader(fraw)); linea = brin.readLine();
                        while (linea != null){ dialogo.setText(linea); linea = brin.readLine();} fraw.close();
                        contTeoria5++;
                        break;

                    case 6:
                        //////////////////////Escribir letra en un fichero///////////////////////////////////
                        finish();
                        break;
                }
                break;

            case "Pasionaria":
                //////////////////////Escribir letra en un fichero///////////////////////////////////
                finish();

                break;

            case "AllIron":
                //////////////////////Escribir letra en un fichero///////////////////////////////////
                finish();

                break;
        }
    }
}
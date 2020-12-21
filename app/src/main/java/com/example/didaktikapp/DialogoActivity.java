package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DialogoActivity extends AppCompatActivity {
    TextView dialogo;
    String marca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo);
        dialogo= findViewById(R.id.dialogo);

        getSupportActionBar().hide();

        Bundle extras = getIntent().getExtras();
        marca = extras.getString("marca");

        try{
            InputStream fraw = null;
            switch (marca)
            {
                case "Zugaztieta":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera1);
                    break;

                case "MinaConcha":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera2);
                    break;

                case "MuesoMineria":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera3);
                    break;

                case "Transporte":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera4);
                    break;

                case "DoctorAreilza":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera5);
                    break;

                case "Pasionaria":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera6);
                    break;

                case "AllIron":
                    fraw = getResources().openRawResource(R.raw.karmele_sarrera7);
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
}
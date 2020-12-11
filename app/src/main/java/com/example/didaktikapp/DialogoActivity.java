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

        Bundle extras = getIntent().getExtras();
        marca = extras.getString("marca");

        dialogo.setText(marca);
        try{
            InputStream fraw = getResources().getAssets().open("Actividad1/KarmeleSarrera1.txt");
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

            String linea = brin.readLine();
            while (linea != null)
            {
                Log.i ("Ficheros", linea);
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
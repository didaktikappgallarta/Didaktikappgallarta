package com.example.didaktikapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MenuPrincipalActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
    }

    public void empezarActividad(View view) {
        //Intent intent = new Intent(MenuPrincipalActivity.this, MapaActivity.class);
        Intent intent = new Intent(MenuPrincipalActivity.this, VideoCrucigramaActivity.class);
        startActivity(intent);
    }

    public void cambiarIdioma(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuPrincipalActivity.this);

        LayoutInflater inflater = getLayoutInflater();

        View idiomaView = inflater.inflate(R.layout.dialogo_idioma,null);

        builder.setView(idiomaView);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnEuskera = idiomaView.findViewById(R.id.euskera);
        Button btnCastellano = idiomaView.findViewById(R.id.castellano);
        Button btnSalir = idiomaView.findViewById(R.id.cancelar);

        btnCastellano.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                DisplayMetrics dn = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();

                conf.setLocale(new Locale("es"));
                dialog.dismiss();

            }
        });

        btnEuskera.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                DisplayMetrics dn = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();

                conf.setLocale(new Locale("eu"));
                dialog.dismiss();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void continuarPartida(View view) {

    }

    public void mostrarAyuda(View view) {

    }

    public void salirAplicacion(View view) {
        System.exit(0);
    }
}

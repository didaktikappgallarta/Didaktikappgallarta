package com.example.didaktikapp;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class MenuPrincipalActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
    }

    public void empezarActividad(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        } else {
            solicitarPermiso(Manifest.permission.ACCESS_FINE_LOCATION, "Sin el permiso de localización no se puede usar el GPS.", LOCATION_PERMISSION_REQUEST_CODE, this);
        }

        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permiso != 0) {
            Toast.makeText(this, "Para usar esta aplicación debes permitir el acceso al GPS", Toast.LENGTH_LONG).show();

        } else {
            Intent intent = new Intent(MenuPrincipalActivity.this, MapsActivity.class);
            startActivity(intent);
        }

        /*Intent intent = new Intent(MenuPrincipalActivity.this, MemoramaActivity.class);
        startActivity(intent);*/

        /*Intent intent = new Intent(MenuPrincipalActivity.this, VideoCrucigramaActivity.class);
        startActivity(intent);*/
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
                Locale myLocale = new Locale("es");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(MenuPrincipalActivity.this, MenuPrincipalActivity.class);
                finish();
                startActivity(refresh);
            }
        });

        btnEuskera.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Locale myLocale = new Locale("eu");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(MenuPrincipalActivity.this, MenuPrincipalActivity.class);
                finish();
                startActivity(refresh);
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

    public void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad, permiso)) {
            new AlertDialog.Builder(actividad).setTitle("Solicitud de permiso").setMessage(justificacion).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    ActivityCompat.requestPermissions(actividad, new String[]{permiso}, requestCode);
                }
            }).show();

        } else {
            ActivityCompat.requestPermissions(actividad, new String[]{permiso}, requestCode);
        }
    }
}

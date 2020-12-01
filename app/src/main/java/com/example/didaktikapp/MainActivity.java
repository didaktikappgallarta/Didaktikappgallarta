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

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 0;
    boolean permisos = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamineto_arriba);
        Animation animacion2  = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        ImageView logo = findViewById(R.id.logo);
        TextView nombre1 = findViewById(R.id.nombre1);
        TextView nombre2 = findViewById(R.id.nombre2);

        logo.setAnimation(animacion1);
        nombre1.setAnimation(animacion2);
        nombre2.setAnimation(animacion2);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        } else {
            solicitarPermiso(Manifest.permission.ACCESS_FINE_LOCATION, "Sin el permiso de localización no se puede usar el GPS.", LOCATION_PERMISSION_REQUEST_CODE, this);
            permisos = false;
        }
        iniciarActividad();
    }

    public void iniciarActividad()
    {
        if(!permisos)
        {
            Toast.makeText(this, "Para usar esta aplicación debes permitir el acceso al GPS", Toast.LENGTH_LONG).show();

        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Intent intent = new Intent(MainActivity.this, CrucigramaActivity.class);
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 5000);
        }

    }
    public void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad,permiso)) {
            new AlertDialog.Builder(actividad).setTitle("Solicitud de permiso").setMessage(justificacion).setPositiveButton("OK",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    ActivityCompat.requestPermissions(actividad,new String[]{permiso}, requestCode);
                    iniciarActividad();
                }
            }).show();

        }
        else {
            ActivityCompat.requestPermissions(actividad,new String[]{permiso}, requestCode);
        }
    }


}
package com.example.didaktikapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MensajeMisteriosoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_misterioso);
    }

    public void comprobarMensaje(View view) {
        EditText f1r1 = findViewById(R.id.f1r1);
        EditText f1r2 = findViewById(R.id.f1r2);
        EditText f1r3 = findViewById(R.id.f1r3);
        EditText f1r4 = findViewById(R.id.f1r4);
        EditText f1r5 = findViewById(R.id.f1r5);
        EditText f1r6 = findViewById(R.id.f1r6);
        EditText f2r1 = findViewById(R.id.f2r1);
        EditText f2r2 = findViewById(R.id.f2r2);
        EditText f2r3 = findViewById(R.id.f2r3);
        EditText f2r4 = findViewById(R.id.f2r4);
        EditText f2r5 = findViewById(R.id.f2r5);
        EditText f2r6 = findViewById(R.id.f2r6);
        EditText f3r1 = findViewById(R.id.f3r1);
        EditText f3r2 = findViewById(R.id.f3r2);
        EditText f4r1 = findViewById(R.id.f4r1);
        EditText f4r2 = findViewById(R.id.f4r2);
        EditText f4r3 = findViewById(R.id.f4r3);
        EditText f4r4 = findViewById(R.id.f4r4);
        EditText f4r5 = findViewById(R.id.f4r5);
        EditText f4r6 = findViewById(R.id.f4r6);
        EditText f4r7 = findViewById(R.id.f4r7);
        EditText f4r8 = findViewById(R.id.f4r8);
        EditText f5r1 = findViewById(R.id.f5r1);
        EditText f5r2 = findViewById(R.id.f5r2);
        EditText f6r1 = findViewById(R.id.f6r1);
        EditText f6r2 = findViewById(R.id.f6r2);
        EditText f6r3 = findViewById(R.id.f6r3);
        EditText f6r4 = findViewById(R.id.f6r4);
        EditText f6r5 = findViewById(R.id.f6r5);
        EditText f6r6 = findViewById(R.id.f6r6);
        EditText f6r7 = findViewById(R.id.f6r7);

        String aliron1 = f1r1.getText().toString() + f1r2.getText().toString() +f1r3.getText().toString() +f1r4.getText().toString() + f1r5.getText().toString() + f1r6.getText().toString();
        String aliron2 = f2r1.getText().toString() + f2r2.getText().toString() +f2r3.getText().toString() +f2r4.getText().toString() + f2r5.getText().toString() + f2r6.getText().toString();
        String el = f3r1.getText().toString() + f3r2.getText().toString();
        String athletic = f4r1.getText().toString() + f4r2.getText().toString() +f4r3.getText().toString() +f4r4.getText().toString() + f4r5.getText().toString() + f4r6.getText().toString() + f4r7.getText().toString() + f4r8.getText().toString();
        String es = f5r1.getText().toString() + f5r2.getText().toString();
        String campeon = f6r1.getText().toString() + f6r2.getText().toString() +f6r3.getText().toString() +f6r4.getText().toString() + f6r5.getText().toString() + f6r6.getText().toString() + f6r7.getText().toString();

        if (aliron1.equals("ALIRON") && aliron2.equals("ALIRON") && el.equals("EL") && athletic.equals("ATHLETIC") && es.equals("ES") && campeon.equals("CAMPEON")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ganaste");
            builder.setMessage("Felicidades!" );
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MensajeMisteriosoActivity.this, PostJuegoActivity.class);
                    intent.putExtra("localizacion", "aliron");
                    startActivity(intent);
                    finish();
                }
            });
            builder.show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Perdiste");
            builder.setMessage("Lo sentimos. Vuelve a internalo en otro momento!" );
            builder.setPositiveButton("Intentar de nuevo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                      new MensajeMisteriosoActivity();
                }
            });
            builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MensajeMisteriosoActivity.this.finish();
                }
            });
            builder.show();
        }
    }


}

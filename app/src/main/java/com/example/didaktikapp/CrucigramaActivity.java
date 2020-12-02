package com.example.didaktikapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CrucigramaActivity extends AppCompatActivity {

    ArrayList<String> descripciones = new ArrayList<String>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crucigrama);

        EditText h = findViewById(R.id.h);
        EditText o = findViewById(R.id.o);
        EditText l = findViewById(R.id.l);
        EditText a = findViewById(R.id.a);

        descripciones.add("1. Saludo comunmente utilizado por las personas");
        descripciones.add("2. Despedida comunmente utilizada por las personas");

        TextView descripcion = findViewById(R.id.descripcion);
        descripcion.setText(descripciones.get(0));

        h.setBackgroundColor(getResources().getColor(R.color.naranja));
        o.setBackgroundColor(getResources().getColor(R.color.naranja));
        l.setBackgroundColor(getResources().getColor(R.color.naranja));
        a.setBackgroundColor(getResources().getColor(R.color.naranja));

        //descripcion.setGravity(Gravity.CENTER_VERTICAL);


        GridLayout myLayout = (GridLayout)findViewById(R.id.layout);

        for( int i = 0; i < myLayout.getChildCount(); i++ ) {
            if(myLayout.getChildAt(i) instanceof EditText ) {
                EditText myEditText = (EditText) myLayout.getChildAt(i);
                EditText nextEditText;
                if (i+1 >= myLayout.getChildCount()) {
                     nextEditText = (EditText) myLayout.getChildAt(0);
                } else {
                     nextEditText = (EditText) myLayout.getChildAt(i+1);
                }

                myEditText.setGravity(Gravity.CENTER_HORIZONTAL);

                myEditText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        System.out.println(s.toString() + " " + start + " " + count);
                        nextEditText.requestFocus();
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }

        }
    }

    public void comprobarCrucigrama(View view) {
        EditText h = findViewById(R.id.h);
        EditText o = findViewById(R.id.o);
        EditText l = findViewById(R.id.l);
        EditText a = findViewById(R.id.a);

        if ((h.getText().toString() + o.getText().toString() + l.getText().toString() + a.getText().toString()).equals("HOLA")) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "has acertado", Toast.LENGTH_SHORT);

            toast1.show();
        } else {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "muy mal", Toast.LENGTH_SHORT);

            toast1.show();
        }
    }

    public void siguienteDescripcion(View view) {
        TextView descripcion = findViewById(R.id.descripcion);
        for( int i = 0; i < descripciones.size();i++ ) {
            if (descripciones.get(i).equals(descripcion.getText().toString())) {
                descripcion.setText(descripciones.get(1));
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "siguiente", Toast.LENGTH_SHORT);

                toast1.show();
            }
        }

        MediaPlayer mp = MediaPlayer.create(this, R.raw.karmelesarrera);
        mp.start();
    }

    public void anteriorDescripcion(View view) {
        TextView descripcion = findViewById(R.id.descripcion);
        for( int i = 0; i < descripciones.size();i++ ) {
            if (descripciones.get(i).equals(descripcion.getText().toString())) {
                descripcion.setText(descripciones.get(i-1));
            }
        }
    }
}

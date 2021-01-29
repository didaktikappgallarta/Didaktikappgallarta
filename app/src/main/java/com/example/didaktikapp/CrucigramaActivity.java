package com.example.didaktikapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CrucigramaActivity extends AppCompatActivity {

    ArrayList<String> descripciones = new ArrayList<String>();

    EditText bBagoneta;
    EditText aBagoneta;
    EditText gBagoneta;
    EditText oBagoneta;
    EditText nBagoneta;
    EditText eBagoneta;
    EditText tBagoneta;
    EditText taBagoneta;
    EditText mMuseoa;
    EditText uMuseoa;
    EditText sMuseoa;
    EditText eMuseoa;
    EditText oMuseoa;
    EditText aMuesoa;
    EditText mMeategi;
    EditText eMeategi;
    EditText aMeategi;
    EditText tMeategi;
    EditText teMeategi;
    EditText gMeategi;
    EditText iMeategi;
    EditText cConcha;
    EditText oConcha;
    EditText nConcha;
    EditText chConcha;
    EditText hConcha;
    EditText aConcha;
    EditText oOspetsua;
    EditText sOspetsua;
    EditText pOspetsua;
    EditText eOspetsua;
    EditText tOspetsua;
    EditText tsOspetsua;
    EditText uOspetsua;
    EditText aOspetsua;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crucigrama);

        descripciones.add("1. Mineralak eramaten zituzten garraio motak.");
        descripciones.add("2. Aintzinean gertatu zenaren aztarnak erakusten dituen eraikina");
        descripciones.add("3. Burdina edo bestelako mineralak ustiatzen diren tokia.");
        descripciones.add("4. Meategi honen izena.");
        descripciones.add("5. Ezaguna izatearen sinonimoa.");

        TextView descripcion = findViewById(R.id.descripcion);
        descripcion.setText(descripciones.get(0));

        bBagoneta = findViewById(R.id.bBagoneta);
        aBagoneta = findViewById(R.id.aBagoneta);
        gBagoneta = findViewById(R.id.gBagoneta);
        oBagoneta = findViewById(R.id.oBagoneta);
        nBagoneta = findViewById(R.id.nBagoneta);
        eBagoneta = findViewById(R.id.eBagoneta);
        tBagoneta = findViewById(R.id.tBagoneta);
        taBagoneta = findViewById(R.id.taBagoneta);

        bBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
        aBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
        gBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
        oBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
        nBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
        eBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
        tBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
        taBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));

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
        String museoa = mMuseoa.getText().toString() + uMuseoa.getText().toString() + sMuseoa.getText().toString() + eMuseoa.getText().toString() + oMuseoa.getText().toString() + aMuesoa.getText().toString();
        String meategi = mMeategi.getText().toString() + eMeategi.getText().toString() + aMeategi.getText().toString() + tMeategi.getText().toString() + teMeategi.getText().toString() + gMeategi.getText().toString() + iMeategi.getText().toString();
        String concha =  cConcha.getText().toString() + oConcha.getText().toString() + nConcha.getText().toString() + chConcha.getText().toString() + hConcha.getText().toString() + aConcha.getText().toString();
        String ospetsua = oOspetsua.getText().toString() + sOspetsua.getText().toString() + pOspetsua.getText().toString() + eOspetsua.getText().toString() + tOspetsua.getText().toString() + tsOspetsua.getText().toString() + uOspetsua.getText().toString() + aOspetsua.getText().toString();
        String bagoneta = bBagoneta.getText().toString() + aBagoneta.getText().toString() + gBagoneta.getText().toString() + oBagoneta.getText().toString() + nBagoneta.getText().toString() + eBagoneta.getText().toString() + tBagoneta.getText().toString() + taBagoneta.getText().toString();

        System.out.println(museoa + " " +  meategi  + " " + concha  + " " + ospetsua + " " + bagoneta);

        if (museoa.equals("MUSEOA") && meategi.equals("MEATEGI") && concha.equals("CONCHA") && ospetsua.equals("OSPETSUA") && bagoneta.equals("BAGONETA")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ganaste");
            builder.setMessage("Felicidades!");
            builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(CrucigramaActivity.this, PostJuegoActivity.class);
                    intent.putExtra("localizacion", "concha");
                    startActivity(intent);
                    finish();
                }
            });
            builder.show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Perdiste");
            builder.setMessage("Lo sentimos!");
            builder.setPositiveButton("Jugar de nuevo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(CrucigramaActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(CrucigramaActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.show();
        }
    }

    public void siguienteDescripcion(View view) {
        TextView descripcion = findViewById(R.id.descripcion);
        mMuseoa = findViewById(R.id.mMuseoa);
        uMuseoa = findViewById(R.id.uMuseoa);
        sMuseoa = findViewById(R.id.sMuseoa);
        eMuseoa = findViewById(R.id.eOspetsua);
        oMuseoa = findViewById(R.id.oMuseoa);
        aMuesoa = findViewById(R.id.aMuseoa);

        mMeategi = findViewById(R.id.mMuseoa);
        eMeategi = findViewById(R.id.eMeategi);
        aMeategi = findViewById(R.id.aMeategi);
        tMeategi = findViewById(R.id.tMeategi);
        teMeategi = findViewById(R.id.teMeategi);
        gMeategi = findViewById(R.id.gMeategi);
        iMeategi = findViewById(R.id.iMeategi);

        cConcha = findViewById(R.id.cConcha);
        oConcha = findViewById(R.id.oMuseoa);
        nConcha = findViewById(R.id.nConcha);
        chConcha = findViewById(R.id.chConcha);
        hConcha = findViewById(R.id.hConcha);
        aConcha = findViewById(R.id.aConcha);

        oOspetsua  = findViewById(R.id.oBagoneta);
        sOspetsua = findViewById(R.id.sOspetsua);
        pOspetsua = findViewById(R.id.pOspetsua);
        eOspetsua = findViewById(R.id.eOspetsua);
        tOspetsua = findViewById(R.id.tOspetsua);
        tsOspetsua = findViewById(R.id.tsOspetsua);
        uOspetsua = findViewById(R.id.uOspetsua);
        aOspetsua = findViewById(R.id.aOspetsua);

        bBagoneta = findViewById(R.id.bBagoneta);
        aBagoneta = findViewById(R.id.aBagoneta);
        gBagoneta = findViewById(R.id.gBagoneta);
        oBagoneta = findViewById(R.id.oBagoneta);
        nBagoneta = findViewById(R.id.nBagoneta);
        eBagoneta = findViewById(R.id.eBagoneta);
        tBagoneta = findViewById(R.id.tBagoneta);
        taBagoneta = findViewById(R.id.taBagoneta);

        if (descripciones.get(4).equals(descripcion.getText().toString())) {
            descripcion.setText(descripciones.get(0));

            bBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
            aBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
            gBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
            oBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
            nBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
            eBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
            tBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
            taBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));

            sOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            pOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            eOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            tOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            tsOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            uOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            aOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));

        } else {
            for( int i = 0; i < descripciones.size();i++ ) {
                if (descripciones.get(i).equals(descripcion.getText().toString())) {
                    int siguienteNumero = i + 1;

                    descripcion.setText(descripciones.get(siguienteNumero));

                    switch (siguienteNumero) {
                        case 1:
                            mMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            uMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            sMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            eMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja));
                            oMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja));
                            aMuesoa.setBackgroundColor(getResources().getColor(R.color.naranja));

                            bBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            gBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            oBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            nBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            eBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            tBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            taBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            break;

                        case 2:
                            mMeategi.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            eMeategi.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            aMeategi.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            tMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));
                            teMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));
                            gMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));
                            iMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));

                            uMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            sMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            eMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            oMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aMuesoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            break;

                        case 3:
                            cConcha.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            oConcha.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            nConcha.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            chConcha.setBackgroundColor(getResources().getColor(R.color.naranja));
                            hConcha.setBackgroundColor(getResources().getColor(R.color.naranja));
                            aConcha.setBackgroundColor(getResources().getColor(R.color.naranja));

                            mMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            eMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            tMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            teMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            gMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            iMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            break;
                        case 4:
                            oOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            sOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            pOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            eOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
                            tOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
                            tsOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
                            uOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
                            aOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));

                            cConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            oConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            nConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            chConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            hConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            break;
                    }

                    break;
                }
            }
        }

        //MediaPlayer mp = MediaPlayer.create(this, R.raw.karmele_sarrera1);
        //mp.start();
    }

    public void anteriorDescripcion(View view) {
        TextView descripcion = findViewById(R.id.descripcion);
        mMuseoa = findViewById(R.id.mMuseoa);
        uMuseoa = findViewById(R.id.uMuseoa);
        sMuseoa = findViewById(R.id.sMuseoa);
        eMuseoa = findViewById(R.id.eOspetsua);
        oMuseoa = findViewById(R.id.oMuseoa);
        aMuesoa = findViewById(R.id.aMuseoa);

        mMeategi = findViewById(R.id.mMuseoa);
        eMeategi = findViewById(R.id.eMeategi);
        aMeategi = findViewById(R.id.aMeategi);
        tMeategi = findViewById(R.id.tMeategi);
        teMeategi = findViewById(R.id.teMeategi);
        gMeategi = findViewById(R.id.gMeategi);
        iMeategi = findViewById(R.id.iMeategi);

        cConcha = findViewById(R.id.cConcha);
        oConcha = findViewById(R.id.oMuseoa);
        nConcha = findViewById(R.id.nConcha);
        chConcha = findViewById(R.id.chConcha);
        hConcha = findViewById(R.id.hConcha);
        aConcha = findViewById(R.id.aConcha);

        oOspetsua  = findViewById(R.id.oBagoneta);
        sOspetsua = findViewById(R.id.sOspetsua);
        pOspetsua = findViewById(R.id.pOspetsua);
        eOspetsua = findViewById(R.id.eOspetsua);
        tOspetsua = findViewById(R.id.tOspetsua);
        tsOspetsua = findViewById(R.id.tsOspetsua);
        uOspetsua = findViewById(R.id.uOspetsua);
        aOspetsua = findViewById(R.id.aOspetsua);

        bBagoneta = findViewById(R.id.bBagoneta);
        aBagoneta = findViewById(R.id.aBagoneta);
        gBagoneta = findViewById(R.id.gBagoneta);
        oBagoneta = findViewById(R.id.oBagoneta);
        nBagoneta = findViewById(R.id.nBagoneta);
        eBagoneta = findViewById(R.id.eBagoneta);
        tBagoneta = findViewById(R.id.tBagoneta);
        taBagoneta = findViewById(R.id.taBagoneta);

        if (descripciones.get(0).equals(descripcion.getText().toString())) {
            descripcion.setText(descripciones.get(4));

            oOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
            sOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
            pOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
            eOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
            tOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
            tsOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
            uOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));
            aOspetsua.setBackgroundColor(getResources().getColor(R.color.naranja));

            bBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            aBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            gBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            nBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            eBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            tBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
            taBagoneta.setBackground(getResources().getDrawable(R.drawable.edit_text_border));

        } else {
            for( int i = 0; i < descripciones.size();i++ ) {
                if (descripciones.get(i).equals(descripcion.getText().toString())) {
                    int numeroAnterior = i - 1;
                    descripcion.setText(descripciones.get(numeroAnterior));

                    System.out.println(numeroAnterior + "eeeeeeeeeeeeeeeeeeeeeeeeeyyyyyyyyyyy");
                    switch (numeroAnterior) {
                        case 0:
                            bBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
                            aBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
                            gBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
                            oBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
                            nBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
                            eBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
                            tBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));
                            taBagoneta.setBackgroundColor(getResources().getColor(R.color.naranja));

                            mMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            uMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            sMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            eMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            oMuseoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aMuesoa.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            break;
                        case 1:
                            mMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            eMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            tMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            teMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            gMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            iMeategi.setBackground(getResources().getDrawable(R.drawable.edit_text_border));

                            mMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            uMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            sMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            eMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja));
                            oMuseoa.setBackgroundColor(getResources().getColor(R.color.naranja));
                            aMuesoa.setBackgroundColor(getResources().getColor(R.color.naranja));
                            break;
                        case 2:
                            cConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            oConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            nConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            chConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            hConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aConcha.setBackground(getResources().getDrawable(R.drawable.edit_text_border));

                            mMeategi.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            eMeategi.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            aMeategi.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            tMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));
                            teMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));
                            gMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));
                            iMeategi.setBackgroundColor(getResources().getColor(R.color.naranja));
                            break;
                        case 3:
                            oOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            sOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            pOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            eOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            tOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            tsOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            uOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));
                            aOspetsua.setBackground(getResources().getDrawable(R.drawable.edit_text_border));

                            cConcha.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            oConcha.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            nConcha.setBackgroundColor(getResources().getColor(R.color.naranja)) ;
                            chConcha.setBackgroundColor(getResources().getColor(R.color.naranja));
                            hConcha.setBackgroundColor(getResources().getColor(R.color.naranja));
                            aConcha.setBackgroundColor(getResources().getColor(R.color.naranja));
                            break;
                    }
                }
            }
        }
    }
}
package com.e.championsaleatoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Cuartos_de_final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuartos_de_final);


        //Creamos el arraylist de los Cuartos de Final.
        ArrayList<Equipo> equiposCuartosFinal = (ArrayList<Equipo>) getIntent().getSerializableExtra("arrayCuartosdeFinal");

        //***********************************
        //desordeno el array list 5 veces.
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(equiposCuartosFinal);
        }
        //***********************************

        //Textos e imagenes de los Cuartofinalistas.
        TextView cuartofinal1 = findViewById(R.id.textCuarto1);
        String equipoCuarto1 = equiposCuartosFinal.get(0).getName();
        cuartofinal1.setText(equipoCuarto1);
        ImageView imagen1 = findViewById(R.id.imageCuarto1);
        imagen1.setImageResource(equiposCuartosFinal.get(0).getImageResourceId());

        TextView cuartofinal2 = findViewById(R.id.textCuarto2);
        String equipoCuarto2 = equiposCuartosFinal.get(1).getName();
        cuartofinal2.setText(equipoCuarto2);
        ImageView imagen2 = findViewById(R.id.imageCuarto2);
        imagen2.setImageResource(equiposCuartosFinal.get(1).getImageResourceId());





    }
}
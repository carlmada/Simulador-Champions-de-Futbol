package com.e.championsaleatoria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        //Creamos el arraylist de la final.
        ArrayList<Equipo> equiposFinal = (ArrayList<Equipo>) getIntent().getSerializableExtra("arrayFinalistas");

        //***********************************
        //desordeno el array list 5 veces.
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(equiposFinal);
        }
        //***********************************

        //Textos e imagenes de los finalistas.
        TextView finalista1 = findViewById(R.id.textFinalista1);
        String equipoFinalista1 = equiposFinal.get(0).getName();
        finalista1.setText(equipoFinalista1);
        ImageView imagen1 = findViewById(R.id.imageFinalista1);
        imagen1.setImageResource(equiposFinal.get(0).getImageResourceId());

        TextView finalista2 = findViewById(R.id.textFinalista2);
        String equipoFinalista2 = equiposFinal.get(1).getName();
        finalista2.setText(equipoFinalista2);
        ImageView imagen2 = findViewById(R.id.imageFinalista2);
        imagen2.setImageResource(equiposFinal.get(1).getImageResourceId());

        //Resultado de la Final.
        int[] resultadoFinal = MainActivity.resultadoEncuentro();

        //Mostramos el resultado en la activity.
        TextView resultadofinalista1 = findViewById(R.id.textResultadoFinalista1);
        String resultadoFinalista1 = String.valueOf(resultadoFinal[0]);
        resultadofinalista1.setText(resultadoFinalista1);

        TextView resultadofinalista2 = findViewById(R.id.textResultadoFinalista2);
        String resultadoFinalista2 = String.valueOf(resultadoFinal[1]);
        resultadofinalista2.setText(resultadoFinalista2);


        //Hacemos la lógica de la final y pasamos el equipo ganador a la pantalla final.
        final Equipo equipoCampeon;
        if(Integer.parseInt(resultadoFinalista1) > Integer.parseInt(resultadoFinalista2)){
            //Campeon finalista 1
             equipoCampeon = equiposFinal.get(0);
        }else {
            //Campeon finalista 2
            equipoCampeon = equiposFinal.get(1);
        }

        //Clicamos en Campeon para ver el campeon...
        Button botonCampeon = findViewById(R.id.buttonCampeon);
        botonCampeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent de la pantalla final.
                Intent intentChampion = new Intent(Final.this, Champion.class);
                intentChampion.putExtra("equipoCampeon", equipoCampeon);
                startActivity(intentChampion);
            }
        });


    }
}
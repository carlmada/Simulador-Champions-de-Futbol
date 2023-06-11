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

public class SemiFinal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_final);


        //Creamos el arraylist de la Semi-final.
        ArrayList<Equipo> equiposSemiFinal = (ArrayList<Equipo>) getIntent().getSerializableExtra("arraySemiFinalistas");

        //***********************************
        //desordeno el array list 5 veces.
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(equiposSemiFinal);
        }
        //***********************************

        //Textos e imagenes de los finalistas.
        TextView Semifinalista1 = findViewById(R.id.textSemiFinalista1);
        String equipoSemiFinalista1 = equiposSemiFinal.get(0).getName();
        Semifinalista1.setText(equipoSemiFinalista1);
        ImageView imagen1 = findViewById(R.id.imageSemiFinalista1);
        imagen1.setImageResource(equiposSemiFinal.get(0).getImageResourceId());

        TextView Semifinalista2 = findViewById(R.id.textSemiFinalista2);
        String equipoSemiFinalista2 = equiposSemiFinal.get(1).getName();
        Semifinalista2.setText(equipoSemiFinalista2);
        ImageView imagen2 = findViewById(R.id.imageSemiFinalista2);
        imagen2.setImageResource(equiposSemiFinal.get(1).getImageResourceId());

        TextView Semifinalista3 = findViewById(R.id.textSemiFinalista3);
        String equipoSemiFinalista3 = equiposSemiFinal.get(2).getName();
        Semifinalista3.setText(equipoSemiFinalista3);
        ImageView imagen3 = findViewById(R.id.imageSemiFinalista3);
        imagen3.setImageResource(equiposSemiFinal.get(2).getImageResourceId());

        TextView Semifinalista4 = findViewById(R.id.textSemiFinalista4);
        String equipoSemiFinalista4 = equiposSemiFinal.get(3).getName();
        Semifinalista4.setText(equipoSemiFinalista4);
        ImageView imagen4 = findViewById(R.id.imageSemiFinalista4);
        imagen4.setImageResource(equiposSemiFinal.get(3).getImageResourceId());


        //**********************************************************
        //1ª Semi-final.
        //************************************************************
        //Resultados 1ª semifinal.
        int[] resultados = MainActivity.resultadoEncuentro();

        //Mostramos el resultado en la activity.
        TextView resultadosemifinalista1 = findViewById(R.id.textResultadoSemiFinalista1);
        String resultadoSemiFinalista1 = String.valueOf(resultados[0]);
        resultadosemifinalista1.setText(resultadoSemiFinalista1);

        TextView resultadosemifinalista2 = findViewById(R.id.textResultadoSemiFinalista2);
        String resultadoSemiFinalista2 = String.valueOf(resultados[1]);
        resultadosemifinalista2.setText(resultadoSemiFinalista2);

        //**********************************************************
        //2ª Semi-final.
        //************************************************************
        //Resultados 2ª semifinal.
        resultados = MainActivity.resultadoEncuentro();
        //Mostramos el resultado en la activity.
        TextView resultadosemifinalista3 = findViewById(R.id.textResultadoSemiFinalista3);
        String resultadoSemiFinalista3 = String.valueOf(resultados[0]);
        resultadosemifinalista3.setText(resultadoSemiFinalista3);

        TextView resultadosemifinalista4 = findViewById(R.id.textResultadoSemiFinalista4);
        String resultadoSemiFinalista4 = String.valueOf(resultados[1]);
        resultadosemifinalista4.setText(resultadoSemiFinalista4);
        //************************************************************

        //Creamos el arraylist de equipos que pasan a la final.
        final ArrayList<Equipo> equiposFinalistas = new ArrayList<>();

        //Hacemos la lógica de los resultados y añadimos a los ganadores.
        // 1ª Semifinal.
        if(Integer.parseInt(resultadoSemiFinalista1) > Integer.parseInt(resultadoSemiFinalista2)){
            equiposFinalistas.add(equiposSemiFinal.get(0));
        }else {
            equiposFinalistas.add(equiposSemiFinal.get(1));
        }

        // 2ª Semifinal.
        if(Integer.parseInt(resultadoSemiFinalista3) > Integer.parseInt(resultadoSemiFinalista4)){
            equiposFinalistas.add(equiposSemiFinal.get(2));
        }else {
            equiposFinalistas.add(equiposSemiFinal.get(3));
        }

        Button botonPasarFinal = findViewById(R.id.buttonFinal);
        botonPasarFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent para ir a la final
                Intent intentFinal = new Intent(SemiFinal.this, Final.class);
                intentFinal.putExtra("arrayFinalistas", equiposFinalistas);
                startActivity(intentFinal);
            }
        });
    }

}
package com.e.championsaleatoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botonInicio = findViewById(R.id.buttonBalon);
        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantallaInicio = new Intent(MainActivity.this, Reglas.class);
                startActivity(pantallaInicio);
            }
        });


    }

    //Metodo general para calcular los resultados de los partidos.
    public static int[] resultadoEncuentro(){

        //calcularemos el resultado de forma aleatoria.
        //declaramos los numeros que necesitamos, y el rango de goles (0-5)
        int numeros = 2;
        int rango = 5;

        //array de 2 numeros generados.
        int[] resultadoPartido = new int[numeros];

        //Calculamos dos numeros aleatorios NO repetidos.
        //Primer numero aleatorio directo.
        resultadoPartido[0] = (int)(Math.random()*rango);

        //Segundo numero aleatorio ha de ser NO repetido al primero.
        //Se hace la comprobación con un bucle...
        for (int i = 1; i < numeros; i++) {
            //Se asigna un nuevo numero a resultado 2
            resultadoPartido[i] = (int)(Math.random()*rango);
            for (int j = 0; j < i; j++) {
                if(resultadoPartido[i] == resultadoPartido[j]){
                    i--;
                }
            }
        }
        return resultadoPartido;
    }

}
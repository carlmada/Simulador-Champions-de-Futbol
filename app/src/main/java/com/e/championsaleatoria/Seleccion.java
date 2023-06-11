package com.e.championsaleatoria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.ArrayList;

import static com.e.championsaleatoria.Equipo.equipos;

public class Seleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        //Creamos el arraylist de equipos seleccionados.
        final ArrayList<Equipo> equiposSeleccionados = new ArrayList<>();

        Button botonInicio = findViewById(R.id.buttonBalon2);
        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Ahora comprobamos el numero de equipos seleccionados...
                //haciendo la suma de los equipos chequeados.

                //limpiamos el arrayList .
                equiposSeleccionados.clear();

                //variable contador de equipos seleccionados.
                int contador = 0;

                //comprovar cada checkbox si es activo.
                CheckBox checkfcb = findViewById(R.id.F_C_Barcelona);
                if (checkfcb.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[0]);
                }

                CheckBox checkatlmadrid = findViewById(R.id.AtlMadrid);
                if (checkatlmadrid.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[1]);
                }

                CheckBox checkmanchestercity = findViewById(R.id.ManchesterCity);
                if (checkmanchestercity.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[2]);
                }

                CheckBox checkjuventus = findViewById(R.id.Juventus);
                if (checkjuventus.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[3]);
                }

                CheckBox checkacmilan = findViewById(R.id.ACMilan);
                if (checkacmilan.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[4]);
                }

                CheckBox checkajax = findViewById(R.id.AjaxAmsterdam);
                if (checkajax.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[5]);
                }

                CheckBox checkasroma = findViewById(R.id.ASRoma);
                if (checkasroma.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[6]);
                }

                CheckBox checkbayernmunich = findViewById(R.id.BayernMunich);
                if (checkbayernmunich.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[7]);
                }

                CheckBox checkchelsea = findViewById(R.id.Chelsea);
                if (checkchelsea.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[8]);
                }

                CheckBox checkliverpool = findViewById(R.id.Liverpool);
                if (checkliverpool.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[9]);
                }

                CheckBox checkmanchesterunited = findViewById(R.id.ManchesterUnited);
                if (checkmanchesterunited.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[10]);
                }

                CheckBox checknapoli = findViewById(R.id.Napoli);
                if (checknapoli.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[11]);
                }

                CheckBox checkpsg = findViewById(R.id.PSG);
                if (checkpsg.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[12]);
                }
                CheckBox checkpsv = findViewById(R.id.PSV);
                if (checkpsv.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[13]);
                }
                CheckBox checkrealmadrid = findViewById(R.id.RealMadrid);
                if (checkrealmadrid.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[14]);
                }
                CheckBox checkporto = findViewById(R.id.Porto);
                if (checkporto.isChecked()){
                    contador += 1;
                    equiposSeleccionados.add(equipos[15]);
                }

                if ( (contador==2) || (contador==4) || (contador==8) || (contador==16) ){

                    //Continuamos juego.
                    //switch-case para seleccionar la activity correspondiente.
                    switch (contador){

                        case 2 :
                            //Paso de arrayList por intent.
                            Intent intentFinal = new Intent(Seleccion.this, Final.class);
                            intentFinal.putExtra("arrayFinalistas", equiposSeleccionados);
                            startActivity(intentFinal);
                            break;

                        case 4 :
                            //Paso de arrayList por intent.
                            Intent intentSemiFinal = new Intent(Seleccion.this, SemiFinal.class);
                            intentSemiFinal.putExtra("arraySemiFinalistas", equiposSeleccionados);
                            startActivity(intentSemiFinal);
                            break;

                        case 8 :
                            //Paso de arrayList por intent.
                            Intent intentCuartosdeFinal = new Intent(Seleccion.this, Cuartos_de_final.class);
                            intentCuartosdeFinal.putExtra("arrayCuartosdeFinal", equiposSeleccionados);
                            startActivity(intentCuartosdeFinal);
                            break;

                        default:
                            throw new IllegalStateException("Unexpected value: " + contador);
                    }
                }else {

                    //AlertDialog
                    AlertDialog.Builder alertaError = new AlertDialog.Builder(Seleccion.this);
                    alertaError.setMessage("Error, hay que seleccionar 2 - 4 - 8 ó 16 EQUIPOS");
                    alertaError.setPositiveButton(android.R.string.ok, null);
                    alertaError.show();

                }
            }
        });
    }
}
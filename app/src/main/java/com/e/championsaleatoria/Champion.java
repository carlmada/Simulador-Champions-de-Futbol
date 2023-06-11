package com.e.championsaleatoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Champion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);

        //Recibimos el equipo Campeon.
        Equipo campeon = (Equipo)getIntent().getSerializableExtra("equipoCampeon");

        //Queda mostrar el campeon en pantalla...
        ImageView imagenCampeon = findViewById(R.id.imageCampeon);
        TextView textEquipoCampeon = findViewById(R.id.textEquipoCampeon);

        imagenCampeon.setImageResource(campeon.getImageResourceId());
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        imagenCampeon.startAnimation(animacion);
        textEquipoCampeon.setText(campeon.getName());

    }
}
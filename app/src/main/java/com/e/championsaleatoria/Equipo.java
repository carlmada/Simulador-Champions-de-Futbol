package com.e.championsaleatoria;

import java.io.Serializable;

public class Equipo implements Serializable {

    // Cada equipo tendrá su nombre y su icono identificativo .

    private final String name;
    private final int imageResourceId;

    //Constructor...


    public Equipo(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    // Gets y Sets...

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }


    // Un array de equipos
    final static Equipo[] equipos = {
            new Equipo( "F.C.Barcelona", R.drawable.fcb),
            new Equipo( "Atlético de Madrid", R.drawable.atlmadrid),
            new Equipo( "Manchester City", R.drawable.manchestercity),
            new Equipo( "Juventus", R.drawable.juventus),
            new Equipo( "AC Milán", R.drawable.acmilan),
            new Equipo( "Ajax Amsterdam", R.drawable.ajaxamsterdam),
            new Equipo( "AS Roma", R.drawable.asroma),
            new Equipo( "Bayern Múnich", R.drawable.bayernmunich),
            new Equipo( "Chelsea", R.drawable.chelsea),
            new Equipo( "Liverpool", R.drawable.liverpool),
            new Equipo( "Manchester United", R.drawable.manchesterunited),
            new Equipo( "Napoli", R.drawable.napoli),
            new Equipo( "Paris Sant Germain", R.drawable.psg),
            new Equipo( "PSV", R.drawable.psv),
            new Equipo( "Real Madrid", R.drawable.realmadrid),
            new Equipo( "Oporto", R.drawable.fcporto)
    };



}

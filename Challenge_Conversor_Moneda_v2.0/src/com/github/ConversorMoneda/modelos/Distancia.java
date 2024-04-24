package com.github.ConversorMoneda.modelos;

public class Distancia extends Conversiones {
    public Distancia(){
        //valores de conversion 1 unidad = x metros
        agregarDicc("Pulg",0.0254);
        agregarDicc("Pie",0.3048 );
        agregarDicc("Yarda",0.9144 );
        agregarDicc("Milla",1609.344);
        agregarDicc("Legua",4828.032);
    }
}

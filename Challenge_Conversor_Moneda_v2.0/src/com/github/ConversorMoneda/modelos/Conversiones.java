package com.github.ConversorMoneda.modelos;

import java.util.HashMap;

public class Conversiones {
    private double valorActual;
    private HashMap<String,Double> diccionario = new HashMap<String,Double>();

    public void agregarDicc(String Moneda, double valor){
        diccionario.put(Moneda,valor);
    }

    public double convertirHaciaExtranjero (String moneda){
        return getValorActual() / diccionario.get(moneda);
    }

    public double convertirHaciaLocal (String moneda){
        return getValorActual() * diccionario.get(moneda);
    }


    public HashMap<String, Double> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<String, Double> diccionario) {
        this.diccionario = diccionario;
    }

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }
}

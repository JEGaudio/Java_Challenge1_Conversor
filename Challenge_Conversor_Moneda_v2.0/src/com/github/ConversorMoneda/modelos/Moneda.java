package com.github.ConversorMoneda.modelos;

import java.util.*;

public class Moneda extends Conversiones {
    public Moneda(){
        agregarDicc("Dólar",952.54);
        agregarDicc("Euro",1019.63 );
        agregarDicc("Libras",1185.94 );
        agregarDicc("Yen",6.15);
        agregarDicc("Won",0.69);
    }

}

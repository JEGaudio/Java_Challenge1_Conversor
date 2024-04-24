package com.github.ConversorMoneda.menu;

import com.github.ConversorMoneda.modelos.Distancia;
import com.github.ConversorMoneda.modelos.Moneda;

import javax.swing.*;

public class ConversorDistancia {
    static Distancia myDistancia = new Distancia();

    public static void menuConversorMoneda(){
        JOptionPane menu = new JOptionPane();
        Double temp;

        Object respuesta = menu.showInputDialog(
                null,
                "Indique la cantidad a convertir",
                "Monto a convertir",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
        if (respuesta==null){
            Principal.preguntaMenu();
            return;
        }
        try {
            temp = Double.parseDouble(respuesta.toString());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Parametro ingresado no corresponde a un número.\nFavor volver a ingresar");
            menuConversorMoneda();
            return;
        }

        myDistancia.setValorActual(temp);
        elegirConversion();

//        System.out.println(myMoneda.convertirHaciaExtranjero("Dolar"));
//        System.out.println(myMoneda.convertirHaciaExtranjero("Yen"));
    }

    public static void elegirConversion(){
        String[] opcionesMenu = {
                "de Pulgada a Metro",
                "de Pie a Metro",
                "de Yarda a Metro",
                "de Milla a Metro",
                "de Legua a Metro",
                "de Metro a Pulgada",
                "de Metro a Pie",
                "de Metro a Yarda",
                "de Metro a Milla",
                "de Metro a Legua"
        };
        String[] opcionesDiccionario = {"Pulg","Pie","Yarda","Milla","Legua"};
        JOptionPane menu = new JOptionPane();

        Object respuesta = menu.showInputDialog(
                null,
                "Indicar el tipo de distancia para el monto: " + myDistancia.getValorActual() ,
                "Tipo de distancia",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMenu,
                null);
        if (respuesta==null){
            menuConversorMoneda();
            return;
        }

        for (int i = 0; i < opcionesMenu.length ; i++) {
            if (respuesta.equals(opcionesMenu[i])){
                if (i<5){
                    mostrarResultado(myDistancia.convertirHaciaLocal(opcionesDiccionario[i]));
                }
                else{
                    mostrarResultado(myDistancia.convertirHaciaExtranjero(opcionesDiccionario[i-5]));
                }
                break;
            }
        }


    }

    public static void mostrarResultado (double valor){
        valor = (double)((int)(valor*100))/100;  //redondear el valor obtenido a dos decimales
        JOptionPane menu = new JOptionPane();
        JOptionPane.showMessageDialog(
                null,
                "El resultado de la conversión es: " + valor,
                "Resultado de la conversion",
                JOptionPane.PLAIN_MESSAGE,
                null);
    }

}

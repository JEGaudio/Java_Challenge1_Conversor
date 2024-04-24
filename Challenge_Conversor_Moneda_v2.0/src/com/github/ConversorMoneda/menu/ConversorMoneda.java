package com.github.ConversorMoneda.menu;

import com.github.ConversorMoneda.modelos.Moneda;

import javax.swing.*;


public class ConversorMoneda{

    static Moneda myMoneda = new Moneda();

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

        myMoneda.setValorActual(temp);
        elegirConversion();

//        System.out.println(myMoneda.convertirHaciaExtranjero("Dolar"));
//        System.out.println(myMoneda.convertirHaciaExtranjero("Yen"));
    }

    public static void elegirConversion(){
        String[] opcionesMenu = {
                "de Peso Chileno a Dólar",
                "de Peso Chileno a Euros",
                "de Peso Chileno a Libras Esterlinas",
                "de Peso Chileno a Yen Japonés",
                "de Peso Chileno a Won sul-coreano",
                "de Dólar a Peso Chileno",
                "de Euros a Peso Chileno",
                "de Libras Esterlinas a Peso Chileno",
                "de Yen Japonés a Peso Chileno",
                "de Won sul-coreano a Peso Chileno"
        };
        String[] opcionesDiccionario = {"Dólar","Euro","Libras","Yen","Won"};
        JOptionPane menu = new JOptionPane();

        Object respuesta = menu.showInputDialog(
                null,
                "Indicar el tipo de cambio para el monto: " + myMoneda.getValorActual() ,
                "Tipo de cambio",
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
                    mostrarResultado(myMoneda.convertirHaciaExtranjero(opcionesDiccionario[i]));
                }
                else{
                    mostrarResultado(myMoneda.convertirHaciaLocal(opcionesDiccionario[i-5]));
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

package com.github.ConversorMoneda.menu;

import javax.swing.*;

public class Principal {
    static boolean seguirCalculando;

    public static void main(String[] args) {
        seguirCalculando = true;

        while(seguirCalculando) {
            preguntaMenu();
        }
    }

    public static void preguntaMenu(){
        String[] opcionesMenu = {"Conversor de Monedas","Conversor de Distancias"};
        JOptionPane menu = new JOptionPane();
        Object respuesta = menu.showInputDialog(
                null,
                "Seleccione una opcion de conversion",
                "Menu com.github.ConversorMoneda.menu.Principal",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMenu,
                null);
        if (respuesta==null) {
            seguirCalculando=false;
            return;
        }
        if (respuesta.equals(opcionesMenu[0])) {
            ConversorMoneda.menuConversorMoneda();
            preguntarSeguir();

        } else if (respuesta.equals(opcionesMenu[1])) {
            ConversorDistancia.menuConversorMoneda();
            preguntarSeguir();

        }

    }

    public static void preguntarSeguir(){
        JOptionPane menu = new JOptionPane();
        var respuesta = JOptionPane.showConfirmDialog(
                null,
                "Deseas seguir calculando?",
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (respuesta==1){
            seguirCalculando = false;
        }
    }

}

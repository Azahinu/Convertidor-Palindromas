package hilos;


import controller.palindromaGUI;

import javax.swing.*;

public class hilo1 extends Thread{

    private JTextArea hiloTextArea;
    private int i;
    private String contenido;
    private String cadena;
    public hilo1 (JTextArea hiloTextArea, String cadena){
        this.hiloTextArea = hiloTextArea;
        this.i=0;
        this.contenido= "---Palabras Originales---\n";
        this.cadena= cadena;
    }
    @Override
    public void run(){
        String[] cadenas = cadena.split(" ");
        for(i=0; i<= cadenas.length; i++){
            contenido=contenido+ i+" - " +cadenas[i]+ "\n";

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hiloTextArea.setText(contenido);
        }
        contenido= "";


    }
}

package hilos;

import javax.swing.*;

public class hilo3 extends Thread {
    private JTextArea hilo3TextArea;
    private int i;
    private String contenido;
    private String cadena;

    public hilo3 (JTextArea hilo3TextArea, String cadena){
        this.hilo3TextArea = hilo3TextArea;
        this.i=0;
        this.contenido= "---No convertibles---\n";
        this.cadena= cadena;
    }
    @Override
    public void run(){
        String[] cadenas = cadena.split(",");
        for(i=0; i<= cadenas.length; i++){
            contenido=contenido + i+" - "+cadenas[i]+"\n";

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hilo3TextArea.setText(contenido);
        }
        contenido= "";


    }

    }


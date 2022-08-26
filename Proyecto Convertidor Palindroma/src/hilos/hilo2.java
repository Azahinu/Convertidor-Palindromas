package hilos;

import javax.swing.*;

public class hilo2 extends Thread{

        private JTextArea hilo2TextArea;
        private int i;
        private String contenido;
        private String cadena;

        public hilo2 (JTextArea hilo2TextArea, String cadena){
            this.hilo2TextArea = hilo2TextArea;
            this.i=0;
            this.contenido= "--Palabras a agregar al nuevo txt--\n";
            this.cadena= cadena;
        }
        @Override
        public void run(){
            String[] cadenas = cadena.split(" ");
            for(i=0; i<= cadenas.length; i++){
                contenido=contenido+ i+" - "+cadenas[i] + "\n";

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hilo2TextArea.setText(contenido);
            }
            contenido= "";



        }
    }


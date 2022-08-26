package controller;

import javax.swing.*;
import java.io.File;
import java.awt.event.*;
import java.nio.file.FileAlreadyExistsException;

import errores.ArchivoNull;
import hilos.hilo1;
import hilos.hilo2;
import hilos.hilo3;
import logger.Registro;
import logica.Limpiar;
import logica.Texto;

/*
 Entrega = 30/05/22
 Poyecto Final-Fase 2 Archivos-Excepciones
 Grupo: Anderson Meneses - Kimberly Oliveros
 Profesor: Juan Alape
 */

public class palindromaGUI extends JFrame  {


    private JTabbedPane tabbedPane1;
    public JPanel panel1;
    private JButton button1;
    private JTextArea textoOriginalTextArea;
    private JButton button2;
    private JButton crearArchivoButton;
    private JTextArea hiloTextArea;
    private JButton verEjecucionButton;
    private JTextArea hilo2TextArea;
    private JTextArea hilo3TextArea;
    private String cadena ;
    private String cadenaConvertida;
    private String informacion;
    private String advertencia;
    private String severo;
    Registro log = new Registro();
    Limpiar lp= new Limpiar();





    public palindromaGUI(){
    }







    public void botones () {
        Texto tx = new Texto();

        // boton 1
        ActionListener bt1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    //Se crea el Jfilechooser
                    JFileChooser fc = new JFileChooser();
                    //Se abre la ventana y guarda la direccion elegida
                    int seleccion = fc.showOpenDialog(fc);
                    //Si acepta hace esto
                    if (seleccion == JFileChooser.APPROVE_OPTION ) {
                        //Se selecciona el fichero
                        File fichero = fc.getSelectedFile();


                        String ruta = fichero.getAbsolutePath();


                        cadena = tx.convertirEnCadena(ruta);
                        textoOriginalTextArea.setText(cadena);
                        informacion = "Archivo abierto";
                        log.logInfo(informacion);



                    }
                }
            }


        };
        button1.addActionListener(bt1);
        // Boton 2
        ActionListener bt2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button2){
                    try {
                        if(cadena == null){
                         throw new ArchivoNull("ERROR por favor ingrese un archivo");
                        }
                        cadenaConvertida = tx.convertirPalindroma(cadena);
                        informacion = "Texto convertido correctamente";
                        JOptionPane.showMessageDialog(null,"Se convirtio la cadena con exito");
                        log.logInfo(informacion);
                    }catch (ArchivoNull e1){
                        severo = "Ojo cadena esta null, imposible convertirla";
                        log.logSevero(severo);
                        JOptionPane.showMessageDialog(null, "ERROR por favor ingrese un archivo");

                    }

                }
            }
        };
        button2.addActionListener(bt2);
        // Boton 3
        ActionListener bt3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == crearArchivoButton){

                    //Se crea el Jfilechooser
                    JFileChooser fc = new JFileChooser();
                    //Se abre la ventana y guarda la direccion elegida
                    int seleccion = fc.showSaveDialog(fc);
                     File archivo = fc.getSelectedFile();
                     String ruta = archivo.getAbsolutePath();

                    try {
                        if(archivo.exists()){
                            throw new ArchivoNull("Ese archivo ya exite");
                        }
                        tx.guardarArchivo(ruta, cadenaConvertida);
                        informacion ="Se guardo el archivo correctamente";
                        log.logInfo(informacion);
                    }catch (ArchivoNull e1){
                        advertencia= "Ojo esta tratando de sobreescribir un archivo existente";
                        log.logAdvertencia(advertencia);
                        JOptionPane.showMessageDialog(null, "Ese archivo ya existe");
                    }
                }
            }
        };
        crearArchivoButton.addActionListener(bt3);
        //Boton 4
        ActionListener bt4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== verEjecucionButton){
                try {
                    if(cadenaConvertida == null){
                        throw new NullPointerException();
                    }
                    hilo1 h1 = new hilo1(hiloTextArea,lp.limpiarCadena(cadena));
                    hilo2 h2 = new hilo2(hilo2TextArea,lp.limpiarCadena(cadenaConvertida));
                    hilo3 h3 = new hilo3(hilo3TextArea,tx.getImprimir());
                    h1.start();
                    h2.start();
                    h3.start();

                    informacion = "Los hilos se ejecutaron";
                    log.logInfo(informacion);
                }catch (NullPointerException e1){
                    advertencia = "Se trato de ejecutar el programa sin convertir el txt original";
                    JOptionPane.showMessageDialog(null,"Error antes de ejecutar convierta primero la cadena");
                }

                }

            }
        };
        verEjecucionButton.addActionListener(bt4);



    }

}


package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Registro {

        private final Logger LOGGER= Logger.getLogger(Registro.class.getName());
        FileHandler archivo;

        {
        try {
            archivo = new FileHandler("C:\\Users\\PORTAUNLOCK3\\OneDrive\\Escritorio\\Programacion III\\Fases\\proyecto-piii\\Proyecto Fase 2\\logger.txt",false);
            archivo.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void logInfo(String informacion){

            LOGGER.log(Level.INFO, informacion);

        }
    public void logAdvertencia(String advertencia){

        LOGGER.log(Level.WARNING,advertencia);

    }
    public void logSevero(String severo){
       
        LOGGER.log(Level.SEVERE,severo);
    }



}






























/**
 * @ Nombre del proyecto: $Convertir Palindroma
 * @ Nombre de archivo:   $Proyecto palindromo
 *@Date: $20/08/2022
 *@Copyright: $Anderson Meneses. All rights reserved.
 * Nota: Este contenido está limitado a la circulación interna de la compañía, y está prohibido usarlo para fines comerciales.
 */
package logica;

import errores.ArchivoNull;
import errores.NoHayArchivo;

import javax.swing.*;
import java.io.*;
import java.text.Normalizer;
import java.util.Locale;
import java.util.Arrays;


public class Texto {
    //Variables Nuevas-------------------------------------------------------
    String lectura, contenido, cadenaConvertida;
    String imprimir= "";
    String imprimir2 = "";
    String convertido = "";
    boolean bandera = false;
    //-----------------------------------------------------------------------

//Creacion de Clases---------------------------------------------------------
Verificar verificar = new Verificar();
Contar contar = new Contar();
Convertir convertir = new Convertir();
Limpiar lp = new Limpiar ();
//---------------------------------------------------------------------------

//Gran parte de la logica----------------------------------------------------
    public String convertirPalindroma(String t) {

        if (bandera == true) {
            bandera = false;

            return cadenaConvertida;
        } else {
            // Limpiando el contenido del txt para poder comparar y convertir
            t = lp.limpiarCadena(t);
            String[] cadena = t.split(" ");
            //
            imprimir2 = Arrays.toString(cadena);
            imprimir2 = lp.limpiarCadena(imprimir2);
            ///* Verifica el array de palabras
            cadenaConvertida = Arrays.toString(verificarPalindroma(cadena, 0));
            cadenaConvertida = lp.limpiarCadena(cadenaConvertida);
             //*/
           //verificarPalindroma(cadena, 0);


            bandera = true;
            return convertirPalindroma(t);
        }


    }
    public String[] verificarPalindroma(String [] cadena, int i){
        if(i > cadena.length-1){
            bandera = false;
            return cadena;
        }else{
            //Contenido variable auxiliar para sacar la cadena en la posicion I
            contenido = cadena[i];
            //Verifica que el tamaño de la palabra, si el tamaño de la palabra es menor o igual a tres, se guarda tal cual la palabra
            if(3 >= contenido.length()){
                cadena[i]= cadena[i];
                imprimir += cadena[i]+ ",";
                return verificarPalindroma(cadena, i+1);
            }else{
            //Si la palabra es mayor que tres se verifica si es palindroma
                bandera = verificar.invertir(contenido, 0);
            //Si es palindroma se guarda tal cual
                if(bandera == true) {
                    cadena[i]= cadena[i];
                    return verificarPalindroma(cadena, i+1);
            //En caso de no ser palindroma se verifica si es par o impar
                }else{
                    if ((contenido.length()) % 2 == 0) {
                        char[] arregloCont = contenido.toCharArray();
            //Verifica si todas sus letras son pares
                        bandera = contar.contarPalabraPar(arregloCont, 0);
                        if(bandera == true) {
                            convertido = "";
                            cadena[i] = convertir.palabraPar(arregloCont,0);
                            return verificarPalindroma(cadena, i + 1);
            //De tener una o mas palabras impares no es convertible, se guarda tal cual
                        }else{
                            cadena[i]=cadena[i];
                            imprimir += cadena[i]+ ",";
                            return verificarPalindroma(cadena, i + 1);
                        }
            //Aqui en caso de que la palabra es impar se verifica que por lo menos tenga una impar y las demas pares
                    } else {
                        char[] arregloCont = contenido.toCharArray();
                        bandera = contar.contarPalabraImpar(arregloCont, 0);
                        if(bandera == true){
                            convertido = "";
                            cadena[i]=convertir.palabraImpar(arregloCont,0);
                            return verificarPalindroma(cadena, i + 1);
            //Si la palabra no cumple con tener un solo caracter impar y los demas pares, la palabra no es convertible
                        }else{
                            cadena[i]=cadena[i];
                            imprimir += cadena[i]+ ",";
                            return verificarPalindroma(cadena, i + 1);
                        }


                    }
                }

            }
        }

    }
//---------------------------------------------------------------------------




//Metodo get que devuelve las palabras que no son palindromas ni convertibles
    public String getImprimir() {
        return imprimir;
    }
//---------------------------------------------------------------------------


//Metodos para los botones---------------------------------------------------
//Metodos buenos
    public String convertirEnCadena(String ruta) {
        try {
            if(!ruta.contains(".txt")){
             throw new NoHayArchivo("Error verifique si el archivo es un txt o exista");
            }
            if(bandera == true){
                bandera = false;
                return contenido;

            }else{
                FileReader fr = new FileReader(ruta);
                BufferedReader br= new BufferedReader(fr);
                contenido = abrirArchivo(br);
                bandera = true;
                return convertirEnCadena(ruta);
            }
        } catch (NoHayArchivo e) {
            JOptionPane.showMessageDialog(null, "Error verifique si el archivo es un txt o exista");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return ruta;
    }
    private String abrirArchivo(BufferedReader br) throws IOException {
        if(bandera == true){
            contenido = contenido.replace("null", "");
            return contenido;
        }else{
            if((lectura = br.readLine())!=null) {
                contenido = contenido+ lectura + "\n";
                return abrirArchivo(br);
            }else{
                bandera = true;
                return abrirArchivo(br);
            }
        }
    }
    public void guardarArchivo(String ruta, String cadenaConvertida) {
        try {
            if(cadenaConvertida == null){
                throw new ArchivoNull("ERROR no se a ingresado un txt");
            }
            FileWriter fw = new FileWriter(ruta+".txt");
            BufferedWriter bw= new BufferedWriter(fw);
            bw.write("//-----------Cadena Convertida-----------//"+"\n");
            bw.write(cadenaConvertida);
            bw.write("\n\n\n");
            bw.write("//-----------Cadena Original-----------//"+"\n");
            bw.write(imprimir2);
            bw.close();
            JOptionPane.showMessageDialog(null, "Archivo TXT creado correctamente");
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ArchivoNull e){
            JOptionPane.showMessageDialog(null, "ERROR no se a ingresado un txt");
        }
    }
//---------------------------------------------------------------------------

}

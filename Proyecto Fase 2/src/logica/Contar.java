package logica;

public class Contar {

    int contador = 0;
    boolean bandera;
    boolean bandera2 = true;
    String aux2 = "";
    String aux3 = "";
    String convertido2 = "";
    String convertido = "";

//Metodos de contar palabras, tanto pares como impares-----------------------
    public boolean contarPalabraPar(char[] arregloCont, int i) {
        contador =0;
        if(i > arregloCont.length-1){
            return bandera;
        }else{
            char aux= arregloCont[i];
            contador = contarPalabra(arregloCont,aux, 0);
            if((contador%2)==0){
                bandera = true;
                return contarPalabraPar(arregloCont, i+1);
            }else{
                bandera = false;
                return contarPalabraPar(arregloCont, i+ arregloCont.length);
            }


        }
    }
    public boolean contarPalabraImpar(char[] arregloCont, int i) {
        contador =0;
        if(i > arregloCont.length-1){
            bandera2 = true;
            aux2= "";
            aux3= "";
            return bandera;
        }else{
            char aux= arregloCont[i];
            aux3 = String.valueOf(arregloCont[i]);
            if(!(aux2.contains(aux3))) {
                aux2+=aux;
                contador = contarPalabra(arregloCont, aux, 0);
            }
            if((contador%2)==0){

                bandera = true;
                return contarPalabraImpar(arregloCont, i+1);
            }else{
                if(bandera2 == true){
                    bandera2 = false;
                    bandera = true;
                    return contarPalabraImpar(arregloCont, i+1);
                }
                bandera = false;
                return contarPalabraImpar(arregloCont, i+arregloCont.length);
            }



        }
    }
    public int contarPalabra(char[] arregloCont, char aux, int i) {

        if(i > arregloCont.length-1){
            int contador2 = contador;
            contador =0;
            return contador2;
        }else{
            if(aux == arregloCont[i]){
                contador += 1;
                return contarPalabra(arregloCont,aux, i+1);
            }
            return contarPalabra(arregloCont,aux, i+1);
        }
    }
    public String contarPalabra2(String aux2, int contador, int i){
        if(i>contador-1){
            convertido2 = convertido;
            convertido = "";
            return convertido2;
        }else{
            convertido += aux2;
            return contarPalabra2(aux2, contador, i+1);
        }
    }
//---------------------------------------------------------------------------
}

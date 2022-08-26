package logica;

public class Convertir {
    private int contador;
    private String convertido = "";
    private String aux2 = "";
    private String aux3 = "";
    private String convertido2 = "";
    Contar contar = new Contar();


    //Metodos para convertir la palabras impares---------------------------------
    public String palabraImpar(char[] arregloCont, int i) {
        contador =0;
        if(i > arregloCont.length-1){
            StringBuilder strb = new StringBuilder(convertido);
            String inverso = strb.reverse().toString();
            convertido2 = convertido;
            aux2 = aux3;
            convertido = "";
            aux3 = "";
            return convertido2+aux2+inverso ;

        }else{
            aux2 = String.valueOf(arregloCont[i]);
            contador = contar.contarPalabra(arregloCont, arregloCont[i], 0);

            if(contador/2 != 1){
                if(!(contador == 1)){
                    contador = contador/2;
                }

                aux2 = contar.contarPalabra2(aux2,contador, 0);
                convertido2 = "";
            }

            if(contador%2 == 1){
                aux3 += aux2;
                return palabraImpar(arregloCont, i+1);
            }
            if(!convertido.contains(aux2)) {
                convertido += aux2;
                return palabraImpar(arregloCont, i+1);
            }else{
                return palabraImpar(arregloCont, i+1);
            }

        }
    }
//---------------------------------------------------------------------------



    //Metodos para convertir la palabras tanto en pares--------------------------
    public String palabraPar(char[] arregloCont, int i) {
        contador =0;
        if(i > arregloCont.length-1){
            StringBuilder strb = new StringBuilder(convertido);
            String inverso = strb.reverse().toString();
            convertido2 = convertido;
            convertido= "";
            return convertido2+inverso ;
        }else{
            aux2 = String.valueOf(arregloCont[i]);
            contador = (contar.contarPalabra(arregloCont, arregloCont[i], 0))/2;
            if(contador != 0){

                aux2 = contar.contarPalabra2(aux2,contador, 0);
                convertido2 = "";
            }
            if(!convertido.contains(aux2)) {
                convertido += aux2;
                return palabraPar(arregloCont, i+1);
            }else{
                return palabraPar(arregloCont, i+1);
            }



        }
    }
//---------------------------------------------------------------------------
}

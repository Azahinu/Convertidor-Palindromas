package logica;

public class Verificar {
    boolean bandera = false;
    //Metodo verifica si es palindroma desde un inicio---------------------------
    public boolean invertir(String contenido, int i){

        if( i > contenido.length()-1){
            return bandera;
        }else{
            StringBuilder strb = new StringBuilder(contenido);
            String inverso = strb.reverse().toString();
            if(inverso == contenido){
                bandera = true;
            }else{
                bandera = false;
            }
            return invertir(contenido, i+contenido.length());
        }


    }
//---------------------------------------------------------------------------
}

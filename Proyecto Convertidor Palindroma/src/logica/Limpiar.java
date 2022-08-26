package logica;

import java.text.Normalizer;
import java.util.Locale;

public class Limpiar {



    public String limpiarCadena(String cadena) {
        // Limpiando el contenido del txt para poder comparar y convertir
        cadena = cadena.replace("\n", " ");
        cadena = cadena.replace(",", "");
        cadena = cadena.replace(";", "");
        cadena = cadena.replace(".", "");
        cadena = cadena.replace(":", "");
        cadena = cadena.replace("_", "");
        cadena = cadena.replace("-", "");
        cadena = cadena.replace("+", "");
        cadena = cadena.replace("[", "");
        cadena = cadena.replace("]", "");
        cadena = cadena.replace(",", "");
        cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        cadena = cadena.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        cadena = cadena.toLowerCase(Locale.ROOT);

        return cadena;

    }

}

package edu.uniandes.ecos.Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que realiza las operaciones de validaci�n y conteo de l�neas de c�digo
 * fuente
 *
 * @author JohnDany
 */
public class ContadorLineasCodigo {

    /**
     * M�todo que recorre el archivo validando y contando l�neas de c�digo
     * fuente
     *
     * @param archivo
     * @return la cantidad de l�neas de c�digo encontradas
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int recorrerArchivo(File archivo) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        int cantidadLineas = 0;
        while ((linea = br.readLine()) != null) {
            cantidadLineas = cantidadLineas + this.leerLinea(linea);
        }
        return cantidadLineas;
    }

    /**
     * M�todo que valida que sea una l�nea de codigo fuente
     *
     * @param linea
     * @return cero si no es una l�nea de c�digo fuente o 1 si lo es.
     */
    private int leerLinea(String linea) {
        int cantidad = 0;
        String lineaTemporal = linea.trim().toLowerCase();
        if (lineaTemporal.trim().length() > 0) {
            if (!lineaTemporal.startsWith("/")) {
                if (!lineaTemporal.startsWith("*")) {
                    if (!lineaTemporal.startsWith("package")) {
                        if (!lineaTemporal.startsWith("import")) {
                            if (!lineaTemporal.equals("{")) {
                                if (!lineaTemporal.equals("}")) {
                                    cantidad = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return cantidad;
    }
}

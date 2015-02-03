package edu.uniandes.ecos.Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que realiza las operaciones de validación y conteo de líneas de código
 * fuente
 *
 * @author JohnDany
 */
public class ContadorLineasCodigo {

    /**
     * Método que recorre el archivo validando y contando líneas de código
     * fuente
     *
     * @param archivo
     * @return la cantidad de líneas de código encontradas
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
     * Método que valida que sea una línea de codigo fuente
     *
     * @param linea
     * @return cero si no es una línea de código fuente o 1 si lo es.
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

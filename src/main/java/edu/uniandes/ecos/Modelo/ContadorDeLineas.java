package edu.uniandes.ecos.Modelo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que tiene los métodos que abren un archivo y cuentan las líneas de
 * código fuente
 *
 * @author JohnDany
 */
public class ContadorDeLineas {
    private  RespuestaContador respuesta;
    public ContadorDeLineas()
    {
        respuesta = new RespuestaContador();
    }

    /**
     * Método que ejecuta el conteo de líneas de código fuente
     *
     * @param rutaFolderArchivos ruta de la carpeta contedora de archivos fuente
     * @param extensiones para realizar el filtro de los archivos encontrados
     * @return respuesta con la inforamción encontrada
     */
    public RespuestaContador ContarLineasCodigoFuente(String rutaFolderArchivos, String... extensiones) {
             if (!rutaFolderArchivos.equals("")) {
            File ruta = new File(rutaFolderArchivos);
            if (ruta.exists()) {
                try {
                    respuesta = this.recorrerDirectorios(ruta, extensiones);
                } catch (IOException ex) {
                    respuesta.setError(ex.getMessage() + "Ruta: " + ruta);
                    Logger.getLogger(ContadorDeLineas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                respuesta.setError("La ruta parametrizada para leer archivos no existe");
            }
        } else {
            respuesta.setError("La ruta para leer los archivos no fue parametrizada.");

        }

        return respuesta;
    }

    /**
     * Método que recorre un directorio en busqueda de archivos válidos para
     * leer.
     *
     * @param directorioRaiz ruta de la carpeta
     * @param extensiones para filtar los archivos encontrados en la ruta
     * @return respuesta con la inforamción encontrada
     * @throws IOException
     */
    private RespuestaContador recorrerDirectorios(File directorioRaiz, String... extensiones) throws IOException {
        File[] elementos = directorioRaiz.listFiles();

        for (File archivo : elementos) {

            if (archivo.isDirectory()) {
                this.recorrerDirectorios(archivo, extensiones);
            } else {
                for (String ext : extensiones) {
                    if (archivo.getPath().toLowerCase().endsWith(ext.toLowerCase())) {
                        respuesta.setCantidadArchivos(respuesta.getCantidadArchivos() + 1);
                        respuesta.setCantidadLineas(respuesta.getCantidadLineas() + new ContadorLineasCodigo().recorrerArchivo(archivo));
                        break;
                    }
                }
            }
        }

        return respuesta;
    }
}

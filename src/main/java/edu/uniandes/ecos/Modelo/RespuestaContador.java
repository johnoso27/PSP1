/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.Modelo;

/**
 * Clase que representa la respuesta obtenida despues de contar las líneas de código fuente.
 * @author JohnDany
 */
public class RespuestaContador {
    private int cantidadLineas;
    private int cantidadArchivos;
    private String error;

    /**
     * @return la cantidadLineas
     */
    public int getCantidadLineas() {
        return cantidadLineas;
    }

    /**
     * @param cantidadLineas la cantidadLineas to set
     */
    public void setCantidadLineas(int cantidadLineas) {
        this.cantidadLineas = cantidadLineas;
    }

    /**
     * @return the cantidadArchivos
     */
    public int getCantidadArchivos() {
        return cantidadArchivos;
    }

    /**
     * @param cantidadArchivos the cantidadArchivos to set
     */
    public void setCantidadArchivos(int cantidadArchivos) {
        this.cantidadArchivos = cantidadArchivos;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
}

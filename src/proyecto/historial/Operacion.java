/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.historial;

import java.time.LocalDateTime;

/**
 * Clase operacion que registra su descripcion y tiempo 
 * @author juego
 */
public class Operacion {
    private String descripcion;
    private LocalDateTime timestamp;
    /**
     * Constructor de Operacion
     * @param descripcion 
     */
    public Operacion(String descripcion) {
        this.descripcion = descripcion;
        this.timestamp = LocalDateTime.now();
    }
    // Getters y setters
    /**
     * Metodo getter de la descripcion
     * @return 
     */
    public String getDescripcion() { 
        return descripcion; 
    }
    /**
     * Metodo getter para el tiempo en vivo en el momento que se hizo la operacion
     * @return 
     */
    public LocalDateTime getTimestamp() { 
        return timestamp; 
    }
    /**
     * Metodo toString para mostrar los datos o la forma en que se va a mostrar
     * @return 
     */
    @Override
    public String toString() {
        return timestamp + ": " + descripcion;
    }
}

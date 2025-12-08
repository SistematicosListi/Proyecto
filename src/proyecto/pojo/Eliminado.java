/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *Clase para los productos eliminados
 * @author aleja
 */
public class Eliminado {
    private String clave;
    private String nombre;
    private String razon;
    private Date fecha;
    /**
     * Constructor parametrizado para los productos eliminados
     * @param clave - clave del producto elimnado
     * @param razon - razon del producto eliminado
     * @param fecha - fecha en la cual fue eliminado
     */
    public Eliminado(String clave, String razon, Date fecha) {
        this.clave = clave;
        this.nombre = nombre;
        this.razon = razon;
        this.fecha = fecha;
    }
    /**
     * Metodo Getter de clave
     * @return 
     */
    public String getClave() {
        return clave;
    }
    /**
     * Metodo setter de clave
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * Metodo Getter de nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo setter de nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo Getter de razon
     * @return 
     */
    public String getRazon() {
        return razon;
    }
    /**
     * Metodo setter de razon
     * @param razon 
     */
    public void setRazon(String razon) {
        this.razon = razon;
    }
    /**
     * Metodo Getter de fecha
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Metodo setter de fecha
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pojo;

/**
 *Clase producto
 * @author aleja
 */
public class Producto implements Comparable<Producto> {
    private String clave;
    private String nombre;
    private int cantidad;
    private double precio;
    /**
     * Constructor parametrizado de producto
     * @param clave - la clave del producto
     * @param nombre - nombre del producto
     * @param cantidad - cantidad de productos
     * @param precio  - precio del producto
     */
    public Producto(String clave, String nombre, int cantidad, double precio) {
        this.clave = clave;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    /**
     * Metodo getter de clave
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
     * Metodo getter de nombre
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
     * Metodo getter de cantidad
     * @return 
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Metodo setter de cantidad
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Metodo getter de precio
     * @return 
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Metodo setter de precio
     * @param precio 
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Netodo que compara los productos
     * @param o el producto el cual se va a comparar
     * @return regresa un numero, dependiendo si es mayor, menor o igual
     */
    @Override
    public int compareTo(Producto o) {
        return this.clave.compareToIgnoreCase(o.clave);
    }
    
    
}

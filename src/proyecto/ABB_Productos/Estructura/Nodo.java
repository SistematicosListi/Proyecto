/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.ABB_Productos.Estructura;

import proyecto.pojo.Producto;

/**
 *  Clase Nodo para 
 * @author juego
 */
public class Nodo implements Comparable<Producto> {
    private Producto valor;
    private Nodo izquierdo;
    private Nodo derecho;
    
    /** constructor vacio
     * 
     */
    public Nodo(){
    }
    
    /** constructor que guarda el producto
     * 
     * @param valor 
     */
    public Nodo(Producto valor){
        this.valor = valor;
    }

    /** regresa el producto guardado 
     * 
     * @return 
     */
    public Producto getValor() {
        return valor;
    }

    /** cambia el producto del nodo 
     * 
     * @param valor 
     */
    public void setValor(Producto valor) {
        this.valor = valor;
    }

    /** regresa el nodo de la izquierda 
     * 
     * @return 
     */
    public Nodo getIzquierdo() {
        return izquierdo;
    }

    /** cambia el nodo de la izquierda 
     * 
     * @param izquierdo 
     */
    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    /** regresa el nodo de la derecha 
     * 
     * @return 
     */
    public Nodo getDerecho() {
        return derecho;
    }

    /** cambia el nodo de la derecha 
     * 
     * @param derecho 
     */
    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    /**
     * compara las claves para saber si va a la izq o der
     */
    public int compareTo(Producto p) {
        if(p == null || p.getClave() == null){
            return 0;
        }
        return valor.getClave().compareToIgnoreCase(p.getClave());
    }
}
    


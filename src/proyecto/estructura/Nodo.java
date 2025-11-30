/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura;

import proyecto.pojo.Producto;
/**
 *
 * @author aleja
 */
public class Nodo {
    Producto producto;
    Nodo izquierdo, derecho;
    
    public Nodo(Producto producto) {
        this.producto = producto;
        izquierdo = derecho = null;
    }
    
}

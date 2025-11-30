/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura;

import proyecto.pojo.Producto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aleja
 */
public class ABB {
    private Nodo raiz;
    
    public void insertar(Producto producto) {
        raiz = insertarRec(raiz, producto);
    }
    
    private Nodo insertarRec(Nodo raiz, Producto producto) {
        if (raiz == null) return new Nodo(producto);
        int cmp = producto.getClave().compareTo(raiz.producto.getClave());
        if (cmp < 0) raiz.izquierdo = insertarRec(raiz.izquierdo, producto);
        else if (cmp > 0) raiz.derecho = insertarRec(raiz.derecho, producto);
        // Si cmp == 0, no inserta (clave repetida, se ignora)
        return raiz;
    }
    
    public Producto buscar(String clave) {
        return buscarRec(raiz, clave);
    }
    private Producto buscarRec(Nodo raiz, String clave) {
        if (raiz == null || raiz.producto.getClave().equals(clave)) 
            return raiz != null ? raiz.producto : null;
        if (clave.compareTo(raiz.producto.getClave()) < 0) 
            return buscarRec(raiz.izquierdo, clave);
        return buscarRec(raiz.derecho, clave);
    }      
    
    public void eliminar(String clave) {
        raiz = eliminarRec(raiz, clave);
    }
    private Nodo eliminarRec(Nodo raiz, String clave) {
        if (raiz == null) return raiz;
        if (clave.compareTo(raiz.producto.getClave()) < 0)
            raiz.izquierdo = eliminarRec(raiz.izquierdo, clave);
        else if (clave.compareTo(raiz.producto.getClave()) > 0)
            raiz.derecho = eliminarRec(raiz.derecho, clave);
        else {
            if (raiz.izquierdo == null) return raiz.derecho;
            else if (raiz.derecho == null) return raiz.izquierdo;
            raiz.producto = minValor(raiz.derecho);
            raiz.derecho = eliminarRec(raiz.derecho, raiz.producto.getClave());
        }
        return raiz;
    }
    
    private Producto minValor(Nodo raiz) {
        Producto min = raiz.producto;
        while (raiz.izquierdo != null) {
            min = raiz.izquierdo.producto;
            raiz = raiz.izquierdo;
        }
        return min;
    }
    
    //Recorrido inorden
    public List<Producto> inorden() {
        List<Producto> lista = new ArrayList<>();
        inordenRec(raiz, lista);
        return lista;
    }
    
    private void inordenRec(Nodo raiz, List<Producto> lista) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo, lista);
            lista.add(raiz.producto);
            inordenRec(raiz.derecho, lista);
        }
    }
    
    // Recorrido preorder
    public List<Producto> preorder() {
        List<Producto> lista = new ArrayList<>();
        preorderRec(raiz, lista);
        return lista;
    }
    private void preorderRec(Nodo raiz, List<Producto> lista) {
        if (raiz != null) {
            lista.add(raiz.producto);
            preorderRec(raiz.izquierdo, lista);
            preorderRec(raiz.derecho, lista);
        }
    }
    
    // Recorrido postorder
    public List<Producto> postorder() {
        List<Producto> lista = new ArrayList<>();
        postorderRec(raiz, lista);
        return lista;
    }
    private void postorderRec(Nodo raiz, List<Producto> lista) {
        if (raiz != null) {
            postorderRec(raiz.izquierdo, lista);
            postorderRec(raiz.derecho, lista);
            lista.add(raiz.producto);
        }
    }
    
    
}

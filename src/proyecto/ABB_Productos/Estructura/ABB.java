/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.ABB_Productos.Estructura;

import java.util.ArrayList;
import java.util.List;
import proyecto.pojo.Producto;

/**
 *
 * @author juego
 */
public class ABB {
    private Nodo raiz;
    private int comparaciones;
    
    /** constructor vacio 
     * 
     */
    public ABB(){
    }
    
    /** regresa la raiz 
     * 
     * @return 
     */
    public Nodo getRaiz(){
        return raiz;
    }
    
    /** cambia la raiz 
     * 
     * @param raiz 
     */
    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }
    
    /** regresa cuantas comparaciones se hicieron 
     * 
     * @return 
     */
    public int getComparaciones(){
        return comparaciones;
    }
    
    /**
     * 
     * @param valor 
     * Inserta productos al arbol
     */
    public void insertar(Producto valor){
        this.raiz = crearNodoRecursivo(raiz, valor); //inserta los productos, pero primero llama de forma recursiva al otro metodo y el primero cumplira el if si esta vacio el nodo o el valor y se insertara la raiz
    }
    
    /** metodo que crea los nodos de forma recursiva 
     * 
     * @param nodo
     * @param valor
     * @return 
     */
    private Nodo crearNodoRecursivo(Nodo nodo, Producto valor){
        if (nodo == null || nodo.getValor() == null){
            nodo = new Nodo(valor);
            return nodo;
        }
        if (nodo.compareTo(valor) > 0){ //
            nodo.setIzquierdo(crearNodoRecursivo(nodo.getIzquierdo(), valor)); //aqui se vuelve a llamar porque no se sabe si hay un nodo en el lado izquierdo entonces vuelve al mismo proceso y lo inserta
        }
        if (nodo.compareTo(valor) < 0){ //lo que hace es comparar el nodo actual con el nuevo que se quiere insertar ejemplo 5 y 6
            // entonces dependiendo lo que mande el metodo compareTo se va al primer if si manda un numero positivo y al segundo si es negativo 
            //ejemplo 5 compara con 6 e5 es menor que 6 entonces manda un numero negativo por lo tanto -1 no es mahyor que 0 avanza al siguiente if 
            nodo.setDerecho(crearNodoRecursivo(nodo.getDerecho(), valor));
        }
        return nodo;
    }
    
    /** busca un producto en el arbol 
     * 
     * @param valor
     * @return 
     */
    public Producto buscar(Producto valor){
        this.comparaciones = 0;
        Producto resultado = buscarRecursivo(raiz, valor);
        System.out.print("Buscar (ABB) - " + valor);
        if (resultado != null){
            System.out.print(" si existe");
        } else {
            System.out.print(" no esta en el arbol");
        }
        System.out.print(" - comparaciones: "+comparaciones);
        System.out.println();
        return resultado;
    }
    
    /** metodo recursivo que hace la busqueda 
     * 
     * @param nodo
     * @param valor
     * @return 
     */
    private Producto buscarRecursivo(Nodo nodo, Producto valor){
        if (nodo == null){
            return null;
        }
        comparaciones++;
        int resultadocomparacion = nodo.compareTo(valor);
        if(resultadocomparacion == 0){
            return nodo.getValor();
        }
        if(resultadocomparacion > 0){
            return buscarRecursivo(nodo.getIzquierdo(), valor);
        } else {
            return buscarRecursivo(nodo.getDerecho(), valor);
        }
    }
    
    /** 
     * Ordena los valores del arbol en una lista le indica que metodo usar, si inordenn ascedente o descendete
     * @param ascendente
     * @return 
     */
    public List<Producto> ordenarDatos(boolean ascendente){
        List<Producto> listaordenada = new ArrayList<>();
        if (ascendente){
            recorrerInordenRecursivo(raiz, listaordenada);
        } else {
            recorrerInordenDescRecursivo(raiz, listaordenada);
        }
        return listaordenada;
    }

    /** recorre el arbol de forma ascendente
     * 
     * @param nodo
     * @param lista 
     */ 
     
    public void recorrerInordenRecursivo(Nodo nodo, List<Producto> lista){
        if (nodo != null){
            recorrerInordenRecursivo(nodo.getIzquierdo(), lista);
            lista.add(nodo.getValor());
            recorrerInordenRecursivo(nodo.getDerecho(), lista);
        }
    }
    
    /** recorre el arbol de forma descendente
     * 
     * @param nodo
     * @param lista 
     */
    public void recorrerInordenDescRecursivo(Nodo nodo, List<Producto> lista){
        if (nodo != null){
            recorrerInordenRecursivo(nodo.getDerecho(), lista);
            lista.add(nodo.getValor());
            recorrerInordenRecursivo(nodo.getIzquierdo(), lista);
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.ABB_Productos.Estructura;

import java.util.ArrayList;
import java.util.List;
import proyecto.ABB_Productos.Estructura.Nodo;
import proyecto.pojo.Producto;

/**
 * Clase para crear el Arbol 
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
     * @param valor Es el producto que se va a insertar
     * Inserta productos al arbol
     */
    public void insertar(Producto valor){
        this.raiz = crearNodoRecursivo(raiz, valor); //inserta los productos, pero primero llama de forma recursiva al otro metodo y el primero cumplira el if si esta vacio el nodo o el valor y se insertara la raiz
    }
    
    /** Metodo que crea los nodos de forma recursiva 
     * 
     * @param nodo es el nodo por el cual empieza (La raiz), ya sea el arbol o el subarbol
     * @param valor el nodo el cual se va a introducir
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
     * @param valor el producto o nodo que se va a buscar
     * @return 
     */
    public Producto buscar(Producto valor){
        this.comparaciones = 0;
        Producto resultado = buscarRecursivo(raiz, valor); //se le pasa el nodo raiz, porque desde ahi debe empezar
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
     * @param nodo es la raiz del arbol o por donde empezará a buscar
     * @param valor el producto el cual se esta buscando o nodo
     * @return 
     */
    private Producto buscarRecursivo(Nodo nodo, Producto valor){
        //caso base de la recursion para poder finalizar
        if (nodo == null){
            return null;
        }
        
        comparaciones++;
        
        //usa el metodo compareTo y le pasa el producto como parametro
        //En compareTo, valor es el nodo actual
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
     * @param ascendente indicamos en que orden se va a ordenar los datos
     * @return regresa la lista con los datos ya ordenados
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
     * @param nodo es la raiz del arbol 
     * @param lista La lista en la cual se ira introduciendo los datos en inorden
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
     * @param nodo La raiz del arbol
     * @param lista La lista en la cual se ira introduciendo los datos en inorden
     */
    public void recorrerInordenDescRecursivo(Nodo nodo, List<Producto> lista){
        if (nodo != null){
            recorrerInordenRecursivo(nodo.getDerecho(), lista);
            lista.add(nodo.getValor());
            recorrerInordenRecursivo(nodo.getIzquierdo(), lista);
        }
    }
    /**
     * 
     * @param clave la clave del objeto que se quiere sacar del arbol
     */
    public void eliminar(String clave){
        this.raiz = eliminarRecursivo(raiz, clave);
    }
    /**
     * 
     * @param nodo la raiz del arbol donde empezara a buscar
     * @param clave la clave del producto el cual se quiere eliminar
     * @return 
     */
    private Nodo eliminarRecursivo(Nodo nodo, String clave){
        if (nodo == null){
            return null;
        }
        comparaciones++;
        int resultadocomparacion = clave.compareToIgnoreCase(nodo.getValor().getClave());
        
        if(resultadocomparacion == 0){ //lo encontro
            
            //en caso del que el nodo que se quiera eliminar no tenga hijos
            if(nodo.getIzquierdo() == null && nodo.getDerecho() == null){
                return null;
            }
            
            //Caso en el que solo tengan un hijo
            //en caso de que no exista el lado izquierdo
            if (nodo.getIzquierdo() == null){
                return nodo.getDerecho();
            }
            // En caso de que no exista el lado derecho
            if(nodo.getDerecho()== null){
                return nodo.getIzquierdo();
            }
            //sustituye el valor eliminado por el minimo del subarbol
            Nodo sucesor = encontrarMinimo(nodo.getDerecho());
            nodo.setValor(sucesor.getValor());
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.getValor().getClave()));
            
        }
        if(resultadocomparacion > 0){ //el nodo comparado fue mayor, asi que se va a la derecha
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), clave));
            
        } else { //el nodo comparado fue menor, asi que va a la izquierda
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), clave));
        }
        
        return nodo;
        

    }
    /**
     * Metodo para buscar el valor minimo 
     * @param nodo el nodo o raiz el cual se va a buscar, ya sea que se empiece por el subarbol izquierdo o derecho
     * @return 
     */
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.MetodosOrdenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que maneja los tipos de ordenaiento logaritmicos (QuickSort y MergeSort)
 * @author juego
 * @param <T> 
 */
public class LogaritmicosUtils<T extends Comparable<T>> {
    
    /**
     * Metodo para comparar los elementos
     * @param value1
     * @param value2
     * @return 
     */
    private int compareToGeneric(T value1, T value2) {
        if (value1 instanceof String && value2 instanceof String) {
            return value1.toString().compareToIgnoreCase(value2.toString());
        }
        return value1.compareTo(value2);
    }

    /**
     * Metodo para dividir las listas
     * @param lista
     * @return 
     */
    public List<T> mergeSort(List<T> lista) {
        //caso base: si la lista tiene 0 1 elementos, ya esta ordenada
        if (lista.size() <= 1) {
            return lista;
        }

        int mitad = lista.size() / 2;
        List<T> izquierda = new ArrayList<>(lista.subList(0, mitad)); //desde la posicion 0 hasta la mitad
        List<T> derecha = new ArrayList<>(lista.subList(mitad, lista.size())); // divide desde la mitad hasta el tamaño de la lista
        //llamada recursiva
        izquierda = mergeSort(izquierda); 
        derecha = mergeSort(derecha);
        
        //fusiona las dos mitades llamando al otro método
        return merge(izquierda, derecha);
    }

    
    /**
     * Metodo para fusionar las dos listas
     * @param izquierda
     * @param derecha
     * @return 
     */
    private List<T> merge(List<T> izquierda, List<T> derecha) {
        List<T> mezcla = new ArrayList<>();

        int i = 0, j = 0;
        //Compara y mezcla los elementos de las dos listas
        while (i < izquierda.size() && j < derecha.size()) {
            if (compareToGeneric(izquierda.get(i), derecha.get(j)) <= 0) {
                mezcla.add(izquierda.get(i));
                i++;
            } else {
                mezcla.add(derecha.get(j));
                j++;
            }
        }

        // Agregar el resto
        while (i < izquierda.size()) {
            mezcla.add(izquierda.get(i));
            i++;
        }

        while (j < derecha.size()) {
            mezcla.add(derecha.get(j));
            j++;
        }

        return mezcla;
    }
    
    
    /**
     * Metodo para ordenar las listas de forma recursiva
     * @param lista
     * @param minimo
     * @param maximo
     * @return 
     */
     public List<T> quickSort(List<T> lista, int minimo, int maximo){
        if(minimo < maximo){
            int posicionPivote = quickSortDividir(lista, minimo, maximo);
            quickSort(lista, minimo, posicionPivote - 1);
            quickSort(lista, posicionPivote + 1, maximo);
        }
        return lista;
    }
     /**
      * Metodo para seleccionar el pivote e irlos moviendo
      * @param lista
      * @param minimo
      * @param maximo
      * @return devuelve el valor
      */
    private int quickSortDividir(List<T> lista, int minimo, int maximo) {
        //elige el pivote
        T valorPivote = lista.get(maximo);
        int i = minimo -1;
        for(int j = minimo; j< maximo; j++){
            if(compareToGeneric(lista.get(j), valorPivote) <= 0){
                i++;
                
                Collections.swap(lista, i, j);
            }
        }
        Collections.swap(lista, i+ 1, maximo);
        return i + 1;
    }
}


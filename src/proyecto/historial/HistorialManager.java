/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.historial;

import java.util.List;
import java.util.Stack;


/**
 * Clase que funciona como pila para almacenar los logs del usuario
 * @author juego
 */
public class HistorialManager {
    private static HistorialManager instance;  // Singleton para acceso global
    private Stack<Operacion> pila;
    /**
     * Constructor privado sin parametros de HistorialManager
     */
    private HistorialManager() {
        pila = new Stack<>();
    }
    /**
     * Metodo que verifique que haya una sola instancia de este
     * @return 
     */
    public static HistorialManager getInstance() {
        if (instance == null) {
            instance = new HistorialManager();
        }
        return instance;
    }
    /**
     * Metodo para agregar operaciones a la pila
     * @param op 
     */
    public void agregarOperacion(Operacion op) {
        pila.push(op);
    }
    /**
     * Metodo para obtener el historial
     * @return 
     */
    public List<Operacion> obtenerHistorial() {
        return pila;  // Devuelve la pila como lista (puedes convertir a ArrayList si necesitas)
    }
    
}

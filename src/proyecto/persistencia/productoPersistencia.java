/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.persistencia;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import proyecto.pojo.Producto;

/**
 *
 * @author juego
 */
/**
 * clase que se encarga de guardar y leer los carros del archivo json
 */
public class productoPersistencia {
    
    /** 
     * Metodo para guardarlos en Json
     * @param nombreArchivo
     * @param listaVehiculos 
     */
    public static void guardarComoJson(String nombreArchivo, List<Producto> listaProductos){
        Gson gson = new Gson();
        String json = gson.toJson(listaProductos);
        try {
            FileWriter escritor = new FileWriter(nombreArchivo);
            escritor.write(json);
            escritor.close();
            System.out.println("Archivo JSON guardado");
        } catch(IOException e){
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Este metodo carga el archivo que creamos 
     * @param nombreArchivo 
     * @return
     * @throws FileNotFoundException 
     */
     
    public static List<Producto> cargarJson(String nombreArchivo) throws FileNotFoundException{
        Gson gson = new Gson(); 
        List<Producto> lista = new ArrayList<>(); 
        try{
            FileReader lector = new FileReader(nombreArchivo);
            Type tipoLista = new TypeToken<List<Producto>>() {}.getType();
            lista = gson.fromJson(lector, tipoLista);
            lector.close();
            System.out.println("Archivo JSON cargado de forma correcta.");
        } catch(IOException ex){
            System.out.println("Error al cargar el archivo: " + ex.getMessage());
        }
        return lista;
    }
}

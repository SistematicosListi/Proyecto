/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import proyecto.pojo.Producto;
import proyecto.pojo.Eliminacion;  // Asumiendo que Eliminacion está en proyecto.pojo
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author aleja
 */
public class JsonUtils {
        public static List<Producto> cargarProductos(String archivo) {
        try (FileReader reader = new FileReader(archivo)) {
            List<Producto> productos = gson.fromJson(reader, new TypeToken<List<Producto>>(){}.getType());
            return productos != null ? productos : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    public static void guardarProductos(List<Producto> productos, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(productos, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
        }
    }
    public static List<Eliminacion> cargarEliminados(String archivo) {
        try (FileReader reader = new FileReader(archivo)) {
            List<Eliminacion> eliminados = gson.fromJson(reader, new TypeToken<List<Eliminacion>>(){}.getType());
            return eliminados != null ? eliminados : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    public static void guardarEliminados(List<Eliminacion> eliminados, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(eliminados, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar eliminados: " + e.getMessage());
        }
    }
    
}

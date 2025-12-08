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
import proyecto.pojo.Eliminado; // Importación adaptada a la nueva clase

/**
 * Clase que se encarga de guardar y cargar los registros de Eliminacion del archivo json.
 */
public class eliminadosPersistencia {
    
    /** * Metodo para guardar los registros de Eliminacion en formato JSON.
     * @param nombreArchivo El nombre del archivo donde se guardará el historial.
     * @param listaEliminados La lista de objetos Eliminado a guardar.
     */
    public static void guardarComoJson(String nombreArchivo, List<Eliminado> listaEliminados){
        Gson gson = new Gson();
        // Convertir la lista de objetos Eliminado a JSON
        String json = gson.toJson(listaEliminados);
        
        try {
            FileWriter escritor = new FileWriter(nombreArchivo);
            escritor.write(json);
            escritor.close();
            System.out.println("Archivo JSON de historial guardado.");
        } catch(IOException e){
            System.out.println("Error al guardar el archivo de historial: " + e.getMessage());
        }
    }
    
    /**
     * Este metodo carga el historial de Eliminacion desde el archivo JSON.
     * @param nombreArchivo El nombre del archivo que se cargará.
     * @return La lista de objetos Eliminado cargados.
     * @throws FileNotFoundException 
     */
    public static List<Eliminado> cargarJson(String nombreArchivo) throws FileNotFoundException{
        Gson gson = new Gson(); 
        List<Eliminado> lista = new ArrayList<>(); 
        
        try{
            FileReader lector = new FileReader(nombreArchivo);
            // Definir el tipo de objeto que se va a cargar: List<Eliminado>
            Type tipoLista = new TypeToken<List<Eliminado>>() {}.getType();
            
            lista = gson.fromJson(lector, tipoLista);
            
            lector.close();
            System.out.println("Archivo JSON de historial eliminados cargado de forma correcta.");
            
        } catch(FileNotFoundException ex){
             // Si el archivo no existe, no es un error critico, devuelve una lista vacía.
             // Relanzamos la excepción para que el Main lo maneje si es necesario.
             throw ex; 
        } catch(IOException ex){
            System.out.println("Error al cerrar el lector: " + ex.getMessage());
        }
        
        // Manejar el caso donde el archivo está vacío o el JSON es nulo
        if (lista == null) {
            return new ArrayList<>();
        }
        return lista;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import proyecto.utils.ProductosUtils;
import proyecto.inventario.InventarioManager;


import proyecto.pojo.Eliminado;
import proyecto.pojo.Producto;

import javax.swing.SwingUtilities;  // Import faltante para SwingUtilities
import proyecto.ABB_Productos.Estructura.ABB;
import proyecto.InterfazGrafica.PrincipalView;
import static proyecto.inventario.InventarioManager.historialEliminaciones;
import proyecto.persistencia.eliminadosPersistencia;
import proyecto.persistencia.productoPersistencia;



/**
 *
 * @author aleja
 */
public class Proyecto {
    public static ABB arbol = new ABB();
    public static InventarioManager inventario = new InventarioManager();
    
    public static final String DATA_FOLDER = "data/";
    
    
    
    public static  String ARCHIVO1 = "Productos.json";
    public static final String ARCHIVO2 = "productosEliminados.json";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        
        List<Producto> productoGuardado = productoPersistencia.cargarJson(ARCHIVO1);
        
        for(Producto p : productoGuardado){
            arbol.insertar(p);
        }
        
        List<Eliminado> historialCargado = eliminadosPersistencia.cargarJson(ARCHIVO2);
        
        // Asignar la lista cargada a la lista estática del Manager
        inventario.historialEliminaciones = historialCargado;
        
        
        
        
        
        
        
        
        
        
        
        FlatGradiantoDeepOceanIJTheme.setup();
       new PrincipalView().setVisible(true);
       
       System.out.println("\n--- REGISTRO DE HISTORIAL DE ELIMINACIONES ---");
        
        if (historialEliminaciones == null || historialEliminaciones.isEmpty()) {
            System.out.println("El historial de eliminaciones está vacío.");
            return;
        }
        
        for (Eliminado registro : historialEliminaciones) {
            System.out.println(registro); 
        }
       
        

    }
    
}

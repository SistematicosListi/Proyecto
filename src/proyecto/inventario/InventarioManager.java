/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.inventario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proyecto.ABB_Productos.Estructura.ABB;
import proyecto.MetodosOrdenamiento.LogaritmicosUtils;
import static proyecto.Proyecto.arbol;
import proyecto.historial.HistorialManager;
import proyecto.historial.Operacion;
import proyecto.pojo.Eliminado;

import proyecto.pojo.Producto;

/**
 *Esta clase gestiona los metodos para gestionar productos 
 * @author aleja
 * 
 */
public class InventarioManager {
    
    public static List<Eliminado> historialEliminaciones = new ArrayList<>();
    
    
    
    
    
    /**
     * Constructor sin parametros de inventario
     */
    public InventarioManager(){
        
    }
    
    
    
    
    /**
     * Metodo para agregar Productos
     * @param p 
     */
    public void agregarProducto(Producto p){
        arbol.insertar(p);
        HistorialManager.getInstance().agregarOperacion(new Operacion("Agregó producto: " + p.getNombre() + " (Clave: " + p.getClave() + ")"));
    }
    
    /**
     * Metodo para buscar Productos
     * @param clave 
     */
    public Producto buscarProducto(String clave){
        Producto productoTemp = new Producto(clave, null, 0, 0);
        return arbol.buscar(productoTemp);
    }
    
     /**
      * Merodo para editar el producto
      * @param p producto
      * @param nombre nombre del producto
      * @param cantidad cantidad de articulos
      * @param precio precio del artticulo
      * @return 
      */
    public boolean editarProducto(Producto p, String nombre, int cantidad, double precio){
        Producto encontrado = arbol.buscar(p);
        
        if (encontrado == null){
            return false; //no se encontro
        }
        
        if (cantidad < 0){
            throw new IllegalArgumentException("Cantidades negativas no pueden ser agregadas");
        }
        
        encontrado.setNombre(nombre);
        encontrado.setCantidad(cantidad);
        encontrado.setPrecio(precio);
        HistorialManager.getInstance().agregarOperacion(new Operacion("Editó producto: " + 
                                                                    encontrado.getNombre() + 
                                                                    " (Clave: " + encontrado.getClave()+
                                                                    ") - Nuevo nombre: " + nombre +  
                                                                     ", Cantidad: " + cantidad +   
                                                                     ", Precio: " + precio));
        
       return true;
        
    }
    /**
     * Metodo para eliminar productos
     * @param clave 
     */
    public void eliminarProducto(String clave){
        arbol.eliminar(clave);
        HistorialManager.getInstance().agregarOperacion(new Operacion("Eliminó producto con clave: " + clave));
    }
            
    /**
     * Metodo para devolver un TableModel que muestra los productos en Inorden
     * @return 
     */
    public DefaultTableModel getProductoInorden(){
        List<Producto> listaProductos = arbol.ordenarDatos(false);
        
        String[] columnas = {"Clave", "Nombre", "Cantidad", "Precio"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0){
            public boolean isCellEditable(int row, int column) {
                return false; // la tabla NO se puede editar
            }
        };
        
        for(Producto p : listaProductos){
            Object[] fila = { p.getClave(),
                              p.getNombre(),
                              p.getCantidad(),
                              p.getPrecio()
                            };
            model.addRow(fila);
            
        }
        
        return model;
        
    }
    /**
     * Metodo para devolver un TableModel ordenado por QuickSort
     * @return 
     */
    public DefaultTableModel getProductosQuickSort(){
        LogaritmicosUtils<Producto> utils = new LogaritmicosUtils<>();
        List<Producto> lista = arbol.ordenarDatos(true); //devuelve los datos del arbol en una lista
        
        List<Producto> listaQuick = utils.quickSort(lista, 0, lista.size()-1); //devuelve la lista ordenada por quickSort
        

        
        String [] columnas = {"Clave", "Nombre", "Cantidad", "Precio"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0){
            public boolean isCellEditable(int row, int column) {
                return false; // la tabla NO se puede editar
            }
        };
        
        for (Producto p : listaQuick){
            Object[] fila = { p.getClave(),
                              p.getNombre(),
                              p.getCantidad(),
                              p.getPrecio()
                
            };
            model.addRow(fila);
        }
        return model;
    }
    /**
     * Metodo qeu devuelve un TableModel ordenado por MergeSort
     * @return 
     */
    public DefaultTableModel getProductosMergeSort(){
        LogaritmicosUtils<Producto> utils = new LogaritmicosUtils<>();
        List<Producto> lista = arbol.ordenarDatos(true);
        List<Producto> listaMerge = utils.mergeSort(lista);
        
        String [] columnas = {"Clave", "Nombre", "Cantidad", "Precio"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        for(Producto p: listaMerge){
            Object[] fila = { p.getClave(),
                              p.getNombre(),
                              p.getCantidad(),
                              p.getPrecio()
            };
            model.addRow(fila);
            
        }
        return model;
        
    }
    
    
    
}

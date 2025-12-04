/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import proyecto.utils.ProductosUtils;
import proyecto.inventario.InventarioManager;


import proyecto.pojo.Eliminacion;
import proyecto.pojo.Producto;

import javax.swing.SwingUtilities;  // Import faltante para SwingUtilities
import proyecto.interfaces.PrincipalView;

/**
 *
 * @author aleja
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
         new PrincipalView().setVisible(true);
         FlatMacDarkLaf.setup();

    }
    
}

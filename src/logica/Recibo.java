/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author davel
 */
public class Recibo {
   
    private String proveedor;
    private String producto;
    
    public Recibo(String proveedor, String producto) {
        
        this.proveedor = proveedor;
        this.producto = producto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
     public String fecha(){
        
        GregorianCalendar gc = new GregorianCalendar();
        int dia = gc.get(Calendar.DAY_OF_MONTH);
        int mes = gc.get(Calendar.MONTH);
        int anio = gc.get(Calendar.YEAR);
        return dia +" - " +mes +" - " +anio;
    
    }
        public String info(){
        
        
        return producto +" - " +proveedor +"-" +fecha();
    
    }
    
     
     
     @Override
    public String toString() {
        return "Recibo" + "\n proveedor= " + proveedor + "\n producto= " + producto + "\n Fecha de recibo: " +fecha() ;
    }
     
   
     
    

    
    
            
   
     
     
}

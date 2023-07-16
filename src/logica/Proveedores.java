/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package logica;

/**
 *
 * @author davel
 */
public enum Proveedores {
    PFIZER("PFIZER", "USA", 0.2, 40),
    MEDISUMI("MEDISUMI", "Alemania", 0.1, 30),
    MAGMA("MAGMA", "Colombia", 0.4, 80),
    ENFARMA("ENFARMA", "Peru", 0.3,50),
    GENECOM("GENECOM", "Argentina", 0.5, 20),
    BAXTER("BAXTER", "Ecuador", 0.0, 10),
    FARMABION("FARMABION", "Ecuador", 0.0,10);
        
    
    private String lugar;
    private String nombre;
    private double des;
    private int cantidad;

    private Proveedores(String nombre, String lugar, double des, int cantidad) {
        this.lugar = lugar;
        this.nombre = nombre;
        this.des = des;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public double getDes() {
        return des;
    }
    

    @Override
    public String toString() {
        return "Proveedores{" + "lugar=" + lugar + ", nombre=" + nombre + ", id=" + des + ", cantidad=" + cantidad + '}';
    }

}

package logica;

/**
 *
 * @author
 */
public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String proveedor;   
    private int cantidadVendida;

    public Producto(int id, String nombre, double precio, int stock, String proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    
    /**
     * Obtiene el valor de cantidadVendida
     *
     * @return el valor de cantidadVendida
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }
    
    /**
     * Obtiene el valor de proveedor
     *
     * @return el valor de proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Coloca el valor de proveedor
     *
     * @param proveedor new value of proveedor
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Obtiene el valor de stock
     *
     * @return el valor de stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Coloca el valor de stock
     *
     * @param stock new value of stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Obtiene el valor de precio
     *
     * @return el valor de precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Coloca el valor de precio
     *
     * @param precio new value of precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el valor de nombre
     *
     * @return el valor de nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Coloca el valor de nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el valor de id
     *
     * @return el valor de id
     */
    public int getId() {
        return id;
    }

    /**
     * Aumenta el stock del producto.
     *
     * @param cantidad
     * @return Mensaje de exito o de error.
     *
     */
    public String comprar(int cantidad) {
        String mensaje = "El valor no debe ser menor a 0";

        if (cantidad > 0) {
            // El += es equivalente a decir; stock = stock + cantidad
            this.stock += cantidad;
            mensaje = "Compra exitosa";
        }

        return mensaje;
    }

    public boolean vender(int cantidad) {
        boolean mensaje = false;
        if (this.stock >= cantidad) {
           
            this.stock  = stock - cantidad; 
            this.cantidadVendida = cantidadVendida+ cantidad;
            mensaje = true;
        }
        return mensaje;
    }

   

}

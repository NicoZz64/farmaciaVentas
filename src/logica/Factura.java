package logica;

import java.util.List;

public class Factura  {

    private String codigo;
    private Cliente cliente;
    private List<ProductoSolicitado> productos;
    // El final es utilizado para que la persona solo pueda utilizarlo una vez y no se puede cambiar
    private final double IVA;

    public Factura(String codigo, Cliente cliente, List<ProductoSolicitado> productos) {
        // colocamos el valor en IVA
          
        this.IVA = 1.12;
        this.codigo = codigo;
        this.cliente = cliente;
        this.productos = productos;
      
    }

    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ProductoSolicitado> getProductos() {
        return productos;
    }
    

    public double calcularSubtotal() {
        double precioTotal = 0 ;
        // Obtiene de la lista los productos y lo suma
        for (ProductoSolicitado p : productos) {
            precioTotal += p.calcularTotalVenta();
        }
        return precioTotal;
    }

    public double calcularTotal() {
        return this.calcularSubtotal() * IVA;
    }

}

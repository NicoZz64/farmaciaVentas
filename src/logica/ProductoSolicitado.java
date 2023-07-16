package logica;

public class ProductoSolicitado {

    private Producto producto;
    private int cantidad;

    public ProductoSolicitado(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void aumentarCantidad(int cant) {
        this.cantidad += cant;
    }

    public double calcularTotalVenta() {
        if (cantidad > 10) {
            return (this.producto.getPrecio() * this.cantidad) * 1.05;
        }
        if (cantidad>5&&cantidad < 8) {
            return (this.producto.getPrecio() * this.cantidad) * 1.10;
        }
        return this.producto.getPrecio() * cantidad;
    }

    public double calcularTotalCompra() {
        return this.producto.getPrecio() * this.cantidad;
    }

}

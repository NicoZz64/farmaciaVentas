package logica;

public class Cliente extends Persona {
    
    private String telefono;
    private String direccion;

    public Cliente(String cedula, String nombre, String telefono, String direccion) {
        super(cedula, nombre);
        this.telefono = telefono;
        this.direccion = direccion;
    }

    

    /**
     * Obtiene el valor de direccion
     *
     * @return el valor de direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Coloca el valor de direccion
     *
     * @param direccion nuevo valor de direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el valor de telefono
     *
     * @return el valor de telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Coloca el valor de telefono
     *
     * @param telefono nuevo valor de telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

}

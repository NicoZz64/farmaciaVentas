/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Cliente;
import logica.Factura;
import logica.Producto;
import logica.ProductoSolicitado;
import static pantallas.InterfazCliente.clientes;

public class InterfazVentas extends javax.swing.JFrame {

    int uy = 0;
    String producto;
    private List<Cliente> clientes = new ArrayList();
    private List<Producto> productos = new ArrayList();
   private List<String> ordenalmacenada = new ArrayList();
    private List<ProductoSolicitado> ordenDeCompra = new ArrayList();
    private List<Factura> facturas = new ArrayList();
    DefaultListModel<String> modeloLista = new DefaultListModel<>();
    DefaultListModel<String> modeloOrden = new DefaultListModel<>();

    DefaultTableModel modeloTabla = new DefaultTableModel();
    InterfazCliente p1 = new InterfazCliente();
    InterfazProducto p2 = new InterfazProducto();
    int h = 0;

    private void obtenerClientes() {
        //for (Cliente cc : p1.clientes) {
        //  clientes.add(cc);
        //}
        Cliente c;
        for (int i = 0; i < InterfazCliente.clientes.size(); i++)
        {
            c = (Cliente) InterfazCliente.clientes.get(i);
            clientes.add(c);
        }
    }

    private void obtenerProductos() {
        //for (Producto cc : p2.productos) {
        //  productos.add(cc);
        //}
        Producto p;
        for (int i = 0; i < InterfazProducto.productos.size(); i++)
        {
            p = (Producto) InterfazProducto.productos.get(i);
            productos.add(p);
        }
    }

    private void listar() {
        // Reinicia las filas
        modeloTabla.setRowCount(0);
        // Crea un objeto con el numero de columnas que esten iniciadas
        Object[] datos = new Object[tablita.getColumnCount()];

        // En este for mete los datos traidos del Arreglo clientes
        for (Factura f : facturas)
        {
            // En el caso de que el arreglo exista el producto se inserta en el Object datos
            if (f != null)
            {
                datos[0] = f.getCodigo();
                datos[1] = f.getCliente().getNombre();
                datos[2] = f.calcularSubtotal();
                datos[3] = f.calcularTotal();
                modeloTabla.addRow(datos);
            }
        }
        // Actualiza la tabla
        tablita.setModel(modeloTabla);
    }

    private void setModelo() {
        // Metemos los valores que queremos que aparezca en la tabla
        String[] cabeceraTabla
                =
                {
                    "Codigo Factura", "Cliente", "Subtotal", "Total"
                };
        // Actualizamos la cabecera
        modeloTabla.setColumnIdentifiers(cabeceraTabla);

        // Actualizamos la tabla
        tablita.setModel(modeloTabla);

    }

    private void mostrarProductoMasVendido() {

        String nombre = null;
        int ventaAlta = 0;
        for (Producto p1 : InterfazProducto.productos)
        {
            if (p1.getCantidadVendida() > ventaAlta)
            {
                ventaAlta = p1.getCantidadVendida();
                nombre = p1.getNombre();
            }
        }
        prv.setText(nombre);
    }

    private void mostrarDineroTotal() {
        
        double total = 0;
        for (Factura f : facturas)
        {
            total += f.calcularTotal();
        }

        totalR.setText(String.valueOf(total));
        
    }

    private void listarProducto() {
        Collections.sort(InterfazProducto.productos, (Producto p1, Producto p2) -> p1.getNombre().compareTo(p2.getNombre())
        );
        modeloLista.removeAllElements();

        for (Producto pro : InterfazProducto.productos)
        {
            modeloLista.addElement(pro.getNombre() + "    precio:" + pro.getPrecio() + " Cantidad disponible: " + pro.getStock());

        }
        productosLista.setModel(modeloLista);
    }

    private void listarOrden() {
        modeloOrden.clear();

        for (ProductoSolicitado o : ordenDeCompra)
        {

            modeloOrden.addElement(o.getProducto().getNombre() + "  Cant: " + o.getCantidad() + "   " + o.calcularTotalVenta());

            
        }
        orden.setModel(modeloOrden);
    }

    private void listarClientes() {
        Collections.sort(InterfazCliente.clientes, (Cliente c1, Cliente c2) -> c1.getNombre().compareTo(c2.getNombre())
        );
        comboClientes.removeAll();

        for (Cliente c : InterfazCliente.clientes)
        {
            comboClientes.addItem(c.getNombre());

        }
    }

    private void ingresarProductos() {

        InterfazProducto.productos.add(new Producto(1, "Ibuprofeno ", 0.12, 15, "MEDISUMI "));
        InterfazProducto.productos.add(new Producto(2, "Buprex ", 7, 13, "MAGMA "));
        InterfazProducto.productos.add(new Producto(3, "Paracetamol ", 0.36, 10, "MEDISUMI "));
        InterfazProducto.productos.add(new Producto(4, "Omeprazol ", 1, 10, "MAGMA "));
        InterfazProducto.productos.add(new Producto(5, "Simvastatina ", 7, 5, "DIEMPEC "));
        //InterfazProducto.productos.add(new Producto());

        int j = 0;
        for (Producto p : InterfazProducto.productos)
        {
            p.vender(j);
            j++;
        }
        l++;

    }

    private void ingresarClientes() {

        InterfazCliente.clientes.add(new Cliente("1752330212", "Wilfredo Tomar", "091299239", "Quito"));
        InterfazCliente.clientes.add(new Cliente("1752330121", "Alejandro Alvarado", "099129239", "Quito"));
        InterfazCliente.clientes.add(new Cliente("1752330432", "Mateo Armas", "099232322", "Guayaquil"));
        InterfazCliente.clientes.add(new Cliente("3234232346", "Xavier Gudiño", "979797979", "Guayaquil"));
        InterfazCliente.clientes.add(new Cliente("2342342344", "David Velasco", "099999999", "Riobamba"));
        InterfazCliente.clientes.add(new Cliente("1752342345", "Juan Espinel", "099999999", "Napo"));

    }

    int r = 0;
    int l = 0;
    int a = 0;
    int bu = 0;
    int s = 0;

    public InterfazVentas() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarProducto();
        listarClientes();

        obtenerProductos();
        obtenerClientes();

        setModelo();
        listar();

        mostrarDineroTotal();
        mostrarProductoMasVendido();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboClientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        reporte = new javax.swing.JTextPane();
        bttnFactura = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        orden = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        productosLista = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        bttnRetirarProducto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        prv = new javax.swing.JTextField();
        totalR = new javax.swing.JTextField();
        bttnAgregarCliente = new javax.swing.JButton();
        bttnPagar = new javax.swing.JButton();
        bttnAgregarProducto = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        subtotal = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        bttnOcultarCliente = new javax.swing.JButton();
        bttnOcultarProducto = new javax.swing.JButton();
        jBuEjemplo = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jScrollPane2.setViewportView(jTextPane1);

        jScrollPane1.setViewportView(jTextPane3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Ventas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(487, 487, 487)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        comboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija un Cliente" }));
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });

        jLabel2.setText("Cliente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        reporte.setEditable(false);
        jScrollPane3.setViewportView(reporte);

        bttnFactura.setText("Generar Factura");
        bttnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttnFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttnFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        orden.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden de Pago"));
        jScrollPane4.setViewportView(orden);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        productosLista.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));
        productosLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(productosLista);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Añadir a la Orden");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bttnRetirarProducto.setText("Retirar Producto");
        bttnRetirarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnRetirarProductoActionPerformed(evt);
            }
        });

        prv.setEditable(false);
        prv.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto Mas Vendido"));

        totalR.setEditable(false);
        totalR.setBorder(javax.swing.BorderFactory.createTitledBorder("Dinero Total Recaudado"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prv, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalR, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prv, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalR))
                .addContainerGap())
        );

        bttnAgregarCliente.setText("Agregar Cliente");
        bttnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAgregarClienteActionPerformed(evt);
            }
        });

        bttnPagar.setText("Pagar");
        bttnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPagarActionPerformed(evt);
            }
        });

        bttnAgregarProducto.setText("Agregar Producto");
        bttnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAgregarProductoActionPerformed(evt);
            }
        });

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo Factura", "Cliente", "Subtotal", "Total"
            }
        ));
        jScrollPane6.setViewportView(tablita);

        subtotal.setEditable(false);
        subtotal.setText(" ");
        subtotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Subtotal"));

        total.setEditable(false);
        total.setText("\n");
        total.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        bttnOcultarCliente.setText("Ocultar Cliente");
        bttnOcultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOcultarClienteActionPerformed(evt);
            }
        });

        bttnOcultarProducto.setText("Ocultar Producto");
        bttnOcultarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOcultarProductoActionPerformed(evt);
            }
        });

        jBuEjemplo.setText("Ejemplo");
        jBuEjemplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuEjemploActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bttnRetirarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBuEjemplo))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bttnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bttnOcultarCliente)
                                            .addComponent(bttnAgregarProducto)
                                            .addComponent(bttnOcultarProducto)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBuEjemplo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bttnAgregarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttnOcultarCliente)
                                .addGap(17, 17, 17)
                                .addComponent(bttnAgregarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttnOcultarProducto)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bttnPagar)
                                    .addComponent(bttnRetirarProducto))
                                .addGap(12, 12, 12)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientesActionPerformed

    private boolean existeProducto(Producto p) {
        for (ProductoSolicitado ps : ordenDeCompra)
        {
            if (ps.getProducto().getNombre().equals(p.getNombre()))
            {
                return true;
            }
        }

        return false;
    }

    private void mostrarCalculos() {
        double subtotalL = 0;
        for (ProductoSolicitado oc : ordenDeCompra)
        {
            subtotalL += oc.calcularTotalCompra();
        }
        subtotal.setText(String.valueOf(subtotalL));
        total.setText(String.valueOf(subtotalL * 1.12));

    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int index = productosLista.getSelectedIndex();
        if (index < 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un producto", "Producto no seleccionado", HEIGHT);
        } else if (existeProducto(productos.get(index)))
        {

            JOptionPane.showMessageDialog(rootPane, "Seleccione otro producto", "Producto duplicado", HEIGHT);

        } else
        {
            String cantidadProducto = JOptionPane.showInputDialog(rootPane, "Ingrese la cantidad", "Orden de Compra Producto", JOptionPane.INFORMATION_MESSAGE);

            if (cantidadProducto.matches("[+-]?\\d*(\\.\\d+)?"))
            {
                if (productos.get(index).vender(Integer.parseInt(cantidadProducto)))
                {
                    ordenDeCompra.add(new ProductoSolicitado(productos.get(index), Integer.parseInt(cantidadProducto)));
                    mostrarCalculos();
                } else
                {
                    JOptionPane.showMessageDialog(rootPane, "No hay stock suficiente", "Stock insuficiente", HEIGHT);

                }

            } else
            {
                JOptionPane.showMessageDialog(rootPane, "Ingrese una cantidad valida", "Cantidad invalida", HEIGHT);

            }

            listarOrden();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void bttnRetirarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnRetirarProductoActionPerformed
        // TODO add your handling code here:

        int quitar = orden.getSelectedIndex();
        if (quitar >= 0)
        {
            ordenDeCompra.remove(quitar);
            mostrarCalculos();
            listarOrden();
        } else
        {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un producto", "Producto no seleccionado", HEIGHT);
        }
    }//GEN-LAST:event_bttnRetirarProductoActionPerformed

    private void bttnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarProductoActionPerformed

        p2.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_bttnAgregarProductoActionPerformed

    private void bttnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPagarActionPerformed
        // TODO add your handling code here:
        int indexClientes = comboClientes.getSelectedIndex();
        if (indexClientes > -1)
        {
            System.out.println(ordenDeCompra.size());
            
           //ordenDeCompra
            facturas.add(new Factura("0P-" + h, InterfazCliente.clientes.get(indexClientes - 1),ordenDeCompra ));

            h++;
            listar();
            mostrarDineroTotal();
            listarOrden();
            //ordenDeCompra.clear();
        } else
        {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un cliente", "Cliente no seleccionado", HEIGHT);
        }
        listarProducto();
        orden.removeAll();
    }//GEN-LAST:event_bttnPagarActionPerformed

    private void bttnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnFacturaActionPerformed
        int indexFactura = tablita.getSelectedRow();
        System.out.println(indexFactura);
        for (ProductoSolicitado o : ordenDeCompra)
        {

            String producto = o.getProducto().getNombre();

        }

        String mensaje = "\t\t\t\t Factura\n";
        if (indexFactura >= 0)
        {
            Factura fa = facturas.get(indexFactura);
            mensaje += "------------------------------------------------------------------------------------------------------------------------------------------------\n";
            mensaje += "Cliente:\n";
            mensaje += "\tCedula:" + fa.getCliente().getCedula() + "\n";
            mensaje += "\tNombre:" + fa.getCliente().getNombre() + "\n";
            mensaje += "\tTelefono:" + fa.getCliente().getTelefono() + "\n";
            mensaje += "------------------------------------------------------------------------------------------------------------------------------------------------\n";
            mensaje += "Productos:\n";
            mensaje += "Tamaño:" + ordenDeCompra.size() + "\n";
            mensaje += "------------------------------------------------------------------------------------------------------------------------------------------------\n";
            for (ProductoSolicitado ps : ordenDeCompra)
            {
                mensaje += ps.getProducto().getNombre() + " - " + ps.getProducto().getPrecio() + "\n";
            }
            ordenDeCompra.clear();
            mensaje += "------------------------------------------------------------------------------------------------------------------------------------------------\n";
            mensaje += "------------------------------------------------------------------------------------------------------------------------------------------------\n";
            mensaje += "Subtotal: " + tablita.getValueAt(tablita.getSelectedRow(), 2).toString() + "\n";
            mensaje += "Total: " + tablita.getValueAt(tablita.getSelectedRow(), 3).toString() + "\n";
            reporte.setText(mensaje);
        } else
        {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una factura", "Factura no seleccionado", HEIGHT);
        }
    }//GEN-LAST:event_bttnFacturaActionPerformed

    private void bttnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarClienteActionPerformed
        InterfazCliente p = new InterfazCliente();
        p.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bttnAgregarClienteActionPerformed

    private void bttnOcultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOcultarClienteActionPerformed
        // TODO add your handling code here:
        InterfazCliente d = new InterfazCliente();
        d.setVisible(false);
    }//GEN-LAST:event_bttnOcultarClienteActionPerformed

    private void bttnOcultarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOcultarProductoActionPerformed
        // TODO add your handling code here:
        InterfazProducto v = new InterfazProducto();
        v.setVisible(false);
    }//GEN-LAST:event_bttnOcultarProductoActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void jBuEjemploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuEjemploActionPerformed
        // TODO add your handling code here:
        ingresarProductos();
        ingresarClientes();
        
        jBuEjemplo.setVisible(false);

    }//GEN-LAST:event_jBuEjemploActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(InterfazVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(InterfazVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(InterfazVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(InterfazVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregarCliente;
    private javax.swing.JButton bttnAgregarProducto;
    private javax.swing.JButton bttnFactura;
    private javax.swing.JButton bttnOcultarCliente;
    private javax.swing.JButton bttnOcultarProducto;
    private javax.swing.JButton bttnPagar;
    private javax.swing.JButton bttnRetirarProducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboClientes;
    private javax.swing.JButton jBuEjemplo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JList<String> orden;
    private javax.swing.JList<String> productosLista;
    private javax.swing.JTextField prv;
    private javax.swing.JTextPane reporte;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTable tablita;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalR;
    // End of variables declaration//GEN-END:variables
}

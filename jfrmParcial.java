
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 50242
 */
public class jfrmParcial extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(jfrmParcial.class.getName());

    private double credito;
    private int periodoMax, periodoMin;
    private double interesMin, interesMax;
    private double incremento;
    private double pagoMensual;
    private boolean tablaPagos;
    public jfrmParcial() {
        initComponents();
        this.setTitle(("Préstamo bancario"));
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        
        int tiposIntrs = 18; // número de filas no fijas
        int añosMeses = 4; // número de columnas no fijas
        
        jtfCredito.setText("6000");
        jtfPeriodoMax.setText("1");
        jtfPeriodoMin.setText("1");
        jtfInteresMax.setText("10.00");
        jtfInteresMin.setText("0.00");
        jcbIncremento.setSelectedIndex(2); // incremento
        
        initTable(tiposIntrs, añosMeses + 1);
        
    }
    
    private void initTable(final int filasTabla, final int colsTabla) {
        class CModeloTablaPrestamo extends javax.swing.table.AbstractTableModel {
            Object dato[][] = new Object[filasTabla][colsTabla];
            String cabecera[] = new String[colsTabla];
            boolean editColum[] = new boolean[colsTabla];

            CModeloTablaPrestamo() {
                for (int c = 0; c < colsTabla; ++c) {
                    // Texto inicial de las cabeceras de las columnas.
                    cabecera[c] = "Columna " + c;
                    // Hacer editables las columnas 1 a colsTabla-1
                    if (c != 0) editColum[c] = true;
                }
            }

            public int getColumnCount() { return cabecera.length; }
            public int getRowCount() { return dato.length; }
            public String getColumnName(int col) { return cabecera[col]; }

            public Object getValueAt(int fila, int col) {
                return dato[fila][col];
            }

            public void setValueAt(Object obj, int fila, int col) {
                dato[fila][col] = obj;
            }

            public boolean isCellEditable(int indFila, int indColum) {
                return editColum[indColum];
            }
        };

        // Crear un modelo de columnas para la tabla préstamo que ignore la primera columna.
        javax.swing.table.TableColumnModel modeloColums = new javax.swing.table.DefaultTableColumnModel() {
            boolean primeraCol = true;

            public void addColumn(javax.swing.table.TableColumn col) {
                // Ignorar la primera columna.
                if (primeraCol) { primeraCol = false; return; }
                col.setMinWidth(110);
                super.addColumn(col);
            }
        };

        // Crear un modelo de columnas para la tabla que hará de cabecera de las filas
        javax.swing.table.TableColumnModel modeloCabsFilas = new javax.swing.table.DefaultTableColumnModel() {
            boolean primeraCol = true;

            public void addColumn(javax.swing.table.TableColumn col) {
                if (primeraCol) {
                    col.setMaxWidth(70);
                    super.addColumn(col);
                    primeraCol = false;
                }
                
            }
        };

        // Crear el modelo de la tabla préstamo
        javax.swing.table.TableModel modeloTabla = new CModeloTablaPrestamo();

        // Crear la tabla préstamo con los modelos pasados como argumentos.
        jtablaPrestamo = new javax.swing.JTable(modeloTabla, modeloColums);

        // Crear la tabla cabecera de las filas.
        jtablaCabsFilas = new javax.swing.JTable(modeloTabla, modeloCabsFilas);

        // Crear las columnas
        jtablaPrestamo.createDefaultColumnsFromModel();
        jtablaCabsFilas.createDefaultColumnsFromModel();

        // Asegurar el sincronismo entre las dos tablas cuando se realicen selecciones
        jtablaPrestamo.setSelectionModel(jtablaCabsFilas.getSelectionModel());

        // Color gris para la cabecera de las filas y hacer la selección sobre la misma invisible.
        jtablaCabsFilas.setBackground(java.awt.Color.lightGray);
        jtablaCabsFilas.setSelectionBackground(java.awt.Color.lightGray);

        // Permitir barras de desplazamiento para ambas tablas
        jtablaPrestamo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtablaCabsFilas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        // Establecer la fuente Courier New
        jtablaPrestamo.setFont(new java.awt.Font("Courier New", 0, 12));
        jtablaCabsFilas.setFont(new java.awt.Font("Courier New", 0, 12));

        // Incluir la tabla préstamo en un panel de desplazamiento
        jScrollPane2.setViewportView(jtablaPrestamo);

        // Crear una vista que será utilizada para colocar la tabla cabecera de las filas
        javax.swing.JViewport jv = new javax.swing.JViewport();
        jv.setView(jtablaCabsFilas);
        jv.setPreferredSize(jtablaCabsFilas.getMaximumSize());
        jScrollPane2.setRowHeader(jv);
    }

    private StringBuffer AlinDer(String patrón, double dato) {
        java.text.FieldPosition fp = new java.text.FieldPosition(java.text.NumberFormat.FRACTION_FIELD);
        java.text.DecimalFormat formato = new java.text.DecimalFormat(patrón);
        StringBuffer salida = new StringBuffer();
        formato.format(dato, salida, fp);
        for (int i = 0; i < (patrón.length() - fp.getEndIndex()); i++) {
            salida.insert(0, ' ');
        }
        return salida;
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
        jtfCredito = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfPeriodoMax = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfPeriodoMin = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfInteresMax = new javax.swing.JTextField();
        jtfInteresMin = new javax.swing.JTextField();
        jcbIncremento = new javax.swing.JComboBox<>();
        jbtCalculoPagos = new javax.swing.JButton();
        jbtCalculoAmort = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtablaPrestamo = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnuOpciones = new javax.swing.JMenu();
        jmItemInstruc = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmItemSalir = new javax.swing.JMenuItem();
        jmnuPrestamoEn = new javax.swing.JMenu();
        jmItemAños = new javax.swing.JMenuItem();
        jmItemMeses = new javax.swing.JMenuItem();
        jmnuAyuda = new javax.swing.JMenu();
        jmItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Crédito:");

        jtfCredito.setBackground(new java.awt.Color(153, 153, 255));
        jtfCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Años del Prestamo"));

        jLabel2.setText("Máximo:");

        jtfPeriodoMax.setBackground(new java.awt.Color(255, 153, 153));
        jtfPeriodoMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Mínimo:");

        jtfPeriodoMin.setBackground(new java.awt.Color(255, 153, 153));
        jtfPeriodoMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPeriodoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPeriodoMin)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfPeriodoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfPeriodoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de interés"));

        jLabel4.setText("% máximo:");

        jLabel5.setText("% mínimo:");

        jLabel6.setText("Incremento:");

        jtfInteresMax.setBackground(new java.awt.Color(153, 255, 153));
        jtfInteresMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jtfInteresMin.setBackground(new java.awt.Color(153, 255, 153));
        jtfInteresMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jcbIncremento.setEditable(true);
        jcbIncremento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "0.10", "0.50", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfInteresMin))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfInteresMax)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfInteresMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtfInteresMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtCalculoPagos.setBackground(new java.awt.Color(204, 204, 255));
        jbtCalculoPagos.setText("Pagos");
        jbtCalculoPagos.addActionListener(this::jbtCalculoPagosActionPerformed);

        jbtCalculoAmort.setBackground(new java.awt.Color(204, 204, 255));
        jbtCalculoAmort.setText("Amortización");
        jbtCalculoAmort.addActionListener(this::jbtCalculoAmortActionPerformed);

        jtablaPrestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtablaPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablaPrestamoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtablaPrestamo);

        jLabel7.setText("Erick Ramirez IVD 24");

        jmnuOpciones.setMnemonic('O');
        jmnuOpciones.setText("Opciones");

        jmItemInstruc.setMnemonic('I');
        jmItemInstruc.setText("Instrucciones");
        jmItemInstruc.addActionListener(this::jmItemInstrucActionPerformed);
        jmnuOpciones.add(jmItemInstruc);
        jmnuOpciones.add(jSeparator1);

        jmItemSalir.setMnemonic('S');
        jmItemSalir.setText("Salir");
        jmItemSalir.addActionListener(this::jmItemSalirActionPerformed);
        jmnuOpciones.add(jmItemSalir);

        jMenuBar1.add(jmnuOpciones);

        jmnuPrestamoEn.setMnemonic('P');
        jmnuPrestamoEn.setText("Préstamo en...");

        jmItemAños.setMnemonic('A');
        jmItemAños.setText("Años");
        jmItemAños.addActionListener(this::jmItemAñosMesesActionPerformed);
        jmnuPrestamoEn.add(jmItemAños);

        jmItemMeses.setMnemonic('M');
        jmItemMeses.setText("Meses");
        jmItemMeses.addActionListener(this::jmItemAñosMesesActionPerformed);
        jmnuPrestamoEn.add(jmItemMeses);

        jMenuBar1.add(jmnuPrestamoEn);

        jmnuAyuda.setMnemonic('A');
        jmnuAyuda.setText("Ayuda");

        jmItemAcercaDe.setMnemonic('A');
        jmItemAcercaDe.setText("Acerca de Préstamo...");
        jmItemAcercaDe.addActionListener(this::jmItemAcercaDeActionPerformed);
        jmnuAyuda.add(jmItemAcercaDe);

        jMenuBar1.add(jmnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jbtCalculoPagos))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jbtCalculoAmort)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtCalculoPagos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCalculoAmort)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCalculoPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalculoPagosActionPerformed
        // TODO add your handling code here:
        try {
            // Actualizar las variables con los valores de los controles
            credito = Double.parseDouble(jtfCredito.getText());
            periodoMin = Integer.parseInt(jtfPeriodoMin.getText());
            periodoMax = Integer.parseInt(jtfPeriodoMax.getText());
            interesMin = Double.parseDouble(jtfInteresMin.getText());
            interesMax = Double.parseDouble(jtfInteresMax.getText());
            incremento = Double.parseDouble((String) jcbIncremento.getSelectedItem());

            // Comprobar que los datos son válidos
            if (credito <= 0 || periodoMin <= 0 || periodoMax <= 0 || periodoMax < periodoMin ||
                interesMin < 0 || interesMax < 0 || interesMax < interesMin) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Datos no válidos", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calcular el nº de tipos de interés y de períodos
        int tiposIntrs = (int) ((interesMax - interesMin) / incremento) + 1;
        int añosMeses = (periodoMax - periodoMin) + 1;

        // Tamaño mínimo de la tabla: los valores iniciales
        int filas = tiposIntrs, cols = añosMeses;
        if (tiposIntrs < 18) filas = 18;
        if (añosMeses < 4) cols = 4;

        // Crear la tabla
        initTable(filas, cols + 1);

        // Almacenar en la columna 0 los tipos de interés
        jtablaCabsFilas.setValueAt(AlinDer("##0.00", interesMin) + "%", 0, 0);
        for (int fila = 1; fila < tiposIntrs; ++fila) {
            jtablaCabsFilas.setValueAt(AlinDer("##0.00", interesMin + incremento * fila) + "%", fila, 0);
        }

        // Almacenar en la fila 0 las distintas duraciones del préstamo
        javax.swing.table.TableColumn colum = null;
        String per = " años";
        if (jmItemAños.isEnabled()) per = " meses";
        for (int columna = 0; columna < añosMeses; ++columna) {
            colum = jtablaPrestamo.getColumnModel().getColumn(columna);
            colum.setHeaderValue((periodoMin + columna) + per);
        }

        // Los períodos ¿en qué vienen dados? ¿En años o en meses?
        int P = 0;
        if (!jmItemAños.isEnabled()) {
            P = 12; // son años
        } else {
            P = 1;  // son meses
        }

        // Calcular pagos
        double interes = 0.0, pagoMensual = 0.0;
        int meses;
        for (int fila = 0; fila < tiposIntrs; ++fila) {
            // Obtener el tipo de interés de la fila actual
            String sinteres = jtablaCabsFilas.getValueAt(fila, 0).toString();
            sinteres = sinteres.substring(0, sinteres.indexOf('%'));
            sinteres = sinteres.replace(',', '.');
            interes = Double.parseDouble(sinteres) / 100 / 12;

            // Calcular los pagos para este tipo de interés
            for (int columna = 0; columna < añosMeses; ++columna) {
                // Obtener la duración del préstamo
                colum = jtablaPrestamo.getColumnModel().getColumn(columna);
                String smeses = (String) colum.getHeaderValue();
                smeses = smeses.substring(0, smeses.indexOf(' '));
                meses = Integer.parseInt(smeses) * P;

                // Calcular la cantidad a pagar mensualmente
                if (interes == 0.0) {
                    pagoMensual = credito / meses;
                } else {
                    pagoMensual = credito * (interes / (1 - (1 / (Math.pow(1.0 + interes, (double) meses)))));
                }

                // Ponerla en la tabla (se redondea a dos decimales)
                jtablaPrestamo.setValueAt(AlinDer("###,###,##0.00", pagoMensual), fila, columna);
            }
        }
        tablaPagos = true;
    
    }//GEN-LAST:event_jbtCalculoPagosActionPerformed

    private void jtablaPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaPrestamoMouseClicked
        // TODO add your handling code here:
        Object datoCelda = jtablaPrestamo.getValueAt(
                jtablaPrestamo.getSelectedRow(),
                jtablaPrestamo.getSelectedColumn());

        if (datoCelda != null && tablaPagos) {
            // Pasar el número a formato de US necesario para parseDouble
            StringBuffer s = new StringBuffer(datoCelda.toString());
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') s.delete(i, i + 1);
                if (s.charAt(i) == ',') s.setCharAt(i, '.');
            }
            // Convertir a double
            pagoMensual = Double.parseDouble(s.toString());
            jbtCalculoAmort.setEnabled(true);
        }
    }//GEN-LAST:event_jtablaPrestamoMouseClicked

    private void jbtCalculoAmortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalculoAmortActionPerformed
        // TODO add your handling code here:
        // Obtener el tipo de interés correspondiente a la celda seleccionada
        int fila = jtablaPrestamo.getSelectedRow();
        int columna = jtablaPrestamo.getSelectedColumn();

        String sinteres = (String) jtablaCabsFilas.getValueAt(fila, 0);
        sinteres = sinteres.substring(0, sinteres.indexOf('%'));
        sinteres = sinteres.replace(',', '.');
        double interes = Double.parseDouble(sinteres) / 100 / 12;

        // Obtener el período correspondiente a la celda seleccionada
        int P = 0;
        if (!jmItemAños.isEnabled()) {
            P = 12; // son años
        } else {
            P = 1;  // son meses
        }

        javax.swing.table.TableColumn colum = null;
        colum = jtablaPrestamo.getColumnModel().getColumn(columna);
        String smeses = (String) colum.getHeaderValue();
        smeses = smeses.substring(0, smeses.indexOf(' '));
        int meses = Integer.parseInt(smeses) * P;

        int filas = meses, cols = 5;
        if (filas < 18) filas = 18;

        // Crear la tabla
        initTable(filas, cols);

        // Almacenar/mostrar en la columna 0 los meses
        for (int mes = 0; mes < meses; ++mes) {
            jtablaCabsFilas.setValueAt(AlinDer("#####", mes + 1), mes, 0);
        }

        // Almacenar en la fila 0 las distintas cabeceras
        String cab[] = {"Capital", "Intereses", "Capital pendiente", "Total intereses"};
        for (columna = 0; columna < 4; ++columna) {
            colum = jtablaPrestamo.getColumnModel().getColumn(columna);
            colum.setHeaderValue(cab[columna]);
        }

        // Calcular y mostrar la tabla de amortización.
        double interesesMensuales = 0, creditoPendiente = credito;
        double capitalMensualAmort = 0, totalIntereses = 0;
        String formato = "###,###,##0.00";

        for (int mes = 0; mes < meses; ++mes) {
            // Cálculo de los interés a pagar en el mes actual
            interesesMensuales = creditoPendiente * interes;
            // Cálculo del capital en el mes actual
            capitalMensualAmort = pagoMensual - interesesMensuales;
            // Cálculo del capital pendiente de pagar
            creditoPendiente -= pagoMensual - interesesMensuales;
            // Cálculo de los intereses totales pagados
            totalIntereses += interesesMensuales;

            // Capital mensual amortizado
            jtablaPrestamo.setValueAt(AlinDer(formato, capitalMensualAmort), mes, 0);
            // Intereses mensuales amortizados
            jtablaPrestamo.setValueAt(AlinDer(formato, interesesMensuales), mes, 1);
            // Capital pendiente después de este pago
            jtablaPrestamo.setValueAt(AlinDer(formato, creditoPendiente), mes, 2);
            // Total intereses abonados después de este pago
            jtablaPrestamo.setValueAt(AlinDer(formato, totalIntereses), mes, 3);
        }

        jbtCalculoAmort.setEnabled(false);
        tablaPagos = false;
    
    }//GEN-LAST:event_jbtCalculoAmortActionPerformed

    private void jmItemInstrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemInstrucActionPerformed
        // TODO add your handling code here:
        String mensaje;
        mensaje = "Introduzca el crédito, la duración del préstamo y el tipo\n";
        mensaje += "de interés. Pulse el botón [Pagos] para visualizar\n";
        mensaje += "los pagos mensuales en la rejilla.\n\n";
        mensaje += "Elija un pago mensual y pulse el botón [Amortización]\n";
        mensaje += "para visualizar el plan de amortización para el interés\n";
        mensaje += "y períodos correspondientes al pago elegido.\n\n";
        mensaje += "Para copiar datos en el portapapeles, seleccione las celdas\n";
        mensaje += "que desee y pulse las teclas Ctrl+c.\n";

        javax.swing.JOptionPane.showMessageDialog(
                null, mensaje, "Instrucciones",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
    }//GEN-LAST:event_jmItemInstrucActionPerformed

    private void jmItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAcercaDeActionPerformed
        // TODO add your handling code here:
        String erick;
        erick = "Aplicación Préstamo. Versión 1.0\n";
        erick += "Copyright () Pablo Alejandro Galindo Arias\n";
        erick+= "Clave:15\nIV Bachillerato E";
        JOptionPane.showMessageDialog(
                null, erick, "Aplicación",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmItemAcercaDeActionPerformed

    private void jmItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jmItemSalirActionPerformed

    private void jmItemAñosMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAñosMesesActionPerformed
        // TODO add your handling code here:
    Object item = evt.getSource();
    String tituloMarco = "";

    if (item == jmItemAños) {
        jmItemAños.setEnabled(false);
        jmItemMeses.setEnabled(true);
        tituloMarco = "Años del préstamo";
    } else if (item == jmItemMeses) {
        jmItemAños.setEnabled(true);
        jmItemMeses.setEnabled(false);
        tituloMarco = "Meses del préstamo";
    }

    jPanel1.setBorder(new javax.swing.border.TitledBorder(tituloMarco));
    }//GEN-LAST:event_jmItemAñosMesesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new jfrmParcial().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton jbtCalculoAmort;
    private javax.swing.JButton jbtCalculoPagos;
    private javax.swing.JComboBox<String> jcbIncremento;
    private javax.swing.JMenuItem jmItemAcercaDe;
    private javax.swing.JMenuItem jmItemAños;
    private javax.swing.JMenuItem jmItemInstruc;
    private javax.swing.JMenuItem jmItemMeses;
    private javax.swing.JMenuItem jmItemSalir;
    private javax.swing.JMenu jmnuAyuda;
    private javax.swing.JMenu jmnuOpciones;
    private javax.swing.JMenu jmnuPrestamoEn;
    private javax.swing.JTable jtablaPrestamo;
    private javax.swing.JTextField jtfCredito;
    private javax.swing.JTextField jtfInteresMax;
    private javax.swing.JTextField jtfInteresMin;
    private javax.swing.JTextField jtfPeriodoMax;
    private javax.swing.JTextField jtfPeriodoMin;
    // End of variables declaration//GEN-END:variables
private javax.swing.JTable jtablaCabsFilas;
}

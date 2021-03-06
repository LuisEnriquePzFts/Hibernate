package Vista;
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.List;
import modelo.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;



public class Alumno extends javax.swing.JFrame {

    public Alumno() {
        initComponents();
    }
    
    public void limpiar() {
        this.txtNomAlu.setText("");
        this.txtCveAlu.setText("");
        this.txtCveAluBus.setText("");
        this.cmbCveGru.setSelectedIndex(0);
        this.jsEdaAlu.getModel().setValue(18);
    }
    
        public void insertarAlumnos() {
        String cveAlu;
        String nomAlu;
        String edaAlu;
        String cveGru;

        cveAlu = txtCveAlu.getText();
        nomAlu = txtNomAlu.getText();
        edaAlu=jsEdaAlu.getValue().toString();
        // edaAlu = Integer.parseInt(jsEdaAlu.getValue().toString());
        cveGru = (String) cmbCveGru.getSelectedItem();

        modelo.Alumno alumno = new modelo.Alumno(cveAlu, nomAlu, edaAlu, cveGru);

        modelo.Operaciones operacion = new modelo.Operaciones();
        operacion.guardarAlumno(alumno);
        JOptionPane.showMessageDialog(null, "Se guardo a:" + " '" + cveAlu + "' " + " Con el nombre: " + " '" + nomAlu + "' ", "Insercion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        limpiar();
        listarAlumnos();
    }
    
    private void initComboGrupo() {
        ComboBoxModel modelo = new DefaultComboBoxModel();
        cmbCveGru.setModel(modelo);
        cmbCveGru.addItem("Seleccione un Grupo");

        modelo.Operaciones operacion = new modelo.Operaciones();
        List datos = operacion.cargarCombo();
        Iterator it = datos.iterator();

        while (it.hasNext()) {
            modelo.Grupo g = (modelo.Grupo) it.next();
            this.cmbCveGru.addItem(g.getCveGru());
        }
    }
    
    public void listarAlumnos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tblAlumnos.setModel(modelo);

            modelo.addColumn("Clave");
            modelo.addColumn("Nombre");
            modelo.addColumn("Edad");
            modelo.addColumn("Grupo");

            modelo.Operaciones operacion = new modelo.Operaciones();
            List datos = operacion.ListaAlumno();
            Iterator it = datos.iterator();

            if (datos.size() > 0) {
                while (it.hasNext()) {
                    modelo.Alumno a = (modelo.Alumno) it.next();

                    Object[] fila = new Object[4];

                    fila[0] = a.getCveAlu();
                    fila[1] = a.getNomAlu();
                    fila[2] = a.getEdaAlu();
                    fila[3] = a.getCveGru();

                    modelo.addRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe ningún alumno agregado");
            }
        } catch (Exception e) {
      }
    }

    
    public void modificarAlumnos() {
        String cveAlu;
        String edaAlu;
        String cveGru;
        String nomAlu;

        cveAlu = txtCveAlu.getText();

        nomAlu = txtNomAlu.getText();
        edaAlu=jsEdaAlu.getValue().toString();
        cveGru = (String) cmbCveGru.getSelectedItem();

        modelo.Operaciones operacion = new modelo.Operaciones();
        modelo.Alumno alumno = null;
        alumno = operacion.obtenerAlumno(cveAlu);

        alumno.setNomAlu(nomAlu);
        alumno.setEdaAlu(edaAlu);
        alumno.setCveAlu(cveAlu);
        alumno.setCveGru(cveGru);
        operacion.actualizarAlumno(alumno);

        JOptionPane.showMessageDialog(null, "Se actualizo a:" + cveAlu + " Con el nombre: " + nomAlu, "Actualizacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarAlumnos();
        btn_Insertar.setEnabled(true);
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
        txtCveAlu.setEnabled(true);
    }
    
        public void buscarAlumnos() {
        String cveAlu;
        cveAlu = txtCveAluBus.getText();
        modelo.Operaciones operacion = new modelo.Operaciones();
        modelo.Alumno alumno = null;
        alumno = operacion.obtenerAlumno(cveAlu);

        txtCveAluBus.setText(alumno.getCveAlu());
        txtCveAlu.setText(alumno.getCveAlu());
        txtNomAlu.setText(alumno.getNomAlu());
        cmbCveGru.setSelectedItem(alumno.getCveGru());
        jsEdaAlu.getModel().setValue(alumno.getEdaAlu());
        txtCveAluBus.setText("");

        btn_Insertar.setEnabled(false);
        btn_Eliminar.setEnabled(true);
        btn_Modificar.setEnabled(true);
        txtCveAlu.setEnabled(false);
    }
        
       public void eliminarAlumnos() {
        JOptionPane.showMessageDialog(null, "¿Seguro que quiere borrar este Alumnos?", "Advertencia", JOptionPane.WARNING_MESSAGE);
        String cveAlu;
        cveAlu = txtCveAlu.getText();
        modelo.Operaciones operacion = new modelo.Operaciones();
        modelo.Alumno alumno = null;
        alumno = operacion.obtenerAlumno(cveAlu);
        operacion.eliminarAlumno(alumno);
        JOptionPane.showMessageDialog(null, "Se elimino a: " + cveAlu, "Eliminacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarAlumnos();
        btn_Insertar.setEnabled(true);
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
        txtCveAlu.setEnabled(true);
    }

    @SuppressWarnings("unchecked")                                         

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCveGru = new javax.swing.JComboBox<String>();
        jsEdaAlu = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCveAluBus = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNomAlu = new javax.swing.JTextPane();
        btn_Buscar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Insertar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCveAlu = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLAVE EXISTENTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EDAD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GRUPO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        cmbCveGru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCveGru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCveGruActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCveGru, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 250, 20));
        getContentPane().add(jsEdaAlu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 50, 20));

        jScrollPane1.setViewportView(txtCveAluBus);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, -1));

        jScrollPane2.setViewportView(txtNomAlu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, -1));

        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        btn_Eliminar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Eliminar.setText("ELIMINAR");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        btn_Insertar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Insertar.setText("AGREGAR");
        btn_Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        btn_Modificar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Modificar.setText("MODIFICAR");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Edad", "Grupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblAlumnos);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 340, 110));

        jButton5.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        jButton6.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jButton6.setText("REGRESAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Perpetua", 1, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText(" AGREGAR ALUMNO  ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 390, 50));

        jScrollPane5.setViewportView(txtCveAlu);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 250, -1));

        jLabel8.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CLAVE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iMAGENES/fondoo.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCveGruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCveGruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCveGruActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
     
            try {
            boolean banClave = true;

            if (!txtCveAlu.getText().isEmpty()) {
                if (txtCveAlu.getText().length() != 5) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 5 carácteres");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacío");
                banClave = false;
            }
            if (banClave) {
              eliminarAlumnos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }  
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        Menu menu=new Menu();
        menu.setVisible(true);
        this.dispose();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed

        try {
            boolean banClave = true;

            if (! !txtCveAluBus.getText().isEmpty()) {
                if (txtCveAluBus.getText().length() != 5) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 5 carácteres");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacío");
                banClave = false;
            }
            if (banClave) {
                buscarAlumnos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
        
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        
        try {
            boolean banClave = true;
            boolean banNombre = true;
            boolean banEdad = true;
            Integer cveGru = cmbCveGru.getSelectedIndex();
            Integer edaAlu;
            edaAlu= Integer.parseInt(jsEdaAlu.getValue().toString());
            

        if (cveGru==0) {
            JOptionPane.showMessageDialog(this, "Debes de Seleccionar un Grupo");
            banClave = false;
        }
        if (txtCveAlu.getText().length() != 5) {
            JOptionPane.showMessageDialog(this, "La clave del alumno debe tener 5 carácteres");
            banClave = false;
        }

        if (!txtNomAlu.getText().isEmpty()) {
            if (!txtNomAlu.getText().matches("^[A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(this, "El nombre no debe de tener números");
                banNombre = false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío");
            banNombre = false;
        }
        if (edaAlu < 17 || edaAlu > 99) {
            JOptionPane.showMessageDialog(this, "La edad debe estar entre 17 y 99");
            banEdad = false;
        }
        if (banClave && banNombre && banEdad) {
            modificarAlumnos();
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertarActionPerformed

        try {
            boolean banClave = true;
            boolean banNombre = true;
            boolean banEdad = true;
            Integer cveGru = cmbCveGru.getSelectedIndex();
            Integer edaAlu;
            edaAlu= Integer.parseInt(jsEdaAlu.getValue().toString());
            
            if (cveGru==0) {
            JOptionPane.showMessageDialog(this, "Debes de Seleccionar un Grupo");
            banClave = false;
        }
        if (txtCveAlu.getText().length() != 5) {
            JOptionPane.showMessageDialog(this, "La clave del alumno debe tener 5 carácteres");
            banClave = false;
        }

        if (!txtNomAlu.getText().isEmpty()) {
            if (!txtNomAlu.getText().matches("^[A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(this, "El nombre no debe de tener números");
                banNombre = false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío");
            banNombre = false;
        }
        if (edaAlu < 17 || edaAlu > 99) {
            JOptionPane.showMessageDialog(this, "La edad debe estar entre 17 y 99");
            banEdad = false;
        }
        if (banClave && banNombre && banEdad) {
            insertarAlumnos();
        }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_InsertarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Insertar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JComboBox<String> cmbCveGru;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner jsEdaAlu;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextPane txtCveAlu;
    private javax.swing.JTextPane txtCveAluBus;
    private javax.swing.JTextPane txtNomAlu;
    // End of variables declaration//GEN-END:variables
}

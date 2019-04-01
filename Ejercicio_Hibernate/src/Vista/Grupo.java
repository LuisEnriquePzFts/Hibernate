package Vista;

import java.util.Iterator;
import java.util.List;
import modelo.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;

public class Grupo extends javax.swing.JFrame {

    public Grupo() {
        initComponents();
        setLocationRelativeTo(null);
        listarGrupos();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }
    
        public void limpiar() {
        this.txtNomGru.setText("");
        this.txt_CveGru.setText("");
    }
    
    public void listarGrupos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tblGrupos.setModel(modelo);

            modelo.addColumn("Clave");
            modelo.addColumn("Nombre");

            Operaciones operacion = new Operaciones();
            List datos = operacion.ListaGrupo();
            Iterator it = datos.iterator();

            if (datos.size() > 0) {
                while (it.hasNext()) {
                    modelo.Grupo g = (modelo.Grupo) it.next();

                    Object[] fila = new Object[2];

                    fila[0] = g.getCveGru();
                    fila[1] = g.getNomGru();

                    modelo.addRow(fila);
                }
            }else {
                JOptionPane.showMessageDialog(this, "No existe ningún grupo agregado");
            }

        } catch (Exception e) {
    }
}
        
    public void modificarGrupos() {
       String cveGru;

        cveGru = txt_CveGru.getText();
        txtCveGru.setEnabled(true);
        Operaciones operacion = new Operaciones();
        modelo.Grupo grupo = null;
        grupo = operacion.obtenerGrupo(cveGru);

        String nomGru;

        nomGru = txtNomGru.getText();

        grupo.setNomGru(nomGru);
        operacion.actualizarGrupo(grupo);
        JOptionPane.showMessageDialog(null, "Se actualizo a:" + cveGru + " Con el nombre: " + nomGru, "Actualizacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarGrupos();
        btnInsertar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }
            
    public void eliminarGrupos() {
        JOptionPane.showMessageDialog(null, "¿Seguro que quiere borrar este Grupo?", "Advertencia", JOptionPane.WARNING_MESSAGE);
        txtCveGru.setEnabled(true);
        String cveGru;
        cveGru = txt_CveGru.getText();
        Operaciones operacion = new Operaciones();
        modelo.Grupo grupo = null;
        grupo = operacion.obtenerGrupo(cveGru);
        operacion.eliminarGrupo(grupo);
        JOptionPane.showMessageDialog(null, "Se elimino a:" + cveGru, "Eliminacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarGrupos();
        btnInsertar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }
            
    public void insertarGrupos() {
        String cveGru;
        String nomGru;

        cveGru = txt_CveGru.getText();
        nomGru = txtNomGru.getText();

        modelo.Grupo grupo = new modelo.Grupo(cveGru, nomGru);

        Operaciones operacion = new Operaciones();
        operacion.guardarGrupo(grupo);
        JOptionPane.showMessageDialog(null, "Se guardo a:" + " '" + cveGru + "' " + " Con el nombre: " + " '" + nomGru + "' ", "Insercion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        txt_CveGru.setText("");
        txtNomGru.setText("");

        limpiar();
        listarGrupos();
    }

    public void buscarGrupos() {
        String cveGru;
        cveGru = txtCveGruBus.getText();
        txtCveGru.setEnabled(false);
        Operaciones operacion = new Operaciones();
        modelo.Grupo grupo = null;
        grupo = operacion.obtenerGrupo(cveGru);

        txtCveGruBus.setText(grupo.getCveGru());
        txt_CveGru.setText(grupo.getCveGru());
        txtNomGru.setText(grupo.getNomGru());
        txtCveGruBus.setText("");

        btnInsertar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCveGru = new javax.swing.JScrollPane();
        txt_CveGru = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNomGru = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCveGruBus = new javax.swing.JTextPane();
        btnBuscar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGrupos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_Salir = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GRUPO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CLAVE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText(" AGREGAR GRUPO  ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtCveGru.setViewportView(txt_CveGru);

        getContentPane().add(txtCveGru, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));

        jScrollPane3.setViewportView(txtNomGru);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 220, -1));

        jScrollPane4.setViewportView(txtCveGruBus);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 140, -1));

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        btnInsertar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btnInsertar.setText("AGREGAR");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        btnModificar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        tblGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblGrupos);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 320, 110));

        btnEliminar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        btn_Salir.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Salir.setText("SALIR");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        btn_Regresar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Regresar.setText("REGRESAR");
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iMAGENES/fondoo.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed

                try {
            boolean banClave = true;
            boolean banNombre = true;

            if (!txt_CveGru.getText().isEmpty()) {
                if (txt_CveGru.getText().length() != 9) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 9 carácteres");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacío");
                banClave = false;
            }

            if (!txtNomGru.getText().isEmpty()) {
                if (!txtNomGru.getText().matches("^[A-Za-z ]*$")) {
                    JOptionPane.showMessageDialog(this, "El nombre no debe de tener números");
                    banNombre = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío");
                banNombre = false;
            }
            if (banClave && banNombre) {
                insertarGrupos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());

        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
try {
            boolean banClave = true;

            if (!txtCveGruBus.getText().isEmpty()) {
                if (txtCveGruBus.getText().length() != 9) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 9 carácteres");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacío");
                banClave = false;
            }
            if (banClave) {
                buscarGrupos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

                try {
            boolean banClave = true;
            boolean banNombre = true;

            if (!txt_CveGru.getText().isEmpty()) {
                if (txt_CveGru.getText().length() != 9) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 9 carácteres");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacío");
                banClave = false;
            }

            if (!txtNomGru.getText().isEmpty()) {
                if (!txtNomGru.getText().matches("^[A-Za-z ]*$")) {
                    JOptionPane.showMessageDialog(this, "El nombre no debe de tener números");
                    banNombre = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío");
                banNombre = false;
            }
            if (banClave && banNombre) {
                modificarGrupos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());

        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       try {
            boolean banClave = true;

            if (!txt_CveGru.getText().isEmpty()) {
                if (txt_CveGru.getText().length() != 9) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 9 carácteres");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacío");
                banClave = false;
            }
            if (banClave) {
              eliminarGrupos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed

        Menu men=new Menu();
        men.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_RegresarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_SalirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tblGrupos;
    private javax.swing.JScrollPane txtCveGru;
    private javax.swing.JTextPane txtCveGruBus;
    private javax.swing.JTextPane txtNomGru;
    private javax.swing.JTextPane txt_CveGru;
    // End of variables declaration//GEN-END:variables
}

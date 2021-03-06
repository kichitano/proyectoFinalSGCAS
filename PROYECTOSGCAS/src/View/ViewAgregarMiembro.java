/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerUsuario;
import Controller.ControllerUsuarioProyecto;
import Model.Proyecto;
import Model.Usuario;
import Model.Usuarioproyecto;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Christian
 */
public class ViewAgregarMiembro extends javax.swing.JDialog {

    /**
     * Creates new form ViewAgregarMiembro2
     */
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    ControllerUsuarioProyecto controllerUsuarioProyecto = new ControllerUsuarioProyecto();
    Proyecto proyecto;
    Usuarioproyecto usuarioproyecto;
    List<Usuario> listaUsuario;
    List<Usuarioproyecto> listaUsuarioproyecto;
    DefaultTableModel defaultTableModel;
    TableRowSorter<TableModel> rowSorter;
    
    public ViewAgregarMiembro(java.awt.Frame parent, boolean modal, Proyecto proyecto, List<Usuario> listaUsuario) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        controlUsuarioListar();
        this.proyecto = proyecto;
        this.listaUsuario = listaUsuario;        
        this.defaultTableModel = (DefaultTableModel) tbllistaMiembros.getModel();
        tbllistaMiembros.getTableHeader().setReorderingAllowed(false);        
        controlUsuarioProyectoListar();
    }

    ViewAgregarMiembro(Object object, boolean b) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxProyectoMiembro = new RSMaterialComponent.RSComboBoxMaterial();
        cbxMiembroEstado = new RSMaterialComponent.RSComboBoxMaterial();
        cbxMiembroRol = new RSMaterialComponent.RSComboBoxMaterial();
        txtBuscarMiembro = new RSMaterialComponent.RSTextFieldMaterial();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbllistaMiembros = new rojerusan.RSTableMetro1();
        btnAgregarMiembro = new rojeru_san.rsbutton.RSButtonGradiente();
        btnEditarMiembro = new rojeru_san.rsbutton.RSButtonGradiente();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Miembro");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 40));

        cbxProyectoMiembro.setForeground(new java.awt.Color(0, 0, 51));
        cbxProyectoMiembro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Miembro" }));
        cbxProyectoMiembro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbxProyectoMiembro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxProyectoMiembroFocusGained(evt);
            }
        });
        jPanel1.add(cbxProyectoMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, -1));

        cbxMiembroEstado.setForeground(new java.awt.Color(0, 0, 51));
        cbxMiembroEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estado", "Activo", "Inactivo" }));
        cbxMiembroEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxMiembroEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 120, -1));

        cbxMiembroRol.setForeground(new java.awt.Color(0, 0, 51));
        cbxMiembroRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Roles", "Analista", "Diseñador", "Programador", "Calidad", "Pruebas", "Configuracion", "Usuario Experto" }));
        cbxMiembroRol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxMiembroRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 150, -1));

        txtBuscarMiembro.setForeground(new java.awt.Color(0, 0, 51));
        txtBuscarMiembro.setPlaceholder("Ingrese texto a buscar...");
        txtBuscarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarMiembroActionPerformed(evt);
            }
        });
        txtBuscarMiembro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarMiembroKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscarMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 490, 40));

        tbllistaMiembros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre de Miembro", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbllistaMiembros.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tbllistaMiembros.setName(""); // NOI18N
        jScrollPane3.setViewportView(tbllistaMiembros);
        if (tbllistaMiembros.getColumnModel().getColumnCount() > 0) {
            tbllistaMiembros.getColumnModel().getColumn(0).setMinWidth(65);
            tbllistaMiembros.getColumnModel().getColumn(0).setPreferredWidth(65);
            tbllistaMiembros.getColumnModel().getColumn(0).setMaxWidth(65);
            tbllistaMiembros.getColumnModel().getColumn(1).setMinWidth(250);
            tbllistaMiembros.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbllistaMiembros.getColumnModel().getColumn(1).setMaxWidth(250);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 490, 260));

        btnAgregarMiembro.setText("Agregar");
        btnAgregarMiembro.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnAgregarMiembro.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMiembroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 120, 40));

        btnEditarMiembro.setText("Editar");
        btnEditarMiembro.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnEditarMiembro.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnEditarMiembro.setEnabled(false);
        btnEditarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMiembroActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProyectoMiembroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxProyectoMiembroFocusGained
        cbxProyectoMiembro.setSelectedItem("");
    }//GEN-LAST:event_cbxProyectoMiembroFocusGained

    private void txtBuscarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarMiembroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMiembroActionPerformed

    private void txtBuscarMiembroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMiembroKeyReleased
        String busquedaUsuario = txtBuscarMiembro.getText();
        if (busquedaUsuario.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + busquedaUsuario));
        }
    }//GEN-LAST:event_txtBuscarMiembroKeyReleased

    private void btnAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMiembroActionPerformed
        try {                                                  
            try {
                usuarioproyecto = new Usuarioproyecto(0, cbxMiembroEstado.getSelectedIndex(), cbxMiembroRol.getSelectedIndex());
                usuarioproyecto.setPROYECTOproId(proyecto);
                usuarioproyecto.setUSUARIOusuId(listaUsuario.get(cbxProyectoMiembro.getSelectedIndex()-1));
                controlUsuarioProyectoGuardar(usuarioproyecto);
                JOptionPane.showMessageDialog(jPanel1, "Operación realizada con éxito.","Entregable",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(ViewAgregarMiembro.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al realizar la operación solicitada.","Proyecto", JOptionPane.WARNING_MESSAGE);
            }
            cbxMiembroEstado.setSelectedIndex(0);
            cbxMiembroRol.setSelectedIndex(0);
            cbxProyectoMiembro.setSelectedIndex(0);
            controlUsuarioProyectoListar();
        } catch (SQLException ex) {
            Logger.getLogger(ViewAgregarMiembro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarMiembroActionPerformed

    private void btnEditarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMiembroActionPerformed
        /*switch (btnEditarMiembro.getText()) {
            case "Cancelar":
            txtFaseNombre.setEnabled(false);
            cbxFaseEstado.setEnabled(false);
            btnAgregarFase.setText("Nuevo");
            btnEditarMiembro.setText("Editar");
            txtBuscarFase.setEnabled(true);
            tbllistaFase.setEnabled(true);
            tbllistaFase.clearSelection();
            txtBuscarEntregable.setEnabled(false);
            txtEntregableNombre.setEnabled(true);
            txtEntregableNombre.setText("");
            btnAgregarMiembro.setEnabled(true);
            btnQuitarEntregable.setEnabled(true);
            break;
            case "Editar":
            btnEditarMiembro.setText("Guardar");
            btnAgregarFase.setText("Cancelar");
            tbllistaFase.setEnabled(false);
            btnEditarMiembro.setEnabled(true);
            txtFaseNombre.setEnabled(true);
            cbxFaseEstado.setEnabled(true);
            break;
            case "Guardar":
            metodologia.setMetNombre(txtFaseNombre.getText());
            metodologia.setMetEstado(cbxFaseEstado.getSelectedIndex());
            tbllistaFase.setEnabled(true);
            try {
                fase.setFasNombre(txtFaseNombre.getText());
                fase.setFasEstado(cbxFaseEstado.getSelectedIndex());
                fase.setMETODOLOGIAmetId(metodologia);
                controlFaseEditar(fase);
                JOptionPane.showMessageDialog(jPanel1, "Operación realizada con éxito.","Fase",JOptionPane.INFORMATION_MESSAGE);
                controlFaseListar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar la operación solicitada.","Fase", JOptionPane.WARNING_MESSAGE);
            }
            txtFaseNombre.setEnabled(false);
            cbxFaseEstado.setEnabled(false);
            btnAgregarFase.setText("Nuevo");
            btnEditarMiembro.setText("Editar");
            txtFaseNombre.setText("");
            cbxFaseEstado.setSelectedIndex(0);
            break;
            default:
            break;
        }*/

    }//GEN-LAST:event_btnEditarMiembroActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAgregarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAgregarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAgregarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAgregarMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewAgregarMiembro dialog = new ViewAgregarMiembro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonGradiente btnAgregarMiembro;
    private rojeru_san.rsbutton.RSButtonGradiente btnEditarMiembro;
    private RSMaterialComponent.RSComboBoxMaterial cbxMiembroEstado;
    private RSMaterialComponent.RSComboBoxMaterial cbxMiembroRol;
    private RSMaterialComponent.RSComboBoxMaterial cbxProyectoMiembro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private rojerusan.RSTableMetro1 tbllistaMiembros;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscarMiembro;
    // End of variables declaration//GEN-END:variables

    private void controlUsuarioListar() throws SQLException {
        listaUsuario = controllerUsuario.controlUsuarioListar();
        for(int i = 0; i < listaUsuario.size(); i++){
            cbxProyectoMiembro.addItem(listaUsuario.get(i).getUsuNombres() + " " + listaUsuario.get(i).getUsuApellidos());
        }        
    }

    private void controlUsuarioProyectoGuardar(Usuarioproyecto usuarioproyecto) throws SQLException {
        controllerUsuarioProyecto.controlUsuarioProyectoGuardar(usuarioproyecto);
    }

    private void controlUsuarioProyectoListar() throws SQLException {
        defaultTableModel.getDataVector().removeAllElements();
        listaUsuarioproyecto = controllerUsuarioProyecto.controlProyectoListar(proyecto);
        rowSorter = new TableRowSorter<>(tbllistaMiembros.getModel());
        tbllistaMiembros.setRowSorter(rowSorter);
        for(int i = 0; i < listaUsuarioproyecto.size(); i++){
            for(int j = 0; j < listaUsuario.size(); j++){
                if(Objects.equals(listaUsuario.get(j).getUsuId(), listaUsuarioproyecto.get(i).getUSUARIOusuId().getUsuId())){
                    listaUsuarioproyecto.get(i).setUSUARIOusuId(listaUsuario.get(j));
                    break;
                }
            }           
            defaultTableModel.addRow(new Object[]{
                listaUsuarioproyecto.get(i).getUsuProyectoId(),
                listaUsuarioproyecto.get(i).getUSUARIOusuId().getUsuNombres() + " " + listaUsuarioproyecto.get(i).getUSUARIOusuId().getUsuApellidos(),
                cbxMiembroRol.getItemAt(listaUsuarioproyecto.get(i).getUsuProyectoCargo()),
                cbxMiembroEstado.getItemAt(listaUsuarioproyecto.get(i).getUsuProyectoEstado())                
            });
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerUsuario;
import Model.Usuario;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class ViewpnlUsuario extends javax.swing.JPanel {

    /**
     * Creates new form pnlUsuario
     */
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    Usuario usuario;
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date fechaRegistro = java.sql.Date.valueOf(LocalDate.now());
    DefaultTableModel defaultTableModel;
    List<Usuario> listaUsuario;
    TableRowSorter<TableModel> rowSorter;
    
    public ViewpnlUsuario() throws SQLException {
        initComponents();
        this.defaultTableModel = (DefaultTableModel) tbllistaUsuario.getModel();
        tbllistaUsuario.getColumnModel().getColumn(0).setMinWidth(0);
        tbllistaUsuario.getColumnModel().getColumn(0).setMaxWidth(0);
        tbllistaUsuario.getTableHeader().setReorderingAllowed(false);
        controlUsuarioListar();
        tbllistaUsuario.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {  
                    usuario = new Usuario();                    
                    insertarUsuarioFormulario();
                }
            }      
        });
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
        jLabel8 = new javax.swing.JLabel();
        txtUsuarioCorreo = new RSMaterialComponent.RSTextFieldMaterial();
        txtUsuarioDNI = new RSMaterialComponent.RSTextFieldMaterial();
        txtUsuarioApellidos = new RSMaterialComponent.RSTextFieldMaterial();
        txtUsuarioNombres = new RSMaterialComponent.RSTextFieldMaterial();
        txtUsuarioNombreUsuario = new RSMaterialComponent.RSTextFieldMaterial();
        cbxUsuarioEstado = new RSMaterialComponent.RSComboBoxMaterial();
        cbxUsuarioNivel = new RSMaterialComponent.RSComboBoxMaterial();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllistaUsuario = new rojerusan.RSTableMetro1();
        btnAgregarUsuario = new rojeru_san.rsbutton.RSButtonGradiente();
        btnEditarUsuario = new rojeru_san.rsbutton.RSButtonGradiente();
        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jLabel2 = new javax.swing.JLabel();
        txtUsuarioContrasena = new RSMaterialComponent.RSPasswordMaterial();
        lblUsuarioFecha = new javax.swing.JLabel();
        txtBuscarUsuario = new RSMaterialComponent.RSTextFieldMaterial();

        setPreferredSize(new java.awt.Dimension(1060, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Gestionar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 300, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 112, 192));
        jLabel8.setText("Fecha:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, 70, 30));

        txtUsuarioCorreo.setForeground(new java.awt.Color(0, 0, 51));
        txtUsuarioCorreo.setEnabled(false);
        txtUsuarioCorreo.setPlaceholder("Correo Electrónico");
        jPanel1.add(txtUsuarioCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 240, -1));

        txtUsuarioDNI.setForeground(new java.awt.Color(0, 0, 51));
        txtUsuarioDNI.setEnabled(false);
        txtUsuarioDNI.setPlaceholder("DNI");
        jPanel1.add(txtUsuarioDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 150, -1));

        txtUsuarioApellidos.setForeground(new java.awt.Color(0, 0, 51));
        txtUsuarioApellidos.setEnabled(false);
        txtUsuarioApellidos.setPlaceholder("Apellidos");
        jPanel1.add(txtUsuarioApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 280, -1));

        txtUsuarioNombres.setForeground(new java.awt.Color(0, 0, 51));
        txtUsuarioNombres.setEnabled(false);
        txtUsuarioNombres.setPlaceholder("Nombres");
        jPanel1.add(txtUsuarioNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 240, -1));

        txtUsuarioNombreUsuario.setForeground(new java.awt.Color(0, 0, 51));
        txtUsuarioNombreUsuario.setEnabled(false);
        txtUsuarioNombreUsuario.setPlaceholder("Usuario");
        jPanel1.add(txtUsuarioNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 240, -1));

        cbxUsuarioEstado.setForeground(new java.awt.Color(0, 0, 51));
        cbxUsuarioEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estado", "Activo", "Inactivo" }));
        cbxUsuarioEstado.setEnabled(false);
        cbxUsuarioEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxUsuarioEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 150, -1));

        cbxUsuarioNivel.setForeground(new java.awt.Color(0, 0, 51));
        cbxUsuarioNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nivel", "Administrador", "Usuario" }));
        cbxUsuarioNivel.setEnabled(false);
        cbxUsuarioNivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxUsuarioNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 150, -1));

        tbllistaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "usuID", "DNI", "Nombres", "Apellidos", "Correo", "Nivel", "Usuario", "Fecha Registro", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbllistaUsuario.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tbllistaUsuario.setName(""); // NOI18N
        jScrollPane2.setViewportView(tbllistaUsuario);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 1020, 150));

        btnAgregarUsuario.setText("Nuevo");
        btnAgregarUsuario.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnAgregarUsuario.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, 150, -1));

        btnEditarUsuario.setText("Editar");
        btnEditarUsuario.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnEditarUsuario.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnEditarUsuario.setEnabled(false);
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 150, -1));

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Información del usuario");
        rSPanelMaterial1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 26, -1, -1));

        txtUsuarioContrasena.setForeground(new java.awt.Color(0, 0, 51));
        txtUsuarioContrasena.setEnabled(false);
        txtUsuarioContrasena.setPlaceholder("Contraseña");
        rSPanelMaterial1.add(txtUsuarioContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        lblUsuarioFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuarioFecha.setForeground(new java.awt.Color(0, 0, 51));
        rSPanelMaterial1.add(lblUsuarioFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 147, 100, 30));

        jPanel1.add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 1020, 280));

        txtBuscarUsuario.setForeground(new java.awt.Color(0, 0, 51));
        txtBuscarUsuario.setPlaceholder("Ingrese texto a buscar...");
        txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 1020, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        if(btnAgregarUsuario.getText().equals("Nuevo")){
            btnAgregarUsuario.setText("Agregar");
            btnEditarUsuario.setText("Cancelar");            
            txtBuscarUsuario.setEnabled(false);
            tbllistaUsuario.setEnabled(false);   
            tbllistaUsuario.clearSelection();
            fechaRegistro = java.sql.Date.valueOf(LocalDate.now());
            lblUsuarioFecha.setText(fechaRegistro.toString());
            habilitarControles();
            limpiarControles();
        }else if(btnAgregarUsuario.getText().equals(("Agregar"))){
            try{    
                usuario = new Usuario(
                0, 
                txtUsuarioDNI.getText(), 
                txtUsuarioNombres.getText(), 
                txtUsuarioApellidos.getText(), 
                txtUsuarioCorreo.getText(), 
                cbxUsuarioNivel.getSelectedIndex(), 
                txtUsuarioNombreUsuario.getText(), 
                String.valueOf(txtUsuarioContrasena.getPassword()), 
                fechaRegistro, 
                cbxUsuarioEstado.getSelectedIndex());
                controlUsuarioGuardar(usuario);
                JOptionPane.showMessageDialog(jPanel1, "Operación realizada con éxito.","Usuario",JOptionPane.INFORMATION_MESSAGE);
                lblUsuarioFecha.setText("");
                controlUsuarioListar();                
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "Error al realizar la operación solicitada.","Usuario", JOptionPane.WARNING_MESSAGE);
            }             
            deshabilitarControles();
        }else if(btnAgregarUsuario.getText().equals("Cancelar")){
            deshabilitarControles();
            insertarUsuarioFormulario();
            tbllistaUsuario.setEnabled(true);
        }
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        if(btnEditarUsuario.getText().equals("Cancelar")){
            deshabilitarControles();
        }else if(btnEditarUsuario.getText().equals("Editar")){
            btnEditarUsuario.setText("Guardar");
            btnAgregarUsuario.setText("Cancelar");
            tbllistaUsuario.setEnabled(false);
            habilitarControles();
        }else if(btnEditarUsuario.getText().equals("Guardar")){            
            usuario.setUsuDNI(txtUsuarioDNI.getText());
            usuario.setUsuNombres(txtUsuarioNombres.getText());
            usuario.setUsuApellidos(txtUsuarioApellidos.getText()); 
            usuario.setUsuCorreo(txtUsuarioCorreo.getText()); 
            usuario.setUsuNivel(cbxUsuarioNivel.getSelectedIndex());
            usuario.setUsuNombreUsuario(txtUsuarioNombreUsuario.getText());
            usuario.setUsuContrasena(String.valueOf(txtUsuarioContrasena.getPassword()));
            usuario.setUsuEstado(cbxUsuarioEstado.getSelectedIndex());
            tbllistaUsuario.setEnabled(true);
            try {
                controlUsuarioEditar(usuario);
                JOptionPane.showMessageDialog(jPanel1, "Operación realizada con éxito.","Usuario",JOptionPane.INFORMATION_MESSAGE);
                controlUsuarioListar();
                limpiarControles();
                deshabilitarControles();                
                txtUsuarioContrasena.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar la operación solicitada.","Usuario", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void txtBuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioKeyReleased
        String busquedaUsuario = txtBuscarUsuario.getText();
        if (busquedaUsuario.trim().length() == 0) {
           rowSorter.setRowFilter(null);
        } else {
           rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + busquedaUsuario));
        }
    }//GEN-LAST:event_txtBuscarUsuarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonGradiente btnAgregarUsuario;
    private rojeru_san.rsbutton.RSButtonGradiente btnEditarUsuario;
    private RSMaterialComponent.RSComboBoxMaterial cbxUsuarioEstado;
    private RSMaterialComponent.RSComboBoxMaterial cbxUsuarioNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUsuarioFecha;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private rojerusan.RSTableMetro1 tbllistaUsuario;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscarUsuario;
    private RSMaterialComponent.RSTextFieldMaterial txtUsuarioApellidos;
    private RSMaterialComponent.RSPasswordMaterial txtUsuarioContrasena;
    private RSMaterialComponent.RSTextFieldMaterial txtUsuarioCorreo;
    private RSMaterialComponent.RSTextFieldMaterial txtUsuarioDNI;
    private RSMaterialComponent.RSTextFieldMaterial txtUsuarioNombreUsuario;
    private RSMaterialComponent.RSTextFieldMaterial txtUsuarioNombres;
    // End of variables declaration//GEN-END:variables

    private void habilitarControles(){
        btnEditarUsuario.setEnabled(true);        
        txtUsuarioDNI.setEnabled(true);
        txtUsuarioNombres.setEnabled(true);
        txtUsuarioApellidos.setEnabled(true);
        txtUsuarioCorreo.setEnabled(true);
        cbxUsuarioNivel.setEnabled(true);
        txtUsuarioNombreUsuario.setEnabled(true);
        txtUsuarioContrasena.setEnabled(true);        
        cbxUsuarioEstado.setEnabled(true);               
    }
    
    private void deshabilitarControles(){
        btnAgregarUsuario.setText("Nuevo");
        btnEditarUsuario.setText("Editar");
        btnEditarUsuario.setEnabled(false);
        txtUsuarioDNI.setEnabled(false);
        txtUsuarioNombres.setEnabled(false);
        txtUsuarioApellidos.setEnabled(false);
        txtUsuarioCorreo.setEnabled(false);
        cbxUsuarioNivel.setEnabled(false);
        txtUsuarioNombreUsuario.setEnabled(false);
        txtUsuarioContrasena.setEnabled(false);
        cbxUsuarioEstado.setEnabled(false);
        txtBuscarUsuario.setEnabled(true);
        tbllistaUsuario.setEnabled(true); 
    }
    
    public void limpiarControles(){
        txtUsuarioDNI.setText("");
        txtUsuarioNombres.setText("");
        txtUsuarioApellidos.setText("");
        txtUsuarioCorreo.setText("");
        cbxUsuarioNivel.setSelectedIndex(0);
        txtUsuarioNombreUsuario.setText("");
        txtUsuarioContrasena.setText("");
        cbxUsuarioEstado.setSelectedIndex(0);
    }
    
    private void insertarUsuarioFormulario() {
        usuario.setUsuId((Integer) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 0));
        usuario.setUsuDNI((String) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 1));
        txtUsuarioDNI.setText(usuario.getUsuDNI());
        usuario.setUsuNombres((String) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 2));
        txtUsuarioNombres.setText(usuario.getUsuNombres());
        usuario.setUsuApellidos((String) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 3));
        txtUsuarioApellidos.setText(usuario.getUsuApellidos());
        usuario.setUsuCorreo((String) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 4));
        txtUsuarioCorreo.setText(usuario.getUsuCorreo());        
        cbxUsuarioNivel.setSelectedItem((String) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 5));
        usuario.setUsuNivel(cbxUsuarioNivel.getSelectedIndex());        
        usuario.setUsuNombreUsuario((String) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 6));
        txtUsuarioNombreUsuario.setText(usuario.getUsuNombreUsuario());
        //CONTROL DE CONTRASEÑA        
        usuario.setUsuFechaRegistro((Date) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 7));
        lblUsuarioFecha.setText(usuario.getUsuFechaRegistro().toString());        
        cbxUsuarioEstado.setSelectedItem((String) tbllistaUsuario.getValueAt(tbllistaUsuario.getSelectedRow(), 8));        
        usuario.setUsuEstado(cbxUsuarioEstado.getSelectedIndex());
        btnEditarUsuario.setEnabled(true);
    }
    
    private void controlUsuarioGuardar(Usuario usuario) throws SQLException {
        controllerUsuario.controlUsuarioGuardar(usuario);
    }

    private void controlUsuarioListar() throws SQLException {
        defaultTableModel.getDataVector().removeAllElements();
        listaUsuario = controllerUsuario.controlUsuarioListar();
        rowSorter = new TableRowSorter<>(tbllistaUsuario.getModel());
        tbllistaUsuario.setRowSorter(rowSorter);
        for(int i = 0; i < listaUsuario.size(); i++){
            defaultTableModel.addRow(new Object[]{
                listaUsuario.get(i).getUsuId(),
                listaUsuario.get(i).getUsuDNI(),
                listaUsuario.get(i).getUsuNombres(),
                listaUsuario.get(i).getUsuApellidos(),
                listaUsuario.get(i).getUsuCorreo(),
                cbxUsuarioNivel.getItemAt(listaUsuario.get(i).getUsuNivel()),
                listaUsuario.get(i).getUsuNombreUsuario(),
                listaUsuario.get(i).getUsuFechaRegistro(),
                cbxUsuarioEstado.getItemAt(listaUsuario.get(i).getUsuEstado())
            });
        }        
    }

    private void controlUsuarioEditar(Usuario usuario) throws SQLException {
        controllerUsuario.controlUsuarioEditar(usuario);
    }
}

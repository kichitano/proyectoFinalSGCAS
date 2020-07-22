/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerMetodologia;
import Model.Metodologia;
import java.awt.Dialog;
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
public class ViewpnlMetodologia extends javax.swing.JPanel {

    /**
     * Creates new form pnlMetodologia
     */
    ControllerMetodologia controllerMetodologia = new ControllerMetodologia();
    Metodologia metodologia;
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date fechaRegistro = java.sql.Date.valueOf(LocalDate.now());
    DefaultTableModel defaultTableModel;
    TableRowSorter<TableModel> rowSorter;
    List<Metodologia> listaMetodologia;
        
    public ViewpnlMetodologia() throws SQLException {
        initComponents();
        this.defaultTableModel = (DefaultTableModel) tbllistaMetodologia.getModel();
        tbllistaMetodologia.getTableHeader().setReorderingAllowed(false);
        controlMetodologiaListar();
        tbllistaMetodologia.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {  
                    metodologia = new Metodologia();                    
                    insertarMetodologiaFormulario();
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
        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMetodologiaFecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMetodologiaCodigo = new javax.swing.JLabel();
        txtMetodologiaNombre = new RSMaterialComponent.RSTextFieldMaterial();
        cbxMetodologiaEstado = new RSMaterialComponent.RSComboBoxMaterial();
        btnAgregarMetodologia = new rojeru_san.rsbutton.RSButtonGradiente();
        btnEditarMetodologia = new rojeru_san.rsbutton.RSButtonGradiente();
        btnMetodologiaFase = new rojeru_san.rsbutton.RSButtonGradiente();
        txtBuscarMetodologia = new RSMaterialComponent.RSTextFieldMaterial();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllistaMetodologia = new rojerusan.RSTableMetro1();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Gestionar Metodologia");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 360, 40));

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Información de Metodología");
        rSPanelMaterial1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 26, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 112, 192));
        jLabel8.setText("Fecha:");
        rSPanelMaterial1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 50, 30));

        lblMetodologiaFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMetodologiaFecha.setForeground(new java.awt.Color(0, 0, 51));
        rSPanelMaterial1.add(lblMetodologiaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 270, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 112, 192));
        jLabel9.setText("Codigo:");
        rSPanelMaterial1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 40));

        lblMetodologiaCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMetodologiaCodigo.setForeground(new java.awt.Color(0, 0, 51));
        rSPanelMaterial1.add(lblMetodologiaCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, 40));

        txtMetodologiaNombre.setForeground(new java.awt.Color(0, 0, 51));
        txtMetodologiaNombre.setEnabled(false);
        txtMetodologiaNombre.setPlaceholder("Nombre");
        rSPanelMaterial1.add(txtMetodologiaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 330, 40));

        cbxMetodologiaEstado.setForeground(new java.awt.Color(0, 0, 51));
        cbxMetodologiaEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estado", "Activo", "Inactivo" }));
        cbxMetodologiaEstado.setEnabled(false);
        cbxMetodologiaEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rSPanelMaterial1.add(cbxMetodologiaEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 180, -1));

        btnAgregarMetodologia.setText("Nuevo");
        btnAgregarMetodologia.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnAgregarMetodologia.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnAgregarMetodologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMetodologiaActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(btnAgregarMetodologia, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 170, 35));

        btnEditarMetodologia.setText("Editar");
        btnEditarMetodologia.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnEditarMetodologia.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnEditarMetodologia.setEnabled(false);
        btnEditarMetodologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMetodologiaActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(btnEditarMetodologia, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 118, 170, 35));

        btnMetodologiaFase.setText("Fases");
        btnMetodologiaFase.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnMetodologiaFase.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnMetodologiaFase.setEnabled(false);
        btnMetodologiaFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMetodologiaFaseActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(btnMetodologiaFase, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 170, 83));

        jPanel1.add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 1020, 180));

        txtBuscarMetodologia.setForeground(new java.awt.Color(0, 0, 51));
        txtBuscarMetodologia.setPlaceholder("Ingrese texto a buscar...");
        txtBuscarMetodologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarMetodologiaActionPerformed(evt);
            }
        });
        txtBuscarMetodologia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarMetodologiaKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscarMetodologia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 1020, -1));

        tbllistaMetodologia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre de Metodologia", "Fecha Registro", "Estado"
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
        tbllistaMetodologia.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tbllistaMetodologia.setName(""); // NOI18N
        jScrollPane2.setViewportView(tbllistaMetodologia);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 1020, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarMetodologiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMetodologiaKeyReleased
        String busquedaUsuario = txtBuscarMetodologia.getText();
        if (busquedaUsuario.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + busquedaUsuario));
        }
    }//GEN-LAST:event_txtBuscarMetodologiaKeyReleased

    private void btnAgregarMetodologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMetodologiaActionPerformed
        switch (btnAgregarMetodologia.getText()) {
            case "Nuevo":                
                limpiarControles();
                habilitarControles();
                btnAgregarMetodologia.setText("Agregar");
                btnEditarMetodologia.setText("Cancelar");
                txtBuscarMetodologia.setEnabled(false);
                tbllistaMetodologia.setEnabled(false);
                tbllistaMetodologia.clearSelection();
                fechaRegistro = java.sql.Date.valueOf(LocalDate.now());
                lblMetodologiaFecha.setText(fechaRegistro.toString());                
                break;
            case "Agregar":
                try{
                    metodologia = new Metodologia(
                            0,
                            txtMetodologiaNombre.getText(),
                            fechaRegistro,
                            cbxMetodologiaEstado.getSelectedIndex());
                    controlMetodologiaGuardar(metodologia);
                    JOptionPane.showMessageDialog(jPanel1, "Operación realizada con éxito.","Metodologia",JOptionPane.INFORMATION_MESSAGE);
                    lblMetodologiaCodigo.setText("");
                    lblMetodologiaFecha.setText("");
                    controlMetodologiaListar();
                    txtBuscarMetodologia.setEnabled(true);
                }catch(HeadlessException | SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al realizar la operación solicitada.","Metodologia", JOptionPane.WARNING_MESSAGE);
                    deshabilitarControles();
                }   break;
            case "Cancelar":
                deshabilitarControles();
                insertarMetodologiaFormulario();
                tbllistaMetodologia.setEnabled(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnAgregarMetodologiaActionPerformed

    private void btnEditarMetodologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMetodologiaActionPerformed
        switch (btnEditarMetodologia.getText()) {
            case "Cancelar":
                deshabilitarControles();
                limpiarControles();
                tbllistaMetodologia.setEnabled(true);
                break;
            case "Editar":
                btnEditarMetodologia.setText("Guardar");
                btnAgregarMetodologia.setText("Cancelar");
                tbllistaMetodologia.setEnabled(false);
                habilitarControles();
                break;
            case "Guardar":                
                metodologia.setMetNombre(txtMetodologiaNombre.getText());
                metodologia.setMetEstado(cbxMetodologiaEstado.getSelectedIndex());
                tbllistaMetodologia.setEnabled(true);
                try {
                    controlMetodologiaEditar(metodologia);
                    JOptionPane.showMessageDialog(jPanel1, "Operación realizada con éxito.","Metodologia",JOptionPane.INFORMATION_MESSAGE);
                    controlMetodologiaListar();
                    limpiarControles();
                    deshabilitarControles();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al realizar la operación solicitada.","Metodologia", JOptionPane.WARNING_MESSAGE);
                }   break;
            default:
                break;
        }
    }//GEN-LAST:event_btnEditarMetodologiaActionPerformed

    private void btnMetodologiaFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMetodologiaFaseActionPerformed
        if(!(txtMetodologiaNombre.getText().equals(""))){
            try {
                ViewAgregarFase viewAgregarFase = new ViewAgregarFase(null, true, metodologia);
                viewAgregarFase.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ViewpnlMetodologia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_btnMetodologiaFaseActionPerformed

    private void txtBuscarMetodologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarMetodologiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMetodologiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonGradiente btnAgregarMetodologia;
    private rojeru_san.rsbutton.RSButtonGradiente btnEditarMetodologia;
    private rojeru_san.rsbutton.RSButtonGradiente btnMetodologiaFase;
    private RSMaterialComponent.RSComboBoxMaterial cbxMetodologiaEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMetodologiaCodigo;
    private javax.swing.JLabel lblMetodologiaFecha;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private rojerusan.RSTableMetro1 tbllistaMetodologia;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscarMetodologia;
    private RSMaterialComponent.RSTextFieldMaterial txtMetodologiaNombre;
    // End of variables declaration//GEN-END:variables

    private void habilitarControles(){
        btnEditarMetodologia.setEnabled(true); 
        btnMetodologiaFase.setEnabled(true);
        txtMetodologiaNombre.setEnabled(true);
        cbxMetodologiaEstado.setEnabled(true);           
    }
    
    private void deshabilitarControles(){
        btnAgregarMetodologia.setText("Nuevo");
        btnEditarMetodologia.setText("Editar");
        btnEditarMetodologia.setEnabled(false);
        btnMetodologiaFase.setEnabled(false);
        txtMetodologiaNombre.setEnabled(false);
        cbxMetodologiaEstado.setEnabled(false);
    }
    
    public void limpiarControles(){
        txtMetodologiaNombre.setText("");
        lblMetodologiaCodigo.setText("");
        lblMetodologiaFecha.setText("");
        cbxMetodologiaEstado.setSelectedIndex(0);
    }
    
    private void insertarMetodologiaFormulario() {
        metodologia.setMetId((Integer) tbllistaMetodologia.getValueAt(tbllistaMetodologia.getSelectedRow(), 0));
        lblMetodologiaCodigo.setText(metodologia.getMetId().toString());
        metodologia.setMetNombre((String) tbllistaMetodologia.getValueAt(tbllistaMetodologia.getSelectedRow(), 1));
        txtMetodologiaNombre.setText(metodologia.getMetNombre());
        metodologia.setMetFechaRegistro((Date) tbllistaMetodologia.getValueAt(tbllistaMetodologia.getSelectedRow(), 2));
        lblMetodologiaFecha.setText(metodologia.getMetFechaRegistro().toString());        
        cbxMetodologiaEstado.setSelectedItem((String) tbllistaMetodologia.getValueAt(tbllistaMetodologia.getSelectedRow(), 3));        
        metodologia.setMetEstado(cbxMetodologiaEstado.getSelectedIndex());
        btnEditarMetodologia.setEnabled(true);
    }
    
    private void controlMetodologiaGuardar(Metodologia metodologia) throws SQLException {
        controllerMetodologia.controlMetodologiaGuardar(metodologia);
    }
    
    private void controlMetodologiaEditar(Metodologia metodologia) throws SQLException {
        controllerMetodologia.controlMetodologiaEditar(metodologia);
    }
    
    private void controlMetodologiaListar() throws SQLException {
        defaultTableModel.getDataVector().removeAllElements();
        listaMetodologia = controllerMetodologia.controlMetodologiaListar();
        rowSorter = new TableRowSorter<>(tbllistaMetodologia.getModel());
        tbllistaMetodologia.setRowSorter(rowSorter);
        for(int i = 0; i < listaMetodologia.size(); i++){
            defaultTableModel.addRow(new Object[]{
                listaMetodologia.get(i).getMetId(),
                listaMetodologia.get(i).getMetNombre(),
                listaMetodologia.get(i).getMetFechaRegistro(),
                cbxMetodologiaEstado.getItemAt(listaMetodologia.get(i).getMetEstado())
            });
        }        
    }      

}

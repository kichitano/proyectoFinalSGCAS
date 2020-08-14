/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerDetalleEntregable;
import Controller.ControllerEntregable;
import Controller.ControllerFase;
import Controller.ControllerUsuarioProyecto;
import Model.Detalleentregable;
import Model.Entregable;
import Model.Fase;
import Model.Proyecto;
import Model.Usuario;
import Model.Usuarioproyecto;
import com.github.lgooddatepicker.tableeditors.DateTableEditor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Christian
 */
public class ViewEntregableProyecto extends javax.swing.JDialog implements TableModelListener {

    ControllerUsuarioProyecto controllerUsuarioProyecto = new ControllerUsuarioProyecto();
    ControllerFase controllerFase = new ControllerFase();
    ControllerEntregable controllerEntregable = new ControllerEntregable();
    ControllerDetalleEntregable controllerDetalleEntregable = new ControllerDetalleEntregable();
    List<Entregable> listaEntregables;
    List<Fase> listaFases;
    List<Usuarioproyecto> listaUsuario;
    List<Detalleentregable> listaDetalleEntregable;
    Detalleentregable detalleentregable;
    Proyecto proyecto;
    Proyecto proyectodetalle;
    Entregable entregable;
    Entregable entregabledetalle;
    Usuario usuario;
    Usuarioproyecto usuarioproyecto;
    DefaultTableModel defaultTableModelentregableRelacion;
    int faseID;
    int entregableID;
    String[] roles = {"Roles","Analista","Diseñador","Programador","Calidad","Pruebas","Configuracion","Usuario Experto"};
    String[] datosMiembro;
    int idMiembro;
    /**
     * Creates new form ViewEntregableRelacion
     */
    public ViewEntregableProyecto(java.awt.Frame parent, boolean modal, Proyecto proyecto) throws SQLException {
        super(parent, modal);
        initComponents();
        this.proyecto = proyecto;        
        setLocationRelativeTo(null);        
        defaultTableModelentregableRelacion = (DefaultTableModel)tbllistaEntregable.getModel();        
        tbllistaEntregable.setModel(defaultTableModelentregableRelacion);        
        tbllistaEntregable.setRowSelectionAllowed(false);
        listaDetalleEntregable = new ArrayList<>();        
        cargarFases();             
        tbllistaEntregable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                if(table.getSelectedColumn() == 0 && table.getSelectedRow() != -1 && table.getValueAt(table.getSelectedRow(), 0).equals(false)){
                    table.setValueAt("", table.getSelectedRow(), 3);
                    table.setValueAt("", table.getSelectedRow(), 4);
                    table.setValueAt(null, table.getSelectedRow(), 5);
                    table.setValueAt(null, table.getSelectedRow(), 6);
                }else if(table.getSelectedColumn() == 0 && table.getSelectedRow() != -1 && table.getValueAt(table.getSelectedRow(), 0).equals(true)){
                    try {  
                        proyectodetalle = proyecto;
                        entregabledetalle = new Entregable();
                        usuarioproyecto = new Usuarioproyecto();
                        detalleentregable = new Detalleentregable();
                        entregabledetalle.setEntId((int) table.getValueAt(table.getSelectedRow(), 1));
                        datosMiembro = table.getValueAt(table.getSelectedRow(), 3).toString().split(":");
                        usuarioproyecto.setUsuProyectoId(Integer.parseInt(datosMiembro[0]));
                        detalleentregable.setPROYECTOproId(proyectodetalle);
                        detalleentregable.setENTREGABLEentId(entregabledetalle);
                        detalleentregable.setUsuarioProyectousuProyectoId(usuarioproyecto);
                        detalleentregable.setArchivoCollection(null);
                        detalleentregable.setDetEntregableFechaInicio(java.sql.Date.valueOf((LocalDate) table.getValueAt(table.getSelectedRow(), 5)));
                        detalleentregable.setDetEntregableFechaFin(java.sql.Date.valueOf((LocalDate) table.getValueAt(table.getSelectedRow(), 6)));
                        detalleentregable.setDetEntregableEstado(1);
                        controldetalleEntregableGuardar(detalleentregable);
                    } catch (SQLException ex) {
                        Logger.getLogger(ViewEntregableProyecto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }          
            }     
        });        
    }

    ViewEntregableProyecto(Object object, boolean b) {
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllistaEntregable = new rojerusan.RSTableMetro1();
        cbxListaFases = new RSMaterialComponent.RSComboBoxMaterial();
        btnGuardarEntregableProyecto = new rojeru_san.rsbutton.RSButtonGradiente();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbllistaEntregable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sel.", "IDEntregable", "Nombre de Entregable", "Responsable", "Cargo", "F. Inicio", "F. Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbllistaEntregable.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tbllistaEntregable.setName(""); // NOI18N
        jScrollPane2.setViewportView(tbllistaEntregable);
        if (tbllistaEntregable.getColumnModel().getColumnCount() > 0) {
            tbllistaEntregable.getColumnModel().getColumn(0).setMinWidth(40);
            tbllistaEntregable.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbllistaEntregable.getColumnModel().getColumn(0).setMaxWidth(40);
            tbllistaEntregable.getColumnModel().getColumn(1).setMinWidth(0);
            tbllistaEntregable.getColumnModel().getColumn(1).setPreferredWidth(0);
            tbllistaEntregable.getColumnModel().getColumn(1).setMaxWidth(0);
            tbllistaEntregable.getColumnModel().getColumn(2).setResizable(false);
            tbllistaEntregable.getColumnModel().getColumn(3).setResizable(false);
            tbllistaEntregable.getColumnModel().getColumn(4).setResizable(false);
            tbllistaEntregable.getColumnModel().getColumn(5).setResizable(false);
            tbllistaEntregable.getColumnModel().getColumn(6).setResizable(false);
        }

        rSPanelMaterial1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 250));

        cbxListaFases.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fases" }));
        cbxListaFases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxListaFasesActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(cbxListaFases, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 740, -1));

        btnGuardarEntregableProyecto.setText("Agregar");
        btnGuardarEntregableProyecto.setColorPrimario(new java.awt.Color(0, 0, 51));
        btnGuardarEntregableProyecto.setColorSecundarioHover(new java.awt.Color(0, 160, 255));
        btnGuardarEntregableProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEntregableProyectoActionPerformed(evt);
            }
        });
        rSPanelMaterial1.add(btnGuardarEntregableProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxListaFasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxListaFasesActionPerformed
        try {
            
            cargarEntregables();
        } catch (SQLException ex) {
            Logger.getLogger(ViewEntregableProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxListaFasesActionPerformed

    private void btnGuardarEntregableProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEntregableProyectoActionPerformed
        /*try {
            entregable = new Entregable(0, txtEntregableNombre.getText());
            entregable.setFase(fase);
            controlEntregableGuardar(entregable);
            JOptionPane.showMessageDialog(jPanel1, "Operación realizada con éxito.","Entregable",JOptionPane.INFORMATION_MESSAGE);
            txtEntregableNombre.setText("");
            controlEntregableListar();
        } catch (SQLException ex) {
            Logger.getLogger(ViewAgregarFase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al realizar la operación solicitada.","Entregable", JOptionPane.WARNING_MESSAGE);
        }*/
        leerEntregables();
    }//GEN-LAST:event_btnGuardarEntregableProyectoActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEntregableProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewEntregableProyecto dialog = new ViewEntregableProyecto(new javax.swing.JFrame(), true);
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
    private rojeru_san.rsbutton.RSButtonGradiente btnGuardarEntregableProyecto;
    private RSMaterialComponent.RSComboBoxMaterial cbxListaFases;
    private javax.swing.JScrollPane jScrollPane2;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private rojerusan.RSTableMetro1 tbllistaEntregable;
    // End of variables declaration//GEN-END:variables
    
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        if(row > -1 && column > -1){
            Object data = model.getValueAt(row, column);   
            if(column == 3){
                if(!(data.toString().equals(""))){
                    datosMiembro = data.toString().split(":");
                    idMiembro = Integer.parseInt(datosMiembro[0]);
                    tbllistaEntregable.setValueAt(roles[idMiembro], row, 4);
                }
            }else if(column == 0 && (Boolean) tbllistaEntregable.getValueAt(row, 0) == false && tbllistaEntregable.getValueAt(row, 3) != null && tbllistaEntregable.getValueAt(row, 3) != "" && tbllistaEntregable.getValueAt(row, 4) != null && tbllistaEntregable.getValueAt(row, 4) != ""){
                entregable = new Entregable((Integer) tbllistaEntregable.getValueAt(row, 1));
                String[] idMiembro = tbllistaEntregable.getValueAt(row, 3).toString().split(":");                
                usuarioproyecto = new Usuarioproyecto(Integer.parseInt(idMiembro[0]));
                detalleentregable = new Detalleentregable(0, "sinArchivo", java.sql.Date.valueOf((LocalDate) tbllistaEntregable.getValueAt(row, 5)), java.sql.Date.valueOf((LocalDate) tbllistaEntregable.getValueAt(row, 6)), 0);
                detalleentregable.setPROYECTOproId(proyecto);                
                detalleentregable.setENTREGABLEentId(entregable);
                detalleentregable.setUsuarioProyectousuProyectoId(usuarioproyecto);                     
                if(listaDetalleEntregable.stream()
                        .filter(o -> o.getENTREGABLEentId().getEntId().equals(detalleentregable.getENTREGABLEentId().getEntId()) &&
                                o.getUsuarioProyectousuProyectoId().getUsuProyectoId().equals(detalleentregable.getUsuarioProyectousuProyectoId().getUsuProyectoId()))
                        .findFirst().isPresent()){
                            listaDetalleEntregable.remove(detalleentregable);
                        } 
                int a = listaDetalleEntregable.size();
                int b = a*2;
            }
        }        
    }
    
    private void leerEntregables() {
        for(int i = 0; i < tbllistaEntregable.getRowCount(); i++){
            if((Boolean) tbllistaEntregable.getValueAt(i, 0) == true){
                entregable = new Entregable((Integer) tbllistaEntregable.getValueAt(i, 1));
                String[] idMiembro = tbllistaEntregable.getValueAt(i, 3).toString().split(":");                
                usuarioproyecto = new Usuarioproyecto(Integer.parseInt(idMiembro[0]));
                detalleentregable = new Detalleentregable(0, "sinArchivo", java.sql.Date.valueOf((LocalDate) tbllistaEntregable.getValueAt(i, 5)), java.sql.Date.valueOf((LocalDate) tbllistaEntregable.getValueAt(i, 6)), 0);
                detalleentregable.setPROYECTOproId(proyecto);                
                detalleentregable.setENTREGABLEentId(entregable);
                detalleentregable.setUsuarioProyectousuProyectoId(usuarioproyecto);
                listaDetalleEntregable.add(detalleentregable);
            }
        }
    }
    
    private void cargarListaMiembros() throws SQLException {
        listaUsuario = controllerUsuarioProyecto.obtenerMiembrosProyecto(proyecto.getProId());        
        JComboBox cbxListaMiembro = new JComboBox();           
        for(int i = 0; i < listaUsuario.size(); i++){
            cbxListaMiembro.addItem(listaUsuario.get(i).getUsuProyectoId() + ": " + listaUsuario.get(i).getUSUARIOusuId().getUsuNombres() + " " + listaUsuario.get(i).getUSUARIOusuId().getUsuApellidos());
        }                
        tbllistaEntregable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cbxListaMiembro));
        tbllistaEntregable.getColumnModel().getColumn(5).setCellEditor(new DateTableEditor());        
        tbllistaEntregable.getColumnModel().getColumn(6).setCellEditor(new DateTableEditor());        
    }
    
    private void cargarFases() throws SQLException {
        listaFases = controllerFase.controlFaseListar(proyecto.getMetodologia().getMetId());        
        for(int i = 0; i < listaFases.size(); i++){
            cbxListaFases.addItem(listaFases.get(i).getFasNombre());
        } 
    }
    
    private void cargarEntregables()throws SQLException{
        try {
            defaultTableModelentregableRelacion.getDataVector().removeAllElements();
            listaEntregables = controllerEntregable.controlEntregableMetodologia(proyecto.getMetodologia());                
            for(int i = 0; i < listaEntregables.size(); i++){
                if(listaEntregables.get(i).getFase().getFasNombre().equals(cbxListaFases.getSelectedItem())){
                   defaultTableModelentregableRelacion.addRow(new Object[]{
                        false,
                        listaEntregables.get(i).getEntId(),
                        listaEntregables.get(i).getEntNombre()
                    }); 
                }
            }
            cargarListaMiembros();
            tbllistaEntregable.getModel().addTableModelListener(this);
        } catch (SQLException ex) {
            Logger.getLogger(ViewEntregableProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void controldetalleEntregableGuardar(Detalleentregable detalleentregable) throws SQLException {
        controllerDetalleEntregable.controldetalleEntregableGuardar(detalleentregable);
    }
}

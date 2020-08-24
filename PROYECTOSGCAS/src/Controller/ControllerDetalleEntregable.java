/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Detalleentregable;
import Model.Entregable;
import Model.Proyecto;
import Model.Usuario;
import Model.Usuarioproyecto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ControllerDetalleEntregable {

    ControllerConexion controllerConexion = new ControllerConexion();
    Proyecto proyecto;
    Entregable entregable;
    Usuario usuario;
    Detalleentregable detalleentregable;
    Usuarioproyecto usuarioproyecto;
    
    public void controldetalleEntregableGuardar(Detalleentregable detalleentregable) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {            
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_I_agregardetalleEntregable(?,?,?,?,?,?)}");           
            prepareStatement.setInt(1, detalleentregable.getPROYECTOproId().getProId());
            prepareStatement.setInt(2, detalleentregable.getENTREGABLEentId().getEntId());
            prepareStatement.setInt(3, detalleentregable.getUsuarioProyectousuProyectoId().getUsuProyectoId());
            prepareStatement.setDate(4, java.sql.Date.valueOf(String.valueOf(detalleentregable.getDetEntregableFechaInicio())));
            prepareStatement.setDate(5, java.sql.Date.valueOf(String.valueOf(detalleentregable.getDetEntregableFechaFin())));
            prepareStatement.setInt(6, detalleentregable.getDetEntregableEstado());
            prepareStatement.executeUpdate();
        }
    }
    
    public void controldetalleEntregableEliminar(int idProyecto, int idEntregable) throws SQLException {        
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_D_eliminardetalleEntregable(?,?)}");
            callableStatement.setInt(1, idProyecto);
            callableStatement.setInt(2, idEntregable);
            callableStatement.executeQuery();
        }
    }

    public List<Detalleentregable> controldetalleEntregableObtener(int proId) throws SQLException {
        List<Detalleentregable> listadetalleEntregable = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerdetalleEntregable(?)}");
            callableStatement.setInt(1, proId);            
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){                
                detalleentregable = new Detalleentregable();
                proyecto = new Proyecto();
                entregable = new Entregable();
                usuarioproyecto = new Usuarioproyecto();                
                detalleentregable.setDetEntregableId(resultSet.getInt(1));
                proyecto.setProId(resultSet.getInt(2));
                detalleentregable.setPROYECTOproId(proyecto);
                entregable.setEntId(resultSet.getInt(3));
                detalleentregable.setENTREGABLEentId(entregable);
                usuarioproyecto.setUsuProyectoId(resultSet.getInt(4));
                detalleentregable.setUsuarioProyectousuProyectoId(usuarioproyecto);
                detalleentregable.setDetEntregableFechaInicio(java.sql.Date.valueOf(String.valueOf(resultSet.getDate(6))));
                detalleentregable.setDetEntregableFechaFin(java.sql.Date.valueOf(String.valueOf(resultSet.getDate(7))));
                listadetalleEntregable.add(detalleentregable);
            }
        }
        return listadetalleEntregable;
    }
}

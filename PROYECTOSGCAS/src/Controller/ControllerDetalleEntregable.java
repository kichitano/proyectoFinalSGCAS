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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class ControllerDetalleEntregable {

    ControllerConexion controllerConexion = new ControllerConexion();
    Proyecto proyecto;
    Entregable entregable;
    Usuario usuario;
    
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
}

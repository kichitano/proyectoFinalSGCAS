/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entregable;
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
public class ControllerEntregable {
    
    ControllerConexion controllerConexion = new ControllerConexion();
    Entregable entregable;
    
    public void controlEntregableGuardar(Entregable entregable) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_I_agregarEntregable(?,?)}");
            prepareStatement.setInt(1, entregable.getFase().getFasId());
            prepareStatement.setString(2, entregable.getEntNombre());
            prepareStatement.executeUpdate();
        }
    }
    
    public List<Entregable> controlEntregableListar(int idFase) throws SQLException {
        List<Entregable> listaEntregable = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerEntregables(?)}");
            callableStatement.setInt(1, idFase);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                entregable = new Entregable();
                entregable.setEntId(resultSet.getInt(1));
                entregable.setEntNombre(resultSet.getString(3));
                listaEntregable.add(entregable);
            }
        }
        return listaEntregable;
    }  
    
    public ArrayList<Integer> contabilizarEntregables() throws SQLException{
        ArrayList<Integer> cantidadEntregables = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerCantidadEntregables()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                cantidadEntregables.add(resultSet.getInt(1));
                cantidadEntregables.add(resultSet.getInt(2));
            }
        }
        return cantidadEntregables;
    }

    public void controlEntregableEliminar(Entregable entregable) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_D_eliminarEntregable(?)}");
            callableStatement.setInt(1, entregable.getEntId());
            callableStatement.executeQuery();
        }
    }
    
}

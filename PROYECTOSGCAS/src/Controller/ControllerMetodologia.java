/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Metodologia;
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
public class ControllerMetodologia {
    
    ControllerConexion controllerConexion = new ControllerConexion();
    Metodologia metodologia;
    
    public void controlMetodologiaGuardar(Metodologia metodologia) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_I_agregarMetodologia(?,?,?)}");
            prepareStatement.setString(1, metodologia.getMetNombre());
            prepareStatement.setDate(2, java.sql.Date.valueOf(String.valueOf(metodologia.getMetFechaRegistro())));
            prepareStatement.setInt(3, metodologia.getMetEstado());
            prepareStatement.executeUpdate();
        }
    }
    
    public List<Metodologia> controlMetodologiaListar() throws SQLException {
        List<Metodologia> listaMetodologia = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerMetodologias()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                metodologia = new Metodologia();
                metodologia.setMetId(resultSet.getInt(1));
                metodologia.setMetNombre(resultSet.getString(2));
                metodologia.setMetFechaRegistro(resultSet.getDate(3));
                metodologia.setMetEstado(resultSet.getInt(4));
                listaMetodologia.add(metodologia);
            }
        }
        return listaMetodologia;
    }    
    
    public void controlMetodologiaEditar(Metodologia metodologia) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_U_editarMetodologia(?,?,?)}");
            prepareStatement.setInt(1, metodologia.getMetId());
            prepareStatement.setString(2, metodologia.getMetNombre());
            prepareStatement.setInt(3, metodologia.getMetEstado());
            prepareStatement.executeUpdate();
        }
    }
}

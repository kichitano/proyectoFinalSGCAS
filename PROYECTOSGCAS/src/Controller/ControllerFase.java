/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Fase;
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
public class ControllerFase {
    
    ControllerConexion controllerConexion = new ControllerConexion();
    Fase fase;
    
    public void controlFaseGuardar(Fase fase) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_I_agregarFase(?,?,?)}");
            prepareStatement.setInt(1, fase.getMETODOLOGIAmetId().getMetId());
            prepareStatement.setString(2, fase.getFasNombre());
            prepareStatement.setInt(3, fase.getFasEstado());
            prepareStatement.executeUpdate();
        }
    }
    
    public List<Fase> controlFaseListar(int idMetodologia) throws SQLException {
        List<Fase> listaFase = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerFases(?)}");
            callableStatement.setInt(1, idMetodologia);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                fase = new Fase();
                fase.setFasId(resultSet.getInt(1));
                fase.setFasNombre(resultSet.getString(3));
                fase.setFasEstado(resultSet.getInt(4));
                listaFase.add(fase);
            }
        }
        return listaFase;
    }  
    
    public void controlFaseEditar(Fase fase) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_U_editarFase(?,?,?)}");
            prepareStatement.setInt(1, fase.getFasId());
            prepareStatement.setString(2, fase.getFasNombre());
            prepareStatement.setInt(3, fase.getFasEstado());
            prepareStatement.executeUpdate();
        }
    }
    
}

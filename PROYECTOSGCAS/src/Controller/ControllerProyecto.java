/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Metodologia;
import Model.Proyecto;
import Model.Usuario;
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
public class ControllerProyecto {

    ControllerConexion controllerConexion = new ControllerConexion();
    Proyecto proyecto;
    Metodologia metodologia;
    Usuario usuario;
    
    public void controlProyectoGuardar(Proyecto proyecto) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {            
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_I_agregarProyecto(?,?,?,?,?,?)}");
            prepareStatement.setInt(1, proyecto.getMetodologia().getMetId());
            prepareStatement.setInt(2, proyecto.getUSUARIOusuId().getUsuId());
            prepareStatement.setString(3, proyecto.getProNombre());
            prepareStatement.setString(4, proyecto.getProDescripcion());
            prepareStatement.setDate(5, java.sql.Date.valueOf(String.valueOf(proyecto.getProFechaInicio())));
            prepareStatement.setInt(6, proyecto.getProEstado());
            prepareStatement.executeUpdate();
        }
    }
    
    public List<Proyecto> controlProyectoListar() throws SQLException {
        List<Proyecto> listaProyecto = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerProyectos()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                proyecto = new Proyecto();
                metodologia = new Metodologia();
                usuario = new Usuario();
                proyecto.setProId(resultSet.getInt(1));
                metodologia.setMetId(resultSet.getInt(2));
                proyecto.setMetodologia(metodologia);
                usuario.setUsuId(resultSet.getInt(3));
                proyecto.setUSUARIOusuId(usuario);
                proyecto.setProNombre(resultSet.getString(4));
                proyecto.setProDescripcion(resultSet.getString(5));
                proyecto.setProFechaInicio(resultSet.getDate(6));                
                proyecto.setProEstado(resultSet.getInt(8));
                listaProyecto.add(proyecto);
            }
        }
        return listaProyecto;
    }         
}

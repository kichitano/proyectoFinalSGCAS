/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class ControllerUsuarioProyecto {
    
    List<Usuarioproyecto> listaUsuarioproyecto;
    List<Usuarioproyecto> listaMiembros;
    ControllerConexion controllerConexion = new ControllerConexion();
    Usuarioproyecto usuarioproyecto;
    Proyecto proyecto;
    Usuario usuario;
    
    public void controlUsuarioProyectoGuardar(Usuarioproyecto usuarioproyecto) throws SQLException {
        try (Connection connection = controllerConexion.conectarBD()) {            
            PreparedStatement prepareStatement = connection.prepareStatement("{call usp_I_agregarUsuarioProyecto(?,?,?,?)}");
            prepareStatement.setInt(1, usuarioproyecto.getPROYECTOproId().getProId());
            prepareStatement.setInt(2, usuarioproyecto.getUSUARIOusuId().getUsuId());
            prepareStatement.setInt(3, usuarioproyecto.getUsuProyectoEstado());
            prepareStatement.setInt(4, usuarioproyecto.getUsuProyectoCargo());
            prepareStatement.executeUpdate();
        }
    }

    public List<Usuarioproyecto> controlProyectoListar(Proyecto proyecto) throws SQLException {
        listaUsuarioproyecto = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerUsuariosProyecto(?)}");
            callableStatement.setInt(1, proyecto.getProId());
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                usuarioproyecto = new Usuarioproyecto();
                proyecto = new Proyecto();
                usuario = new Usuario();
                usuarioproyecto.setUsuProyectoId(resultSet.getInt(1));
                proyecto.setProId(resultSet.getInt(2));
                usuarioproyecto.setPROYECTOproId(proyecto);
                usuario.setUsuId(resultSet.getInt(3));
                usuarioproyecto.setUSUARIOusuId(usuario);
                usuarioproyecto.setUsuProyectoEstado(resultSet.getInt(4));
                usuarioproyecto.setUsuProyectoCargo(resultSet.getInt(5));
                listaUsuarioproyecto.add(usuarioproyecto);
            }
        }
        return listaUsuarioproyecto;
    }
    
    public ArrayList<Integer> contabilizarMiembros() throws SQLException{
        ArrayList<Integer> cantidadMiembros = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerCantidadMiembros()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                cantidadMiembros.add(resultSet.getInt(1));
                cantidadMiembros.add(resultSet.getInt(2));
            }
        }
        return cantidadMiembros;
    }
    
    public List<Usuarioproyecto> obtenerMiembrosProyecto(int proyectoID) throws SQLException{
        listaMiembros = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerMiembrosProyecto(?)}");
            callableStatement.setInt(1, proyectoID);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                usuario = new Usuario();
                usuarioproyecto = new Usuarioproyecto();         
                usuarioproyecto.setUsuProyectoId(resultSet.getInt(1));
                usuario.setUsuId(resultSet.getInt(2));
                usuario.setUsuDNI(resultSet.getString(3));
                usuario.setUsuNombres(resultSet.getString(4));
                usuario.setUsuApellidos(resultSet.getString(5));
                usuarioproyecto.setUsuProyectoCargo(resultSet.getInt(6));
                usuarioproyecto.setUSUARIOusuId(usuario);
                listaMiembros.add(usuarioproyecto);
            }
        }        
        return listaMiembros;
    }
}

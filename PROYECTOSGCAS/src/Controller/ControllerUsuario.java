/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class ControllerUsuario {
    
    ControllerConexion controllerConexion = new ControllerConexion();
    Usuario usuario;
    
    public Usuario controlUsuarioIniciarSesion(String nombreUsuario, char[] contrasenaUsuario) throws SQLException{
        usuario = new Usuario();
        Connection connection = controllerConexion.conectarBD();    
        CallableStatement callableStatement = connection.prepareCall("{call usp_S_validarUsuario(?,?)}");    
        callableStatement.setString(1, nombreUsuario);    
        callableStatement.setString(2, String.valueOf(contrasenaUsuario));      
        ResultSet resultSet = callableStatement.executeQuery();
        while(resultSet.next()){
            usuario.setUsuId(resultSet.getInt(1));
            usuario.setUsuDNI(resultSet.getString(2));
            usuario.setUsuNombres(resultSet.getString(3));
            usuario.setUsuApellidos(resultSet.getString(4));
            usuario.setUsuCorreo(resultSet.getString(5));
            usuario.setUsuNivel(resultSet.getInt(6));
            usuario.setUsuNombreUsuario(resultSet.getString(7));
            usuario.setUsuFechaRegistro(resultSet.getDate(8));
            usuario.setUsuEstado(resultSet.getInt(9));
        }
        connection.close();
        return usuario;
    }

    public void controlUsuarioGuardar(Usuario usuario) throws SQLException {
        Connection connection = controllerConexion.conectarBD();    
        PreparedStatement prepareStatement = connection.prepareStatement("{call usp_I_agregarUsuario(?,?,?,?,?,?,?,?,?)}");    
        prepareStatement.setString(1, usuario.getUsuDNI());   
        prepareStatement.setString(2, usuario.getUsuNombres());         
        prepareStatement.setString(3, usuario.getUsuApellidos());         
        prepareStatement.setString(4, usuario.getUsuCorreo());         
        prepareStatement.setInt(5, usuario.getUsuNivel());   
        prepareStatement.setString(6, usuario.getUsuNombreUsuario());         
        prepareStatement.setString(7, usuario.getUsuContrasena());         
        prepareStatement.setDate(8, java.sql.Date.valueOf(String.valueOf(usuario.getUsuFechaRegistro())));         
        prepareStatement.setInt(9, usuario.getUsuEstado());   
        prepareStatement.executeUpdate();
        connection.close();
    }
    
    public List<Usuario> controlUsuarioListar() throws SQLException {
        List<Usuario> listaUsuario = new ArrayList<>();
        try (Connection connection = controllerConexion.conectarBD()) {
            CallableStatement callableStatement = connection.prepareCall("{call usp_S_obtenerUsuarios()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                usuario = new Usuario();
                usuario.setUsuId(resultSet.getInt(1));
                usuario.setUsuDNI(resultSet.getString(2));
                usuario.setUsuNombres(resultSet.getString(3));
                usuario.setUsuApellidos(resultSet.getString(4));
                usuario.setUsuCorreo(resultSet.getString(5));
                usuario.setUsuNivel(resultSet.getInt(6));
                usuario.setUsuNombreUsuario(resultSet.getString(7));
                usuario.setUsuFechaRegistro(resultSet.getDate(8));
                usuario.setUsuEstado(resultSet.getInt(9));
                listaUsuario.add(usuario);
            }
        }
        return listaUsuario;
    }

    public void controlUsuarioEditar(Usuario usuario) throws SQLException {
        Connection connection = controllerConexion.conectarBD();    
         PreparedStatement prepareStatement = connection.prepareStatement("{call usp_U_editarUsuario(?,?,?,?,?,?,?,?,?,?)}");    
        if (usuario.getUsuContrasena().equals("")){
            CallableStatement callableStatement2 = connection.prepareCall("{call usp_S_obtenerContrasena(?)}");   
            callableStatement2.setInt(1, usuario.getUsuId());
            ResultSet resultSet = callableStatement2.executeQuery();
            while(resultSet.next()){
                usuario.setUsuContrasena(resultSet.getString(1));
            }
        }
        prepareStatement.setInt(1, usuario.getUsuId());   
        prepareStatement.setString(2, usuario.getUsuDNI());   
        prepareStatement.setString(3, usuario.getUsuNombres());         
        prepareStatement.setString(4, usuario.getUsuApellidos());         
        prepareStatement.setString(5, usuario.getUsuCorreo());         
        prepareStatement.setInt(6, usuario.getUsuNivel());   
        prepareStatement.setString(7, usuario.getUsuNombreUsuario());         
        prepareStatement.setString(8, usuario.getUsuContrasena());         
        prepareStatement.setDate(9, java.sql.Date.valueOf(String.valueOf(usuario.getUsuFechaRegistro())));         
        prepareStatement.setInt(10, usuario.getUsuEstado());   
        prepareStatement.executeUpdate();
        connection.close();        
    }    
}   

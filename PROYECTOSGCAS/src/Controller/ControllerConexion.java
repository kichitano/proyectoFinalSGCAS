/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class ControllerConexion {
    
    public static final String PROPERTY_URL_DB = "jdbc:mysql://localhost:3306/dbsgcas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public Connection conectarBD() {        
        Connection connection = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
                connection = DriverManager.getConnection(PROPERTY_URL_DB,
                        "root", "1234");           
                boolean valid = connection.isValid(1);
                System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error al conectar con la base de datos de MySQL (" + PROPERTY_URL_DB + "): " + sqle);
        }
        return connection;
    }

    public void desconectarBD() throws SQLException {
        Connection connection = DriverManager.getConnection(PROPERTY_URL_DB);
        if ( connection != null) {
           connection.close();
        }
   }
    
}

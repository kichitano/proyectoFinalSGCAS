package Model;

import Model.Proyecto;
import Model.Usuarioproyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-30T01:32:07")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> usuCorreo;
    public static volatile SingularAttribute<Usuario, Integer> usuNivel;
    public static volatile SingularAttribute<Usuario, Integer> usuId;
    public static volatile SingularAttribute<Usuario, String> usuNombres;
    public static volatile CollectionAttribute<Usuario, Usuarioproyecto> usuarioproyectoCollection;
    public static volatile SingularAttribute<Usuario, Date> usuFechaRegistro;
    public static volatile SingularAttribute<Usuario, String> usuNombreUsuario;
    public static volatile SingularAttribute<Usuario, String> usuDNI;
    public static volatile CollectionAttribute<Usuario, Proyecto> proyectoCollection;
    public static volatile SingularAttribute<Usuario, String> usuApellidos;
    public static volatile SingularAttribute<Usuario, Integer> usuEstado;
    public static volatile SingularAttribute<Usuario, String> usuContrasena;

}
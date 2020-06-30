package Model;

import Model.Detalleentregable;
import Model.Proyecto;
import Model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-30T01:32:07")
@StaticMetamodel(Usuarioproyecto.class)
public class Usuarioproyecto_ { 

    public static volatile SingularAttribute<Usuarioproyecto, Usuario> uSUARIOusuId;
    public static volatile CollectionAttribute<Usuarioproyecto, Detalleentregable> detalleentregableCollection;
    public static volatile SingularAttribute<Usuarioproyecto, Proyecto> pROYECTOproId;
    public static volatile SingularAttribute<Usuarioproyecto, Integer> usuProyectoCargo;
    public static volatile SingularAttribute<Usuarioproyecto, Integer> usuProyectoId;
    public static volatile SingularAttribute<Usuarioproyecto, Integer> usuProyectoEstado;

}
package Model;

import Model.Detalleentregable;
import Model.Metodologia;
import Model.Relacionentregable;
import Model.Solicitudcambio;
import Model.Usuario;
import Model.Usuarioproyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-13T17:00:02")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Integer> proEstado;
    public static volatile CollectionAttribute<Proyecto, Solicitudcambio> solicitudcambioCollection;
    public static volatile SingularAttribute<Proyecto, Usuario> uSUARIOusuId;
    public static volatile CollectionAttribute<Proyecto, Detalleentregable> detalleentregableCollection;
    public static volatile SingularAttribute<Proyecto, Metodologia> metodologia;
    public static volatile CollectionAttribute<Proyecto, Relacionentregable> relacionentregableCollection;
    public static volatile SingularAttribute<Proyecto, String> proNombre;
    public static volatile CollectionAttribute<Proyecto, Usuarioproyecto> usuarioproyectoCollection;
    public static volatile SingularAttribute<Proyecto, Integer> proId;
    public static volatile SingularAttribute<Proyecto, Date> proFechaFin;
    public static volatile SingularAttribute<Proyecto, Date> proFechaInicio;
    public static volatile SingularAttribute<Proyecto, String> proDescripcion;

}
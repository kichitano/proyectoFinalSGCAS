package Model;

import Model.Detalleentregable;
import Model.Proyecto;
import Model.Solicitudaprobacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-13T17:00:02")
@StaticMetamodel(Solicitudcambio.class)
public class Solicitudcambio_ { 

    public static volatile SingularAttribute<Solicitudcambio, Integer> solCambioId;
    public static volatile SingularAttribute<Solicitudcambio, Proyecto> pROYECTOproId;
    public static volatile SingularAttribute<Solicitudcambio, Detalleentregable> detalleEntregabledetEntregableId;
    public static volatile SingularAttribute<Solicitudcambio, String> solCambioComentario;
    public static volatile CollectionAttribute<Solicitudcambio, Solicitudaprobacion> solicitudaprobacionCollection;
    public static volatile SingularAttribute<Solicitudcambio, Date> solCambioFecha;

}
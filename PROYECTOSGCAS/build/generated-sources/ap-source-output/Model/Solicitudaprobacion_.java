package Model;

import Model.Solicitudcambio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-30T01:32:07")
@StaticMetamodel(Solicitudaprobacion.class)
public class Solicitudaprobacion_ { 

    public static volatile SingularAttribute<Solicitudaprobacion, Date> solAprobacionFecha;
    public static volatile SingularAttribute<Solicitudaprobacion, String> solAprobacionComentario;
    public static volatile SingularAttribute<Solicitudaprobacion, Solicitudcambio> solicitudCAMBIOsolCambioId;
    public static volatile SingularAttribute<Solicitudaprobacion, Integer> solAprobacionEstado;
    public static volatile SingularAttribute<Solicitudaprobacion, Integer> solAprobacionId;

}
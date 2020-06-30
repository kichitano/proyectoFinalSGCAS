package Model;

import Model.Archivo;
import Model.Entregable;
import Model.Proyecto;
import Model.Solicitudcambio;
import Model.Usuarioproyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-30T01:32:07")
@StaticMetamodel(Detalleentregable.class)
public class Detalleentregable_ { 

    public static volatile CollectionAttribute<Detalleentregable, Solicitudcambio> solicitudcambioCollection;
    public static volatile SingularAttribute<Detalleentregable, Integer> detEntregableId;
    public static volatile SingularAttribute<Detalleentregable, String> detEntregableNombreArchivo;
    public static volatile SingularAttribute<Detalleentregable, Proyecto> pROYECTOproId;
    public static volatile SingularAttribute<Detalleentregable, Entregable> eNTREGABLEentId;
    public static volatile SingularAttribute<Detalleentregable, Date> detEntregableFechaEntrega;
    public static volatile SingularAttribute<Detalleentregable, Date> detEntregableFechaFin;
    public static volatile CollectionAttribute<Detalleentregable, Archivo> archivoCollection;
    public static volatile SingularAttribute<Detalleentregable, Usuarioproyecto> usuarioProyectousuProyectoId;
    public static volatile SingularAttribute<Detalleentregable, Date> detEntregableFechaInicio;
    public static volatile SingularAttribute<Detalleentregable, Integer> detEntregableEstado;

}
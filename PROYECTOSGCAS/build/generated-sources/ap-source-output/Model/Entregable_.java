package Model;

import Model.Detalleentregable;
import Model.Fase;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-29T01:59:13")
@StaticMetamodel(Entregable.class)
public class Entregable_ { 

    public static volatile SingularAttribute<Entregable, Fase> fase;
    public static volatile CollectionAttribute<Entregable, Detalleentregable> detalleentregableCollection;
    public static volatile SingularAttribute<Entregable, Integer> entId;
    public static volatile SingularAttribute<Entregable, String> entNombre;

}
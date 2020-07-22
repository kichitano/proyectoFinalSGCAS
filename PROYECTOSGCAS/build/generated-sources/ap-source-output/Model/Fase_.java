package Model;

import Model.Entregable;
import Model.Metodologia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-21T13:54:15")
@StaticMetamodel(Fase.class)
public class Fase_ { 

    public static volatile SingularAttribute<Fase, Metodologia> mETODOLOGIAmetId;
    public static volatile SingularAttribute<Fase, Integer> fasEstado;
    public static volatile SingularAttribute<Fase, Integer> fasId;
    public static volatile CollectionAttribute<Fase, Entregable> entregableCollection;
    public static volatile SingularAttribute<Fase, String> fasNombre;

}
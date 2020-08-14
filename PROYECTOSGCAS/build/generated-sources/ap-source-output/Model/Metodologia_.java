package Model;

import Model.Fase;
import Model.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-13T17:00:02")
@StaticMetamodel(Metodologia.class)
public class Metodologia_ { 

    public static volatile SingularAttribute<Metodologia, String> metNombre;
    public static volatile SingularAttribute<Metodologia, Date> metFechaRegistro;
    public static volatile SingularAttribute<Metodologia, Integer> metEstado;
    public static volatile SingularAttribute<Metodologia, Integer> metId;
    public static volatile CollectionAttribute<Metodologia, Fase> faseCollection;
    public static volatile CollectionAttribute<Metodologia, Proyecto> proyectoCollection;

}
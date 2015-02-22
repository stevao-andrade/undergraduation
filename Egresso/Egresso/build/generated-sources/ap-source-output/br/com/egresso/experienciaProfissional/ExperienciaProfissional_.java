package br.com.egresso.experienciaProfissional;

import br.com.egresso.usuario.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-01-03T11:23:47")
@StaticMetamodel(ExperienciaProfissional.class)
public class ExperienciaProfissional_ { 

    public static volatile SingularAttribute<ExperienciaProfissional, Date> dataFim;
    public static volatile SingularAttribute<ExperienciaProfissional, String> areaDeFormacao;
    public static volatile SingularAttribute<ExperienciaProfissional, Integer> codigo_experiencia;
    public static volatile SingularAttribute<ExperienciaProfissional, Usuario> usuario;
    public static volatile SingularAttribute<ExperienciaProfissional, Date> dataInicio;
    public static volatile SingularAttribute<ExperienciaProfissional, String> empresa;
    public static volatile SingularAttribute<ExperienciaProfissional, String> cargo;

}
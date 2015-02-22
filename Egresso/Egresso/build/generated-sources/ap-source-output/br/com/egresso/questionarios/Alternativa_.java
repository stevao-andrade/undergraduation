package br.com.egresso.questionarios;

import br.com.egresso.questionarios.Questao;
import br.com.egresso.questionarios.Questionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-01-03T11:23:47")
@StaticMetamodel(Alternativa.class)
public class Alternativa_ { 

    public static volatile SingularAttribute<Alternativa, Integer> codigo_alternativa;
    public static volatile SingularAttribute<Alternativa, Questionario> questionario;
    public static volatile SingularAttribute<Alternativa, Questao> questao;
    public static volatile SingularAttribute<Alternativa, String> enunciadoAlternativa;

}
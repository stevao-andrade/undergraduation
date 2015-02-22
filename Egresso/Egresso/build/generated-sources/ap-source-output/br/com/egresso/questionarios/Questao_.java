package br.com.egresso.questionarios;

import br.com.egresso.questionarios.Alternativa;
import br.com.egresso.questionarios.Questionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-01-03T11:23:47")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile SingularAttribute<Questao, String> enunciadoQuestao;
    public static volatile ListAttribute<Questao, Alternativa> alternativas;
    public static volatile SingularAttribute<Questao, Integer> codigo_questao;
    public static volatile SingularAttribute<Questao, Questionario> questionario;

}
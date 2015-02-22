package br.com.egresso.questionarios;

import br.com.egresso.questionarios.Questao;
import br.com.egresso.questionarios.Resposta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-03-29T11:25:18")
@StaticMetamodel(Questionario.class)
public class Questionario_ { 

    public static volatile ListAttribute<Questionario, Resposta> listaDeRespostas;
    public static volatile SingularAttribute<Questionario, String> curso;
    public static volatile ListAttribute<Questionario, Questao> questoes;
    public static volatile SingularAttribute<Questionario, String> nomeQuestionario;
    public static volatile SingularAttribute<Questionario, Date> dataCriacao;
    public static volatile SingularAttribute<Questionario, Date> dataDisponibilidadeFinal;
    public static volatile SingularAttribute<Questionario, Integer> codigo_questionario;

}
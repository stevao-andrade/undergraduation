package br.com.egresso.questionarios;

import br.com.egresso.questionarios.Alternativa;
import br.com.egresso.questionarios.Questao;
import br.com.egresso.questionarios.Questionario;
import br.com.egresso.usuario.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-01-03T11:23:47")
@StaticMetamodel(Resposta.class)
public class Resposta_ { 

    public static volatile SingularAttribute<Resposta, Usuario> usuario;
    public static volatile SingularAttribute<Resposta, Integer> codigo_resposta;
    public static volatile SingularAttribute<Resposta, Questionario> questionario;
    public static volatile SingularAttribute<Resposta, Questao> questao;
    public static volatile SingularAttribute<Resposta, Alternativa> alternativa;

}
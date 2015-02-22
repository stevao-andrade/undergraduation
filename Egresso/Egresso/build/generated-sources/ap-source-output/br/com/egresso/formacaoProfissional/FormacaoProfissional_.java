package br.com.egresso.formacaoProfissional;

import br.com.egresso.usuario.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-01-03T11:23:47")
@StaticMetamodel(FormacaoProfissional.class)
public class FormacaoProfissional_ { 

    public static volatile SingularAttribute<FormacaoProfissional, String> instituicaoFormacao;
    public static volatile SingularAttribute<FormacaoProfissional, Date> dataFim;
    public static volatile SingularAttribute<FormacaoProfissional, Usuario> usuario;
    public static volatile SingularAttribute<FormacaoProfissional, Date> dataInicio;
    public static volatile SingularAttribute<FormacaoProfissional, Integer> codigo_formacao;
    public static volatile SingularAttribute<FormacaoProfissional, String> descricao;
    public static volatile SingularAttribute<FormacaoProfissional, String> titulacao;

}
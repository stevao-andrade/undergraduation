package br.com.egresso.instituicaoEnsino;

import br.com.egresso.usuario.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-01-03T11:23:47")
@StaticMetamodel(InstituicaoEnsino.class)
public class InstituicaoEnsino_ { 

    public static volatile SingularAttribute<InstituicaoEnsino, String> curso;
    public static volatile SingularAttribute<InstituicaoEnsino, Usuario> usuario;
    public static volatile SingularAttribute<InstituicaoEnsino, Date> data_inicio;
    public static volatile SingularAttribute<InstituicaoEnsino, Integer> codigo_instituicao;
    public static volatile SingularAttribute<InstituicaoEnsino, String> nome_instituicao;
    public static volatile SingularAttribute<InstituicaoEnsino, Date> data_final;

}
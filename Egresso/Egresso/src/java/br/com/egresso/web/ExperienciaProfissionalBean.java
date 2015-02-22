/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.experienciaProfissional.ExperienciaProfissional;
import br.com.egresso.experienciaProfissional.ExperienciaProfissionalRN;
import br.com.egresso.util.ContextoUtil;
import br.com.egresso.util.MensagemContexto;
import br.com.egresso.util.ValidaData;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author stevao.alves
 */
@ManagedBean(name = "experienciaProfissionalBean")
@RequestScoped
public class ExperienciaProfissionalBean {

    private ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional();
    private List<ExperienciaProfissional> lista = null;

    public List<ExperienciaProfissional> getLista() {

        if (this.lista == null) {
            UsuarioBean usuarioBean = ContextoUtil.getUsuarioBean();
            ExperienciaProfissionalRN experienciaRN = new ExperienciaProfissionalRN();
            lista = experienciaRN.listar(usuarioBean.getUsuarioLogado());
        }
        return this.lista;
    }

    public void setLista(List<ExperienciaProfissional> lista) {
        this.lista = lista;
    }

    public ExperienciaProfissional getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public void setExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    public void setFormacaoProfissional(ExperienciaProfissional experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    public void salvar() {

        if(ValidaData.validar(this.experienciaProfissional.getDataInicio(), this.experienciaProfissional.getDataFim())){
        }
        else{
        UsuarioBean usuarioBean = ContextoUtil.getUsuarioBean();
        this.experienciaProfissional.setUsuario(usuarioBean.getUsuarioLogado());

        ExperienciaProfissionalRN experienciaProfissionalRN = new ExperienciaProfissionalRN();
        experienciaProfissionalRN.salvar(experienciaProfissional);

        System.out.println("Experiência Profissional Inserida com Sucesso");
        MensagemContexto.adicionarMensagem("Experiencia Profissional adcionada com sucesso.");

        /* Nova instancia de formação profissional para limpar os dados e  lista
        recebe NULL para forçar o recarregamento no metodo Listar*/
        this.experienciaProfissional = new ExperienciaProfissional();
        this.lista = null;
        }

    }

    public void excluir() {
        ExperienciaProfissionalRN experiencia = new ExperienciaProfissionalRN();
        experiencia.excluir(experienciaProfissional);
        
        MensagemContexto.adicionarMensagem("Experiencia Profissional excluída com sucesso.");
        
        this.experienciaProfissional = new ExperienciaProfissional();
        this.lista = null;
    }
}

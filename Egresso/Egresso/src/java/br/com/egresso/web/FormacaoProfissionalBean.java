/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.formacaoProfissional.FormacaoProfissional;
import br.com.egresso.formacaoProfissional.FormacaoProfissionalRN;
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
@ManagedBean
@RequestScoped
public class FormacaoProfissionalBean {

    private FormacaoProfissional formacaoProfissional = new FormacaoProfissional();
    private List<FormacaoProfissional> lista = null;

    public List<FormacaoProfissional> getLista() {

        if (this.lista == null) {
            UsuarioBean usuarioBean = ContextoUtil.getUsuarioBean();
            FormacaoProfissionalRN formacaoRN = new FormacaoProfissionalRN();
            lista = formacaoRN.listar(usuarioBean.getUsuarioLogado());
        }
        return this.lista;
    }

    public FormacaoProfissional getFormacaoProfissional() {
        return formacaoProfissional;
    }

    public void setFormacaoProfissional(FormacaoProfissional formacaoProfissional) {
        this.formacaoProfissional = formacaoProfissional;
    }

    public void salvar() {
        
        if(ValidaData.validar(this.formacaoProfissional.getDataInicio(), this.formacaoProfissional.getDataFim())){
        }
        else{
        UsuarioBean usuarioBean = ContextoUtil.getUsuarioBean();
        this.formacaoProfissional.setUsuario(usuarioBean.getUsuarioLogado());
        
        FormacaoProfissionalRN formacaoProfissionalRN = new FormacaoProfissionalRN();
        formacaoProfissionalRN.salvar(this.formacaoProfissional);
        
        MensagemContexto.adicionarMensagem("Formação Profissional adcionada com sucesso.");

        /* Nova instancia de formação profissional para limpar os dados e  lista
        recebe NULL para forçar o recarregamento no metodo Listar*/
        this.formacaoProfissional = new FormacaoProfissional();
        this.lista = null;
        }
    }

    public void excluir() {
        FormacaoProfissionalRN formacao = new FormacaoProfissionalRN();

        formacao.excluir(formacaoProfissional); 
        
        MensagemContexto.adicionarMensagem("Formação Profissional excluída com sucesso.");
        
        this.formacaoProfissional = new FormacaoProfissional();
        this.lista = null;
    }
}

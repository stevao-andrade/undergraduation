/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.instituicaoEnsino.Curso;
import br.com.egresso.instituicaoEnsino.CursoRN;
import br.com.egresso.instituicaoEnsino.Faculdade;
import br.com.egresso.instituicaoEnsino.FaculdadeRN;
import br.com.egresso.instituicaoEnsino.InstituicaoEnsino;
import br.com.egresso.instituicaoEnsino.InstituicaoEnsinoRN;
import br.com.egresso.util.ContextoUtil;
import br.com.egresso.util.MensagemContexto;
import br.com.egresso.util.ValidaData;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author stevao.alves
 */
@ManagedBean(name = "instituicaoEnsinoBean")
@RequestScoped
public class InstituicaoEnsinoBean {

    private InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino();
    private List<InstituicaoEnsino> lista = null;
    private List<Faculdade> listaDeFaculdades;
    private List<Curso> listaDeCursos;

    public List<SelectItem> getListaDeCursos() {
        CursoRN cursoRN = new CursoRN();
        List<Curso> cursos = new ArrayList<Curso>();
        cursos = cursoRN.listar();

        List lista = new ArrayList();

        for (Curso c : cursos) {
            SelectItem item = new SelectItem(c.getNome());
            lista.add(item);
        }
        return lista;
    }

    public List<SelectItem> getListaDeFaculdades() {
        FaculdadeRN faculdadeRN = new FaculdadeRN();
        List<Faculdade> faculdades = new ArrayList<Faculdade>();
        faculdades = faculdadeRN.listar();

        List lista = new ArrayList();

        for (Faculdade f : faculdades) {
            SelectItem item = new SelectItem(f.getNome());
            lista.add(item);
        }
        return lista;
    }

    public InstituicaoEnsino getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public List<InstituicaoEnsino> getLista() {
        if (this.lista == null) {
            UsuarioBean usuarioBean = ContextoUtil.getUsuarioBean();
            InstituicaoEnsinoRN instituicaoRN = new InstituicaoEnsinoRN();
            lista = instituicaoRN.listar(usuarioBean.getUsuarioLogado());
        }
        return this.lista;
    }

    public void setLista(List<InstituicaoEnsino> lista) {
        this.lista = lista;
    }

    public void salvar() {

        if(ValidaData.validar(this.instituicaoEnsino.getData_inicio(), this.instituicaoEnsino.getData_final())){
        }
        else{
        UsuarioBean usuarioBean = ContextoUtil.getUsuarioBean();
        this.instituicaoEnsino.setUsuario(usuarioBean.getUsuarioLogado());

        InstituicaoEnsinoRN instituicaoRN = new InstituicaoEnsinoRN();

        instituicaoRN.salvar(instituicaoEnsino);

        System.out.println("Instituição de Ensino Inserida com Sucesso");

        MensagemContexto.adicionarMensagem("Instituição de Ensino adcionada com sucesso.");


        /* Nova instancia de formação profissional para limpar os dados e  lista
        recebe NULL para forçar o recarregamento no metodo Listar*/
        this.instituicaoEnsino = new InstituicaoEnsino();
        this.lista = null;
        }
    }

    public void excluir() {
        InstituicaoEnsinoRN instituicaoRN = new InstituicaoEnsinoRN();
        instituicaoRN.excluir(instituicaoEnsino);

        MensagemContexto.adicionarMensagem("Instituição de Ensino excluída com sucesso.");

        this.instituicaoEnsino = new InstituicaoEnsino();
        this.lista = null;
    }
}

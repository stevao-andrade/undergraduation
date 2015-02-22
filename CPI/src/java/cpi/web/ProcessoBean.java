/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import cpi.controler.AnoDAO;
import cpi.controler.PlenariaDAO;
import cpi.controler.ProcessoDAO;
import cpi.controler.ServicoDAO;
import cpi.modelo.Ano;
import cpi.modelo.Plenaria;
import cpi.modelo.Processo;
import cpi.modelo.Servico;
import cpi.usuario.Usuario;
import cpi.util.HibernateUtil;
import cpi.util.MensagemContexto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author stevao
 */
@ManagedBean
@ViewScoped
public class ProcessoBean implements Serializable {

    private Usuario user;
    private Processo processo = new Processo();
    private Processo processoView = new Processo();
    private List<Servico> listaServicos;
    private List<Plenaria> listaPlenarias;
    private List<Ano> listaAno = new ArrayList<Ano>();
    private List<Processo> lista = null;

    public Processo getProcessoView() {
        return processoView;
    }

    public void setProcessoView(Processo processoView) {
        this.processoView = processoView;
    }

    
    public void setListaAno(List<Ano> listaAno) {
        this.listaAno = listaAno;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public List<Processo> getLista() {

        if (this.lista == null) {
            Session s = HibernateUtil.getSession();
            Transaction t = s.beginTransaction();

            ProcessoDAO dao = new ProcessoDAO(s);
            
            this.lista = dao.listar();

            t.commit();
            s.close();
        }
        return this.lista;
    }
    


    public void setListaPlenarias(List<Plenaria> listaPlenarias) {
        this.listaPlenarias = listaPlenarias;
    }

    public List<Plenaria> getListaPlenarias() {
        
        this.listaPlenarias = new ArrayList<Plenaria>();

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        PlenariaDAO dao = new PlenariaDAO(s);


        this.listaPlenarias = dao.listar();

        t.commit();
        s.close();

        return this.listaPlenarias;
    }

    public List<Servico> getListaServicos() {
        
        this.listaServicos = new ArrayList<Servico>();
        
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        ServicoDAO dao = new ServicoDAO(s);

        List<Servico> listaLocal = new ArrayList<Servico>();
        
        this.listaServicos = dao.listar();
        
        t.commit();
        s.close();

        return listaServicos;
    }

    public List<Ano> getListaAno() {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        AnoDAO dao = new AnoDAO(s);

        this.listaAno = dao.listar();

        t.commit();
        s.close();

        return listaAno;
    }

    public void salvarProcesso() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        ProcessoDAO dao = new ProcessoDAO(s);

        dao.salvar(processo);

        t.commit();
        s.close();

        MensagemContexto.adicionarMensagem("Processo adcionado com sucesso.");

        this.processo = new Processo();
        this.lista = null;
    }

    public void excluir() {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        ProcessoDAO dao = new ProcessoDAO(s);

        System.out.println(processo.getRequerente());

        dao.excluir(processo);

        t.commit();
        s.close();

        if (this.processo.getRequerente() != null) {
            MensagemContexto.adicionarMensagem("Processo " + this.processo.getRequerente() + " excluido com sucesso.");
        }

        this.processo = new Processo();
        this.lista = null;
    }

    public void exibirDialogExcluir() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        requisicao.execute("confirmacao.show()"); //executa o componente dialog
    }

    public void exibirDialogDetalhes() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        requisicao.execute("detalhes.show()"); //executa o componente dialog
    }
}

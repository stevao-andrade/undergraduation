/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import cpi.controler.FiscalizacaoDAO;
import cpi.modelo.Fiscalizacao;
import cpi.util.HibernateUtil;
import cpi.util.MensagemContexto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author stevao
 */
@ManagedBean
@ViewScoped
public class FiscalizacaoBean implements Serializable {

    private Fiscalizacao fiscalizacao = new Fiscalizacao();
    private Fiscalizacao fiscalizacaoView = new Fiscalizacao();
    private List<Fiscalizacao> lista = null;
    private List<SelectItem> listaStatus;
    private List<SelectItem> listaTipoFiscalizacao;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fiscalizacao getFiscalizacaoView() {
        return fiscalizacaoView;
    }

    public void setFiscalizacaoView(Fiscalizacao fiscalizacaoView) {
        this.fiscalizacaoView = fiscalizacaoView;
    }

    public List<Fiscalizacao> getLista() {

        if (this.lista == null) {
            Session s = HibernateUtil.getSession();
            Transaction t = s.beginTransaction();

            FiscalizacaoDAO dao = new FiscalizacaoDAO(s);
            this.lista = dao.listar();

            t.commit();
            s.close();
        }
        return this.lista;
    }

    public void setLista(List<Fiscalizacao> lista) {
        this.lista = lista;
    }

    public Fiscalizacao getFiscalizacao() {
        return fiscalizacao;
    }

    public void setFiscalizacao(Fiscalizacao fiscalizacao) {
        this.fiscalizacao = fiscalizacao;
    }

    public List<SelectItem> getListaTipoFiscalizacao() {

        this.listaTipoFiscalizacao = new ArrayList<SelectItem>();

        SelectItem item = new SelectItem("Falta de Registro no CRA-PI", "Falta de Registro no CRA-PI");
        SelectItem item2 = new SelectItem("Falta de pagamento da Anuidade devida", "Falta de pagamento da Anuidade devida");
        SelectItem item3 = new SelectItem("Falta do Responsável Técnico", "Falta do Responsável Técnico");
        SelectItem item4 = new SelectItem("Outras Infrações", "Outras Infrações");

        this.listaTipoFiscalizacao.add(item);
        this.listaTipoFiscalizacao.add(item2);
        this.listaTipoFiscalizacao.add(item3);
        this.listaTipoFiscalizacao.add(item4);

        return listaTipoFiscalizacao;
    }

    public void setListaTipoFiscalizacao(List<SelectItem> listaTipoFiscalizacao) {
        this.listaTipoFiscalizacao = listaTipoFiscalizacao;
    }

    public void atualizaSelect(ValueChangeListener evt) {
        System.out.println(this.status);
    }
    
    public List<SelectItem> getListaStatus() {

        this.listaStatus = new ArrayList<SelectItem>();

        SelectItem item = new SelectItem("Em Andamento", "Em Andamento");
        SelectItem item2 = new SelectItem("Regularizado", "Regularizado");
        SelectItem item3 = new SelectItem("Arquivado", "Arquivado");
        SelectItem item4 = new SelectItem("Recurso ao CFA", "Recurso ao CFA");
        SelectItem item5 = new SelectItem("Execução Judicial", "Execução Judicial");

        this.listaStatus.add(item);
        this.listaStatus.add(item2);
        this.listaStatus.add(item3);
        this.listaStatus.add(item4);
        this.listaStatus.add(item5);

        return listaStatus;
    }

    public void setListaStatus(List<SelectItem> listaStatus) {
        this.listaStatus = listaStatus;
    }

    public void salvarFiscalizacao() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        FiscalizacaoDAO dao = new FiscalizacaoDAO(s);

        dao.salvar(this.fiscalizacao);

        t.commit();
        s.close();

        MensagemContexto.adicionarMensagem("Fiscalização adcionada com sucesso.");

        this.fiscalizacao = new Fiscalizacao();
        this.lista = null;
    }

    public void excluir() {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        FiscalizacaoDAO dao = new FiscalizacaoDAO(s);

        dao.excluir(this.fiscalizacao);

        t.commit();
        s.close();

        if (!"".equals(this.fiscalizacao.getProcesso())) {
            MensagemContexto.adicionarMensagem("Fiscalização de processo " + this.fiscalizacao.getProcesso() + " excluida com sucesso.");
        }

        this.fiscalizacao = new Fiscalizacao();
        this.lista = null;
    }

    public void exibirDialogDetalhes() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        requisicao.execute("detalhes.show()"); //executa o componente dialog
    }

    public void exibirDialogExcluir() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        requisicao.execute("confirmacao.show()"); //executa o componente dialog
    }


}

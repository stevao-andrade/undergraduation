/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import cpi.controler.RcaDAO;
import cpi.modelo.RCA;
import cpi.util.HibernateUtil;
import cpi.util.MensagemContexto;
import java.io.Serializable;
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
public class RcaBean implements Serializable{

    private RCA rca = new RCA();
    private List<RCA> lista = null;
    private RCA rcaView = new RCA();

    public RCA getRcaView() {
        return rcaView;
    }

    public void setRcaView(RCA rcaView) {
        this.rcaView = rcaView;
    }
    
    public RCA getRca() {
        return rca;
    }

    public void setRca(RCA rca) {
        this.rca = rca;
    }

    public List<RCA> getLista() {

        if (this.lista == null) {
            Session s = HibernateUtil.getSession();
            Transaction t = s.beginTransaction();

            RcaDAO dao = new RcaDAO(s);
            this.lista = dao.listar();

            t.commit();
            s.close();
        }
        return this.lista;
    }

    public void setLista(List<RCA> lista) {
        this.lista = lista;
    }

    public void salvarRCA() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        RcaDAO dao = new RcaDAO(s);

        dao.salvar(rca);

        t.commit();
        s.close();

        MensagemContexto.adicionarMensagem("RCA adcionada com sucesso.");

        this.rca = new RCA();
        this.lista = null;
    }

    public void excluir() {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        RcaDAO dao = new RcaDAO(s);

        dao.excluir(this.rca);

        t.commit();
        s.close();

        if (!"".equals(this.rca.getNumeroEmpresa())) {
            MensagemContexto.adicionarMensagem("RCA de numero " + this.rca.getNumero() + " excluida com sucesso.");
        }

        this.rca = new RCA();
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

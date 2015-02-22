/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import cpi.controler.AnoDAO;
import cpi.controler.CertidaoDAO;
import cpi.modelo.Ano;
import cpi.modelo.Certidao;
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
public class CertidaoBean implements Serializable{

    private Certidao certidaoView = new Certidao();
    private Certidao certidao = new Certidao();
    private List<Ano> listaAno = new ArrayList<Ano>();
    private List<Certidao> lista = null;

    public Certidao getCertidaoView() {
        return certidaoView;
    }

    public void setCertidaoView(Certidao certidaoView) {
        this.certidaoView = certidaoView;
    }
    
    public List<Certidao> getLista() {

        if (this.lista == null) {
            Session s = HibernateUtil.getSession();
            Transaction t = s.beginTransaction();

            CertidaoDAO dao = new CertidaoDAO(s);
            this.lista = dao.listar();

            t.commit();
            s.close();
        }
        return this.lista;
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

    public void salvarCertidao() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        CertidaoDAO dao = new CertidaoDAO(s);

        dao.salvar(certidao);

        t.commit();
        s.close();

        MensagemContexto.adicionarMensagem("Certidão adcionada com sucesso.");

        this.certidao = new Certidao();
        this.lista = null;
    }

    public void excluir() {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        CertidaoDAO dao = new CertidaoDAO(s);

        dao.excluir(this.certidao);

        t.commit();
        s.close();

        if (this.certidao.getRequerente() != null) {
            MensagemContexto.adicionarMensagem("Certidão de " + this.certidao.getRequerente() + " excluida com sucesso.");
        }

        this.certidao = new Certidao();
        this.lista = null;
    }

    public void exibirDialogDetalhes() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        requisicao.execute("detalhes.show()"); //executa o componente dialog
    }

    public void exibirDialogExcluir() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        System.out.println(this.certidao.getRequerente());
        requisicao.execute("confirmacao.show()"); //executa o componente dialog
    }

    public Certidao getCertidao() {
        return certidao;
    }

    public void setCertidao(Certidao certidao) {
        this.certidao = certidao;
    }

    public void setListaAno(List<Ano> listaAno) {
        this.listaAno = listaAno;
    }


}

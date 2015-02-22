/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import cpi.controler.CertidaoDAO;
import cpi.controler.FiscalizacaoDAO;
import cpi.controler.ProcessoDAO;
import cpi.controler.RcaDAO;
import cpi.modelo.Certidao;
import cpi.modelo.Fiscalizacao;
import cpi.modelo.Processo;
import cpi.modelo.RCA;
import cpi.util.HibernateUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Stevao
 */
@ManagedBean
@SessionScoped
public class AtualizacaoBean implements Serializable {

    private Fiscalizacao fiscalizacao = new Fiscalizacao();
    private Certidao certidao = new Certidao();
    private Processo processo = new Processo();
    private RCA rca = new RCA();

    public Certidao getCertidao() {
        return certidao;
    }

    public void setCertidao(Certidao certidao) {
        this.certidao = certidao;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public RCA getRca() {
        return rca;
    }

    public void setRca(RCA rca) {
        this.rca = rca;
    }

    public Fiscalizacao getFiscalizacao() {
        return fiscalizacao;
    }

    public void setFiscalizacao(Fiscalizacao fiscalizacao) {
        this.fiscalizacao = fiscalizacao;
    }

    public String atualizarFiscalizacao() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        FiscalizacaoDAO dao = new FiscalizacaoDAO(s);

        dao.salvar(this.fiscalizacao);

        t.commit();
        s.close();

        return "/restrito/fiscalizacao.xhtml";

    }

    public String atualizarRCA() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        RcaDAO dao = new RcaDAO(s);

        dao.salvar(this.rca);

        t.commit();
        s.close();

        return "/restrito/rca.xhtml";

    }

    public String atualizarCertidao() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        CertidaoDAO dao = new CertidaoDAO(s);

        dao.salvar(this.certidao);

        t.commit();
        s.close();

        return "/restrito/certidoes.xhtml";
    }

    public String atualizarProcesso() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        ProcessoDAO dao = new ProcessoDAO(s);

        dao.salvar(this.processo);

        t.commit();
        s.close();

        return "/restrito/processos.xhtml";

    }
}

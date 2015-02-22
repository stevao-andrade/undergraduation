/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.model;


/**
 *
 * @author fj_informatica
 */
public class HabilidadeValor {


    private boolean bancoDeDados;
    private boolean css;
    private boolean c;
    private boolean ia;
    private boolean java;
    private boolean suporte;
    private boolean delphi;
    private boolean design;
    private boolean html;
    private boolean php;
    private boolean redes;
    private boolean ruby;
    private String outros;

    public HabilidadeValor() {
    }




    public boolean isBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(boolean bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean isCss() {
        return css;
    }

    public void setCss(boolean css) {
        this.css = css;
    }

    public boolean isDelphi() {
        return delphi;
    }

    public void setDelphi(boolean delphi) {
        this.delphi = delphi;
    }

    public boolean isDesign() {
        return design;
    }

    public void setDesign(boolean design) {
        this.design = design;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    public boolean isIa() {
        return ia;
    }

    public void setIa(boolean ia) {
        this.ia = ia;
    }

    public boolean isJava() {
        return java;
    }

    public void setJava(boolean java) {
        this.java = java;
    }


    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }


    public boolean isPhp() {
        return php;
    }

    public void setPhp(boolean php) {
        this.php = php;
    }

    public boolean isRedes() {
        return redes;
    }

    public void setRedes(boolean redes) {
        this.redes = redes;
    }

    public boolean isRuby() {
        return ruby;
    }

    public void setRuby(boolean ruby) {
        this.ruby = ruby;
    }

    public boolean isSuporte() {
        return suporte;
    }

    public void setSuporte(boolean suporte) {
        this.suporte = suporte;
    }
  

}

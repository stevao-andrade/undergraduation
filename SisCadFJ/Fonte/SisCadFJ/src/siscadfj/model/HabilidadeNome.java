/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.model;

/**
 *
 * @author Stevao
 */
public class HabilidadeNome {
    
    private int idHab;
    private String nomeHab;


    public HabilidadeNome() {
    }



    public HabilidadeNome(int idHab, String nomeHab) {
        this.idHab = idHab;
        this.nomeHab = nomeHab;
    }

   

    public int getIdHab() {
        return idHab;
    }

    public void setIdHab(int idHab) {
        this.idHab = idHab;
    }

    public String getNomeHab() {
        return nomeHab;
    }

    public void setNomeHab(String nomeHab) {
        this.nomeHab = nomeHab;
    }



}

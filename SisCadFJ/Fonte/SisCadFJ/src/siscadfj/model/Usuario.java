/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.model;

/**
 *
 * @author fj_informatica
 */
public class Usuario {

    private String user;
    private String pass;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    

}

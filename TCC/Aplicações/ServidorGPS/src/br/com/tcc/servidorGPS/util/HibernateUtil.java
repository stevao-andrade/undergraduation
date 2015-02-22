/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.servidorGPS.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author stevao
 * 
 * Classe para criar sessão do  Hibernate
 */
public class HibernateUtil {
    
    private static  SessionFactory factory;

    static {
        
        Configuration cfg = new AnnotationConfiguration();
        cfg.configure("hibernate.cfg.xml");
        
        factory = cfg.buildSessionFactory();            
    }
    
    public static Session getSession(){
        return factory.openSession();
    }
    
}

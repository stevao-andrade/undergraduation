package br.com.egresso.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 *
 * @author Stevão Andrade
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory = buildSessisonFactory();

    private static SessionFactory buildSessisonFactory() {
        try{
            AnnotationConfiguration cfg = new AnnotationConfiguration();
            cfg.configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
        }catch(Throwable e){
            System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
            throw new ExceptionInInitializerError(e);            
        }            
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
}

package DAO;

import Entity.Categorie;
import Entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CategorieDao {

    private SessionFactory factory;

    public CategorieDao(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Categorie.class)
                .buildSessionFactory();
    }
    public void save(Categorie entity){
        Session session= factory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }finally{
            session.close();
        }
    }
}

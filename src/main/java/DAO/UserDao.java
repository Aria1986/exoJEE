package DAO;

import Entity.Category;
import Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDao {

    private SessionFactory factory;

    public UserDao(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
    public void save(User user){
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }


}

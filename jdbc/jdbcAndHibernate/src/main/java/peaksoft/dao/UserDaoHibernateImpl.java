package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.util.Util;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();


    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        SessionFactory session1 = Util.getSession();
        Session session = session1.openSession();
        session.beginTransaction();
        session.persist(name);
        session.persist(lastName);
        session.persist(age);
        session.getTransaction().commit();
        session.close();
        System.out.println(name + "is added to database");

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
//        Session session = Util.getSession().openSession();
//        session.beginTransaction();
//        List<User> students =session.createQuery("select u from User u").getResultList();
//        session.getTransaction().commit();
//        session.close();
//        return students ;
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}

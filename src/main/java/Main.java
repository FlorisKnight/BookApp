import com.fasterxml.classmate.AnnotationConfiguration;
import models.Book;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        /*
        Book book = new Book();
        book.setId(1);
        book.setName("Fear: Trump in the White House");
        book.setAuthor("Bob Woodward");
        */

        User user = new User();
        user.setUsername("Username");
        user.setEmail("poep@poep.nl");
        user.setPassword("wachtwoord");
/*
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        entityManager.close();*/

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        //session.save(user);


        List users = session.createCriteria(User.class)
                .add( Restrictions.eq("username", "Username"))
                .add( Restrictions.eq("email", "poep@poep.nl"))
                .list();

        for (Object o: users){
            User u = (User)o;
            user = u;
            System.out.println(u.getId());
        }

        user = (User) users.get(0);
        //user = session.get(User.class, user.getId());
        session.remove(user);
        /*
        user = session.get(User.class, 1);
        user.setUsername("Test");
        session.update(user);
*/
        /*String hql = "FROM dbi359176.users U WHERE U.username = 'username'";
        Query query = session.createQuery(hql);
        System.out.println(user1.getEmail());*/

        session.getTransaction().commit();
        session.close();

    }
}

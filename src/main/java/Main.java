import models.Book;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Book book = new Book();
        book.setId(1);
        book.setName("Fear: Trump in the White House");
        book.setAuthor("Bob Woodward");

        User user = new User();
        user.setId(1);
        user.setEmail("poep@poep.nl");
        user.setPassword("wachtwoord");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(book);
        entityManager.persist(user);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}

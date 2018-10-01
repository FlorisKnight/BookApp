package restAPI;

import models.Book;
import models.User;
import models.UsersBooksColumn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class BookAppRestDB implements IBookAppRestDB{


    public int Login(String loginData, String password) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List users = session.createCriteria(User.class)
                    .add(Restrictions.or(
                            Restrictions.eq("username", loginData),
                            Restrictions.eq("email", loginData)
                    ))
                    .add(Restrictions.eq("password", password))
                    .list();

            User u = (User)users.get(0);

            if (users.size() > 0)
                return u.getId();
            else
                return -1;
        } catch (Exception e){
            System.out.println(e);
            return -1;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean CheckAvailability(String username, String email) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List users = session.createCriteria(User.class)
                    .add(Restrictions.or(
                            Restrictions.eq("username", username),
                            Restrictions.eq("email", email)
                    ))
                    .list();

            if (users.size() > 0)
                return true;
            else
                return false;
        } catch (Exception e){
            System.out.println(e);
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean Register(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            session.save(user);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean CheckDuplicate(String name, String author) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List books = session.createCriteria(Book.class)
                    .add( Restrictions.eq("author", author))
                    .add( Restrictions.eq("name", name))
                    .list();

            if (books.size() > 0)
                return false;
            else
                return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public void AddBook(String name, String author) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            session.save(book);
        } catch (Exception e){
            System.out.println(e);
        }finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public Book GetBook(String name, String author) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List books = session.createCriteria(Book.class)
                    .add( Restrictions.eq("author", author))
                    .add( Restrictions.eq("name", name))
                    .list();

            return (Book) books.get(1);
        } catch (Exception e){
            System.out.println(e);
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean MoveBook(int bookId, int userId, int listId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List userbookcolums = session.createCriteria(UsersBooksColumn.class)
                    .add( Restrictions.eq("bookId", bookId))
                    .add( Restrictions.eq("userId", userId))
                    .list();

            if (userbookcolums.size() > 0){
                UsersBooksColumn ubc = (UsersBooksColumn) userbookcolums.get(0);
                ubc.setColumnId(listId);
                session.update(ubc);
            }
            else {
                UsersBooksColumn ubc = new UsersBooksColumn();
                ubc.setBookId(bookId);
                ubc.setUserId(userId);
                ubc.setColumnId(listId);

                session.save(ubc);
            }


            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public ArrayList<Book> LoadBooks(int userId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        ArrayList<Book> booklist = new ArrayList<>();
        try {
            String hql = "SELECT DISTINCT * FROM books WHERE books.id = usersbookscolumn.bookId AND users.bookId = "+ userId;

            List books = session.createQuery(hql).list();

            for (Object o: books){
                booklist.add((Book)o);
            }

            return booklist;
        } catch (Exception e){
            System.out.println(e);
            return booklist;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public void RemoveBook(int bookId, int userId) {SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List books = session.createCriteria(UsersBooksColumn.class)
                    .add( Restrictions.eq("userId", userId))
                    .add( Restrictions.eq("bookId", bookId))
                    .list();

            UsersBooksColumn ubc = (UsersBooksColumn) books.get(0);
            ubc = session.get(UsersBooksColumn.class, ubc.getId());
            session.remove(ubc);

        } catch (Exception e){
            System.out.println(e);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}

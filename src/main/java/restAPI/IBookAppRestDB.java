package restAPI;

import models.Book;

import java.util.ArrayList;

public interface IBookAppRestDB {
    //Login
    int Login(String loginData, String password);

    //Register
    boolean CheckAvailability(String username, String email);

    boolean Register(String username, String email, String password);

    //Add book
    boolean CheckDuplicate (String name, String author);

    void AddBook(String name, String author);

    Book GetBook(String name, String author);

    //Move Book
    boolean MoveBook(int bookId, int userId, int listId);

    //Load Books
    ArrayList<Book> LoadBooks(int userId);

    //Remove Book
    void RemoveBook(int bookId, int userId);
}

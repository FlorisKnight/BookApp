package restAPI;

import models.Book;

import java.util.ArrayList;

public interface IBookAppRestLogic {
    //Login
    //loginData can be email or username
    int Login(String loginData, String password);

    //Register
    boolean Register(String username, String email, String password);

    //Add book
    Book AddBook(String name, String author);

    //Move Book
    boolean MoveBook(int bookId, int userId, int listId);

    //Load Books
    ArrayList<Book> LoadBooks(int userId);

    //Remove Book
    void RemoveBook(int bookId, int userId);

}

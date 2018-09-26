package restAPI;

import models.Book;

import java.util.ArrayList;

public class BookAppRestLogic implements IBookAppRestLogic{
    private IBookAppRestDB orm;

    public BookAppRestLogic(IBookAppRestDB orm) {
        this.orm = orm;
    }


    public int Login(String loginData, String password) {
        if (CheckString(loginData) && CheckString(password)){
            int userId = orm.Login(loginData, password);
            return userId;
        }
            return -1;
    }

    public boolean Register(String username, String email, String password) {
        if (CheckString(username) && CheckString(email) && CheckString(password)){
            if (orm.CheckAvailability(username,email)){
                orm.Register(username,email,password);
                return true;
            }
        }
        return false;
    }


    public Book AddBook(String name, String author) {
        if (CheckString(name) && CheckString(author)){
            if (orm.CheckDuplicate(name, author)){
                orm.AddBook(name,author);
            }
            return orm.GetBook(name,author);
        }
        Book book = new Book();
        book.setId(-1);
        return book;
    }

    public boolean MoveBook(int bookId, int userId, int listId) {
        if (listId >= 0 && listId <= 2 && orm.MoveBook(bookId, userId, listId)){
            return true;
        }
        return false;
    }

    public ArrayList<Book> LoadBooks(int userId) {
        return orm.LoadBooks(userId);
    }

    public void RemoveBook(int bookId, int userId) {
        orm.RemoveBook(bookId, userId);
    }

    private boolean CheckString(String text){
        //Regex this shit
        return true;
    }
}

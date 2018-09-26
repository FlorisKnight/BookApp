package restAPI;

import models.Book;

import java.util.ArrayList;

public class BookAppRestDB implements IBookAppRestDB{

    public int Login(String loginData, String password) {
        //Try to find which person it is with or statement
        //Catch returns -1
        return 0;
    }

    public boolean CheckAvailability(String username, String email) {
        return false;
    }

    public boolean Register(String username, String email, String password) {
        return false;
    }

    public boolean CheckDuplicate(String name, String author) {
        return false;
    }

    public void AddBook(String name, String author) {

    }

    public Book GetBook(String name, String author) {
        return null;
    }

    public boolean MoveBook(int bookId, int userId, int listId) {
        try {

        } catch (Exception e){

        }
        return false;
    }

    public ArrayList<Book> LoadBooks(int userId) {
        return null;
    }

    public void RemoveBook(int bookId, int userId) {

    }
}

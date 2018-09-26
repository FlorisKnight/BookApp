package shared.dto.result;

import models.Book;
import shared.dto.BaseResultDto;

import java.util.ArrayList;

public class LoadBooksResultDto extends BaseResultDto {
    ArrayList<Book> books;

    public LoadBooksResultDto(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

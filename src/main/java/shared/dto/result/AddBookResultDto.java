package shared.dto.result;

import models.Book;
import shared.dto.BaseResultDto;

public class AddBookResultDto extends BaseResultDto {
    Book book;

    public AddBookResultDto(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}

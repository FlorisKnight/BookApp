package shared.dto.request;

import shared.dto.BaseRequestDto;

public class AddBookRequestDto extends BaseRequestDto {
    String name;
    String author;

    public AddBookRequestDto(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}

package shared.dto.request;

import shared.dto.BaseRequestDto;

public class RemoveBookRequestDto extends BaseRequestDto {
    int bookId;
    int userId;

    public RemoveBookRequestDto(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }
}

package shared.dto.request;

import shared.dto.BaseRequestDto;

public class MoveBookRequestDto extends BaseRequestDto {
    int bookId;
    int userId;
    int listId;

    public MoveBookRequestDto(int bookId, int userId, int listId) {
        this.bookId = bookId;
        this.userId = userId;
        this.listId = listId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public int getListId() {
        return listId;
    }
}

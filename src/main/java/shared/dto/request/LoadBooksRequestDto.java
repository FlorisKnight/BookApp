package shared.dto.request;

import shared.dto.BaseRequestDto;

public class LoadBooksRequestDto extends BaseRequestDto {
    int userId;

    public LoadBooksRequestDto(int userId){
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

}

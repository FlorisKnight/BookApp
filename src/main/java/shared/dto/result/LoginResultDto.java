package shared.dto.result;

import shared.dto.BaseResultDto;

public class LoginResultDto extends BaseResultDto {
    int userId;

    public LoginResultDto(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}

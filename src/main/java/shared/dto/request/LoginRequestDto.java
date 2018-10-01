package shared.dto.request;

import shared.dto.BaseRequestDto;

public class LoginRequestDto extends BaseRequestDto {
    String loginData;
    String password;

    public LoginRequestDto(String loginData, String password) {
        this.loginData = loginData;
        this.password = password;
    }

    public String getLoginData() {
        return loginData;
    }

    public String getPassword() {
        return password;
    }

}

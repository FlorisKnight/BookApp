package shared.dto.request;

import shared.dto.BaseRequestDto;

public class RegisterRequestDto extends BaseRequestDto {
    String username;
    String email;
    String password;

    public RegisterRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

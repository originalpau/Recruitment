package se.kth.iv1201.recruitment.auth;

import lombok.Data;
import se.kth.iv1201.recruitment.user.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class AuthUserDTO {
    @NotEmpty(message = "First name is required")
    private String name;
    @NotEmpty(message = "Last name is required")
    private String surname;
    @NotEmpty(message = "Person number is required")
    private String pnr;
    @NotEmpty(message = "Email is is required")
    @Email(message = "The email address is invalid.")
    private String email;
    @NotEmpty(message = "Username is is required")
    private String username;
    @NotEmpty(message = "Password is is required")
    private String password;

    public User toUser() {
        return new User(name,
                surname,
                pnr,
                email.toLowerCase(),
                username,
                password);
    }
}

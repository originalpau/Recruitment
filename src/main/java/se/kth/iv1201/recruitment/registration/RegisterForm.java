package se.kth.iv1201.recruitment.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.iv1201.recruitment.user.Role;
import se.kth.iv1201.recruitment.user.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterForm {
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
                password,
                new Role());
    }
}

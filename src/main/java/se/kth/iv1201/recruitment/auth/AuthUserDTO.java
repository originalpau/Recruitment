package se.kth.iv1201.recruitment.auth;

import lombok.Data;
import se.kth.iv1201.recruitment.user.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * A form bean for the registration form.
 * Validates the fields in the register form.
 */
@Data
public class AuthUserDTO {

    @NotEmpty(message = "First name is required")
    private String name;

    @NotEmpty(message = "Last name is required")
    private String surname;

    @NotEmpty(message = "Person number is required")
    @Pattern(regexp = "^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])\\-\\d{4}$",
            message = "Please enter a valid format, YYYYMMDD-NNNNN, for your person number")
    private String pnr;

    @NotEmpty(message = "Email is is required")
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @Size(min = 3, max = 20, message = "The username must be between 3 to 20 characters long")
    @NotEmpty(message = "Username is is required")
    private String username;

    @Size(min = 3, max = 20, message = "The password must be between 3 to 20 characters long")
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

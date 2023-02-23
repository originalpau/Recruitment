package se.kth.iv1201.recruitment.auth;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Handles all HTTP requests related to authentication.
 */
@Controller
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    /**
     * A get request for the login page.
     * 
     * @return The login page url.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * A get request to show the registration form.
     *
     * @param model Model objects used by the register page.
     * @return The registration page url.
     */
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new AuthUserDTO());
        return "register";
    }

    /**
     * The registration form has been submitted.
     * This method validates the fields,
     * and ensures that the username and email are not registered in our system since before.
     *
     * @param userDTO Content of the register user form.
     * @param bindingResult Validation results for the register form.
     * @param model Model objects used by the register page.
     * @return The registration page with a confirmation message if the registration succeeds.
     */
    @PostMapping("/register")
    public String register(@ModelAttribute("userDTO") @Valid AuthUserDTO userDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (authService.emailExists(userDTO)) {
            bindingResult.rejectValue("email", "userDTO.email", "Email already registered.");
            return "register";
        }


        if (authService.usernameExists(userDTO)) {
            bindingResult.rejectValue("username", "userDTO.username", "Username already taken.");
            return "register";
        }

        authService.register(userDTO);
        return "redirect:/register?success";
    }

}

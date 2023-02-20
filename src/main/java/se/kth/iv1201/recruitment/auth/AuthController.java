package se.kth.iv1201.recruitment.auth;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new AuthUserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userDTO") @Valid AuthUserDTO userDTO) {
        authService.register(userDTO);
        return "redirect:/register?success";
    }

}

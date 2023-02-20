package se.kth.iv1201.recruitment.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.kth.iv1201.recruitment.auth.AuthService;

@Controller
public class UserController {

    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/applications")
    public String applications() {
        return "applications";
    }

}
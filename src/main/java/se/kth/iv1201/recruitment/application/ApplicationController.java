package se.kth.iv1201.recruitment.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.kth.iv1201.recruitment.auth.AuthService;

/**
 * Handles HTTP requests for applications.
 */
@Controller
public class ApplicationController {

    /**
     * No page is specified, show home page.
     *
     * @return A response that shows index page url.
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * A get request to view applications page. This page can only be accessed by recruiters.
     *
     * @return The applications' web page url.
     */
    @GetMapping("/applications")
    public String applications() {
        return "applications";
    }

}
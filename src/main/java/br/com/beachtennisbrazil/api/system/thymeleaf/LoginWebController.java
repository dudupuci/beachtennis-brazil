package br.com.beachtennisbrazil.api.system.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginWebController {

    @GetMapping(value = "dashboard/login")
    public String login(Model model) {
        return "login";
    }
}

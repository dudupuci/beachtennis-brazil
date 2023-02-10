package br.com.beachtennisbrazil.api.app.controllers.thymeleaf;

import br.com.beachtennisbrazil.api.system.serviceimpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {
    @Autowired
    private LoginService service;


    // vai ler o path
    @GetMapping(value = "/logins")
    public String listLogins(Model model) {
        model.addAttribute("logins", service.findAllUsernames());
        // é o que retorna a pagina, não precisa passar .html
        return "index";
    }
}
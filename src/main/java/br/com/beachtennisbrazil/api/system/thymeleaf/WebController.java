package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.system.serviceimpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/*
O Value sempre irá ler o path da página a ser aberta
O return sempre irá referenciar a página (não precisa passar .html)
 */

@Controller
public class WebController {
    @Autowired
    private LoginService service;


    @GetMapping(value = "/home")
    public String acessHome() {
        return "home";
    }

}
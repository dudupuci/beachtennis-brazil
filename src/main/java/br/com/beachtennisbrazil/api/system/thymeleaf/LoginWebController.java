package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.repositories.LoginRepository;
import br.com.beachtennisbrazil.api.system.serviceimpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginWebController {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private LoginService service;

    @GetMapping (value = "dashboard/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/list-logins")
    public ModelAndView getAllLogins() {
        ModelAndView mav = new ModelAndView("list-logins");
        List<Login> list = service.findAllUsernames();
        mav.addObject("logins", list);
        return mav;
    }
}

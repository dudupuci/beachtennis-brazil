package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.system.dto.LoginDTO;
import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.entities.Register;
import br.com.beachtennisbrazil.api.system.repositories.LoginRepository;
import br.com.beachtennisbrazil.api.system.serviceimpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginWebController {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private LoginService service;

    @GetMapping("dashboard/login")
    public ModelAndView tryConnect() {
        ModelAndView mav = new ModelAndView("login");
        Login login = new Login();
        mav.addObject("login", login);
        return mav;
    }

    @PostMapping("/authenticate")
    public String authenticate(@ModelAttribute Login login) {
        service.authenticate(login);
        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    public ModelAndView getAllLoginsHome() {
        ModelAndView mav = new ModelAndView("home");
        List<Login> list = service.findAllUsernames();
        mav.addObject("logins", list);
        return mav;
    }
}

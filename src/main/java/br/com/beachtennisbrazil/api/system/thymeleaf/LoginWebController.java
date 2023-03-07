package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.app.dto.PlayerSystemAccessDto;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.system.entities.Login;
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

    @GetMapping("admin/login")
    public ModelAndView tryConnectAdmin() {
        ModelAndView mav = new ModelAndView("login-admin");
        Login login = new Login();
        mav.addObject("login", login);
        return mav;
    }

    @GetMapping("player/login")
    public ModelAndView tryConnectPlayer() {
        ModelAndView mav = new ModelAndView("login-player");
        Player player = new Player();
        mav.addObject("player", player);
        return mav;
    }

    @PostMapping("/authenticate")
    public String authenticate(@ModelAttribute Login login) {
        service.authenticate(login);
        return "redirect:/home";
    }

    @PostMapping("/authenticatePlayer")
    public String authenticatePlayer(@ModelAttribute PlayerSystemAccessDto dto) {
        service.authenticatePlayer(dto);
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

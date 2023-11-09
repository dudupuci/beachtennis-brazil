package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.app.dto.PlayerSystemAccessDto;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.system.entities.Register;
import br.com.beachtennisbrazil.api.system.serviceimpl.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterWebController {

    @Autowired
    private RegisterService service;

    @GetMapping("admin/register")
    public ModelAndView addRegisterForm() {
        ModelAndView mav = new ModelAndView("register");
        Register register = new Register();
        mav.addObject("register", register);
        return mav;
    }

    @GetMapping("player/register")
    public ModelAndView addPlayerRegisterForm() {
        ModelAndView mav = new ModelAndView("register-player");
        Player player = new Player();
        mav.addObject("player", player);
        return mav;
    }

    @PostMapping("/saveRegister")
    public String saveRegister(@ModelAttribute Register register) {
        service.convertRegisterToLogin(register);
        return "redirect:/dashboard/login";
    }

    @PostMapping("/savePlayerRegister")
    public String savePlayerRegister(@ModelAttribute Player player) {
        service.convertPlayerSystemRegisterToPlayerLogin(player);
        return "redirect:/player/login";
    }
}

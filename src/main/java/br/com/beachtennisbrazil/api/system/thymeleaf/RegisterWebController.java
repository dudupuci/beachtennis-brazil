package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.system.entities.Register;
import br.com.beachtennisbrazil.api.system.serviceimpl.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterWebController {

    @Autowired
    private RegisterService service;

    @GetMapping("system/register")
    public ModelAndView addRegisterForm() {
        ModelAndView mav = new ModelAndView("register");
        Register register = new Register();
        mav.addObject("register", register);
        return mav;
    }

    @PostMapping("/saveRegister")
    public String saveRegister(@ModelAttribute Register register) {
        service.convertRegisterToLogin(register);
        return "redirect:/list-logins";
    }
}

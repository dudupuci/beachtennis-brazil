package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.app.dto.GameCourtDTO;
import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.repositories.GameCourtRepository;
import br.com.beachtennisbrazil.api.app.serviceimpl.GameCourtService;
import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.entities.Register;
import br.com.beachtennisbrazil.api.system.repositories.LoginRepository;
import br.com.beachtennisbrazil.api.system.serviceimpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class CourtsWebController {

    @Autowired
    private GameCourtService service;

    @GetMapping(value = "/v1/dashboard/courts")
    public ModelAndView getAllLogins() {
        ModelAndView mav = new ModelAndView("courts");
        List<GameCourt> list = service.findAll();
        mav.addObject("game", new GameCourt());
        mav.addObject("courts", list);
        return mav;
    }


    @GetMapping("/delete/{id}")
    public String deleteGameCourt(@PathVariable("id") UUID id, Model model) {
        service.deleteGameCourtById(id);
        return "redirect:/v1/dashboard/courts";
    }

   @GetMapping("/courts")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("courts");
        GameCourt game = new GameCourt();
        mav.addObject("game", game);
        return mav;
    }


    @PostMapping("/saveGame")
    public String saveGame(@ModelAttribute GameCourtDTO game) {
        service.createGameCourt(game.toEntity());
        return "redirect:/v1/dashboard/courts";
    }


}

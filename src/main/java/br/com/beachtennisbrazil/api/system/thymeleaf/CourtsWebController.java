package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.app.dto.BeachTennisGameDto;
import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import br.com.beachtennisbrazil.api.app.entities.GameWithoutAppointment;
import br.com.beachtennisbrazil.api.app.serviceimpl.BeachTennisGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class CourtsWebController {

    @Autowired
    private BeachTennisGameService service;

    @GetMapping(value = "/v1/dashboard/courts")
    public ModelAndView getAllLogins() {
        ModelAndView mav = new ModelAndView("courts");
        List<BeachTennisGame> list = service.findAll();
        mav.addObject("game", new BeachTennisGame());
        mav.addObject("courts", list);
        return mav;
    }


    @GetMapping("/delete/{id}")
    public String deleteBeachTennisGame(@PathVariable("id") UUID id, Model model) {
        service.deleteBeachTennisGameById(id);
        return "redirect:/v1/dashboard/courts";
    }

   @GetMapping("/courts")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("courts");
        BeachTennisGame game = new BeachTennisGame();
        mav.addObject("game", game);
        return mav;
    }


    @PostMapping("/saveGame")
    public String saveGame(@ModelAttribute GameWithoutAppointment game) {
        service.createBeachTennisGame(game);
        return "redirect:/v1/dashboard/courts";
    }


}

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


    @GetMapping(value = "/courts")
    public ModelAndView getAllLogins() {
        ModelAndView mav = new ModelAndView("courts");
        List<GameCourt> list = service.findAll();
        mav.addObject("courts", list);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteGameCourt(@PathVariable("id") UUID id, Model model) {
        service.deleteGameCourtById(id);
        return "redirect:/courts";
    }

    @GetMapping("dashboard/createNewGame")
    public ModelAndView addNewGame() {
        ModelAndView mav = new ModelAndView("gameCourt");
        GameCourtDTO gameCourt = new GameCourtDTO();
        mav.addObject("gameCourt", gameCourt);
        return mav;
    }

    @PostMapping("/createNewGame")
    public String createNewGame(@ModelAttribute GameCourtDTO gameCourt) {
        service.createGameCourt(gameCourt.toEntity());
        return "redirect:/courts";
    }


}

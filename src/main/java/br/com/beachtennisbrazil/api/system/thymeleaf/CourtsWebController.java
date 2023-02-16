package br.com.beachtennisbrazil.api.system.thymeleaf;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.repositories.GameCourtRepository;
import br.com.beachtennisbrazil.api.app.serviceimpl.GameCourtService;
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
public class CourtsWebController {

    @Autowired
    private GameCourtService service;


    @GetMapping(value = "live/courts")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("courts");
        List<GameCourt> list = service.findAll();
        mav.addObject("court", list);
        return mav;
    }

    /*
        <tr th:each="login: ${logins}">
        <td th:text="${login.id}"></td>
        <td th:text="${login.username}"></td>
        <td th:text="${login.password}"></td>
        <td th:text="${login.email}"></td>
    </tr>
    </tbody>
</table>

     */
}

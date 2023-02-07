package br.com.beachtennisbrazil.api.system.controllers;

import br.com.beachtennisbrazil.api.system.entities.Collaborator;
import br.com.beachtennisbrazil.api.system.enums.CollaboratorPaper;
import br.com.beachtennisbrazil.api.system.serviceimpl.CollaboratorService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/collaborators")
@RestController
@CrossOrigin("*")
public class CollaboratorController {

    @Autowired
    private CollaboratorService service;

    @GetMapping(value = "/function")
    public ResponseEntity<List<Collaborator>> findByFunction(
            @RequestParam(required = false, name = "value", defaultValue = "MANAGER") CollaboratorPaper value
    ) {
        var list = service.findByFunction(CollaboratorPaper.valueOf(value.toString()));
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/vacation")
    public ResponseEntity<List<Collaborator>> findByIsOnVacation(
            @RequestParam(required = false, name = "value", defaultValue = "false") Boolean value
    ) {
        var list = service.findByIsOnVacation(value);
        return ResponseEntity.ok().body(list);
    }


}

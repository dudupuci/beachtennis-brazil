package br.com.beachtennisbrazil.api.app.controllers;

import br.com.beachtennisbrazil.api.app.dto.BeachTennisGameDto;
import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import br.com.beachtennisbrazil.api.app.entities.GameWithoutAppointment;
import br.com.beachtennisbrazil.api.app.serviceimpl.BeachTennisGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/games")
@CrossOrigin("*")
public class BeachTennisGameController {

    @Autowired
    private BeachTennisGameService service;

    @GetMapping
    public ResponseEntity<List<BeachTennisGame>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BeachTennisGame> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody GameWithoutAppointment dto) {
        service.createBeachTennisGame(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

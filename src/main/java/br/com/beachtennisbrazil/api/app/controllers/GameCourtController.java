package br.com.beachtennisbrazil.api.app.controllers;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.serviceimpl.GameCourtService;
import br.com.beachtennisbrazil.api.app.serviceimpl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/games")
@CrossOrigin("*")
public class GameCourtController {

    @Autowired
    private GameCourtService service;

    @GetMapping
    public ResponseEntity<List<GameCourt>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameCourt> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<HttpResponse.ResponseInfo> save(@RequestBody GameCourt gameCourt) {
        service.createGameCourt(gameCourt);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

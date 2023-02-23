package br.com.beachtennisbrazil.api.app.controllers;

import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.serviceimpl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/players")
@CrossOrigin("*")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/information")
    public ResponseEntity<List<Player>> findAllInformationFromPlayers() {
        return ResponseEntity.ok().body(service.findAllInformationFromPlayers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Player player) {
        service.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        service.deletePlayerById(id);
        return ResponseEntity.noContent().build();
    }
}

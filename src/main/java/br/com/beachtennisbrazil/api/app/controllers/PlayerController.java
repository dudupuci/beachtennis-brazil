package br.com.beachtennisbrazil.api.app.controllers;

import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.serviceimpl.PlayerService;
import br.com.beachtennisbrazil.api.system.serviceimpl.RegisterService;
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

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerPlayer(@RequestBody Player player) {
        registerService.convertPlayerSystemRegisterToPlayerLogin(player);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered! Username: "+ player.getCpf()+ "code: "+player.getAccessCode());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        service.deletePlayerById(id);
        return ResponseEntity.noContent().build();
    }
}

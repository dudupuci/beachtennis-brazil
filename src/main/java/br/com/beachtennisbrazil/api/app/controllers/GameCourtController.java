package br.com.beachtennisbrazil.api.app.controllers;

import br.com.beachtennisbrazil.api.app.dto.GameCourtDTO;
import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.serviceimpl.GameCourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<GameCourtDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id).toDto());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody GameCourtDTO dto) {
        service.createGameCourt(dto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

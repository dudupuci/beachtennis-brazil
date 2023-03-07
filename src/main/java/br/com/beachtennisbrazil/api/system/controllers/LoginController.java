package br.com.beachtennisbrazil.api.system.controllers;

import br.com.beachtennisbrazil.api.app.dto.PlayerSystemAccessDto;
import br.com.beachtennisbrazil.api.app.serviceimpl.PlayerService;
import br.com.beachtennisbrazil.api.system.dto.LoginDto;
import br.com.beachtennisbrazil.api.system.dto.RecoveryPasswordDto;
import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.serviceimpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Login> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Login>> findAll() {
        return ResponseEntity.ok().body(service.findAllUsernames());
    }

    @PostMapping
    public ResponseEntity<LoginDto> authenticate(@RequestBody @Valid LoginDto loginDto) {
        var authentication = service.authenticate(loginDto.toLogin());
        return ResponseEntity.ok().body(authentication);
    }

    @PostMapping(value = "/player")
    public ResponseEntity<PlayerSystemAccessDto> authenticatePlayer(@RequestBody @Valid PlayerSystemAccessDto loginDto) {
        var authentication = service.authenticatePlayer(loginDto);
        return ResponseEntity.ok().body(authentication);
    }


    @PostMapping(value = "/account-lost")
    public ResponseEntity<LoginDto> recoverPassword(@RequestBody RecoveryPasswordDto recovery) {
        var login = service.recoveryPassword(recovery.getEmail());
        return ResponseEntity.ok().body(login.toDto());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteLogins();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

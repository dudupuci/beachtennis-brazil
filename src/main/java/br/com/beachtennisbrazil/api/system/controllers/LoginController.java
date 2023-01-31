package br.com.beachtennisbrazil.api.system.controllers;

import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.serviceimpl.LoginService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Login> authenticate(@RequestBody Login login) {
        var authentication = service.authenticate(login);
        return ResponseEntity.ok().body(authentication);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteLogins();
        return ResponseEntity.noContent().build();
    }

}

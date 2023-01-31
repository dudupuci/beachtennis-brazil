package br.com.beachtennisbrazil.api.system.controllers;

import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.serviceimpl.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/register")
@RestController
@CrossOrigin("*")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping
    public ResponseEntity<Login> register(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(login));
    }
}

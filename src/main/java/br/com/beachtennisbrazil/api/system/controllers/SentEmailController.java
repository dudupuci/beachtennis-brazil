package br.com.beachtennisbrazil.api.system.controllers;

import br.com.beachtennisbrazil.api.system.entities.SentEmailAdmin;
import br.com.beachtennisbrazil.api.system.serviceimpl.SentEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/sent-emails")
@CrossOrigin("*")
public class SentEmailController {

    @Autowired
    private SentEmailService service;

    @GetMapping
    public ResponseEntity<List<SentEmailAdmin>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}

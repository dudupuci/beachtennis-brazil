package br.com.beachtennisbrazil.api.app.controllers;


import br.com.beachtennisbrazil.api.app.entities.SubscriptionPlan;
import br.com.beachtennisbrazil.api.app.serviceimpl.SubscriptionPlanService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "subscription-plans")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService service;

    @GetMapping
    public ResponseEntity<List<SubscriptionPlan>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubscriptionPlan> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SubscriptionPlan plan) {
        service.save(plan);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}

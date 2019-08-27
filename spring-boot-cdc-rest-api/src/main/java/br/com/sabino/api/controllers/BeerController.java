package br.com.sabino.api.controllers;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService service;

    @GetMapping("/{id}")
    public Beer getOne(@PathVariable("id") UUID id) {
        return service.findOne(id);
    }

    @PostMapping
    public ResponseEntity<Beer> create(@RequestBody Beer beerRequest) {
        return new ResponseEntity<>(service.create(beerRequest), HttpStatus.CREATED);
    }
}


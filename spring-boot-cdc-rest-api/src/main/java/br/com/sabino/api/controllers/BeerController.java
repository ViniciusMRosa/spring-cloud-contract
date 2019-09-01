package br.com.sabino.api.controllers;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService service;

    @GetMapping("/{id}")
    public Beer getOne(@PathVariable("id") Integer id) {
        return service.findOne(id);
    }

    @PostMapping
    public ResponseEntity<Beer> create(@Valid @RequestBody Beer beerRequest) {
        return new ResponseEntity<>(service.create(beerRequest), HttpStatus.CREATED);
    }
}


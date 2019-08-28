package br.com.sabino.api;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService service;

    @PostMapping
    public ResponseEntity<Beer> create(@Valid @RequestBody Beer beerRequest) {
        return new ResponseEntity<>(service.create(beerRequest), HttpStatus.CREATED);
    }
}


package br.com.sabino.api;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.ProducerBeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
public class ProducerBeerController {

    private final ProducerBeerService service;

    @PostMapping
    public ResponseEntity<Beer> create(@Valid @RequestBody Beer beerRequest) {
        return new ResponseEntity<>(service.create(beerRequest), HttpStatus.CREATED);
    }
}


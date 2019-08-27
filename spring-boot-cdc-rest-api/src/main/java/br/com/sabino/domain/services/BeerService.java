package br.com.sabino.domain.services;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository repository;

    public Beer create(Beer beer) {
        beer.randomUUID();
        return repository.saveAndFlush(beer);
    }

    public Beer findOne(UUID id) {
        return repository.findById(id).get();
    }
}

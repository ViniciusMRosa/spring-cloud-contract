package br.com.sabino.domain.services;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository repository;

    public Beer create(Beer beer) {
        return repository.saveAndFlush(beer);
    }

    public Beer findOne(Integer id) {
        return repository.findById(id).get();
    }
}

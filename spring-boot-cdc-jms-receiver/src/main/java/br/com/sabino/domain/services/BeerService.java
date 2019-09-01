package br.com.sabino.domain.services;

import br.com.sabino.domain.client.BeerClient;
import br.com.sabino.domain.entities.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerClient beerClient;

    public Beer processor(Beer beer) {
        return beer;
    }

    public Beer sendBeerFromClient(Beer beer) {
        return beerClient.send(beer);
    }
}
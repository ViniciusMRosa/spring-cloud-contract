package br.com.sabino.domain.services;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.client.BeerClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerService {

    private final BeerClient beerClient;

    public Beer produceBeerFromClient(Beer beer) {
        return beerClient.send(beer);
    }

    public Beer sendNotification(Beer beer) {
        return beer;
    }
}
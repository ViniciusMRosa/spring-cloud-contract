package br.com.sabino.domain.services;

import br.com.sabino.domain.client.BeerFeignClient;
import br.com.sabino.domain.entities.ConsumerBeer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerBeerService {

    private final BeerFeignClient beerFeignClient;

    public ConsumerBeer consume(ConsumerBeer consumerBeer) {
        return consumerBeer;
    }

    public ConsumerBeer publishOnClient(ConsumerBeer consumerBeer) {
        return beerFeignClient.send(consumerBeer);
    }
}
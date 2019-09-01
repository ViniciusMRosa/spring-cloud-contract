package br.com.sabino.domain.services;

import br.com.sabino.application.amqp.producer.ProducerMessage;
import br.com.sabino.application.amqp.source.BeerCustomSource;
import br.com.sabino.domain.entities.Beer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProducerBeerService {

    private final BeerCustomSource beerCustomSource;
    private final ProducerMessage producerMessage;

    public Beer create(Beer beer) {
        producerMessage.publish(beer, beerCustomSource);
        return beer;
    }
}

package br.com.sabino.domain.services;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.message.producer.MessageProducer;
import br.com.sabino.message.source.RestSource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerService {

    private final RestSource restSource;
    private final MessageProducer messageProducer;

    public Beer create(Beer beer) {
        messageProducer.send(beer, restSource);
        return beer;
    }
}

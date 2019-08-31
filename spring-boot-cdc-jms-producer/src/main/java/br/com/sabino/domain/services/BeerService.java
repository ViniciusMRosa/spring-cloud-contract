package br.com.sabino.domain.services;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.jms.MessageSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerService {

    private final MessageSender messageSender;

    public Beer create(Beer beer) {
        messageSender.sendNotification(beer);
        return beer;
    }
}

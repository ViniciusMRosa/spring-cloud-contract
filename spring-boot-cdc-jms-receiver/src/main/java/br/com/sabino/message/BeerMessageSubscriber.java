package br.com.sabino.message;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerMessageSubscriber {

    @Getter
    private Beer beer;
    private final BeerService beerService;

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Beer handleMessage(Beer beer) {
        this.beer = beer;
        return beerService.processor(beer);
    }
}

package br.com.sabino.application.amqp;

import br.com.sabino.domain.entities.ConsumerBeer;
import br.com.sabino.domain.services.ConsumerBeerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerMessage {

    @Getter
    private ConsumerBeer consumerBeer;
    private final ConsumerBeerService consumerBeerService;

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public ConsumerBeer handleMessage(ConsumerBeer consumerBeer) {
        this.consumerBeer = consumerBeer;
        return consumerBeerService.consume(consumerBeer);
    }
}

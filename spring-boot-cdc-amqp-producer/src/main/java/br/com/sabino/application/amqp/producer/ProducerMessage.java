package br.com.sabino.application.amqp.producer;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.application.amqp.source.BeerCustomSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(BeerCustomSource.class)
public class ProducerMessage {

    public boolean publish(Beer payload, BeerCustomSource beerCustomSource){
        var message = MessageBuilder.withPayload(payload).build();
        return beerCustomSource.sendMessageDefaultChannel().send(message);
    }

}

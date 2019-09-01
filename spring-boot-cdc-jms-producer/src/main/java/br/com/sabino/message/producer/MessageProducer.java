package br.com.sabino.message.producer;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.message.source.RestSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(RestSource.class)
public class MessageProducer {

    public boolean send(Beer payload, RestSource restSource){
        var message = MessageBuilder.withPayload(payload).build();
        return restSource.sendMessageDefaultChannel().send(message);
    }

}

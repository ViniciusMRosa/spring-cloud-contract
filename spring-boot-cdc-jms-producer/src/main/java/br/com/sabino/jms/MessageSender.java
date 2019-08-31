package br.com.sabino.jms;

import br.com.sabino.domain.entities.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final Source source;

    public void sendNotification(Beer beer) {
        this.source.output().send(MessageBuilder.withPayload(beer).build());
    }
}

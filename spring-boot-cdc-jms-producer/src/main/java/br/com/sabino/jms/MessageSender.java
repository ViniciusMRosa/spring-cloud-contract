package br.com.sabino.jms;

import br.com.sabino.domain.entities.Beer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageSender {

    public static final String QUEUE_BEER = "queue.beer";
    public static final String BLANK = "";

    private AmqpTemplate amqpTemplate;

    public void sendNotification(Beer beer) {
        amqpTemplate.convertAndSend(QUEUE_BEER, BLANK, beer);
    }
}

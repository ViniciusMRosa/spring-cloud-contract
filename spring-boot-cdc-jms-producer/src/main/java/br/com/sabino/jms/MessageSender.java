package br.com.sabino.jms;

import br.com.sabino.domain.entities.Beer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageSender {

    public static final String QUEUE_BEER = "queue.beer";
    private final RabbitTemplate rabbitTemplate;

    public void sendNotification(Beer beer) {
        rabbitTemplate.convertAndSend(QUEUE_BEER, beer);
    }
}

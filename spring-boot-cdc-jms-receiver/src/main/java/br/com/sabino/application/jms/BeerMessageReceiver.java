package br.com.sabino.application.jms;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BeerMessageReceiver {

    private final BeerService beerService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue("queue.beer"), exchange = @Exchange(value = "queue.beer-exchange", ignoreDeclarationExceptions = "true")))
    public Beer handle(Beer beer) {
        return beerService.sendNotification(beer);
    }
}

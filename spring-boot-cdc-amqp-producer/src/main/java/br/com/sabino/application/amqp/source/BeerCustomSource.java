package br.com.sabino.application.amqp.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BeerCustomSource {
    @Output("product-channel")
    MessageChannel sendMessageDefaultChannel();
}

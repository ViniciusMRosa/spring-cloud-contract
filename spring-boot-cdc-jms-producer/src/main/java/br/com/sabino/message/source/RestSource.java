package br.com.sabino.message.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RestSource {
    @Output("product-channel")
    MessageChannel sendMessageDefaultChannel();
}

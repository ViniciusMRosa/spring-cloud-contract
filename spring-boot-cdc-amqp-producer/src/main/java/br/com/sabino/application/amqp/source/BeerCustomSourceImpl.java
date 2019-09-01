package br.com.sabino.application.amqp.source;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(BeerCustomSource.class)
public class BeerCustomSourceImpl {
}
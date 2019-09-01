package br.com.sabino.domain.client;

import br.com.sabino.domain.entities.ConsumerBeer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "beer-client", url = "${feign.beer-client.url}")
public interface BeerFeignClient {

    @PostMapping
    ConsumerBeer send(@RequestBody ConsumerBeer consumerBeer);
}

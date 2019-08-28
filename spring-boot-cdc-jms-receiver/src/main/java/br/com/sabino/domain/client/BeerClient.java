package br.com.sabino.domain.client;

import br.com.sabino.domain.entities.Beer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "beer-client", url = "${feign.beer-client.url}")
public interface BeerClient {

    @PostMapping
    Beer send(@RequestBody Beer beer);
}

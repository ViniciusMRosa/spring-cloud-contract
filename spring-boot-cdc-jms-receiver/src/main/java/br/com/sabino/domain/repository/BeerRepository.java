package br.com.sabino.domain.repository;

import br.com.sabino.domain.entities.Beer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "beer-client", url = "http://localhost:8082/api/beer")
public interface BeerRepository {

    @PostMapping
    Beer saveBeer(@RequestBody Beer beer);
}

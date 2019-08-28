package br.com.sabino.contract;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.client.BeerClient;
import br.com.sabino.domain.services.BeerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DirtiesContext
@AutoConfigureStubRunner
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BeerServiceProduceTest {

    @Autowired
    private BeerService service;

    @MockBean
    private BeerClient client;

    @Test
    public void verifyProduceBeerCompliesToContract() {

        //arrange
        final var opaBier = Beer.builder()
                .id(UUID.fromString("d25a125a-6b03-407a-b90a-cfe1ecaf1dfb"))
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        when(client.send(any(Beer.class))).thenReturn(opaBier);

        //act
        final var producedBeer = service.produceBeerFromClient(opaBier);

        //assert
        assertThat(opaBier.getId(), is(equalTo(producedBeer.getId())));
        assertThat(opaBier.getName(), is(equalTo(producedBeer.getName())));
        assertThat(opaBier.getAlcoholTenor(), is(equalTo(producedBeer.getAlcoholTenor())));
        assertThat(opaBier.getIbu(), is(equalTo(producedBeer.getIbu())));
        assertThat(opaBier.getStyle(), is(equalTo(producedBeer.getStyle())));
        assertThat(opaBier.getDescription(), is(equalTo(producedBeer.getDescription())));
    }
}
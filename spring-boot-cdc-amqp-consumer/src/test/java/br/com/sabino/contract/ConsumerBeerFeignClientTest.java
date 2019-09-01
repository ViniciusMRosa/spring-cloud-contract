package br.com.sabino.contract;

import br.com.sabino.domain.client.BeerFeignClient;
import br.com.sabino.domain.entities.ConsumerBeer;
import br.com.sabino.domain.services.ConsumerBeerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DirtiesContext
@AutoConfigureStubRunner(ids = "br.com.sabino:spring-boot-cdc-rest-api:+:8082", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ConsumerBeerFeignClientTest {

    @Autowired
    private ConsumerBeerService service;

    @MockBean
    private BeerFeignClient client;

    @Test
    public void verifyProduceBeerCompliesToContract() {

        //arrange
        final var opaBier = ConsumerBeer.builder()
                .id(1)
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilibrio entre aroma e amargor, a Opa Bier harmoniza 3 lupulos especiais nessa receita de sabor intenso e citrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        when(client.send(any(ConsumerBeer.class))).thenReturn(opaBier);

        //act
        final var producedBeer = service.publishOnClient(opaBier);

        //assert
        assertThat(opaBier.getId(), is(equalTo(producedBeer.getId())));
        assertThat(opaBier.getName(), is(equalTo(producedBeer.getName())));
        assertThat(opaBier.getAlcoholTenor(), is(equalTo(producedBeer.getAlcoholTenor())));
        assertThat(opaBier.getIbu(), is(equalTo(producedBeer.getIbu())));
        assertThat(opaBier.getStyle(), is(equalTo(producedBeer.getStyle())));
        assertThat(opaBier.getDescription(), is(equalTo(producedBeer.getDescription())));
    }
}
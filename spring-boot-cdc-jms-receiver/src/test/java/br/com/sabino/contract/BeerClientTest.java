package br.com.sabino.contract;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.repository.BeerRepository;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "br.com.sabino:spring-boot-cdc-rest-api:+:8082")
public class BeerClientTest {

    @Autowired
    private BeerRepository beerRepository;

    @Test
    public void shouldCreateBeerCompliesToContract() {
        var opaBier = Beer.builder()
                .id(UUID.fromString("d25a125a-6b03-407a-b90a-cfe1ecaf1dfb"))
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        var opaBierResponseSent = beerRepository.saveBeer(opaBier);

        MatcherAssert.assertThat(opaBier.getId(), is(equalTo(opaBierResponseSent.getId())));
        MatcherAssert.assertThat(opaBier.getName(), is(equalTo(opaBierResponseSent.getName())));
        MatcherAssert.assertThat(opaBier.getAlcoholTenor(), is(equalTo(opaBierResponseSent.getAlcoholTenor())));
        MatcherAssert.assertThat(opaBier.getIbu(), is(equalTo(opaBierResponseSent.getIbu())));
        MatcherAssert.assertThat(opaBier.getStyle(), is(equalTo(opaBierResponseSent.getStyle())));
        MatcherAssert.assertThat(opaBier.getDescription(), is(equalTo(opaBierResponseSent.getDescription())));
    }
}
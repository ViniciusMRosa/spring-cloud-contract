package br.com.sabino.contract;

import br.com.sabino.application.amqp.ConsumerMessage;
import br.com.sabino.domain.entities.ConsumerBeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"br.com.sabino:spring-boot-cdc-amqp-producer:+:8080"}, stubsMode = StubsMode.LOCAL)
public class ConsumeMessageTest {

    @Autowired
    private StubTrigger stubTrigger;

    @Autowired
    private ConsumerMessage consumerMessage;

    @Test
    public void shouldConsumeAMessageOfANewBeer() {

        this.stubTrigger.trigger("opa_bier");

        //arrange
        var opaBier = ConsumerBeer.builder()
                .id(1)
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilibrio entre aroma e amargor, a Opa Bier harmoniza 3 lupulos especiais nessa receita de sabor intenso e citrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        //act
        final var messageConsumerBeerBeer = this.consumerMessage.getConsumerBeer();

        //assert
        assertThat(opaBier.getId(), is(equalTo(messageConsumerBeerBeer.getId())));
        assertThat(opaBier.getName(), is(equalTo(messageConsumerBeerBeer.getName())));
        assertThat(opaBier.getAlcoholTenor(), is(equalTo(messageConsumerBeerBeer.getAlcoholTenor())));
        assertThat(opaBier.getIbu(), is(equalTo(messageConsumerBeerBeer.getIbu())));
        assertThat(opaBier.getStyle(), is(equalTo(messageConsumerBeerBeer.getStyle())));
        assertThat(opaBier.getDescription(), is(equalTo(messageConsumerBeerBeer.getDescription())));
    }
}
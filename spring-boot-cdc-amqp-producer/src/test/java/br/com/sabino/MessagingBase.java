package br.com.sabino;

import br.com.sabino.application.amqp.producer.ProducerMessage;
import br.com.sabino.application.amqp.source.BeerCustomSource;
import br.com.sabino.domain.entities.Beer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@DirtiesContext
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMessageVerifier
public class MessagingBase {

    @Autowired
    private ProducerMessage producerMessage;

    @Autowired
    private BeerCustomSource beerCustomSource;

    public void publishMessage() {
        var beer = Beer.builder()
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilibrio entre aroma e amargor, a Opa Bier harmoniza 3 lupulos especiais nessa receita de sabor intenso e citrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        producerMessage.publish(beer, beerCustomSource);
    }
}

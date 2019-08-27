package br.com.sabino;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.jms.MessageSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMessageVerifier
public abstract class MessagingBase {

    @Autowired
    private MessageSender messageSender;

   protected void createBeer() {
        var beer = Beer.builder()
                .id(UUID.fromString("d25a125a-6b03-407a-b90a-cfe1ecaf1dfb"))
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        messageSender.sendNotification(beer);
    }
}

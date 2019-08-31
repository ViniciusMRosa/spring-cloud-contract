package br.com.sabino;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.jms.MessageSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMessageVerifier
public class MessagingBase {

    @Autowired
    private MessageSender messageSender;

    public void sendNotification() {
        var beer = Beer.builder()
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilibrio entre aroma e amargor, a Opa Bier harmoniza 3 lupulos especiais nessa receita de sabor intenso e citrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();
        messageSender.sendNotification(beer);
    }
}

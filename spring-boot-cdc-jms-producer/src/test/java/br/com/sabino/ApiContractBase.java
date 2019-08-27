package br.com.sabino;

import br.com.sabino.api.BeerController;
import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import br.com.sabino.jms.MessageSender;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@AutoConfigureMessageVerifier
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ApiContractBase {

    @Autowired
    private BeerController beerController;

    @MockBean
    private BeerService service;

    @Before
    public void setup() {
        var mockMvcBuilder = MockMvcBuilders.standaloneSetup(beerController);
        var beer = Beer.builder()
                .id(UUID.fromString("d25a125a-6b03-407a-b90a-cfe1ecaf1dfb"))
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        when(service.create(any(Beer.class))).thenReturn(beer);

        standaloneSetup(mockMvcBuilder);
    }
}
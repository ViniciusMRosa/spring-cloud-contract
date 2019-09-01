package br.com.sabino;

import br.com.sabino.api.BeerController;
import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@AutoConfigureMessageVerifier
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BeerApiBase {

    @Autowired
    private BeerController beerController;

    @MockBean
    private BeerService service;

    @Before
    public void setup() {
        var beer = Beer.builder()
                .alcoholTenor("6,1%")
                .description("Na cerveja IPA Opa Bier artesanal, para atingir o equilibrio entre aroma e amargor, a Opa Bier harmoniza 3 lupulos especiais nessa receita de sabor intenso e citrico.")
                .ibu("37")
                .style("India Pale Ale")
                .name("India Pale Ale Opa Bier")
                .build();

        when(service.create(any(Beer.class))).thenReturn(beer);

        RestAssuredMockMvc.standaloneSetup( MockMvcBuilders.standaloneSetup(beerController));
    }
}
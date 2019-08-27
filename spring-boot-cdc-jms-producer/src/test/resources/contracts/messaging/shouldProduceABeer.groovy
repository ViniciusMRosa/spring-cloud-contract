package contracts.messaging

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'Should produce a Opa Bier'
    label 'Opa Bier'
    input {
        triggeredBy('createBeer()')
    }
    outputMessage {
        sentTo 'queue.beer'
        headers {
            header('contentType': 'application/json')
        }
        body([
                id          : "d25a125a-6b03-407a-b90a-cfe1ecaf1dfb",
                alcoholTenor: "6,1%",
                description : "Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.",
                ibu         : "37",
                name        : "India Pale Ale Opa Bier",
                style       : "India Pale Ale"
        ])
    }
}
package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/api/v1/beer'
        body(
                "alcoholTenor": "6,1%",
                "description" : "Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.",
                "ibu"         : "37",
                "name"        : "India Pale Ale Opa Bier",
                "style"       : "India Pale Ale"
        )
        headers {
            contentType(applicationJsonUtf8())
        }
    }
    response {
        status CREATED()
        body([
                alcoholTenor: '6,1%',
                description : 'Na cerveja IPA Opa Bier artesanal, para atingir o equilibrio entre aroma e amargor, a Opa Bier harmoniza 3 lupulos especiais nessa receita de sabor intenso e citrico.',
                ibu         : '37',
                name        : 'India Pale Ale Opa Bier',
                style       : 'India Pale Ale'
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
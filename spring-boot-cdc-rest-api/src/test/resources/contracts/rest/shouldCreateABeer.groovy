package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
Represents a successful scenario of getting a beer
```
given:
	client is old enough
when:
	he applies for a beer
then:
	we'll grant him the beer
```
""")
    request {
        method ('POST')
        url ('/api/beer')
        body([
                alcoholTenor: "6,1%",
                description : "Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.",
                ibu         : "37",
                name        : "India Pale Ale Opa Bier",
                style       : "India Pale Ale"
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
    response {
        status CREATED()
        body([
                id          : 1,
                alcoholTenor: "6,1%",
                description : "Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.",
                ibu         : "37",
                name        : "India Pale Ale Opa Bier",
                style       : "India Pale Ale"
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
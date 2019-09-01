package contracts.messaging

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label 'opa_bier'
    input {
        triggeredBy('sendNotification()')
    }
    outputMessage {
        sentTo('product-process')
        body([
                alcoholTenor: '6,1%',
                description : 'Na cerveja IPA Opa Bier artesanal, para atingir o equilibrio entre aroma e amargor, a Opa Bier harmoniza 3 lupulos especiais nessa receita de sabor intenso e citrico.',
                ibu         : '37',
                name        : 'India Pale Ale Opa Bier',
                style       : 'India Pale Ale'
        ])
        headers {
            messagingContentType(applicationJson())
        }
    }
}
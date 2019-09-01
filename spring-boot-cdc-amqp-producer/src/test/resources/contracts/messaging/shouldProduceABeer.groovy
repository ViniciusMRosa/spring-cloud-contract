package contracts.messaging

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    // Label by means of which the output message can be triggered
    label 'opa_bier'
    input {
        // the contract will be triggered by a method
        triggeredBy('publishMessage()')
    }
    // output message of the contract
    outputMessage {
        // destination to which the output message will be sent
        sentTo('product-process')
        // the body of the output message
        body([
                id: 1,
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
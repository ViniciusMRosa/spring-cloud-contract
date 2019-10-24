import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description"should receive message"
    label "triggerTestMessage"
    input {
        triggeredBy("triggerMessage()")
    }
    outputMessage {
        sentTo "messages"
        body(["body": "messageBody"])
    }
}


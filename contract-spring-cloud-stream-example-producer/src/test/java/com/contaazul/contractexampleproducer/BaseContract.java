package com.contaazul.contractexampleproducer;

import lombok.AllArgsConstructor;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ContractExampleProducerApplication.class, TestApplication.class})
@AutoConfigureMessageVerifier
public class BaseContract {

	@Autowired
	private MessageController messageController;

	public  void triggerMessage(){
		messageController.sendMessage();
	}
}

@Profile( "test" )
@Component
@AllArgsConstructor
class TestMessageSender implements MessageSender{

	private final Source source;

	@Override
	public void sendMessage() {
		source.output().send( MessageBuilder.withPayload( new MessageDTO( "messageBody" ) ).build() );
	}
}
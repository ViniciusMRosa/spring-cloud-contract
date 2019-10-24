package com.contaazul.contractexampleproducer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ContractExampleProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractExampleProducerApplication.class, args);
	}

}

@RestController
@AllArgsConstructor
class MessageController{

	private MessageSender messageSender;

	@PostMapping("/message")
	void sendMessage(){
		messageSender.sendMessage();
	}
}


interface MessageSender{
	void sendMessage();
}
@Component
@AllArgsConstructor
@Profile( "!test" )
class ProductionMessageSender implements MessageSender {
	@Override public void sendMessage() {
		System.out.println("Production message sent");
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class MessageDTO {
	private String body;
}
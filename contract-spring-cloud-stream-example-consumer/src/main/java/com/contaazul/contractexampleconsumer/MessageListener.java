package com.contaazul.contractexampleconsumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {
	@NonNull
	private Sink sink;
	@Getter
	private String message;

	@StreamListener(Sink.INPUT)
	public void onMessage(MessageDTO message){
		this.message = message.getBody();
	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class MessageDTO {
	private String body;
}
package com.contaazul.contractexampleconsumer;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
		ids = "com.contaazul:contract-example-producer")
public class MessageListenerTest {

	@Autowired
	private StubTrigger trigger;

	@Autowired
	MessageListener listener;

	@Test
	public void shouldreceiveMessage(){
		trigger.trigger( "triggerTestMessage" );

		BDDAssertions.assertThat( listener.getMessage()).isEqualTo( "messageBody" );
	}

}

package co.com.ceiba.devfest.bdd.steps;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import co.com.ceiba.devfest.bdd.CodeBreakerGame;

@Component
public class StartGameSteps {
	
	private CodeBreakerGame _game;
	private ByteArrayOutputStream _baos; 
	
	
	@Given("I am not yet playing")
	public void givenIAmNotYetPlaying() {
		_baos = new ByteArrayOutputStream();
		PrintStream _out = new PrintStream(_baos);
		_game = new CodeBreakerGame(_out);
	}

	@When("I start a game")
	public void whenIStartAGame() {
		_game.start();
	}

	@Then("I should see $message")
	public void thenIShouldSeeMessage(String message) {
		String result = _baos.toString();
		
		Assert.assertThat(result, Matchers.containsString(message));
	}

}

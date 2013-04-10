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
public class SubmitGuessSteps {
	private CodeBreakerGame _game;
	private ByteArrayOutputStream _baos; 
	
	@Given("The secret code is $secretCode")
	public void givenTheSecretCodeIssecretCode(String secretCode) {
		int[] intSecretCode = convertToInt(secretCode);
		
		
		_baos = new ByteArrayOutputStream();
		PrintStream _out = new PrintStream(_baos);
		_game = new CodeBreakerGame(_out, intSecretCode);
	}

	private int[] convertToInt(String secretCode) {
		int[] intSecretCode = new int[4];
		intSecretCode[0] = Integer.parseInt(secretCode.substring(0,1));
		intSecretCode[1] = Integer.parseInt(secretCode.substring(1,2));
		intSecretCode[2] = Integer.parseInt(secretCode.substring(2,3));
		intSecretCode[3] = Integer.parseInt(secretCode.substring(3,4));
		return intSecretCode;
	}

	@When("I guess $guessCode")
	public void whenIGuessguessCode(String guessCode) {
		_game.guess(convertToInt(guessCode));
	}

	@Then("The mark is $mark")
	public void thenTheMarkIsmark(String mark) {
		String result = _baos.toString();
		
		Assert.assertThat(result, Matchers.containsString(mark));
	}


}

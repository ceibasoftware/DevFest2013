package co.com.ceiba.devfest.tdd;

import junit.framework.Assert;

import org.junit.Test;

import co.com.ceiba.devfest.bdd.CodeBreakerGame;

public class StartGameTests {
	
	@Test
	public void whenStartGameItShouldHaveSecretCode(){
		CodeBreakerGame game = new CodeBreakerGame();
		game.start();
		Assert.assertNotNull(game.getSecretCode());
	}

}

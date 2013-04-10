package co.com.ceiba.devfest.bdd;

import java.io.PrintStream;

public class CodeBreakerGame {
	
	private PrintStream _out;
	private int[] _secretCode;

	public CodeBreakerGame() {
		this(System.out);
	}
	
	public CodeBreakerGame(PrintStream out) {
		this(out, generateRandomSecretCode());
	}

	public CodeBreakerGame(PrintStream out, int[] secretCode) {
		_out = out;
		_secretCode = secretCode;
	}

	private static int[] generateRandomSecretCode() {
		
		int[] secretCode = new int[4];
		secretCode[0] = (int) (Math.random()*9);
		secretCode[1] = (int) (Math.random()*9);
		secretCode[2] = (int) (Math.random()*9);
		secretCode[3] = (int) (Math.random()*9);
		return secretCode;
	}

	public void start() {
		_out.println("Welcome codebreaker!");
		_out.println("Submit guess:");
		
	}

	public int[] getSecretCode() {
		return _secretCode;
	}

	public void guess(int[] guessCode) {
		int countExactMatch = 0;
		int countNumberMatch = 0;
		for(int i = 0; i < 4; i++){
			if(guessCode[i] == _secretCode[i]){
				countExactMatch ++;
			}else{
				for(int j = 0; j < 4; j++){
					if(guessCode[i] == _secretCode[j]){
						countNumberMatch ++;
					}
				}
			}
		}
		String result = "";
		for(int i = 0; i < countExactMatch; i ++){
			result += "+";
		}
		for(int i = 0; i < countNumberMatch; i ++){
			result += "-";
		}
		if("".endsWith(result)){
			_out.println("Try again!");
		}else{
			_out.println(result);
		}
	}

}

package classes.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestNetwork {

	public String testnetwork() {
		try {
			System.out.println("Testando conex�o com a internet...");
			new Thread();
			Runtime.getRuntime().exec("ping www.google.com.br -c 5");
			Thread.sleep(10000);
			Process run = Runtime.getRuntime().exec("ping www.google.com.br -c 4");
			InputStreamReader input = new InputStreamReader(run.getErrorStream());
			BufferedReader bReader = new BufferedReader(input);
			if (bReader.readLine() == null) {
				System.out.println("Conex�o efetuada com sucesso! Voc� est� online!");
				return "true";
			} else {
				System.out.println("Erro! conex�o n�o efetuada. Favor tentar novamente!");
				return "false";
			}

		} catch (IOException | InterruptedException exc) {
						return "false";

		}
	}

}

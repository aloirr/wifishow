package classes.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetRuntimeInput {

	public void getruntimeinput(String arquivo, String comando) {
		try {
			File conf = new File(arquivo);
			FileWriter gravaConf = new FileWriter(conf);
			InputStreamReader iReader = new InputStreamReader(Runtime.getRuntime().exec(comando).getInputStream());
			BufferedReader bReader = new BufferedReader(iReader);
			String leitorLinha;
			while ((leitorLinha = bReader.readLine()) != null) {
				gravaConf.write(leitorLinha + "\n");
			}
			gravaConf.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}

	}

}
